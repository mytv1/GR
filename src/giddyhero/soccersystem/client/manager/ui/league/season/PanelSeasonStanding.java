package giddyhero.soccersystem.client.manager.ui.league.season;

import java.util.ArrayList;
import java.util.List;

import giddyhero.soccersystem.client.SystemManager;
import giddyhero.soccersystem.client.manager.ui.player.TablePlayer;
import giddyhero.soccersystem.client.share.CSSUtils;
import giddyhero.soccersystem.shared.model.Match;
import giddyhero.soccersystem.shared.model.Player;
import giddyhero.soccersystem.shared.model.Standing;
import giddyhero.soccersystem.shared.model.Team;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ToggleButton;
import com.google.gwt.user.client.ui.VerticalPanel;

public class PanelSeasonStanding extends FlowPanel {
	TableScoreInfoCreating tblCreating;
	TableScoreInfoCreated tblCreated;
	Label lbCreated = new Label("Table"),lbCreating   = new Label("Add New Team");
	long seasonId;
	List<Standing> standings = new ArrayList<>();
	List<Team> teamAll;

	public PanelSeasonStanding(List<Team> teams) {
		super();
		this.teamAll = teams;
		initTheme();
		initTable();
	}
	
	public void setStandings(List<Standing> standings) {
		this.standings = standings;
		tblCreated.setData(standings);
	}
	
	public void setSeasonId(long seasonId) {
		this.seasonId = seasonId;
	}

	private void initTheme() {
		CSSUtils.setBackgroundColor(this, "#DEDEDE");
	}

	private void initTable() {
		initGenerateComponent();
		initLabelCreating();
		initTableCreating();
		initLabelCreated();		
		initTableCreated();
	}

	private void initGenerateComponent() {
		VerticalPanel vp = new VerticalPanel();
		vp.setWidth("100%");
		add(vp);
		
		Label lbTitle = new Label("Generate From Matches");
		CSSUtils.setFontSize(lbTitle, "medium");
		CSSUtils.setPadding(lbTitle, 10);
		lbTitle.getElement().getStyle().setFontWeight(FontWeight.BOLD);
		vp.add(lbTitle);
		
		HorizontalPanel hp = new HorizontalPanel();
		vp.add(hp);
		
		Button btGenerate = new Button("Generate");
		btGenerate.setSize("250px", "40px");
		btGenerate.getElement().getStyle().setMarginLeft(40, Unit.PX);
		btGenerate.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				SystemManager.Service.league.getMatchOfSeason(seasonId, new AsyncCallback<List<Match>>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Get all match of season "+seasonId+" fail");
					}

					@Override
					public void onSuccess(List<Match> result) {
						Window.alert("Calculating!....");
						ServiceSyncSeason.generateStandingFromMatches(seasonId,result,standings);				
						SystemManager.Service.league.saveStandings(seasonId, standings, new AsyncCallback<List<Standing>>() {

							@Override
							public void onFailure(Throwable caught) {
								Window.alert("Save standing fail : "+caught.toString());								
							}

							@Override
							public void onSuccess(List<Standing> result) {
								Window.alert("Save standing success : "+result.size()+"\n");
								String alert = "";
								for (Standing standing : result) {
									alert += standing.teamName + " ( " + standing.win + " - " + standing.draw + " - " + standing.lose + " ) "
											+ standing.played + " ( " + standing.goalFor + " - " + standing.goalAgaints + ")\n";
								}
								Window.alert(alert);
								tblCreated.setData(result);
							}
						});
					}
					
				});
				
			}
		});
		hp.add(btGenerate);
		
		Label lbNote = new Label("Generate table from played matches");
		lbNote.getElement().getStyle().setMarginLeft(40, Unit.PX);
		hp.add(lbNote);
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

	
	class TableScoreInfoCreated extends TableStanding{
		
		public TableScoreInfoCreated(List<Team> teams) {
			super(teams);
			setHandlerToSaveButton();
		}

		private void setHandlerToSaveButton() {
			colSave.setFieldUpdater(new FieldUpdater<Standing, String>() {

				@Override
				public void update(final int index, Standing object, String value) {
					SystemManager.Service.league.saveStanding(object, seasonId, new AsyncCallback<Standing>() {

						@Override
						public void onFailure(Throwable caught) {
							Window.alert("save fail : "+caught.toString());
						}

						@Override
						public void onSuccess(Standing result) {
							Window.alert("save success : "+result.toString());
						}
					});
				}
			});			
		}

		
		
	}

	class TableScoreInfoCreating extends TableStanding {
		Column<Standing, String> colCreate;
		Standing scoreTemp = new Standing();

		public TableScoreInfoCreating(List<Team> teams) {
			super(teams);
			init();
			setTempData();
		}

		private void setTempData() {
			scoreTemp.id = 12398098L;
			scoreTemp.teamId = teams.get(0).id;
			ArrayList<Standing> listScore = new ArrayList<Standing>();
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
			colCreate = new Column<Standing, String>(new ButtonCell()) {

				@Override
				public String getValue(Standing object) {
					return "Create";
				}
			};
			colCreate.setFieldUpdater(new FieldUpdater<Standing, String>() {

				@Override
				public void update(int index, final Standing object, String value) {
					object.id = null;
					Window.alert("Team want to created: " + object.toString());
					SystemManager.Service.league.saveStanding(object, seasonId, new AsyncCallback<Standing>() {

						@Override
						public void onFailure(Throwable caught) {
							Window.alert("Save fail : "+caught.toString());
						}

						@Override
						public void onSuccess(Standing result) {
							object.id = 6632254138744832L;
							ArrayList<Standing> cloneList = new ArrayList<Standing>();
							List<Standing> targetList = tblCreated.providerScoreInfo.getList();
							for (Standing scoreInfo : targetList) {
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
