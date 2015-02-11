package giddyhero.soccersystem.client.mobile.activities;

import giddyhero.soccersystem.client.mobile.activities.greeting.GreetingView;
import giddyhero.soccersystem.client.mobile.activities.home.HomeView;
import giddyhero.soccersystem.client.mobile.activities.news.detail.NewsDetailView;
import giddyhero.soccersystem.client.mobile.activities.news.list.NewsView;
import giddyhero.soccersystem.client.mobile.activities.player.PlayerView;
import giddyhero.soccersystem.client.mobile.activities.team.TeamView;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

public interface ClientFactory {
	public PlaceController getPlaceController();
	public EventBus getEventBus();
	public HomeView getHomeView();
	public GreetingView getGreetingView();
	public NewsView getNewsView();
	public NewsDetailView getNewsDetailView();
	public PlayerView getPlayerView();
	public TeamView getTeamView();
}
