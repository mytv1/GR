package giddyhero.soccersystem.client.mobile.activities;

import giddyhero.soccersystem.client.mobile.activities.games.GamesView;
import giddyhero.soccersystem.client.mobile.activities.home.HomeView;
import giddyhero.soccersystem.client.mobile.activities.league.LeagueView;
import giddyhero.soccersystem.client.mobile.activities.league.table.LeagueTableView;
import giddyhero.soccersystem.client.mobile.activities.livescore.LiveScoreView;
import giddyhero.soccersystem.client.mobile.activities.match.MatchView;
import giddyhero.soccersystem.client.mobile.activities.mypage.MyPageView;
import giddyhero.soccersystem.client.mobile.activities.news.NewsView;
import giddyhero.soccersystem.client.mobile.activities.teams.TeamView;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

public interface ClientFactory {
	public PlaceController getPlaceController();
	public EventBus getEventBus();
//	public GreetingView getGreetingView();
	public NewsView getNewsView();
	public GamesView getGamesView();
//	public NewsDetailView getNewsDetailView();
//	public PlayerView getPlayerView();
//	public TeamView getTeamView();
	public HomeView getHomeView();
	public LiveScoreView getLiveScoreView();
	public MyPageView getMyPageView();
	LeagueView getLeagueView();
	public TeamView getTeamView();
	public LeagueTableView getLeagueTableView();
	public MatchView getMatchView();
}
