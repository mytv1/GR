package giddyhero.soccersystem.client.manager.ui.league.season;

import giddyhero.soccersystem.client.HistoryToken;
import giddyhero.soccersystem.client.SystemManager;
import giddyhero.soccersystem.client.share.CSSUtils;
import giddyhero.soccersystem.shared.model.League;
import giddyhero.soccersystem.shared.model.Match;
import giddyhero.soccersystem.shared.model.Standing;
import giddyhero.soccersystem.shared.model.Season;
import giddyhero.soccersystem.shared.model.Team;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class PanelSeason extends FlowPanel {

	Label lbLeague = new Label("League : "), lbSeason = new Label("Season : "), lbCaption = new Label(),
			lbLastUpdated = new Label();
	League league;
	Season season;
	List<Standing> standings;
	PanelSeasonMatch pnMatch;
	PanelSeasonStanding pnScoreTable;
	PanelSeasonSyncData pnSync = new PanelSeasonSyncData();

	public PanelSeason(League league, Season season) {
		this();
		this.league = league;
		this.season = season;
		lbSeason.setText("Season : " + season.year);
		lbLeague.setText("League " + league.name);
		
	}

	public PanelSeason() {
		super();
		
		SystemManager.DataCache.TeamUtils.update(new AsyncCallback<List<Team>>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(List<Team> result) {
				init();
			}
		});
	}
	
	private void init(){
		initLeagueNameColumn();
		initLabelSeasonColumn();
		initSyncPanels();
		getInfoFromHistoryToken();
	}

	private void initSyncPanels() {
		add(pnSync);
	}

	public void getInfoFromHistoryToken() {
		String token = History.getToken();
		long seasonId = Long.parseLong(token.replace(HistoryToken.SEASON, ""));
		SystemManager.Service.league.getSeason(seasonId, new AsyncCallback<Season>() {

			@Override
			public void onSuccess(Season result) {
				season = result;
				lbSeason.setText("Season : " + season.year);
				lbCaption.setText("Caption : " + season.caption);
				lbLastUpdated.setText("Last Updated : " + season.lastUpdated);
				pnSync.db.setSeason(result);
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

				SystemManager.Service.league.getStandingsById(season.id, new AsyncCallback<List<Standing>>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Get all score info fail : " + caught.toString());
					}

					@Override
					public void onSuccess(List<Standing> result) {
						// Window.alert("Get all score info success: "+result.size());
						standings = result;
						initPanelStanding();
						initPanelMatch();
						SystemManager.Service.league.getMatchOfSeason(season.id, new AsyncCallback<List<Match>>() {

							@Override
							public void onFailure(Throwable caught) {
								Window.alert("Get match of season fail " + caught.toString());
							}

							@Override
							public void onSuccess(List<Match> result) {
								Window.alert("Get match off season success : " + result.size());
								SystemManager.DataCache.MatchUtils.setMatches(result);
								pnMatch.setMatches(result);
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

	private void initPanelStanding() {
		pnScoreTable = new PanelSeasonStanding(SystemManager.DataCache.TeamUtils.teams);
		pnScoreTable.setSeasonId(season.id);
		pnScoreTable.setStandings(standings);
		add(pnScoreTable);
	}

	private void initPanelMatch() {
		pnMatch = new PanelSeasonMatch(SystemManager.DataCache.TeamUtils.teams);
		pnMatch.setSeasonId(season.id);
		add(pnMatch);
	}

	private void initLabelSeasonColumn() {
		VerticalPanel vp = new VerticalPanel();
		vp.getElement().getStyle().setWidth(100, Unit.PCT);
		CSSUtils.setBackgroundColor(vp, "#DEDEDE");
		CSSUtils.setMarginBottom(vp, 20);
		CSSUtils.setFontSize(lbSeason, "medium");
		CSSUtils.setFontSize(lbCaption, "medium");
		CSSUtils.setFontSize(lbLastUpdated, "medium");
		CSSUtils.setPadding(vp, 10);
		add(vp);
		vp.add(lbSeason);
		vp.add(lbCaption);
		vp.add(lbLastUpdated);
	}

	private void initLeagueNameColumn() {

		CSSUtils.setBackgroundColor(lbLeague, "#DEDEDE");
		CSSUtils.setMarginBottom(lbLeague, 20);
		CSSUtils.setFontSize(lbLeague, "medium");
		CSSUtils.setPadding(lbLeague, 10);
		add(lbLeague);
	}

	// public void getTeamsInSeason() {
	// for(Standing scoreInfo : scoreInfos){
	// Team team = getTeamInfo(scoreInfo.teamId);
	// if (team != null)
	// teamInSeason.add(team);
	// }
	// }
	//
	// private Team getTeamInfo(long teamId) {
	// for (Team team : teamsAll) {
	// if (team.id == teamId)
	// return team;
	// }
	// return null;
	// }

}
