package giddyhero.soccersystem.server;

import static com.googlecode.objectify.ObjectifyService.ofy;
import giddyhero.soccersystem.client.manager.ui.league.LeagueService;
import giddyhero.soccersystem.shared.model.EventCard;
import giddyhero.soccersystem.shared.model.EventChangePlayer;
import giddyhero.soccersystem.shared.model.EventGoal;
import giddyhero.soccersystem.shared.model.League;
import giddyhero.soccersystem.shared.model.Match;
import giddyhero.soccersystem.shared.model.Standing;
import giddyhero.soccersystem.shared.model.Season;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.appengine.labs.repackaged.com.google.common.collect.Multiset.Entry;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Ref;

@SuppressWarnings("serial")
public class LeagueServiceImpl extends RemoteServiceServlet implements LeagueService {

	@Override
	public void saveLeague(League league) {
		ofy().save().entity(league);
	}


	@Override
	public League[] getAllLeague() {
		List<League> leagueList = ofy().load().type(League.class).list();
		League[] leagues = new League[leagueList.size()];
		for (int i = 0; i < leagueList.size(); i++) {
			leagues[i] = leagueList.get(i);
		}
		return leagues;
	}
	
	@Override
	public void deleteLeague(long id) {
		
		League league = getLeague(id);
		
		List<Long> seasonIds = league.seasonIds;
		for (int i = 0; i < seasonIds.size(); i++) {
			long seasonId = seasonIds.get(i);
			deleteSeason(seasonId);
		}
		
		ofy().delete().type(League.class).id(id);
	}

	/************************************* Season ************************************/

	@Override
	public void deleteSeason(long id) {
		ofy().delete().type(Season.class).id(id);
	}
	
	
	@Override
	public Season[] getAllSeason() {
		List<Season> seasonList = ofy().load().type(Season.class).list();
		Season[] leagues = new Season[seasonList.size()];
		for (int i = 0; i < seasonList.size(); i++) {
			leagues[i] = seasonList.get(i);
		}
		return leagues;
	}

	public Season getSeason(long id) {
		Ref<Season> season = ofy().load().type(Season.class).id(id);
		return season.get();
	}

	public League getLeague(long id) {
		Ref<League> league = ofy().load().type(League.class).id(id);
		return league.get();
	}

	@Override
	public Season createNewSeason(League league, Season season) {
		Key<Season> result = ofy().save().entity(season).now();
		season.id = result.getId();

		league.addSeason(season.id);
		// addSeason(league, season.id);
		ofy().save().entity(league).now();

		return season;
	}


	@Override
	public long[] saveEventCard(EventCard[] eventCards) {
		long[] eventCardIds = new long[eventCards.length];
		for (int i = 0; i < eventCards.length; i++) {
			EventCard eventCard = eventCards[i];
			Key<EventCard> result = ofy().save().entity(eventCard).now();
			eventCardIds[i] = result.getId();
		}

		return eventCardIds;
	}


	/*************************************************** Standing ************************************************/
	
	@Override
	public Standing saveStanding(Standing scoreInfo, long seasonId) {
		scoreInfo.seasonId = seasonId;
		Key<Standing> key = ofy().save().entity(scoreInfo).now();
		long id = key.getId();
		scoreInfo.id = id;
		Season season = getSeason(seasonId);
		season.standings.add(id);
		saveSeason(season);
		return scoreInfo;
	}

	boolean isScoreInfoExist(Season season, long scoreInfoId) {
		for (long id : season.standings) {
			if (id == scoreInfoId)
				return true;
		}
		return false;
	}

	@Override
	public Season saveSeason(Season season) {
		Key<Season> key = ofy().save().entity(season).now();
		season.id = key.getId();
		return season;
	}

	@Override
	public List<Season> getSeasonsById(List<Long> ids) {
		List<Season> seasons = new ArrayList<Season>();
		for (Long id : ids) {
			Season season = getSeason(id);
			seasons.add(season);
		}
		return seasons;
	}

	@Override
	public List<Standing> getStandingsById(long seasonId) {
		List<Standing> result = ofy().load().type(Standing.class).filter("seasonId", seasonId).list();
		List<Standing> list = new ArrayList<Standing>(result);
		return list;
	}

