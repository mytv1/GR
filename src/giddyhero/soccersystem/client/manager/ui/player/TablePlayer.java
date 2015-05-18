package giddyhero.soccersystem.client.manager.ui.player;

import giddyhero.soccersystem.client.SystemManager;
import giddyhero.soccersystem.client.manager.ui.widget.ResizableImageCell;
import giddyhero.soccersystem.client.share.CSSUtils;
import giddyhero.soccersystem.shared.Position;
import giddyhero.soccersystem.shared.model.Player;
import giddyhero.soccersystem.shared.model.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.SelectionCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SelectionModel;

public class TablePlayer extends DataGrid<Player> {

	public ListDataProvider<Player> playersProvider = new ListDataProvider<>(Player.KEY_PROVIDER);
	public Column<Player, String> colHeight, colId, colAvatar, colName, colNation, colBirth,
			colPosition, colTeam, colSave, colDelete, colAvatarUrl;
	List<Team> teams;
	String[] nations;

	public TablePlayer() {
		super(Player.KEY_PROVIDER);
		init();
		style();
	}

	private void style() {
		CSSUtils.setMarginCenter(this);
	}

	private void init() {
		initTableBase();
		getAllTeam();
	}
	
	protected void startInit(){
		initColumn();
	}
	
	private void getAllTeam() {
		SystemManager.Service.team.getAllTeams(new AsyncCallback<List<Team>>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("get all team fail");
			}

			@Override
			public void onSuccess(List<Team> result) {
				teams = result;
				SystemManager.Service.general.getAllCountryNames(new AsyncCallback<String[]>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("get all nation fail");						
					}

					@Override
					public void onSuccess(String[] result) {
						nations = result;
						startInit();
					}
				});
				
			}
		});		
	}

	private void initColumn() {
		initIdColumn();
		initNameColumn();
		initBirthColumn();
		initAvatarColumn();
		initAvatarUrlColumn();
		initHeighColumn();
		initNationColumn();
		initPositionColumn();
		initTeamColumn();
		initSaveColumn();
		initDeleteColumn();
	}

	private void initAvatarUrlColumn() {
		colAvatarUrl = new Column<Player, String>(new EditTextCell()) {

			@Override
			public String getValue(Player object) {
				return object.avatarUrl;
			}
		};
		colAvatarUrl.setFieldUpdater(new FieldUpdater<Player, String>() {

			@Override
			public void update(int index, Player object, String value) {
				object.avatarUrl = value;
				playersProvider.getList().set(index, object);
			}
		});
		addColumn(colAvatarUrl, "Avatar Url");
	}

	private void initBirthColumn() {
		colBirth = new Column<Player, String>(new EditTextCell()) {

			@Override
			public String getValue(Player object) {
				String birthStr = object.birth;
				if (birthStr == null)
					return "N/A";
				return birthStr;
			}
		};
		colBirth.setFieldUpdater(new FieldUpdater<Player, String>() {

			@Override
			public void update(int index, Player object, String value) {
				object.birth = value;
				playersProvider.getList().set(index, object);
			}
		});
//		setColumnWidth(colBirth, "50px");
		addColumn(colBirth, "Birth");
	}

	private void initDeleteColumn() {
		colDelete = new Column<Player, String>(new ButtonCell()) {

			@Override
			public String getValue(Player object) {
				return "Delete";
			}
		};

		colDelete.setFieldUpdater(new FieldUpdater<Player, String>() {

			@Override
			public void update(final int index, Player object, String value) {
//				 Window.alert("U click on player : ");
				SystemManager.Service.player.deletePlayer(object.id, new AsyncCallback<Void>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Delete player failure : " + caught.toString());
					}

					@Override
					public void onSuccess(Void result) {
						Window.alert("Delete player success");
						playersProvider.getList().remove(index);
						redraw();
					}
				});
			}
		});
		addColumn(colDelete, "Delete");
	}

	private void initSaveColumn() {
		colSave = new Column<Player, String>(new ButtonCell()) {

			@Override
			public String getValue(Player object) {
				return "Save";
			}
		};

		colSave.setFieldUpdater(new FieldUpdater<Player, String>() {

			@Override
			public void update(final int index, Player object, String value) {
//				Window.alert("U click on player 1 : " + object.toString());
				SystemManager.Service.player.savePlayer(object, new AsyncCallback<Player>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Save player fail " + caught.toString());
					}

					@Override
					public void onSuccess(Player result) {
						Window.alert("Save player success : " + result.toString());
					}

				});
			}
		});
		addColumn(colSave, "Save");
	}

	private void initTeamColumn() {
		ArrayList<String> listTeam = new ArrayList<String>();
		for (Team team : teams) {
			listTeam.add(""+team.name+" ("+team.id+")");
		}
		SelectionCell selectionCell = new SelectionCell(listTeam);
		colTeam = new Column<Player, String>(selectionCell) {
			@Override
			public String getValue(Player object) {
				for (Team team : teams) {
					if (team.id == object.currentTeamId)
						return ""+team.name+" ("+team.id+")";
				}
				return "N/A team";
			}
		};
		colTeam.setFieldUpdater(new FieldUpdater<Player, String>() {

			@Override
			public void update(int index, Player object, String value) {
				int i = value.indexOf('(');
				String subStr = value.substring(i+1,value.indexOf(')'));
				Window.alert("substr : "+subStr);
				object.currentTeamId = Long.parseLong(subStr);
				playersProvider.getList().set(index, object);
			}
		});
		addColumn(colTeam, "Team");
	}

	private void initPositionColumn() {
		ArrayList<String> listPos = new ArrayList<String>();
		for(Entry<Integer, String> entry : Position.positions.entrySet()) {
		    int key = entry.getKey();
		    String val = entry.getValue();
		    listPos.add(val+" ("+key+')');
		}
		SelectionCell selectionCell = new SelectionCell(listPos);
		colPosition = new Column<Player, String>(selectionCell) {

			@Override
			public String getValue(Player object) {
//				return ""+Position.getPositionNameById(object.positionId)+" ("+object.positionId;
				return object.position;
			}
		};
		colPosition.setFieldUpdater(new FieldUpdater<Player, String>() {

			@Override
			public void update(int index, Player object, String value) {
//				int i = value.indexOf('(');
//				String subStr = value.substring(i+1,value.indexOf(')'));
//				Window.alert("substr : "+subStr);
				object.position = value;
//				object.positionId = Integer.parseInt(subStr);
				playersProvider.getList().set(index, object);
			}
		});
		addColumn(colPosition, "Position");
	}

	private void initNationColumn() {
		ArrayList<String> listNation = new ArrayList<String>();
		for (String str : nations) {
			listNation.add(str);
		}
		SelectionCell selectionCell = new SelectionCell(listNation);
		colNation = new Column<Player, String>(selectionCell) {

			@Override
			public String getValue(Player object) {
				return object.nationality;
			}
		};
		colNation.setFieldUpdater(new FieldUpdater<Player, String>() {

			@Override
			public void update(int index, Player object, String value) {
				object.nationality = value;
				playersProvider.getList().set(index, object);
			}
		});
		addColumn(colNation, "Nation");
	}

	private void initHeighColumn() {
		colHeight = new Column<Player, String>(new EditTextCell()) {

			@Override
			public String getValue(Player object) {
				return object.height + "";
			}
		};
		colHeight.setFieldUpdater(new FieldUpdater<Player, String>() {

			@Override
			public void update(int index, Player object, String value) {
				object.height = Integer.parseInt(value);
				playersProvider.getList().set(index, object);
			}
		});
		addColumn(colHeight, " Height");
	}

	private void initAvatarColumn() {
		
		ResizableImageCell imgCell = new ResizableImageCell("40px", "40px");
		colAvatar = new Column<Player, String>(imgCell) {

			@Override
			public String getValue(Player object) {
				return object.avatarUrl;
			}
		};
		colAvatar.setFieldUpdater(new FieldUpdater<Player, String>() {

			@Override
			public void update(int index, Player object, String value) {
				object.avatarUrl = value;
				playersProvider.getList().set(index, object);
			}
		});
		addColumn(colAvatar, "Avatar");
	}

	private void initNameColumn() {
		colName = new Column<Player, String>(new EditTextCell()) {

			@Override
			public String getValue(Player object) {
				return object.name;
			}
		};
		colName.setFieldUpdater(new FieldUpdater<Player, String>() {

			@Override
			public void update(int index, Player object, String value) {
				object.name = value;
				playersProvider.getList().set(index, object);
			}
		});
		addColumn(colName, "Name");
	}

	private void initIdColumn() {
		colId = new Column<Player, String>(new TextCell()) {

			@Override
			public String getValue(Player object) {
				return object.id.toString();
			}
		};
		addColumn(colId, "Id");
	}

	private void initTableBase() {
		setSize("1000px", "450px");
		ListHandler<Player> sortHandler = new ListHandler<Player>(playersProvider.getList());
		addColumnSortHandler(sortHandler);

		final SelectionModel<Player> selectionModel = new MultiSelectionModel<Player>(Player.KEY_PROVIDER);
		setSelectionModel(selectionModel, DefaultSelectionEventManager.<Player> createCheckboxManager());

		setEmptyTableWidget(new Label("Empty"));
		playersProvider.addDataDisplay(this);
		setFocus(false);
	}

	public void setData(List<Player> listPlayer) {
		playersProvider.setList(listPlayer);
		setRowData(playersProvider.getList());
		redraw();
	}

}
