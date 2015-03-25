package giddyhero.soccersystem.client;

import giddyhero.soccersystem.client.manager.ui.news.NewsService;
import giddyhero.soccersystem.client.manager.ui.news.NewsServiceAsync;
import giddyhero.soccersystem.client.manager.ui.player.PlayerService;
import giddyhero.soccersystem.client.manager.ui.player.PlayerServiceAsync;
import giddyhero.soccersystem.client.manager.ui.team.TeamService;
import giddyhero.soccersystem.client.manager.ui.team.TeamServiceAsync;
import giddyhero.soccersystem.client.mobile.activities.AppActivityMapper;
import giddyhero.soccersystem.client.mobile.activities.AppAnimationMapper;
import giddyhero.soccersystem.client.mobile.activities.AppPlaceHistoryMapper;
import giddyhero.soccersystem.client.mobile.activities.ClientFactory;
import giddyhero.soccersystem.client.mobile.activities.ClientFactoryImpl;
import giddyhero.soccersystem.client.mobile.activities.home.HomePlace;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.gwtphonegap.client.PhoneGap;
import com.googlecode.gwtphonegap.client.PhoneGapAvailableEvent;
import com.googlecode.gwtphonegap.client.PhoneGapAvailableHandler;
import com.googlecode.gwtphonegap.client.PhoneGapTimeoutEvent;
import com.googlecode.gwtphonegap.client.PhoneGapTimeoutHandler;
import com.googlecode.gwtphonegap.client.util.PhonegapUtil;
import com.googlecode.mgwt.mvp.client.AnimatingActivityManager;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.MGWTSettings;
import com.googlecode.mgwt.ui.client.MGWTSettings.ViewPort;
import com.googlecode.mgwt.ui.client.widget.animation.AnimationWidget;

public class MobileEntryPoint implements EntryPoint {

	private PhoneGap phoneGap;
	public static ClientFactory clientFactory = GWT
			.create(ClientFactoryImpl.class);
	
	public static class Service{
	
		public static GeneralServiceAsync general = GWT
				.create(GeneralService.class);
		public final static NewsServiceAsync news = GWT
				.create(NewsService.class);
		public final static PlayerServiceAsync player = GWT
				.create(PlayerService.class);
		public final static TeamServiceAsync team = GWT
				.create(TeamService.class);
	}

	@Override
	public void onModuleLoad() {
		initPhoneGap();
		setMGWTSettings();
		initManager();
	}

	private void initManager() {
		AppPlaceHistoryMapper historyMapper = GWT
				.create(AppPlaceHistoryMapper.class);

		createPhoneDisplay();

		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(
				historyMapper);
		historyHandler.register(clientFactory.getPlaceController(),
				clientFactory.getEventBus(), new HomePlace());
		historyHandler.handleCurrentHistory();
	}

	private void createPhoneDisplay() {
		AnimationWidget display = new AnimationWidget();
		AppActivityMapper appActivityMapper = new AppActivityMapper(
				clientFactory);
		AppAnimationMapper appAnimationMapper = new AppAnimationMapper();
		AnimatingActivityManager activityManager = new AnimatingActivityManager(
				appActivityMapper, appAnimationMapper,
				clientFactory.getEventBus());
		activityManager.setDisplay(display);
		RootPanel.get().add(display);
	}

	private void setMGWTSettings() {
		ViewPort viewPort = new MGWTSettings.ViewPort();
		viewPort.setUserScaleAble(false).setMinimumScale(1.0)
				.setMinimumScale(1.0).setMaximumScale(1.0);

		MGWTSettings settings = new MGWTSettings();
		settings.setViewPort(viewPort);
		settings.setFullscreen(true);
		settings.setFixIOS71BodyBug(true);
		settings.setPreventScrolling(true);
		MGWT.applySettings(settings);
	}

	public static ClientFactory getClientFactory() {
		return clientFactory;
	}

	private void initPhoneGap() {
		phoneGap = GWT.create(PhoneGap.class);
		phoneGap.addHandler(new PhoneGapAvailableHandler() {
			@Override
			public void onPhoneGapAvailable(PhoneGapAvailableEvent event) {
				if (phoneGap.isPhoneGapDevice()) {
					PhonegapUtil.prepareService((ServiceDefTarget) Service.news,
							"http://1-dot-mytv-ssm.appspot.com/",
							"/mobileentrypoint/news");
					PhonegapUtil.prepareService((ServiceDefTarget) Service.general,
							"http://1-dot-mytv-ssm.appspot.com/",
							"/mobileentrypoint/general");
					PhonegapUtil.prepareService((ServiceDefTarget) Service.player,
							"http://1-dot-mytv-ssm.appspot.com/",
							"/mobileentrypoint/player");
					PhonegapUtil.prepareService((ServiceDefTarget) Service.team,
							"http://1-dot-mytv-ssm.appspot.com/",
							"/mobileentrypoint/team");
				} else {
					Service.general.registerAllEntity(new AsyncCallback<Void>(){

						@Override
						public void onSuccess(Void result) {
							Window.alert("Register Success");
						}

						@Override
						public void onFailure(Throwable caught) {
							Window.alert("Register Failure");
						}
						
					});
//					
//					 Service.news.registerRelateEntity(new AsyncCallback<Void>() {
//
//						@Override
//						public void onSuccess(Void result) {
//							Window.alert("Register Success");
//						}
//
//						@Override
//						public void onFailure(Throwable caught) {
//							Window.alert("Register Failure");
//						}
//					});
				}
//				Window.alert("on Phonegap Available");
			}
		});

		phoneGap.addHandler(new PhoneGapTimeoutHandler() {
			@Override
			public void onPhoneGapTimeout(PhoneGapTimeoutEvent event) {
				Window.alert("on PhoneGap Timeout");
			}
		});
		phoneGap.initializePhoneGap();
	}

}
