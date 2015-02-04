package giddyhero.soccersystem.client.mobile.activities;

import giddyhero.soccersystem.client.mobile.activities.greeting.GreetingActivity;
import giddyhero.soccersystem.client.mobile.activities.greeting.GreetingPlace;
import giddyhero.soccersystem.client.mobile.activities.home.HomeActivity;
import giddyhero.soccersystem.client.mobile.activities.home.HomePlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class AppActivityMapper implements ActivityMapper {

	private ClientFactory clientFactory;

	public AppActivityMapper(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public Activity getActivity(Place place) {
		if (place instanceof GreetingPlace)
			return new GreetingActivity(clientFactory, place);

		return new HomeActivity(clientFactory, place);
	}
}
