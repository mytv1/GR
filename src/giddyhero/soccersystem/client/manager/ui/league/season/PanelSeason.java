package giddyhero.soccersystem.client.manager.ui.league.season;

import giddyhero.soccersystem.client.HistoryToken;
import giddyhero.soccersystem.client.SystemManager;
import giddyhero.soccersystem.client.share.CSSUtils;
import giddyhero.soccersystem.shared.model.League;
import giddyhero.soccersystem.shared.model.Match;
import giddyhero.soccersystem.shared.model.ScoreInfo;
import giddyhero.soccersystem.shared.model.Season;
import giddyhero.soccersystem.shared.model.Team;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;

public class PanelSeason extends FlowPanel {

	Label lbLeague = new Label("League : "), lbSeason = new Label("Season : ");
	League league;
	Season season;
	List<Team> teamsAll, teamInSeason = new ArrayList<Team>();
	List<ScoreInfo> scoreInfos;
	List<Match> matches;
	PanelSeasonMatch pnMatch;
	PanelSeasonScore pnScoreTable;

	public PanelSeason(League league, Season season) {
		this();
		this.league = league;
		this.season = season;
		lbSeason.setText("Season : " + season.year);
		lbLeague.setText("League " + league.name);
	}

	public PanelSeason() {
		super();
		initLeagueNameColumn();
		initLabelSeasonColumn();
		getInfoFromHistoryToken();

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
						
					}
				});
				
				SystemManager.Service.league.getScoreInfosById(season.scoreIds, new AsyncCallback<List<ScoreInfo>>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Get all score info fail : "+caught.toString());
					}

					@Override
					public void onSuccess(List<ScoreInfo> result) {
//						Window.alert("Get all score info success: "+result.size());
//						for (ScoreInfo scoreInfo : result) {
//							Window.alert(" -- "+scoreInfo.toString());
//						}
						scoreInfos = result;
						SystemManager.Service.team.getAllTeams(new AsyncCallback<List<Team>>() {

							@Override
							public void onFailure(Throwable caught) {
								Window.alert("Get all team fail");
							}

							@Override
							public void onSuccess(List<Team> result) {
								teamsAll = result;
								getTeamsInSeason();
								initPanelScoreTable();
								initPanelMatch();								
								SystemManager.Service.league.getMatchOfSeason(season.id, new AsyncCallback<List<Match>>() {

									@Override
									public void onFailure(Throwable caught) {
										Window.alert("Get match of season fail "+caught.toString());
									}

									@Override
									public void onSuccess(List<Match> result) {
										Window.alert("Get all match success: "+result.size());
										pnMatch.setMatches(result);
									}
								});
							}
						});
						
					}
				});
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("get season failure");
			}
		});

	}


	private void initPanelScoreTable() {
		pnScoreTable = new PanelSeasonScore(teamsAll);
		pnScoreTable.setSeasonId(season.id);
		pnScoreTable.tblCreated.setData(scoreInfos);
		add(pnScoreTable);
	}

	private void initPanelMatch() {
		pnMatch = new PanelSeasonMatch(teamInSeason);
		pnMatch.setSeasonId(season.id);
		add(pnMatch);
	}

	private void initLabelSeasonColumn() {
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

	public void getTeamsInSeason() {
		for(ScoreInfo scoreInfo : scoreInfos){
			Team team = getTeamInfo(scoreInfo.teamId);
			if (team != null)
				teamInSeason.add(team);
		}
//		Window.alert("Size : "+teamInSeason.size());
	}

	private Team getTeamInfo(long teamId) {
		for (Team team : teamsAll) {
			if (team.id == teamId)
				return team;
		}
		return null;
	}

//	class PanelMatch extends FlowPanel {
//
//		Button btCreateMatch = new Button("Create Match");
//		public TableInfoDisplay tblMatches = new TableInfoDisplay();
//
//		public PanelMatch() {
//			super();
//			initTheme();
//			initButton();
//			initTable();
//		}
//
//		private void initTheme() {
//			CSSUtils.setBackgroundColor(PanelMatch.this, "#DEDEDE");
//		}
//
//		private void initTable() {
//			CSSUtils.setMargin(tblMatches, 10);
//			tblMatches.setWidth("98%");
//			tblMatches.getElement().getStyle().setTextAlign(Style.TextAlign.CENTER);
//
//			tblMatches.setText(0, 0, "Time");
//			tblMatches.setText(0, 1, "Match");
//			tblMatches.setText(0, 2, "Action");
//
//			add(tblMatches);
//		}
//
//		public void initTableContent() {
//			SystemManager.Service.league.getMatchOfSeason(season.id, new AsyncCallback<List<Match>>() {
//
//				@Override
//				public void onFailure(Throwable caught) {
//					Window.alert("Get match of season failure : " + caught.toString());
//				}
//
//				@Override
//				public void onSuccess(List<Match> result) {
////					Window.alert("get " + result.size() + "match available");
//					for (int i = 0; i < result.size(); i++) {
//						final Match match = result.get(i);
//						tblMatches.setText(i + 1, 0, match.dateString);
//						tblMatches.setText(i + 1, 1,
//								SystemManager.DataCache.TeamUtils.getTeamNameOfId(match.homeTeamId) + " ___________ "
//										+ SystemManager.DataCache.TeamUtils.getTeamNameOfId(match.awayTeamId));
//						ActionPanel actionPanel = tblMatches.createActionPanelIn(i + 1, 2);
//						actionPanel.btEdit.addClickHandler(new ClickHandler() {
//							
//							@Override
//							public void onClick(ClickEvent event) {
//								Window.open("Manager.html#"+HistoryToken.MATCH_UPDATE_WINDOW+match.id, "window name", "width=1100, height=500");			
//							}
//						});
//						
//						actionPanel.btDelete.addClickHandler(new ClickHandler() {
//							
//							@Override
//							public void onClick(ClickEvent event) {
//								SystemManager.Service.league.deleteMatch(match.id, new AsyncCallback<Void>() {
//
//									@Override
//									public void onFailure(Throwable caught) {
//										Window.alert("Delete Match Failure");
//									}
//
//									@Override
//									public void onSuccess(Void result) {
//										Window.alert("Delete Success");										
//									}
//								});
//							}
//						});
//					}
//				}
//			});
//		}
//
//		private void initButton() {
//			CSSUtils.setMargin(btCreateMatch, 10);
//			btCreateMatch.addClickHandler(new ClickHandler() {
//
//				@Override
//				public void onClick(ClickEvent event) {
//					Window.open("Manager.html#" + HistoryToken.MATCH_CREATE_IN_SEASON_WINDOW + "" + season.id,
//							"window name", "width=1100, height=500");
//				}
//			});
//			add(btCreateMatch);
//		}
//	}

}
