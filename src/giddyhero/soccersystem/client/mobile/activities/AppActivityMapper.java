package giddyhero.soccersystem.client.mobile.activities;

import giddyhero.soccersystem.client.mobile.activities.greeting.GreetingActivity;
import giddyhero.soccersystem.client.mobile.activities.greeting.GreetingPlace;
import giddyhero.soccersystem.client.mobile.activities.home.HomeActivity;
import giddyhero.soccersystem.client.mobile.activities.home.HomePlace;
import giddyhero.soccersystem.client.mobile.activities.news.detail.NewsDetailActivity;
import giddyhero.soccersystem.client.mobile.activities.news.detail.NewsDetailPlace;
import giddyhero.soccersystem.client.mobile.activities.news.list.NewsActivity;
import giddyhero.soccersystem.client.mobile.activities.news.list.NewsPlace;
import giddyhero.soccersystem.client.mobile.activities.player.PlayerActivity;
import giddyhero.soccersystem.client.mobile.activities.player.PlayerPlace;
import giddyhero.soccersystem.client.mobile.activities.team.TeamActivity;
import giddyhero.soccersystem.client.mobile.activities.team.TeamPlace;

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
		else if (place instanceof HomePlace)
			return new HomeActivity(clientFactory, place);
		else if (place instanceof NewsPlace)
			return new NewsActivity(clientFactory, place);
		else if (place instanceof NewsDetailPlace)
			return new NewsDetailActivity(clientFactory, place);
		else if (place instanceof PlayerPlace)
			return new PlayerActivity(clientFactory, place);
		else if (place instanceof TeamPlace)
			return new TeamActivity(clientFactory, place);
		return new HomeActivity(clientFactory, place);
	}
}
