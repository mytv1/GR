package giddyhero.soccersystem.client;

import giddyhero.soccersystem.client.manager.ui.MainPage;
import giddyhero.soccersystem.client.manager.ui.league.LeagueService;
import giddyhero.soccersystem.client.manager.ui.league.LeagueServiceAsync;
import giddyhero.soccersystem.client.manager.ui.match.MatchCreatePanel;
import giddyhero.soccersystem.client.manager.ui.news.NewsService;
import giddyhero.soccersystem.client.manager.ui.news.NewsServiceAsync;
import giddyhero.soccersystem.client.manager.ui.player.PlayerService;
import giddyhero.soccersystem.client.manager.ui.player.PlayerServiceAsync;
import giddyhero.soccersystem.client.manager.ui.team.TeamService;
import giddyhero.soccersystem.client.manager.ui.team.TeamServiceAsync;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SoccerSystem implements EntryPoint {

	public static class Service {
		public final static GeneralServiceAsync general = GWT.create(GeneralService.class);
		public final static PlayerServiceAsync player = GWT.create(PlayerService.class);
		public final static NewsServiceAsync news = GWT.create(NewsService.class);
		public final static TeamServiceAsync team = GWT.create(TeamService.class);
		public final static LeagueServiceAsync league = GWT.create(LeagueService.class);
	}
	

	public static MainPage mainPage;

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
//		 mainPage = new MainPage();
		RootLayoutPanel.get().add(new MainPage());
		Service.general.registerAllEntity(new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
//				Window.alert("Init Failure");
			}

			@Override
			public void onSuccess(Void result) {
//				Window.alert("Init Success");
//				test();
			}
		});
	}

//	private void test() {
//		mainPage.addNewPanel(new MatchCreatePanel());
//	}

}
