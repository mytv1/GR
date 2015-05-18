package giddyhero.soccersystem.client.manager.ui.league.season;

import giddyhero.soccersystem.client.SystemManager;
import giddyhero.soccersystem.client.externaldb.apifootballdata.Model;
import giddyhero.soccersystem.client.externaldb.apifootballdata.Model.FootBallDataMatch;
import giddyhero.soccersystem.client.externaldb.apifootballdata.Model.FootBallDataPlayer;
import giddyhero.soccersystem.client.externaldb.apifootballdata.Model.FootBallDataPlayers;
import giddyhero.soccersystem.client.externaldb.apifootballdata.Model.FootBallDataSeasonInfo;
import giddyhero.soccersystem.client.externaldb.apifootballdata.Model.FootBallDataSeasonMatches;
import giddyhero.soccersystem.client.externaldb.apifootballdata.Model.FootBallDataSeasonTeams;
import giddyhero.soccersystem.client.externaldb.apifootballdata.Model.FootBallDataTeam;
import giddyhero.soccersystem.shared.model.Match;
import giddyhero.soccersystem.shared.model.Player;
import giddyhero.soccersystem.shared.model.Season;
import giddyhero.soccersystem.shared.model.Standing;
import giddyhero.soccersystem.shared.model.Team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ServiceSyncSeason {

	static Season season;
	static int siteSeasonId;
	static String TOKEN = "ae9a49c6d8b94af990243ca44cd5a4d9";
	static String ADDRESS_URL = "http://api.football-data.org/alpha/";

	public static void sync(Season season, int siteId, boolean isSyncBasicInfo, boolean isSyncTeams,
			 boolean isSyncPlayers,boolean isSyncFixtures) {
		ServiceSyncSeason.season = season;
		ServiceSyncSeason.siteSeasonId = siteId;
		if (isSyncBasicInfo)
			syncBasicInformation();
		if (isSyncTeams)
			syncTeams(isSyncPlayers);
		if (isSyncFixtures)
			syncFixtures();
	}

	private static void syncFixtures() {
		String url = ADDRESS_URL + "soccerseasons/" + siteSeasonId + "/fixtures";
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(url));
		builder.setHeader("X-Auth-Token", TOKEN);
		builder.setTimeoutMillis(20000);
		try {

			Request request = builder.sendRequest(null, new RequestCallback() {
				public void onError(Request request, Throwable exception) {
					// Couldn't connect to server (could be timeout, SOP
					// violation, etc.)
				}

				public void onResponseReceived(Request request, Response response) {
					if (200 == response.getStatusCode()) {
						String jsonStr = response.getText();
						FootBallDataSeasonMatches data = Model.parseSeasonMatchesJson(jsonStr);
						updateMatches(data);
						// Window.alert("Caption : "+jsonStr);
					} else {
						Window.alert("Error : " + response.getStatusText());
					}
				}

			});

		} catch (RequestException e) {
			// Couldn't connect to server
		}
	}

	public static void syncBasicInformation() {
		String url = ADDRESS_URL + "soccerseasons/" + siteSeasonId;
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(url));
		builder.setHeader("X-Auth-Token", TOKEN);
		builder.setTimeoutMillis(10000);
		try {

			Request request = builder.sendRequest(null, new RequestCallback() {
				public void onError(Request request, Throwable exception) {
					// Couldn't connect to server (could be timeout, SOP
					// violation, etc.)
				}

				public void onResponseReceived(Request request, Response response) {
					if (200 == response.getStatusCode()) {
						String jsonStr = response.getText();
						FootBallDataSeasonInfo data = Model.parseSeasonInfoJson(jsonStr);
						updateBasicInfo(data);
						// Window.alert("Caption : "+data.getCaption());
					} else {
						Window.alert("Error : " + response.getStatusText());
					}
				}
			});

		} catch (RequestException e) {
			// Couldn't connect to server
		}
	}

	static void updateBasicInfo(FootBallDataSeasonInfo data) {
		String caption = data.getCaption();
		String lastUpdate = data.getLastUpdate();
		season.caption = caption;
		season.lastUpdated = lastUpdate;
		SystemManager.Service.league.saveSeason(season, new AsyncCallback<Season>() {

			@Override
			public void onSuccess(Season result) {
				Window.alert("Update basic info success : " + "\n Caption : " + result.caption + "\n Last Updated : "
						+ result.lastUpdated);
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Update basic info fail : " + caught.toString());
			}
		});
	}

	private static void syncTeams(final boolean isSyncPlayers) {
		String url = ADDRESS_URL + "soccerseasons/" + siteSeasonId + "/teams";
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(url));
		builder.setHeader("X-Auth-Token", "ae9a49c6d8b94af990243ca44cd5a4d9");
		builder.setTimeoutMillis(10000);
		try {

			Request request = builder.sendRequest(null, new RequestCallback() {
				public void onError(Request request, Throwable exception) {
					// Couldn't connect to server (could be timeout, SOP
					// violation, etc.)
					Window.alert("Error : " + exception.toString());
				}

				public void onResponseReceived(Request request, Response response) {
					if (200 == response.getStatusCode()) {
						String jsonStr = response.getText();
						FootBallDataSeasonTeams data = Model.parseSeasonTeamsJson(jsonStr);
//						JsArray<FootBallDataTeam> dataTeams = data.getTeams();
//						Window.alert("Link : "+dataTeams.get(0).getPlayersLink());
						updateTeams(data,isSyncPlayers);
					} else {
						Window.alert("Error : " + response.getStatusText());
					}
				}
			});

		} catch (RequestException e) {
			// Couldn't connect to server
		}
	}

	private static void updateMatches(FootBallDataSeasonMatches data) {
		JsArray<FootBallDataMatch> dataTeams = data.getMatches();
		final Match[] matches = new Match[dataTeams.length()];
		for (int i = 0; i < dataTeams.length(); i++) {
			FootBallDataMatch dataMatch = dataTeams.get(i);
			Match match = dataMatch.toMatch();
			long id = SystemManager.DataCache.MatchUtils.isMatchExist(match);
			if (id != -1)
				match.id = id;
			long homeId = SystemManager.DataCache.TeamUtils.isTeamExist(match.homeTeamName);
			if (homeId != -1)
				match.homeTeamId = homeId;
			long awayId = SystemManager.DataCache.TeamUtils.isTeamExist(match.awayTeamName);
			if (awayId != -1)
				match.awayTeamId = awayId;
			matches[i] = match;
		}

		SystemManager.Service.league.saveMatches(season, matches, new AsyncCallback<Integer>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Save matches fail : " + caught.toString());
			}

			@Override
			public void onSuccess(Integer result) {
				String alert = "Save " + result + " matches success : ";
				int newNumber = 0, updatedNumber = 0;
				for (int i = 0; i < matches.length; i++) {
					if (matches[i].id != null)
						updatedNumber++;
					else
						newNumber++;
				}
				Window.alert(alert + "\n New : " + newNumber + "\n Updated : " + updatedNumber);
			}
		});
		// Window.alert(dataTeams.get(0).getHomeTeamName()+" --- size : "+dataTeams.length());
	}

	static void updateTeams(FootBallDataSeasonTeams data, final boolean isSyncPlayers) {
		JsArray<FootBallDataTeam> dataTeams = data.getTeams();
		final Map<String, String> teamPlayersLink = new HashMap<>();
		final List<Team> teams = new ArrayList<Team>();
		for (int i = 0; i < dataTeams.length(); i++) {
			FootBallDataTeam dataTeam = dataTeams.get(i);
			Team team = dataTeam.toTeam();
			long id = SystemManager.DataCache.TeamUtils.isTeamExist(team.name);
			if (id != -1)
				team.id = id;
			teams.add(team);
			if (isSyncPlayers)
				teamPlayersLink.put(dataTeam.getName(), dataTeam.getPlayersLink());
		}
		SystemManager.DataCache.TeamUtils.saveTeams(teams, new AsyncCallback<List<Team>>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Save team fail : " + caught.toString());
			}

			@Override
			public void onSuccess(final List<Team> result) {
				String alert = "Save " + result.size() + " teams success : ";
				for (int i = 0; i < teams.size(); i++) {
					if (teams.get(i).id != null)
						alert += "\n (Updated) ";
					else
						alert += "\n (New) ";
					alert += teams.get(i).name;
				}
				if (isSyncPlayers)
				{
					SystemManager.DataCache.PlayerUtils.update(new AsyncCallback<List<Player>>() {

						@Override
						public void onFailure(Throwable caught) {
							Window.alert("update all player failure : "+caught.toString());
						}

						@Override
						public void onSuccess(List<Player> players) {
							syncPlayers(result,teamPlayersLink);							
						}
					});
				
				}
				Window.alert(alert);
			}
		});
	}
	
	public static void syncPlayers(List<Team> teams, Map<String, String> teamPlayersLink){
		for (Entry<String, String> entry : teamPlayersLink.entrySet()) {
			for (Team team : teams) {
				if (team.name.equalsIgnoreCase(entry.getKey())){
					savePlayersFromLink(team, entry.getValue());
					break;
				}
			}
		}
	}
	
	static void savePlayersFromLink(final Team team,String url){
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(url));
		builder.setHeader("X-Auth-Token", "ae9a49c6d8b94af990243ca44cd5a4d9");
		builder.setTimeoutMillis(10000);
		try {

			Request request = builder.sendRequest(null, new RequestCallback() {
				public void onError(Request request, Throwable exception) {
					Window.alert("Error : " + exception.toString());
				}

				public void onResponseReceived(Request request, Response response) {
					if (200 == response.getStatusCode()) {
						String jsonStr = response.getText();
						FootBallDataPlayers data = Model.parseTeamPlayersJson(jsonStr);
						savePlayersToTeam(data,team);
					} else {
						Window.alert("Error : " + response.getStatusText());
					}
				}
			});

		} catch (RequestException e) {
			// Couldn't connect to server
		}
	}
	

	protected static void savePlayersToTeam(FootBallDataPlayers data, final Team team) {
		Window.alert("Save players of team : "+team.name);
		JsArray<FootBallDataPlayer> dataPlayers = data.getPlayers();
		final List<Player> players = new ArrayList<Player>();
		for (int i = 0; i < dataPlayers.length(); i++) {
			FootBallDataPlayer dataPlayer = dataPlayers.get(i);
			Player player = dataPlayer.toPlayer();
			long id = SystemManager.DataCache.PlayerUtils.isPlayerExist(player);
			if (id != -1)
				player.id = id;
			player.currentTeamId = team.id;
			players.add(player);
		}
		SystemManager.DataCache.PlayerUtils.savePlayers(players, new AsyncCallback<List<Player>>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Save player of team "+team.name+" fail :"+caught.toString());
			}

			@Override
			public void onSuccess(List<Player> result) {
				String alert = "Save player of team "+team.name+" success! ";
				for (int i = 0; i < players.size(); i++) {
					if (players.get(i).id != null)
						alert += "\n (Updated) ";
					else
						alert += "\n (New) ";
					alert += players.get(i).name;
				}
				Window.alert(alert);				
			}
		});
	}

	public static void generateStandingFromMatches(long seasonId, List<Match> matches,
			List<Standing> standings) {
		// ArrayList<Standing> standings = new ArrayList<Standing>();
		for (Standing standing : standings) {
			standing.refresh();
		}
		for (Match match : matches) {
			
			Standing home = getStanding(standings, match.homeTeamId, match.homeTeamName);
			home.seasonId = seasonId;
			Standing away = getStanding(standings, match.awayTeamId, match.awayTeamName);
			away.seasonId = seasonId;
			if (match.status.equalsIgnoreCase("FINISHED")) {
				home.played++;
				away.played++;

				home.goalFor += match.goalsHomeTeam;
				away.goalFor += match.goalsAwayTeam;

				home.goalAgaints += match.goalsAwayTeam;
				away.goalAgaints += match.goalsHomeTeam;

				switch (result(match.goalsHomeTeam, match.goalsAwayTeam)) {
				case 1:
					home.win++;
					away.lose++;
					break;
				case 2:
					home.draw++;
					away.draw++;
					break;
				case 3:
					away.win++;
					home.lose++;
				default:
					break;
				}
			}
		}

	}


	static Standing isStandingListContainName(List<Standing> list, long teamId) {
		for (Standing standing : list) {
			if (standing.teamId == teamId)
				return standing;
		}
		return null;
	}

	static Standing getStanding(List<Standing> standings, long teamId, String teamName) {
		Standing standing = isStandingListContainName(standings, teamId);
		if (standing != null) {
			return standing;
		} else {
			standing = new Standing(teamId, teamName);
			standings.add(standing);
			return standing;
		}
	}

	static int result(int homeGoal, int awayGoal) {
		if (homeGoal == awayGoal)
			return 2;
		else if (homeGoal > awayGoal)
			return 1;
		else
			return 3;
	}
}
