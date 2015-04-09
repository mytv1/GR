package giddyhero.soccersystem.client.manager.ui.league;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

import giddyhero.soccersystem.shared.model.EventCard;
import giddyhero.soccersystem.shared.model.EventChangePlayer;
import giddyhero.soccersystem.shared.model.EventGoal;
import giddyhero.soccersystem.shared.model.League;
import giddyhero.soccersystem.shared.model.Match;
import giddyhero.soccersystem.shared.model.ScoreInfo;
import giddyhero.soccersystem.shared.model.Season;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.googlecode.objectify.Ref;

@RemoteServiceRelativePath("league")
public interface LeagueService extends RemoteService {
	void saveLeague(League league);

	League[] getAllLeague();
	
	public League getLeague(long id);

	/*<--------------------  Season  -------------------->*/
	Season[] getAllSeason();

	Season createNewSeason(League league, Season season);
	
	List<Season> getSeasonsById(List<Long> ids);

	public Season getSeason(long id);
	
	public Season saveSeason(Season season);

	/*<--------------------  Season  -------------------->*/
	/*<-------------------- Match  -------------------->*/

	Match saveMatch(Match match, EventCard[] eventCards, EventGoal[] eventGoals,
			EventChangePlayer[] eventChangePlayers);
	
	Match saveMatch(Match match, long seasonId);

	List<Match> getMatchOfSeason(long seasonId);

	long[] saveEventCard(EventCard[] eventCards);

	public void deleteMatch(long id);

	public int saveMatches(Match[] matches);
	
	public Match getMatch(long matchId);
	
	/*<-------------------- Match  -------------------->*/
	/*<-------------------- Table Score  -------------------->*/
	ScoreInfo saveScoreInfo(ScoreInfo scoreInfo, long seasonId);
	
	List<ScoreInfo> getScoreInfosById(List<Long> ids);
	
	ScoreInfo getScoreInfo(long id);
	
	void deleteScoreInfo(long id);
	/*<-------------------- Table Score  -------------------->*/
}
