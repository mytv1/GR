package giddyhero.soccersystem.client.manager.ui.league;

import java.util.List;

import giddyhero.soccersystem.shared.model.EventCard;
import giddyhero.soccersystem.shared.model.EventChangePlayer;
import giddyhero.soccersystem.shared.model.EventGoal;
import giddyhero.soccersystem.shared.model.League;
import giddyhero.soccersystem.shared.model.Match;
import giddyhero.soccersystem.shared.model.Season;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LeagueServiceAsync {

	void saveLeague(League league, AsyncCallback<Void> callback);

	void getAllLeague(AsyncCallback<League[]> callback);

	void getAllSeason(AsyncCallback<Season[]> callback);

	void createNewSeason(League league,Season season, AsyncCallback<Season> callback);

	void createMatch(Match match, EventCard[] eventCards, EventGoal[] eventGoals,
			EventChangePlayer[] eventChangePlayers, AsyncCallback<Match> callback);

	void saveEventCard(EventCard[] eventCards, AsyncCallback<long[]> callback);

	void getSeason(long id, AsyncCallback<Season> callback);

	void getLeague(long id, AsyncCallback<League> callback);

	void saveMatches(Match[] matches, AsyncCallback<Integer> callback);

	void getMatchOfSeason(long seasonId, AsyncCallback<List<Match>> callback);

	void deleteMatch(long id, AsyncCallback<Void> callback);

	void getMatch(long matchId, AsyncCallback<Match> callback);

}
