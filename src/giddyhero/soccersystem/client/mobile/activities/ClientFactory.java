package giddyhero.soccersystem.client.mobile.activities;

import giddyhero.soccersystem.client.mobile.activities.greeting.GreetingView;
import giddyhero.soccersystem.client.mobile.activities.home.HomeView;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

public interface ClientFactory {
	public PlaceController getPlaceController();
	public HomeView getHomeView();
	public GreetingView getGreetingView();
	public EventBus getEventBus();
}
