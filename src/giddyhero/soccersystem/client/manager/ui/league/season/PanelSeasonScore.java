package giddyhero.soccersystem.client.manager.ui.league.season;

import java.util.ArrayList;
import java.util.List;

import giddyhero.soccersystem.client.SystemManager;
import giddyhero.soccersystem.client.manager.ui.player.TablePlayer;
import giddyhero.soccersystem.client.share.CSSUtils;
import giddyhero.soccersystem.shared.model.Player;
import giddyhero.soccersystem.shared.model.ScoreInfo;
import giddyhero.soccersystem.shared.model.Team;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ToggleButton;

public class PanelSeasonScore extends FlowPanel {
	TableScoreInfoCreating tblCreating;
	TableScoreInfoCreated tblCreated;
	Label lbCreated = new Label("Table"),lbCreating   = new Label("Add New Team");
	long seasonId;
	List<Team> teamAll;

	public PanelSeasonScore(List<Team> teams) {
		super();
		this.teamAll = teams;
		initTheme();
		initTable();
	}
	
	public void setSeasonId(long seasonId) {
		this.seasonId = seasonId;
	}

	private void initTheme() {
		CSSUtils.setBackgroundColor(this, "#DEDEDE");
	}

	private void initTable() {
		initLabelCreating();
		initTableCreating();
		initLabelCreated();		
		initTableCreated();
	}

	private void initLabelCreated() {
		CSSUtils.setFontSize(lbCreated, "medium");
		CSSUtils.setPadding(lbCreated, 10);
		add(lbCreated);
	}

	private void initLabelCreating() {
		CSSUtils.setFontSize(lbCreating, "medium");
		CSSUtils.setPadding(lbCreating, 10);
		add(lbCreating);		
	}

	private void initTableCreated() {
		tblCreated = new TableScoreInfoCreated(teamAll);
		add(tblCreated);		
		
	}

	private void initTableCreating() {
		tblCreating = new TableScoreInfoCreating(teamAll);
		tblCreating.setHeight("60px");

		add(tblCreating);
	}

	
	class TableScoreInfoCreated extends TableScore{
		
		public TableScoreInfoCreated(List<Team> teams) {
			super(teams);
			setHandlerToSaveButton();
		}

		private void setHandlerToSaveButton() {
			colSave.setFieldUpdater(new FieldUpdater<ScoreInfo, String>() {

				@Override
				public void update(final int index, ScoreInfo object, String value) {
					SystemManager.Service.league.saveScoreInfo(object, seasonId, new AsyncCallback<ScoreInfo>() {

						@Override
						public void onFailure(Throwable caught) {
							Window.alert("save fail : "+caught.toString());
						}

						@Override
						public void onSuccess(ScoreInfo result) {
							Window.alert("save success : "+result.toString());
						}
					});
				}
			});			
		}

		
		
	}

	class TableScoreInfoCreating extends TableScore {
		Column<ScoreInfo, String> colCreate;
		ScoreInfo scoreTemp = new ScoreInfo();

		public TableScoreInfoCreating(List<Team> teams) {
			super(teams);
			init();
			setTempData();
		}

		private void setTempData() {
			scoreTemp.id = 12398098L;
			scoreTemp.teamId = teams.get(0).id;
			ArrayList<ScoreInfo> listScore = new ArrayList<ScoreInfo>();
			listScore.add(scoreTemp);
			setData(listScore);			
		}


		private void init() {
			removeColumn(colId);
			removeColumn(colPlayed);
			removeColumn(colWin);
			removeColumn(colLose);
			removeColumn(colDraw);
			removeColumn(colGoalFor);
			removeColumn(colGoalAgaints);
			removeColumn(colGoalDifference);
			removeColumn(colPoints);
			removeColumn(colSave);
			removeColumn(colDelete);
			initColCreateButton();
		}


		private void initColCreateButton() {
			colCreate = new Column<ScoreInfo, String>(new ButtonCell()) {

				@Override
				public String getValue(ScoreInfo object) {
					return "Create";
				}
			};
			colCreate.setFieldUpdater(new FieldUpdater<ScoreInfo, String>() {

				@Override
				public void update(int index, final ScoreInfo object, String value) {
					object.id = null;
					Window.alert("Team want to created: " + object.toString());
					SystemManager.Service.league.saveScoreInfo(object, seasonId, new AsyncCallback<ScoreInfo>() {

						@Override
						public void onFailure(Throwable caught) {
							Window.alert("Save fail : "+caught.toString());
						}

						@Override
						public void onSuccess(ScoreInfo result) {
							object.id = 6632254138744832L;
							ArrayList<ScoreInfo> cloneList = new ArrayList<ScoreInfo>();
							List<ScoreInfo> targetList = tblCreated.providerScoreInfo.getList();
							for (ScoreInfo scoreInfo : targetList) {
								cloneList.add(scoreInfo);
							}
							cloneList.add(result);
							tblCreated.setData(cloneList);
						}
					});
				}
			});

			addColumn(colCreate, "Create");
		}
	}

}
