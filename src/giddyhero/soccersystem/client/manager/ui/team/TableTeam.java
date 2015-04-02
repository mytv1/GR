package giddyhero.soccersystem.client.manager.ui.team;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import giddyhero.soccersystem.client.SystemManager;
import giddyhero.soccersystem.client.manager.ui.widget.ResizableImageCell;
import giddyhero.soccersystem.client.share.CSSUtils;
import giddyhero.soccersystem.shared.Position;
import giddyhero.soccersystem.shared.model.Player;
import giddyhero.soccersystem.shared.model.Team;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.cell.client.SelectionCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SelectionModel;

public class TableTeam extends DataGrid<Team>{
	ListDataProvider<Team> playersProvider = new ListDataProvider<>(Team.KEY_PROVIDER);
	public Column<Team, String> colHeight, colId, colAvatar, colName, colNation, colPosition, colTeam, colSave, colDelete, colAvatarUrl;
	Column<Team, String> colEstablishYear;
	List<Team> teams;
	String[] nations;

	public TableTeam() {
		super(Team.KEY_PROVIDER);
		init();
		style();
	}

	private void style() {
		CSSUtils.setMarginCenter(this);
	}

	private void init() {
		initTableBase();
		getData();
	}
	
	protected void startInit(){
		initColumn();
	}
	