	@Override
	public Standing getScoreInfo(long id) {
		Ref<Standing> key = ofy().load().type(Standing.class).id(id);
		return key.get();
	}

	@Override
	public void deleteScoreInfo(long id) {
		Standing scoreInfo = getScoreInfo(id);
		ofy().delete().type(Standing.class).id(id);
		if (scoreInfo != null && scoreInfo.seasonId != 0 ) {
			Season season = getSeason(scoreInfo.seasonId);
			season.standings.remove(id);
			saveSeason(season);
		}
	}
	

	@Override
	public List<Standing> saveStandings(long seasonId,List<Standing> standings) {
		Season season = getSeason(seasonId);
		Map<Key<Standing>, Standing> map = ofy().save().entities(standings).now();

		for (java.util.Map.Entry<Key<Standing>, Standing> standing : map.entrySet()) {
			season.standings.add(standing.getValue().id);
		}
		List<Standing> standingsNew = new ArrayList<Standing>(map.values());
		return standingsNew;
	}


	/* <----------------------------------- Match -----------------------------------> */
	@Override
	public Match saveMatch(Match match, long seasonId) {
		match.seasonId = seasonId;
		Key<Match> result = ofy().save().entity(match).now();
		match.id = result.getId();
		Season season = getSeason(seasonId);
		season.matchIds.add(match.id);
		saveSeason(season);
		return match;
	}
	
	@Override
	public List<Match> getMatchOfSeason(long seasonId) {
		List<Match> result = ofy().load().type(Match.class).filter("seasonId", seasonId).list();
		List<Match> list = new ArrayList<Match>(result);
		return list;
	}

	@Override
	public void deleteMatch(long id) {
		Match match = getMatch(id);
		if (match != null) {
			Season season = getSeason(match.seasonId);
			if (season != null)
				{
					season.matchIds.remove(id);
					saveSeason(season);
				}
			ofy().delete().type(Match.class).id(id);
		}
		
	}

	@Override
	public Match getMatch(long matchId) {
		Ref<Match> matchRef = ofy().load().type(Match.class).id(matchId);
		return matchRef.get();
	}
	
	@Override
	public Match saveMatch(Match match, EventCard[] eventCards, EventGoal[] eventGoals,
			EventChangePlayer[] eventChangePlayers) {

		long[] eventCardIds = new long[eventCards.length];
		long[] eventGoalIds = new long[eventGoals.length];
		long[] eventChangePlayerIds = new long[eventChangePlayers.length];

		for (int i = 0; i < eventChangePlayers.length; i++) {
			EventChangePlayer eventChangePlayer = eventChangePlayers[i];
			Key<EventChangePlayer> result = ofy().save().entity(eventChangePlayer).now();
			eventChangePlayerIds[i] = result.getId();
		}

		for (int i = 0; i < eventCards.length; i++) {
			EventCard eventCard = eventCards[i];
			Key<EventCard> result = ofy().save().entity(eventCard).now();
			eventCardIds[i] = result.getId();
		}

		for (int i = 0; i < eventGoals.length; i++) {
			EventGoal eventGoal = eventGoals[i];
			Key<EventGoal> result = ofy().save().entity(eventGoal).now();
			eventGoalIds[i] = result.getId();
		}

		match.setEvents(eventCardIds, eventGoalIds, eventChangePlayerIds);
		Key<Match> result = ofy().save().entity(match).now();
		match.id = result.getId();
		return match;
	}

	@Override
	public int clearMatchesOfSeason(long seasonId) {
		List<Match> keys = ofy().load().type(Match.class).filter("seasonId", seasonId).list();
		ofy().delete().entities(keys.toArray()).now();
		return keys.size();
	}

	@Override
	public int saveMatches(Season season,Match[] matches) {
		for (Match match : matches) {
			match.seasonId = season.id;
		}
		Map<Key<Match>, Match> map = ofy().save().entities(matches).now();
		
		for (java.util.Map.Entry<Key<Match>, Match> match : map.entrySet()) {
			season.matchIds.add(match.getValue().id);
		}
		return map.size();
	}


	@Override
	public List<Match> getAllMatches() {
		return  new ArrayList<Match>(ofy().load().type(Match.class).list());
	}

	/* <----------------------------------- Match -----------------------------------> */

}