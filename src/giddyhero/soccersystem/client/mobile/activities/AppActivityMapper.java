package giddyhero.soccersystem.client.mobile.activities;

import giddyhero.soccersystem.client.mobile.activities.games.GamesActivity;
import giddyhero.soccersystem.client.mobile.activities.games.GamesPlace;
import giddyhero.soccersystem.client.mobile.activities.home.HomeActivity;
import giddyhero.soccersystem.client.mobile.activities.home.HomePlace;
import giddyhero.soccersystem.client.mobile.activities.league.LeagueActivity;
import giddyhero.soccersystem.client.mobile.activities.league.LeaguePlace;
import giddyhero.soccersystem.client.mobile.activities.league.table.LeagueTableActivity;
import giddyhero.soccersystem.client.mobile.activities.league.table.LeagueTablePlace;
import giddyhero.soccersystem.client.mobile.activities.livescore.LiveScoreActivity;
import giddyhero.soccersystem.client.mobile.activities.livescore.LiveScorePlace;
import giddyhero.soccersystem.client.mobile.activities.match.MatchActivity;
import giddyhero.soccersystem.client.mobile.activities.match.MatchPlace;
import giddyhero.soccersystem.client.mobile.activities.mypage.MyPageActivity;
import giddyhero.soccersystem.client.mobile.activities.mypage.MyPagePlace;
import giddyhero.soccersystem.client.mobile.activities.news.NewsActivity;
import giddyhero.soccersystem.client.mobile.activities.news.NewsPlace;
import giddyhero.soccersystem.client.mobile.activities.player.PlayerActivity;
import giddyhero.soccersystem.client.mobile.activities.player.PlayerPlace;
import giddyhero.soccersystem.client.mobile.activities.teams.TeamActivity;
import giddyhero.soccersystem.client.mobile.activities.teams.TeamPlace;

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
		else if (place instanceof LeaguePlace)
			return new LeagueActivity(clientFactory, place);
		else if (place instanceof LiveScorePlace)
			return new LiveScoreActivity(clientFactory, place);
		else if (place instanceof GamesPlace)
			return new GamesActivity(clientFactory, place);
		else if (place instanceof MyPagePlace)
			return new MyPageActivity(clientFactory, place);
		else if (place instanceof NewsPlace)
			return new NewsActivity(clientFactory, place);
		else if (place instanceof TeamPlace)
			return new TeamActivity(clientFactory, place);
		else if (place instanceof LeagueTablePlace)
			return new LeagueTableActivity(clientFactory, place);
		else if (place instanceof MatchPlace)
			return new MatchActivity(clientFactory, place);
		else if (place instanceof PlayerPlace)
			return new PlayerActivity(clientFactory, place);
//		return new HomeActivity(clientFactory, place);
		return null;
	}
}
