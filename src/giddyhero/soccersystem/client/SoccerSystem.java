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
	public final static GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);
	public final static PlayerServiceAsync playerService = GWT
			.create(PlayerService.class);
	public final static NewsServiceAsync newsService = GWT
			.create(NewsService.class);
	public final static TeamServiceAsync teamService = GWT
			.create(TeamService.class);
	PhoneGap phonegap = GWT.create(PhoneGap.class);
	

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
//		RootPanel.get().add(new MainPage());
//		initPhoneGap();
		RootLayoutPanel.get().add(new MainPage());
		greetingService.initDataStore(new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Init Failure");
			}

			@Override
			public void onSuccess(Void result) {
				Window.alert("Init Success");
			}
		});
//		PhonegapUtil.prepareService(greetingService, "http://1-dot-mytv-ssm.appspot.com/", "")
//		greetingService.initDataStore(new AsyncCallback<Void>() {
//
//			@Override
//			public void onFailure(Throwable caught) {
//				Window.alert("Failure");
//			}
//
//			@Override
//			public void onSuccess(Void result) {
//				Window.alert("Success");				
//			}
//		});
		
	}


	private void initPhoneGap() {
		phonegap.addHandler(new PhoneGapAvailableHandler() {
			
			@Override
			public void onPhoneGapAvailable(PhoneGapAvailableEvent event) {
				if (phonegap.isPhoneGapDevice())
					PhonegapUtil.prepareService((ServiceDefTarget)teamService,  "http://1-dot-mytv-ssm.appspot.com/", "/soccersystem/team");
				Window.alert("Phonegap Available 222");
			}
		});
		
		phonegap.addHandler(new PhoneGapTimeoutHandler() {
			
			@Override	
			public void onPhoneGapTimeout(PhoneGapTimeoutEvent event) {
				Window.alert("Something wrong happend");
			}
		});
		
		phonegap.initializePhoneGap();
	}
}
