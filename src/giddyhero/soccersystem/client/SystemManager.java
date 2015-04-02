package giddyhero.soccersystem.client;

import giddyhero.soccersystem.client.manager.ui.MainPage;
import giddyhero.soccersystem.client.manager.ui.league.LeagueService;
import giddyhero.soccersystem.client.manager.ui.league.LeagueServiceAsync;
import giddyhero.soccersystem.client.manager.ui.league.PanelCreateLeague;
import giddyhero.soccersystem.client.manager.ui.league.PanelLeagueAll;
import giddyhero.soccersystem.client.manager.ui.league.season.PanelSeasonOverView;
import giddyhero.soccersystem.client.manager.ui.match.PanelMatchCreate;
import giddyhero.soccersystem.client.manager.ui.match.WindowCreateMatch;
import giddyhero.soccersystem.client.manager.ui.match.WindowUpdateMatch;
import giddyhero.soccersystem.client.manager.ui.news.NewsService;
import giddyhero.soccersystem.client.manager.ui.news.NewsServiceAsync;
import giddyhero.soccersystem.client.manager.ui.news.PanelCreateNews;
import giddyhero.soccersystem.client.manager.ui.news.PanelNewsAll;
import giddyhero.soccersystem.client.manager.ui.player.PanelPlayerAll;
import giddyhero.soccersystem.client.manager.ui.player.PlayerService;
import giddyhero.soccersystem.client.manager.ui.player.PlayerServiceAsync;
import giddyhero.soccersystem.client.manager.ui.player.WindowCreatePlayer;
import giddyhero.soccersystem.client.manager.ui.team.PanelTeamAll;
import giddyhero.soccersystem.client.manager.ui.team.PanelTeamAll2;
import giddyhero.soccersystem.client.manager.ui.team.PanelTeamCreate;
import giddyhero.soccersystem.client.manager.ui.team.TeamService;
import giddyhero.soccersystem.client.manager.ui.team.TeamServiceAsync;
import giddyhero.soccersystem.shared.model.Team;

import java.util.List;
import java.util.logging.Logger;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
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
		
		public static class TeamUtils{
			public static List<Team> teams;
			
			public static void getAllTeam(){
				Service.team.getAllTeams(new AsyncCallback<List<Team>>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("get all team failure");
					}

					@Override
					public void onSuccess(List<Team>result) {
//						Window.alert("get all team success");
						teams = result;
					}
				});
			}
			
			public static String getTeamNameOfId(long id){
				if (teams != null){
					for (Team team : teams) {
//						Window.alert("id1 : "+team.id+" -- id 2 : "+id);
						if (team.id == id)
							return team.name;
					}
				}
				return "N/A Team";
			}
			
		}
		
		
	}

	public static class HistoryManager implements ValueChangeHandler<String> {

		public static final HistoryManager IMPL = new HistoryManager();

		@Override
		public void onValueChange(ValueChangeEvent<String> event) {
			String historyToken = event.getValue();
//			Window.alert("value change isContain? "+(historyToken.contains(HistoryToken.SEASON)));
			try {
				if (historyToken.equalsIgnoreCase(HistoryToken.LEAGUE)) {
					
					mainPage.addNewCenterContent(new PanelLeagueAll());
				} else if (historyToken.equalsIgnoreCase(HistoryToken.LEAGUE_CREATE)) {
					
					mainPage.addNewCenterContent(new PanelCreateLeague());
				} else if (historyToken.equalsIgnoreCase(HistoryToken.TEAM)) {
					
					mainPage.addNewCenterContent(new PanelTeamAll2());
				} else if (historyToken.equalsIgnoreCase(HistoryToken.TEAM_CREATE)) {
					
					mainPage.addNewCenterContent(new PanelTeamCreate());
				} else if (historyToken.equalsIgnoreCase(HistoryToken.PLAYER)) {
					
					mainPage.addNewCenterContent(new PanelPlayerAll());
					
				} else if (historyToken.equalsIgnoreCase(HistoryToken.NEWS)) {
					
					mainPage.addNewCenterContent(new PanelNewsAll());
				} else if (historyToken.equalsIgnoreCase(HistoryToken.NEWS_CREATE)) {
					
					mainPage.addNewCenterContent(new PanelCreateNews());
				} else if (historyToken.equalsIgnoreCase(HistoryToken.MATCH_CREATE)) {
					
					mainPage.addNewCenterContent(new PanelMatchCreate());
				} else if (historyToken.equalsIgnoreCase(HistoryToken.TEST)) {
					
					mainPage.addNewCenterContent(new WindowUpdateMatch());
				}else if (historyToken.equalsIgnoreCase(HistoryToken.WINDOW_CREATE_PLAYER)) {
					
					RootLayoutPanel.get().clear();
					RootLayoutPanel.get().add(new WindowCreatePlayer());
				}  
				else if (historyToken.contains(HistoryToken.MATCH_UPDATE_WINDOW)) {
					RootLayoutPanel.get().clear();
					RootLayoutPanel.get().add(new WindowUpdateMatch());
				} else if (historyToken.contains(HistoryToken.MATCH_CREATE_IN_SEASON_WINDOW)) {
					RootLayoutPanel.get().clear();
					RootLayoutPanel.get().add(new WindowCreateMatch());
				} else if (historyToken.contains(HistoryToken.SEASON)) {
					mainPage.addNewCenterContent(new PanelSeasonOverView());
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
				Window.alert("Register success");
				DataCache.TeamUtils.getAllTeam();
				startApp();
			}
		});
	}

	private void startApp() {
//		RootLayoutPanel.get().add(new TestDataGrid());
//		RootLayoutPanel.get().add(new PanelPlayerAll());
		
		String token = History.getToken();
		RootLayoutPanel.get().add(mainPage);
		if (token != "") {
			History.newItem(HistoryToken.BLANK);
			History.newItem(token);
		} 
			
	}

}
