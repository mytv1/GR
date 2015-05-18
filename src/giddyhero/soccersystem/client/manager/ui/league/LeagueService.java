package giddyhero.soccersystem.client.manager.ui.league;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

import giddyhero.soccersystem.shared.model.EventCard;
import giddyhero.soccersystem.shared.model.EventChangePlayer;
import giddyhero.soccersystem.shared.model.EventGoal;
import giddyhero.soccersystem.shared.model.League;
import giddyhero.soccersystem.shared.model.Match;
import giddyhero.soccersystem.shared.model.Standing;
import giddyhero.soccersystem.shared.model.Season;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.googlecode.objectify.Ref;

@RemoteServiceRelativePath("league")
public interface LeagueService extends RemoteService {
	void saveLeague(League league);

	League[] getAllLeague();

	League getLeague(long id);
	
	void deleteLeague(long id);

	/* <-------------------- Season --------------------> */
	Season[] getAllSeason();

	Season createNewSeason(League league, Season season);

	List<Season> getSeasonsById(List<Long> ids);

	Season getSeason(long id);

	Season saveSeason(Season season);
	
	void deleteSeason(long id);

	/* <-------------------- Season --------------------> */
	/* <-------------------- Match --------------------> */

	Match saveMatch(Match match, EventCard[] eventCards, EventGoal[] eventGoals, EventChangePlayer[] eventChangePlayers);

	Match saveMatch(Match match, long seasonId);
	

	List<Match> getMatchOfSeason(long seasonId);
	
	List<Match> getAllMatches();

	long[] saveEventCard(EventCard[] eventCards);

	void deleteMatch(long id);

	int saveMatches(Season season,Match[] matches);

	Match getMatch(long matchId);
	
	int clearMatchesOfSeason(long seasonId);

	/* <-------------------- Match --------------------> */
	/* <-------------------- Table Score --------------------> */
	Standing saveStanding(Standing scoreInfo, long seasonId);
	
	List<Standing> saveStandings(long seasonId,List<Standing>  standings);

	List<Standing> getStandingsById(long id);

	Standing getScoreInfo(long id);

	void deleteScoreInfo(long id);
	/* <-------------------- Table Score --------------------> */
}
