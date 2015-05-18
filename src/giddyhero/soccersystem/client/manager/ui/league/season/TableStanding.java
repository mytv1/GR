package giddyhero.soccersystem.client.manager.ui.league.season;

import giddyhero.soccersystem.client.SystemManager;
import giddyhero.soccersystem.client.share.CSSUtils;
import giddyhero.soccersystem.shared.model.Match;
import giddyhero.soccersystem.shared.model.Player;
import giddyhero.soccersystem.shared.model.Standing;
import giddyhero.soccersystem.shared.model.Team;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.cell.client.SelectionCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SelectionModel;

public class TableStanding extends DataGrid<Standing> {
	ListDataProvider<Standing> providerScoreInfo = new ListDataProvider<>(Standing.KEY_PROVIDER);
	public Column<Standing, String> colId, colTeam, colSave, colDelete, colWin, colPlayed, colGoalFor, colGoalAgaints,
			colGoalDifference, colLose, colPoints, colDraw;
	ListHandler<Standing> sortHandler = new ListHandler<Standing>(providerScoreInfo.getList());
	List<Standing> scoreInfos;
	List<Team> teams;

	public TableStanding(List<Team> teams) {
		super(Standing.KEY_PROVIDER);
		this.teams = teams;
		init();
		style();
	}

	private void style() {
		CSSUtils.setMarginCenter(this);
	}

	private void init() {
		initTableBase();
		initColumn();
	}


	private void initColumn() {
		initIdColumn();
		initTeamColumn();
		initPlayedColumn();
		initWinColumn();
		initDrawColumn();
		initLoseColumn();
		initGoalForColumn();
		initGoalAgaintsColumn();
		initGoalDifferenceColumn();
		initPointColumn();
		initSaveColumn();
		initDeleteColumn();
	}
	
	private void initPointColumn() {
		colPoints = new Column<Standing, String>(new TextCell()) {

			@Override
			public String getValue(Standing object) {
				return (object.win*3 + object.draw*1) + "";
			}
		};
		colPoints.setSortable(true);
		 sortHandler.setComparator(colPoints, new Comparator<Standing>() {
		      @Override
		      public int compare(Standing o1, Standing o2) {
		    	 int p1 = Integer.parseInt(colPoints.getValue(o1));
		    	 int p2 = Integer.parseInt(colPoints.getValue(o2));
		    	
		        return p1 - p2;
		      }
		    });
		addColumn(colPoints, "Point");		
	}

	private void initLoseColumn() {
		colLose = new Column<Standing, String>(new TextCell()) {

			@Override
			public String getValue(Standing object) {
				return object.lose + "";
			}
		};
		addColumn(colLose, "Lose");
	}
	
	private void initDrawColumn() {
		colDraw = new Column<Standing, String>(new EditTextCell()) {

			@Override
			public String getValue(Standing object) {
				return object.draw + "";
			}
		};
		addColumn(colDraw, "Draw");
	}

	private void initDeleteColumn() {
	colDelete = new Column<Standing, String>(new ButtonCell()) {

		@Override
		public String getValue(Standing object) {
			return "Delete";
		}
	};

	colDelete.setFieldUpdater(new FieldUpdater<Standing, String>() {

		@Override
		public void update(final int index, Standing object, String value) {
			// Window.alert("U click on player : ");
			SystemManager.Service.league.deleteScoreInfo(object.id, new AsyncCallback<Void>() {

				@Override
				public void onFailure(Throwable caught) {
					Window.alert("delete fail : "+caught.toString());
				}

				@Override
				public void onSuccess(Void result) {
					Window.alert("Delete success!");
					providerScoreInfo.getList().remove(index);
					redraw();
				}
			});
		}
	});
	addColumn(colDelete, "Delete");
}

private void initSaveColumn() {
	colSave = new Column<Standing, String>(new ButtonCell()) {

		@Override
		public String getValue(Standing object) {
			return "Save";
		}
	};

	addColumn(colSave, "Save");
}

