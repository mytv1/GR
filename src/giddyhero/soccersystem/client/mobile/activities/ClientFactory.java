package giddyhero.soccersystem.client.mobile.activities;

import giddyhero.soccersystem.client.mobile.activities.home.HomeView;
import giddyhero.soccersystem.client.mobile.activities.livescore.LiveScoreView;
import giddyhero.soccersystem.client.mobile.activities.news.NewsView;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

public interface ClientFactory {
	public PlaceController getPlaceController();
	public EventBus getEventBus();
//	public GreetingView getGreetingView();
	public NewsView getNewsView();
//	public NewsDetailView getNewsDetailView();
//	public PlayerView getPlayerView();
//	public TeamView getTeamView();
	public HomeView getHomeView();
	public LiveScoreView getLiveScoreView();
}
