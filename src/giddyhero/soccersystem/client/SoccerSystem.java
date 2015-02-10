package giddyhero.soccersystem.client;


import giddyhero.soccersystem.client.manager.ui.MainPage;
import giddyhero.soccersystem.client.manager.ui.news.NewsService;
import giddyhero.soccersystem.client.manager.ui.news.NewsServiceAsync;
import giddyhero.soccersystem.client.manager.ui.player.PlayerService;
import giddyhero.soccersystem.client.manager.ui.player.PlayerServiceAsync;
import giddyhero.soccersystem.client.manager.ui.team.TeamService;
import giddyhero.soccersystem.client.manager.ui.team.TeamServiceAsync;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dev.DevMode;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.gwtphonegap.client.PhoneGap;
import com.googlecode.gwtphonegap.client.PhoneGapAvailableEvent;
import com.googlecode.gwtphonegap.client.PhoneGapAvailableHandler;
import com.googlecode.gwtphonegap.client.PhoneGapTimeoutEvent;
import com.googlecode.gwtphonegap.client.PhoneGapTimeoutHandler;
import com.googlecode.gwtphonegap.client.util.PhonegapUtil;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SoccerSystem implements EntryPoint {
//	public final static GeneralServiceAsync generalService = GWT
//			.create(GeneralService.class);
//	public final static PlayerServiceAsync playerService = GWT
//			.create(PlayerService.class);
//	public final static NewsServiceAsync newsService = GWT
//			.create(NewsService.class);
//	public final static TeamServiceAsync teamService = GWT
//			.create(TeamService.class);
	
	public static class Service{
		public final static GeneralServiceAsync general = GWT
				.create(GeneralService.class);
		public final static PlayerServiceAsync player= GWT
				.create(PlayerService.class);
		public final static NewsServiceAsync news= GWT
				.create(NewsService.class);
		public final static TeamServiceAsync team= GWT
				.create(TeamService.class);
		
	}
	

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		RootLayoutPanel.get().add(new MainPage());
		Service.general.registerAllEntity(new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Init Failure");
			}

			@Override
			public void onSuccess(Void result) {
				Window.alert("Init Success");
			}
		});
	}


}
