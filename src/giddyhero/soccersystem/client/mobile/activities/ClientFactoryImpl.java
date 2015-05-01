package giddyhero.soccersystem.client.mobile.activities;

import giddyhero.soccersystem.client.mobile.activities.games.GamesView;
import giddyhero.soccersystem.client.mobile.activities.games.GamesViewImpl;
import giddyhero.soccersystem.client.mobile.activities.home.HomeView;
import giddyhero.soccersystem.client.mobile.activities.home.HomeViewImpl;
import giddyhero.soccersystem.client.mobile.activities.league.LeagueView;
import giddyhero.soccersystem.client.mobile.activities.league.LeagueViewImpl;
import giddyhero.soccersystem.client.mobile.activities.league.table.LeagueTableView;
import giddyhero.soccersystem.client.mobile.activities.league.table.LeagueTableViewImpl;
import giddyhero.soccersystem.client.mobile.activities.livescore.LiveScoreView;
import giddyhero.soccersystem.client.mobile.activities.livescore.LiveScoreViewImpl;
import giddyhero.soccersystem.client.mobile.activities.match.MatchView;
import giddyhero.soccersystem.client.mobile.activities.match.MatchViewImpl;
import giddyhero.soccersystem.client.mobile.activities.mypage.MyPageView;
import giddyhero.soccersystem.client.mobile.activities.mypage.MyPageViewImpl;
import giddyhero.soccersystem.client.mobile.activities.news.NewsView;
import giddyhero.soccersystem.client.mobile.activities.news.NewsViewImpl;
import giddyhero.soccersystem.client.mobile.activities.teams.TeamView;
import giddyhero.soccersystem.client.mobile.activities.teams.TeamViewImpl;

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
	public LeagueView getLeagueView() {
		return new LeagueViewImpl();
	}
	
	@Override
	public LeagueTableView getLeagueTableView() {
		return new LeagueTableViewImpl();
	}
	
	

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

	@Override
	public GamesView getGamesView() {
		return new GamesViewImpl();
	}

	@Override
	public MyPageView getMyPageView() {
		return new MyPageViewImpl();
	}

	@Override
	public TeamView getTeamView() {
		return new TeamViewImpl();
	}

	@Override
	public MatchView getMatchView() {
		return new MatchViewImpl();
	}
}
