package giddyhero.soccersystem.client.mobile.activities;

import giddyhero.soccersystem.client.mobile.activities.home.HomeView;
import giddyhero.soccersystem.client.mobile.activities.home.HomeViewImpl;
import giddyhero.soccersystem.client.mobile.activities.livescore.LiveScoreView;
import giddyhero.soccersystem.client.mobile.activities.livescore.LiveScoreViewImpl;
import giddyhero.soccersystem.client.mobile.activities.news.NewsView;
import giddyhero.soccersystem.client.mobile.activities.news.NewsViewImpl;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

public class ClientFactoryImpl  implements ClientFactory  {

	private SimpleEventBus eventBus;
	private PlaceController placeController;
	
	public ClientFactoryImpl() {
		eventBus = new SimpleEventBus();
		placeController = new PlaceController(eventBus);
	}

	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}

	@Override
	public EventBus getEventBus() {
		return eventBus;
	}

	@Override
	public HomeView getHomeView() {
		return new HomeViewImpl();
	}

//	@Override
//	public GreetingView getGreetingView() {
//		return new GreetingViewImpl();
//	}

	@Override
	public NewsView getNewsView() {
		return new NewsViewImpl();
	}
//
//	@Override
//	public NewsDetailView getNewsDetailView() {
//		return new NewsDetailViewImpl();
//	}
//
//	@Override
//	public PlayerView getPlayerView() {
//		return new PlayerViewImpl();
//	}
//
//	@Override
//	public TeamView getTeamView() {
//		return new TeamViewImpl();
//	}

	@Override
	public LiveScoreView getLiveScoreView() {
		return new LiveScoreViewImpl();
	}
}
