package giddyhero.soccersystem.client.manager.ui.league;

import java.util.List;

import giddyhero.soccersystem.shared.model.EventCard;
import giddyhero.soccersystem.shared.model.EventChangePlayer;
import giddyhero.soccersystem.shared.model.EventGoal;
import giddyhero.soccersystem.shared.model.League;
import giddyhero.soccersystem.shared.model.Match;
import giddyhero.soccersystem.shared.model.ScoreInfo;
import giddyhero.soccersystem.shared.model.Season;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LeagueServiceAsync {

	void saveLeague(League league, AsyncCallback<Void> callback);

	void getAllLeague(AsyncCallback<League[]> callback);

	void getAllSeason(AsyncCallback<Season[]> callback);

	void createNewSeason(League league,Season season, AsyncCallback<Season> callback);

	void getSeason(long id, AsyncCallback<Season> callback);

	void getLeague(long id, AsyncCallback<League> callback);

	/* <----------------------- Match ------------------------> */
	void saveMatch(Match match, EventCard[] eventCards, EventGoal[] eventGoals,
			EventChangePlayer[] eventChangePlayers, AsyncCallback<Match> callback);

	void saveEventCard(EventCard[] eventCards, AsyncCallback<long[]> callback);


	void saveMatches(Match[] matches, AsyncCallback<Integer> callback);

	void getMatchOfSeason(long seasonId, AsyncCallback<List<Match>> callback);

	void deleteMatch(long id, AsyncCallback<Void> callback);

	void getMatch(long matchId, AsyncCallback<Match> callback);

	void saveMatch(Match match, long seasonId, AsyncCallback<Match> callback);
	/* <----------------------- Match ------------------------> */
	
	void saveSeason(Season season, AsyncCallback<Season> callback);

	void getSeasonsById(List<Long> ids, AsyncCallback<List<Season>> callback);

	void getScoreInfosById(List<Long> ids, AsyncCallback<List<ScoreInfo>> callback);

	void getScoreInfo(long id, AsyncCallback<ScoreInfo> callback);

	void deleteScoreInfo(long id, AsyncCallback<Void> callback);

	void saveScoreInfo(ScoreInfo scoreInfo, long seasonId, AsyncCallback<ScoreInfo> callback);



}
