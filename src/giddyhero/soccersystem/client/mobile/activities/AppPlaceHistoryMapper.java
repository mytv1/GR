package giddyhero.soccersystem.client.mobile.activities;

import giddyhero.soccersystem.client.mobile.activities.games.GamesPlace.GamesPlaceTokenizer;
import giddyhero.soccersystem.client.mobile.activities.home.HomePlace.HomePlaceTokenizer;
import giddyhero.soccersystem.client.mobile.activities.league.LeaguePlace.LeaguePlaceTokenizer;
import giddyhero.soccersystem.client.mobile.activities.league.table.LeagueTablePlace.LeagueTablePlaceTokenizer;
import giddyhero.soccersystem.client.mobile.activities.livescore.LiveScorePlace.LiveScorePlaceTokenizer;
import giddyhero.soccersystem.client.mobile.activities.match.MatchViewImpl;
import giddyhero.soccersystem.client.mobile.activities.match.MatchPlace.MatchPlaceTokenizer;
import giddyhero.soccersystem.client.mobile.activities.mypage.MyPagePlace.MyPagePlaceTokenizer;
import giddyhero.soccersystem.client.mobile.activities.player.PlayerPlace;
import giddyhero.soccersystem.client.mobile.activities.player.PlayerPlace.PlayerPlaceTokenizer;
import giddyhero.soccersystem.client.mobile.activities.teams.TeamPlace.TeamPlaceTokenizer;
import giddyhero.soccersystem.shared.model.Player;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({ HomePlaceTokenizer.class, LeaguePlaceTokenizer.class, LiveScorePlaceTokenizer.class,
		GamesPlaceTokenizer.class, MyPagePlaceTokenizer.class, LeaguePlaceTokenizer.class, TeamPlaceTokenizer.class,
		LeagueTablePlaceTokenizer.class, MatchPlaceTokenizer.class, PlayerPlaceTokenizer.class })
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}