	private void getData() {
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

	private void initColumn() {
		initIdColumn();
		initNameColumn();
		initAvatarColumn();
		initAvatarUrlColumn();
		initEstablishYearColumn();
//		initHeighColumn();
		initNationColumn();
//		initPositionColumn();
//		initTeamColumn();
		initSaveColumn();
		initDeleteColumn();
	}

	private void initAvatarUrlColumn() {
		colAvatarUrl = new Column<Team, String>(new EditTextCell()) {

			@Override
			public String getValue(Team object) {
				return object.logoUrl;
			}
		};
		colAvatarUrl.setFieldUpdater(new FieldUpdater<Team, String>() {

			@Override
			public void update(int index, Team object, String value) {
				object.logoUrl = value;
				playersProvider.getList().set(index, object);
			}
		});
		addColumn(colAvatarUrl, "Avatar Url");
	}

	private void initEstablishYearColumn() {
		colEstablishYear = new Column<Team, String>(new EditTextCell()) {

			@Override
			public String getValue(Team object) {
				int year = object.establishYear;
				return Integer.toString(year);
			}
		};
		colEstablishYear.setFieldUpdater(new FieldUpdater<Team, String>() {

			@Override
			public void update(int index, Team object, String value) {
				object.establishYear = Integer.parseInt(value);
				playersProvider.getList().set(index, object);
			}
		});
		addColumn(colEstablishYear, "Establish");
	}

	private void initDeleteColumn() {
		colDelete = new Column<Team, String>(new ButtonCell()) {

			@Override
			public String getValue(Team object) {
				return "Delete";
			}
		};

		colDelete.setFieldUpdater(new FieldUpdater<Team, String>() {

			@Override
			public void update(final int index, Team object, String value) {
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
		colSave = new Column<Team, String>(new ButtonCell()) {

			@Override
			public String getValue(Team object) {
				return "Save";
			}
		};

		colSave.setFieldUpdater(new FieldUpdater<Team, String>() {

			@Override
			public void update(final int index, Team object, String value) {
//				Window.alert("U click on player 1 : " + object.toString());
				SystemManager.Service.team.saveTeam(object, new AsyncCallback<Team>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Save player fail " + caught.toString());
					}

					@Override
					public void onSuccess(Team result) {
						Window.alert("Save player success : " + result.toString());
					}

				});
			}
		});
		addColumn(colSave, "Save");
	}
//
//	private void initTeamColumn() {
//		ArrayList<String> listTeam = new ArrayList<String>();
//		for (Team team : teams) {
//			listTeam.add(""+team.name+" ("+team.id+")");
//		}
//		SelectionCell selectionCell = new SelectionCell(listTeam);
//		colTeam = new Column<Player, String>(selectionCell) {
//			@Override
//			public String getValue(Player object) {
//				for (Team team : teams) {
//					if (team.id == object.currentTeamId)
//						return ""+team.name+" ("+team.id+")";
//				}
//				return "N/A team";
//			}
//		};
//		colTeam.setFieldUpdater(new FieldUpdater<Player, String>() {
//
//			@Override
//			public void update(int index, Player object, String value) {
//				int i = value.indexOf('(');
//				String subStr = value.substring(i+1,value.indexOf(')'));
//				Window.alert("substr : "+subStr);
//				object.currentTeamId = Long.parseLong(subStr);
//				playersProvider.getList().set(index, object);
//			}
//		});
//		addColumn(colTeam, "Team");
//	}
//
//	private void initPositionColumn() {
//		ArrayList<String> listPos = new ArrayList<String>();
//		for(Entry<Integer, String> entry : Position.positions.entrySet()) {
//		    int key = entry.getKey();
//		    String val = entry.getValue();
//		    listPos.add(val+" ("+key+')');
//		}
//		SelectionCell selectionCell = new SelectionCell(listPos);
//		colPosition = new Column<Player, String>(selectionCell) {
//
//			@Override
//			public String getValue(Player object) {
//				return ""+Position.getPositionNameById(object.positionId)+" ("+object.positionId;
//			}
//		};
//		colPosition.setFieldUpdater(new FieldUpdater<Player, String>() {
//
//			@Override
//			public void update(int index, Player object, String value) {
//				int i = value.indexOf('(');
//				String subStr = value.substring(i+1,value.indexOf(')'));
//				Window.alert("substr : "+subStr);
//				object.positionId = Integer.parseInt(subStr);
//				playersProvider.getList().set(index, object);
//			}
//		});
//		addColumn(colPosition, "Position");
//	}

	private void initNationColumn() {
		ArrayList<String> listNation = new ArrayList<String>();
		for (String str : nations) {
			listNation.add(str);
		}
		SelectionCell selectionCell = new SelectionCell(listNation);
		colNation = new Column<Team, String>(selectionCell) {

			@Override
			public String getValue(Team object) {
				return object.nation;
			}
		};
		colNation.setFieldUpdater(new FieldUpdater<Team, String>() {

			@Override
			public void update(int index, Team object, String value) {
				object.nation = value;
				playersProvider.getList().set(index, object);
			}
		});
		addColumn(colNation, "Nation");
	}
//
//	private void initHeighColumn() {
//		colHeight = new Column<Player, String>(new EditTextCell()) {
//
//			@Override
//			public String getValue(Player object) {
//				return object.height + "";
//			}
//		};
//		colHeight.setFieldUpdater(new FieldUpdater<Player, String>() {
//
//			@Override
//			public void update(int index, Player object, String value) {
//				object.height = Integer.parseInt(value);
//				playersProvider.getList().set(index, object);
//			}
//		});
//		addColumn(colHeight, " Height");
//	}
//
	private void initAvatarColumn() {
		
		ResizableImageCell imgCell = new ResizableImageCell("40px", "40px");
		colAvatar = new Column<Team, String>(imgCell) {

			@Override
			public String getValue(Team object) {
				return object.logoUrl;
			}
		};
		colAvatar.setFieldUpdater(new FieldUpdater<Team, String>() {

			@Override
			public void update(int index, Team object, String value) {
				object.logoUrl = value;
				playersProvider.getList().set(index, object);
			}
		});
		addColumn(colAvatar, "Avatar");
	}

	private void initNameColumn() {
		colName = new Column<Team, String>(new EditTextCell()) {

			@Override
			public String getValue(Team object) {
				return object.name;
			}
		};
		colName.setFieldUpdater(new FieldUpdater<Team, String>() {

			@Override
			public void update(int index, Team object, String value) {
				object.name = value;
				playersProvider.getList().set(index, object);
			}
		});
		addColumn(colName, "Name");
	}

	private void initIdColumn() {
		colId = new Column<Team, String>(new TextCell()) {

			@Override
			public String getValue(Team object) {
				return object.id.toString();
			}
		};
		addColumn(colId, "Id");
	}

	private void initTableBase() {
		setSize("1000px", "500px");
		ListHandler<Team> sortHandler = new ListHandler<Team>(playersProvider.getList());
		addColumnSortHandler(sortHandler);

		final SelectionModel<Team> selectionModel = new MultiSelectionModel<Team>(Team.KEY_PROVIDER);
		setSelectionModel(selectionModel, DefaultSelectionEventManager.<Team> createCheckboxManager());

		setEmptyTableWidget(new Label("Empty"));
		playersProvider.addDataDisplay(this);
		setFocus(false);
	}

	public void setData(List<Team> listPlayer) {
		playersProvider.setList(listPlayer);
		setRowData(playersProvider.getList());
		redraw();
	}
}
