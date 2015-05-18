package giddyhero.soccersystem.client;

import giddyhero.soccersystem.client.manager.ui.MainPage;
import giddyhero.soccersystem.client.manager.ui.league.LeagueService;
import giddyhero.soccersystem.client.manager.ui.league.LeagueServiceAsync;
import giddyhero.soccersystem.client.manager.ui.league.PanelLeagueCreate;
import giddyhero.soccersystem.client.manager.ui.league.PanelLeagueAll;
import giddyhero.soccersystem.client.manager.ui.league.season.PanelSeason;
import giddyhero.soccersystem.client.manager.ui.match.WindowCreateMatch;
import giddyhero.soccersystem.client.manager.ui.match.WindowUpdateMatch;
import giddyhero.soccersystem.client.manager.ui.news.NewsService;
import giddyhero.soccersystem.client.manager.ui.news.NewsServiceAsync;
import giddyhero.soccersystem.client.manager.ui.news.PanelNewsAll;
import giddyhero.soccersystem.client.manager.ui.news.WindowCreateNews;
import giddyhero.soccersystem.client.manager.ui.player.PanelPlayerAll;
import giddyhero.soccersystem.client.manager.ui.player.PlayerService;
import giddyhero.soccersystem.client.manager.ui.player.PlayerServiceAsync;
import giddyhero.soccersystem.client.manager.ui.player.WindowCreatePlayer;
import giddyhero.soccersystem.client.manager.ui.team.PanelTeamAll;
import giddyhero.soccersystem.client.manager.ui.team.TeamService;
import giddyhero.soccersystem.client.manager.ui.team.TeamServiceAsync;
import giddyhero.soccersystem.client.manager.ui.team.WindowCreateTeam;
import giddyhero.soccersystem.shared.model.Match;
import giddyhero.soccersystem.shared.model.Player;
import giddyhero.soccersystem.shared.model.Season;
import giddyhero.soccersystem.shared.model.Team;

