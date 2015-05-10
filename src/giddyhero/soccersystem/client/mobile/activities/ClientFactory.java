package giddyhero.soccersystem.client.mobile.activities;

import giddyhero.soccersystem.client.mobile.activities.games.GamesView;
import giddyhero.soccersystem.client.mobile.activities.games.knowledgechallenge.GameKCView;
import giddyhero.soccersystem.client.mobile.activities.home.HomeView;
import giddyhero.soccersystem.client.mobile.activities.league.LeagueView;
import giddyhero.soccersystem.client.mobile.activities.league.table.LeagueTableView;
import giddyhero.soccersystem.client.mobile.activities.livescore.LiveScoreView;
import giddyhero.soccersystem.client.mobile.activities.match.MatchView;
import giddyhero.soccersystem.client.mobile.activities.mypage.MyPageView;
import giddyhero.soccersystem.client.mobile.activities.news.NewsView;
import giddyhero.soccersystem.client.mobile.activities.player.PlayerView;
import giddyhero.soccersystem.client.mobile.activities.store.StoreView;
import giddyhero.soccersystem.client.mobile.activities.teams.TeamView;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

public interface ClientFactory {
	PlaceController getPlaceController();

	EventBus getEventBus();

	NewsView getNewsView();

	GamesView getGamesView();

	HomeView getHomeView();

	LiveScoreView getLiveScoreView();

	MyPageView getMyPageView();

	LeagueView getLeagueView();

	TeamView getTeamView();

	LeagueTableView getLeagueTableView();

	MatchView getMatchView();

	PlayerView getPlayerView();

	StoreView getStoreView();

	GameKCView getGamesKCView();
}
