package giddyhero.soccersystem.client.manager.ui.league.season;

import java.util.List;

import giddyhero.soccersystem.client.HistoryToken;
import giddyhero.soccersystem.client.SystemManager;
import giddyhero.soccersystem.client.SystemManager.DataCache.TeamUtils;
import giddyhero.soccersystem.client.manager.ui.widget.TableInfoDisplay;
import giddyhero.soccersystem.client.manager.widget.SSFlexTable.ActionPanel;
import giddyhero.soccersystem.client.share.CSSUtils;
import giddyhero.soccersystem.shared.model.League;
import giddyhero.soccersystem.shared.model.Match;
import giddyhero.soccersystem.shared.model.Season;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class PanelSeasonOverView extends FlowPanel {

	Label lbLeague = new Label("League : "), lbSeason = new Label("Season : ");
	League league;
	Season season;
	PanelMatch pnMatch;
	PanelScoreTable pnScoreTable;

	public PanelSeasonOverView(League league, Season season) {
		this();
		this.league = league;
		this.season = season;
		lbSeason.setText("Season : " + season.year);
		lbLeague.setText("League " + league.name);
	}

	public PanelSeasonOverView() {
		super();
		getInfoFromHistoryToken();
		init();
	}

	public void getInfoFromHistoryToken() {
		String token = History.getToken();
		long seasonId = Long.parseLong(token.replace(HistoryToken.SEASON, ""));
		SystemManager.Service.league.getSeason(seasonId, new AsyncCallback<Season>() {

			@Override
			public void onSuccess(Season result) {
				season = result;
				lbSeason.setText("Season : " + season.year);
				SystemManager.Service.league.getLeague(season.leagueId, new AsyncCallback<League>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Get League Failure");
					}

					@Override
					public void onSuccess(League result) {
						league = result;
						lbLeague.setText("League " + league.name);
						pnMatch.initTableContent();
					}
				});
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("get season failure");
			}
		});

	}

	private void init() {
		initLeagueNameColumn();
		initSeasonColumn();
		initPanelScoreTable();
		initPanelMatch();
	}

	private void initPanelScoreTable() {
		pnScoreTable = new PanelScoreTable();
		add(pnScoreTable);
	}

	private void initPanelMatch() {
		pnMatch = new PanelMatch();
		add(pnMatch);
	}

	private void initSeasonColumn() {
		CSSUtils.setBackgroundColor(lbSeason, "#DEDEDE");
		CSSUtils.setMarginBottom(lbSeason, 20);
		CSSUtils.setFontSize(lbSeason, "medium");
		CSSUtils.setPadding(lbSeason, 10);
		add(lbSeason);
	}

	private void initLeagueNameColumn() {
		CSSUtils.setBackgroundColor(lbLeague, "#DEDEDE");
		CSSUtils.setMarginBottom(lbLeague, 20);
		CSSUtils.setFontSize(lbLeague, "medium");
		CSSUtils.setPadding(lbLeague, 10);
		add(lbLeague);
	}

	class PanelScoreTable extends FlowPanel {

		Button btCreateMatch = new Button("Create Table");
		FlexTable tblScore = new FlexTable();

		public PanelScoreTable() {
			super();
			initTheme();
			initButton();
			initTable();
		}

		private void initTheme() {
			CSSUtils.setBackgroundColor(PanelScoreTable.this, "#DEDEDE");
		}

		private void initTable() {
			CSSUtils.setMargin(tblScore, 10);
			tblScore.setWidth("90%");
			tblScore.getElement().getStyle().setTextAlign(Style.TextAlign.CENTER);

			tblScore.setText(0, 0, "Rank");
			tblScore.setText(0, 1, "Team Name");
			tblScore.setText(0, 2, "Played");
			tblScore.setText(0, 3, "Win");
			tblScore.setText(0, 4, "Goal For");
			tblScore.setText(0, 5, "Goal Againts");
			tblScore.setText(0, 6, "Goal Difference");
			tblScore.setText(0, 7, "Point");

			add(tblScore);
		}

		private void initButton() {
			CSSUtils.setMargin(btCreateMatch, 10);
			add(btCreateMatch);
		}
	}

	class PanelMatch extends FlowPanel {

		Button btCreateMatch = new Button("Create Match");
		public TableInfoDisplay tblMatches = new TableInfoDisplay();

		public PanelMatch() {
			super();
			initTheme();
			initButton();
			initTable();
		}

		private void initTheme() {
			CSSUtils.setBackgroundColor(PanelMatch.this, "#DEDEDE");
		}

		private void initTable() {
			CSSUtils.setMargin(tblMatches, 10);
			tblMatches.setWidth("98%");
			tblMatches.getElement().getStyle().setTextAlign(Style.TextAlign.CENTER);

			tblMatches.setText(0, 0, "Time");
			tblMatches.setText(0, 1, "Match");
			tblMatches.setText(0, 2, "Action");

			add(tblMatches);
		}

		public void initTableContent() {
			SystemManager.Service.league.getMatchOfSeason(season.id, new AsyncCallback<List<Match>>() {

				@Override
				public void onFailure(Throwable caught) {
					Window.alert("Get match of season failure : " + caught.toString());
				}

				@Override
				public void onSuccess(List<Match> result) {
//					Window.alert("get " + result.size() + "match available");
					for (int i = 0; i < result.size(); i++) {
						final Match match = result.get(i);
						tblMatches.setText(i + 1, 0, match.dateString);
						tblMatches.setText(i + 1, 1,
								SystemManager.DataCache.TeamUtils.getTeamNameOfId(match.homeTeamId) + " ___________ "
										+ SystemManager.DataCache.TeamUtils.getTeamNameOfId(match.awayTeamId));
						ActionPanel actionPanel = tblMatches.createActionPanelIn(i + 1, 2);
						actionPanel.btEdit.addClickHandler(new ClickHandler() {
							
							@Override
							public void onClick(ClickEvent event) {
								Window.open("Manager.html#"+HistoryToken.MATCH_UPDATE_WINDOW+match.id, "window name", "width=1100, height=500");			
							}
						});
						
						actionPanel.btDelete.addClickHandler(new ClickHandler() {
							
							@Override
							public void onClick(ClickEvent event) {
								SystemManager.Service.league.deleteMatch(match.id, new AsyncCallback<Void>() {

									@Override
									public void onFailure(Throwable caught) {
										Window.alert("Delete Match Failure");
									}

									@Override
									public void onSuccess(Void result) {
										Window.alert("Delete Success");										
									}
								});
							}
						});
					}
				}
			});
		}

		private void initButton() {
			CSSUtils.setMargin(btCreateMatch, 10);
			btCreateMatch.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					Window.open("Manager.html#" + HistoryToken.MATCH_CREATE_IN_SEASON_WINDOW + "" + season.id,
							"window name", "width=1100, height=500");
				}
			});
			add(btCreateMatch);
		}
	}

}