	private void initTeamColumn() {
		ArrayList<String> listTeam = new ArrayList<String>();
		for (Team team : teams) {
			listTeam.add("" + team.name + " (" + team.id + ")");
		}
		SelectionCell selectionCell = new SelectionCell(listTeam);
		colTeam = new Column<Standing, String>(selectionCell) {
			@Override
			public String getValue(Standing object) {
				for (Team team : teams) {
					if (team.id == object.teamId)
						return "" + team.name + " (" + team.id + ")";
				}
				return "N/A team";
			}
		};
		colTeam.setSortable(true);
		colTeam.setFieldUpdater(new FieldUpdater<Standing, String>() {

			@Override
			public void update(int index, Standing object, String value) {
				int i = value.indexOf('(');
				String subStr = value.substring(i + 1, value.indexOf(')'));
//				Window.alert("substr : " + subStr);
				object.teamId = Long.parseLong(subStr);
				providerScoreInfo.getList().set(index, object);
			}
		});
		setColumnWidth(colTeam, "150px");
		addColumn(colTeam, "Team");
	}

	private void initWinColumn() {
		colWin = new Column<Standing, String>(new EditTextCell()) {

			@Override
			public String getValue(Standing object) {
				return object.win + "";
			}
		};
		colWin.setFieldUpdater(new FieldUpdater<Standing, String>() {

			@Override
			public void update(int index, Standing object, String value) {
				object.win = Integer.parseInt(value);
				providerScoreInfo.getList().set(index, object);
			}
		});
		addColumn(colWin, "Win");
	}

	private void initPlayedColumn() {
		colPlayed = new Column<Standing, String>(new EditTextCell()) {

			@Override
			public String getValue(Standing object) {
				return object.played + "";
			}
		};
		colPlayed.setFieldUpdater(new FieldUpdater<Standing, String>() {

			@Override
			public void update(int index, Standing object, String value) {
				object.played = Integer.parseInt(value);
				providerScoreInfo.getList().set(index, object);
			}
		});
		addColumn(colPlayed, "Played");
	}

	private void initGoalForColumn() {
		colGoalFor = new Column<Standing, String>(new EditTextCell()) {

			@Override
			public String getValue(Standing object) {
				return object.goalFor + "";
			}
		};
		colGoalFor.setFieldUpdater(new FieldUpdater<Standing, String>() {

			@Override
			public void update(int index, Standing object, String value) {
				object.goalFor = Integer.parseInt(value);
				providerScoreInfo.getList().set(index, object);
			}
		});
		addColumn(colGoalFor, "Goal For");
	}

	private void initGoalAgaintsColumn() {
		colGoalAgaints = new Column<Standing, String>(new EditTextCell()) {

			@Override
			public String getValue(Standing object) {
				return object.goalAgaints + "";
			}
		};
		colGoalAgaints.setFieldUpdater(new FieldUpdater<Standing, String>() {

			@Override
			public void update(int index, Standing object, String value) {
				object.goalAgaints = Integer.parseInt(value);
				providerScoreInfo.getList().set(index, object);
			}
		});
		addColumn(colGoalAgaints, "Goal Againts");
	}

	private void initGoalDifferenceColumn() {
		colGoalDifference = new Column<Standing, String>(new TextCell()) {

			@Override
			public String getValue(Standing object) {
				return (object.goalFor - object.goalAgaints) + "";
			}
		};
		addColumn(colGoalDifference, "Goal Diff");
	}

	private void initIdColumn() {
		colId = new Column<Standing, String>(new TextCell()) {

			@Override
			public String getValue(Standing object) {
				return object.id.toString();
			}
		};
		addColumn(colId, "Id");
	}

	private void initTableBase() {
		setSize("1000px", "700px");
		
		addColumnSortHandler(sortHandler);

		final SelectionModel<Standing> selectionModel = new MultiSelectionModel<Standing>(Standing.KEY_PROVIDER);
		setSelectionModel(selectionModel, DefaultSelectionEventManager.<Standing> createCheckboxManager());

		setEmptyTableWidget(new Label("Empty"));
		providerScoreInfo.addDataDisplay(this);
		setFocus(false);
	}

	public void setData(List<Standing> scoreInfos) {
		providerScoreInfo.setList(scoreInfos);
		setRowData(providerScoreInfo.getList());
		sortHandler.setList(providerScoreInfo.getList());
		redraw();
	}
}
