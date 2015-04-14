package giddyhero.soccersystem.client.mobile.activities;

import giddyhero.soccersystem.client.mobile.activities.home.HomeActivity;
import giddyhero.soccersystem.client.mobile.activities.home.HomePlace;
import giddyhero.soccersystem.client.mobile.activities.livescore.LiveScoreActivity;
import giddyhero.soccersystem.client.mobile.activities.livescore.LiveScorePlace;
import giddyhero.soccersystem.client.mobile.activities.news.NewsActivity;
import giddyhero.soccersystem.client.mobile.activities.news.NewsPlace;

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
		if (place instanceof HomePlace)
			return new HomeActivity(clientFactory, place);
		else if (place instanceof NewsPlace)
			return new NewsActivity(clientFactory, place);
		else if (place instanceof LiveScorePlace)
			return new LiveScoreActivity(clientFactory, place);
//		else if (place instanceof NewsDetailPlace)
//			return new NewsDetailActivity(clientFactory, place);
//		else if (place instanceof PlayerPlace)
//			return new PlayerActivity(clientFactory, place);
//		else if (place instanceof TeamPlace)
//			return new TeamActivity(clientFactory, place);
//		return new HomeActivity(clientFactory, place);
		return null;
	}
}