import java.util.List;
import java.util.logging.Logger;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SystemManager implements EntryPoint {

	public static Logger logger = Logger.getLogger("Manager");

	public static class Service {
		public final static GeneralServiceAsync general = GWT.create(GeneralService.class);
		public final static PlayerServiceAsync player = GWT.create(PlayerService.class);
		public final static NewsServiceAsync news = GWT.create(NewsService.class);
		public final static TeamServiceAsync team = GWT.create(TeamService.class);
		public final static LeagueServiceAsync league = GWT.create(LeagueService.class);
	}

	public static class DataCache {
		
		public static class PlayerUtils{
			public static List<Player> players;
			
			public static void update(final AsyncCallback<List<Player>> callBack){
				Service.player.getAllPlayers(new AsyncCallback<List<Player>>() {

					@Override
					public void onFailure(Throwable caught) {
						callBack.onFailure(caught);
					}

					@Override
					public void onSuccess(List<Player> result) {
						players = result;
						callBack.onSuccess(result);
					}
					
				});
			}
			
			private static void mergePlayers(List<Player> listNew){
				for (Player playerNew : listNew) {
					for (Player playerOld : players) {
						if (playerOld.name.equalsIgnoreCase(playerNew.name) && playerOld.birth.equalsIgnoreCase(playerNew.birth)){
							playerOld = playerNew;
							break;
						}
					}
					players.add(playerNew);
				}
				
			}
			
			public static void savePlayers(List<Player> players,final AsyncCallback<List<Player>> callBack){
				Service.player.savePlayers(players,new AsyncCallback<List<Player>>() {

					@Override
					public void onFailure(Throwable caught) {
						callBack.onFailure(caught);
					}

					@Override
					public void onSuccess(List<Player> result) {
						mergePlayers(result);
						callBack.onSuccess(result);
					}
					
				});
			}
			
			public static long isPlayerExist(Player comparablePlayer){
				for (Player player : players) {
					if (player.name.equalsIgnoreCase(comparablePlayer.name) && player.birth.equalsIgnoreCase(comparablePlayer.birth))
						return player.id;
				}
				return -1;
			}
			
		}

		public static class TeamUtils {
			public static List<Team> teams;

			
			public static void update( final AsyncCallback<List<Team>> callBack){
				Service.team.getAllTeams(new AsyncCallback<List<Team>>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("get all team failure");
						callBack.onFailure(caught);
					}

					@Override
					public void onSuccess(List<Team> result) {
						teams = result;
						callBack.onSuccess(result);
					}
				});
			}
			
			private static void mergeTeams(List<Team> listNew){
				for (Team teamNew : listNew) {
					for (Team teamOld : teams) {
						if (teamOld.name.equalsIgnoreCase(teamNew.name)){
							teamOld = teamNew;
							break;
						}
					}
					teams.add(teamNew);
				}
				
			}

			public static void saveTeams(List<Team> teams, final AsyncCallback<List<Team>> callBack){
				Service.team.saveTeams(teams,new AsyncCallback<List<Team>>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("get all team failure");
						callBack.onFailure(caught);
					}

					@Override
					public void onSuccess(List<Team> result) {
						mergeTeams(result);
						callBack.onSuccess(result);
					}
				});
			}
			
			public static long isTeamExist(String teamName){
				for (Team team : teams) {
					if (team.name.equalsIgnoreCase(teamName))
						return team.id;
				}
				return -1;
			}

			public static String getTeamNameOfId(long id) {
				if (teams != null) {
					for (Team team : teams) {
						// Window.alert("id1 : "+team.id+" -- id 2 : "+id);
						if (team.id == id)
							return team.name;
					}
				}
				return "N/A Team";
			}

		}
		
		public static class MatchUtils{
			public static List<Match> matches;
			
			public static void setMatches(List<Match> matches) {
				MatchUtils.matches = matches;
			}
			
			public static long isMatchExist(Match comparingMatch){
				for (Match match : matches) {
					if (match.isEqual(comparingMatch))
						return match.id;
				}
				return -1;
			}
		}
		

	}

	public static class HistoryManager implements ValueChangeHandler<String> {

		public static final HistoryManager IMPL = new HistoryManager();

		@Override
		public void onValueChange(ValueChangeEvent<String> event) {
			String historyToken = event.getValue();
			// Window.alert("value change isContain? "+(historyToken.contains(HistoryToken.SEASON)));
			try {
				if (historyToken.equalsIgnoreCase(HistoryToken.LEAGUE)) {

					mainPage.addNewCenterContent(new PanelLeagueAll());
				} else if (historyToken.equalsIgnoreCase(HistoryToken.LEAGUE_CREATE)) {

					mainPage.addNewCenterContent(new PanelLeagueCreate());
				} else if (historyToken.equalsIgnoreCase(HistoryToken.TEAM)) {

					mainPage.addNewCenterContent(new PanelTeamAll());
				} else if (historyToken.equalsIgnoreCase(HistoryToken.PLAYER)) {

					mainPage.addNewCenterContent(new PanelPlayerAll());

				} else if (historyToken.equalsIgnoreCase(HistoryToken.NEWS)) {

					mainPage.addNewCenterContent(new PanelNewsAll());
				} else if (historyToken.equalsIgnoreCase(HistoryToken.NEWS_CREATE)) {

					RootLayoutPanel.get().clear();
					RootLayoutPanel.get().add(new WindowCreateNews());
				} else if (historyToken.equalsIgnoreCase(HistoryToken.TEST)) {

					mainPage.addNewCenterContent(new WindowUpdateMatch());
				} else if (historyToken.equalsIgnoreCase(HistoryToken.WINDOW_CREATE_PLAYER)) {

					RootLayoutPanel.get().clear();
					RootLayoutPanel.get().add(new WindowCreatePlayer());
				} else if (historyToken.equalsIgnoreCase(HistoryToken.WINDOW_CREATE_TEAM)) {

					RootLayoutPanel.get().clear();
					RootLayoutPanel.get().add(new WindowCreateTeam());
				} else if (historyToken.contains(HistoryToken.MATCH_UPDATE_WINDOW)) {
					RootLayoutPanel.get().clear();
					RootLayoutPanel.get().add(new WindowUpdateMatch());
				} else if (historyToken.contains(HistoryToken.MATCH_CREATE_IN_SEASON_WINDOW)) {
					RootLayoutPanel.get().clear();
					RootLayoutPanel.get().add(new WindowCreateMatch());
				} else if (historyToken.contains(HistoryToken.SEASON)) {
					mainPage.addNewCenterContent(new PanelSeason());
				}

				else {
					mainPage.clearMainPanel();
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	public static MainPage mainPage = new MainPage();

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		History.addValueChangeHandler(HistoryManager.IMPL);
		registerObjectify();
	}

	private void registerObjectify() {
		Service.general.registerAllEntity(new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Init Failure");
			}

			@Override
			public void onSuccess(Void result) {

				DataCache.TeamUtils.update(new AsyncCallback<List<Team>>() {

					@Override
					public void onFailure(Throwable caught) {
					}

					@Override
					public void onSuccess(List<Team> result) {
						Window.alert("Register success - Starting");
						startApp();						
					}
				});
				
			}
		});
	}

	private void startApp() {

		String token = History.getToken();
		RootLayoutPanel.get().add(mainPage);
		if (token != "") {
			History.newItem(HistoryToken.BLANK);
			History.newItem(token);
		}
//		testGetBigData();
	}


	private void fix() {
		SystemManager.Service.league.getSeason(5069298359861248L, new AsyncCallback<Season>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("fix fail 1");
			}

			@Override
			public void onSuccess(Season season) {
				season.matchIds.clear();
				SystemManager.Service.league.saveSeason(season, new AsyncCallback<Season>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("fix fail 2");
					}

					@Override
					public void onSuccess(Season result) {
						Window.alert("fix success " + result.standings.size());
					}
				});
			}
		});
	}
}
