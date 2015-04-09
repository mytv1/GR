package giddyhero.soccersystem.client.manager.ui.league.season;

import giddyhero.soccersystem.client.HistoryToken;
import giddyhero.soccersystem.client.SystemManager;
import giddyhero.soccersystem.client.manager.ui.widget.ResizableImageCell;
import giddyhero.soccersystem.client.share.CSSUtils;
import giddyhero.soccersystem.shared.model.Match;
import giddyhero.soccersystem.shared.model.ScoreInfo;
import giddyhero.soccersystem.shared.model.Team;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.DatePickerCell;
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

public class TableMatch extends DataGrid<Match> {
	ListDataProvider<Match> matchProvider = new ListDataProvider<>(Match.KEY_PROVIDER);
	public Column<Match, String> colId,  colName, colTeam, colSave, colDetail,
			colDelete, colStatus,  colMinutes, colDate;
	List<Team> teams;

	// List<Team> teams;

	public TableMatch(List<Team> teams) {
		super(Match.KEY_PROVIDER);
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
		initHomeTeamColumn();
		initAwayTeamColumn();
		initStatusColumn();
		initMinutesColumn();
		initDateColumn();
		initDetailColumn();
		initSaveColumn();
		initDeleteColumn();
	}

	private void initDetailColumn() {
		colDetail = new Column<Match, String>(new ButtonCell()) {

			@Override
			public String getValue(Match object) {
				return "Detail";
			}
		};

		colDetail.setFieldUpdater(new FieldUpdater<Match, String>() {

			@Override
			public void update(final int index, Match object, String value) {
				Window.open("Manager.html#"+HistoryToken.MATCH_UPDATE_WINDOW+object.id, "window name", "width=1100, height=500");
			}
		});
		addColumn(colDetail, "Delete");
	}

	private void initStatusColumn() {
		colStatus = new Column<Match, String>(new EditTextCell()) {

			@Override
			public String getValue(Match object) {
				return object.status;
			}
		};
		colStatus.setFieldUpdater(new FieldUpdater<Match, String>() {

			@Override
			public void update(int index, Match object, String value) {
				object.status = value;
				matchProvider.getList().set(index, object);
			}
		});
		addColumn(colStatus, "Status");
	}

	private void initDateColumn() {
		colDate = new Column<Match, String>(new EditTextCell()) {

			@Override
			public String getValue(Match object) {
				return object.dateString;
			}
		};
		colDate.setFieldUpdater(new FieldUpdater<Match, String>() {

			@Override
			public void update(int index, Match object, String value) {
				object.dateString = value;
				matchProvider.getList().set(index, object);
			}
		});
		addColumn(colDate, "Date");
	}

	private void initMinutesColumn() {
		colMinutes = new Column<Match, String>(new EditTextCell()) {

			@Override
			public String getValue(Match object) {
				return object.minutes;
			}
		};
		colMinutes.setFieldUpdater(new FieldUpdater<Match, String>() {

			@Override
			public void update(int index, Match object, String value) {
				object.minutes = value;
				matchProvider.getList().set(index, object);
			}
		});
		addColumn(colMinutes, "Minutes");
	}

	private void initDeleteColumn() {
		colDelete = new Column<Match, String>(new ButtonCell()) {

			@Override
			public String getValue(Match object) {
				return "Delete";
			}
		};

		colDelete.setFieldUpdater(new FieldUpdater<Match, String>() {

			@Override
			public void update(final int index, Match object, String value) {
				SystemManager.Service.league.deleteMatch(object.id, new AsyncCallback<Void>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Delete player failure : " + caught.toString());
					}

					@Override
					public void onSuccess(Void result) {
						Window.alert("Delete player success");
						matchProvider.getList().remove(index);
						redraw();
					}
				});
			}
		});
		addColumn(colDelete, "Delete");
	}

	private void initSaveColumn() {
		colSave = new Column<Match, String>(new ButtonCell()) {

			@Override
			public String getValue(Match object) {
				return "Save";
			}
		};

		addColumn(colSave, "Save");
	}

	private void initHomeTeamColumn() {
		ArrayList<String> listTeam = new ArrayList<String>();
		for (Team team : teams) {
			listTeam.add("" + team.name + " (" + team.id + ")");
		}
		SelectionCell selectionCell = new SelectionCell(listTeam);
		colTeam = new Column<Match, String>(selectionCell) {
			@Override
			public String getValue(Match object) {
				for (Team team : teams) {
					if (team.id == object.homeTeamId)
						return "" + team.name + " (" + team.id + ")";
				}
				return "N/A team";
			}
		};
		colTeam.setFieldUpdater(new FieldUpdater<Match, String>() {

			@Override
			public void update(int index, Match object, String value) {
				int i = value.indexOf('(');
				String subStr = value.substring(i + 1, value.indexOf(')'));
				object.homeTeamId = Long.parseLong(subStr);
				matchProvider.getList().set(index, object);
			}
		});
		addColumn(colTeam, "Home Team");
	}

	private void initAwayTeamColumn() {
		ArrayList<String> listTeam = new ArrayList<String>();
		for (Team team : teams) {
			listTeam.add("" + team.name + " (" + team.id + ")");
		}
		SelectionCell selectionCell = new SelectionCell(listTeam);
		colTeam = new Column<Match, String>(selectionCell) {
			@Override
			public String getValue(Match object) {
				for (Team team : teams) {
					if (team.id == object.awayTeamId)
						return "" + team.name + " (" + team.id + ")";
				}
				return "N/A team";
			}
		};
		colTeam.setFieldUpdater(new FieldUpdater<Match, String>() {

			@Override
			public void update(int index, Match object, String value) {
				int i = value.indexOf('(');
				String subStr = value.substring(i + 1, value.indexOf(')'));
				object.awayTeamId = Long.parseLong(subStr);
				matchProvider.getList().set(index, object);
			}
		});
		addColumn(colTeam, "Away Team");
	}

	private void initIdColumn() {
		colId = new Column<Match, String>(new TextCell()) {

			@Override
			public String getValue(Match object) {
				return object.id.toString();
			}
		};
		addColumn(colId, "Id");
	}

	private void initTableBase() {
		setSize("1000px", "450px");
		ListHandler<Match> sortHandler = new ListHandler<Match>(matchProvider.getList());
		addColumnSortHandler(sortHandler);

		final SelectionModel<Match> selectionModel = new MultiSelectionModel<Match>(Match.KEY_PROVIDER);
		setSelectionModel(selectionModel, DefaultSelectionEventManager.<Match> createCheckboxManager());

		setEmptyTableWidget(new Label("Empty"));
		matchProvider.addDataDisplay(this);
		setFocus(false);
	}

	public void setData(List<Match> listPlayer) {
		matchProvider.setList(listPlayer);
		setRowData(matchProvider.getList());
		redraw();
	}
}
