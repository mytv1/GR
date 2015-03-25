package giddyhero.soccersystem.server;

import static com.googlecode.objectify.ObjectifyService.ofy;
import giddyhero.soccersystem.client.ClientUtils;
import giddyhero.soccersystem.client.manager.ui.league.LeagueService;
import giddyhero.soccersystem.shared.model.EventCard;
import giddyhero.soccersystem.shared.model.EventChangePlayer;
import giddyhero.soccersystem.shared.model.EventGoal;
import giddyhero.soccersystem.shared.model.League;
import giddyhero.soccersystem.shared.model.Match;
import giddyhero.soccersystem.shared.model.Season;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.Key;

@SuppressWarnings("serial")
public class LeagueServiceImpl extends RemoteServiceServlet implements
		LeagueService {

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
	public Season[] getAllSeason() {
		List<Season> seasonList = ofy().load().type(Season.class).list();
		Season[] leagues = new Season[seasonList.size()];
		for (int i = 0; i < seasonList.size(); i++) {
			leagues[i] = seasonList.get(i);
		}
		return leagues;
	}

	@Override
	public Season createNewSeason(League league,Season season) {
		Key<Season> result = ofy().save().entity(season).now();
		season.id = result.getId();
		
		league.addSeason(season.id);
//		addSeason(league, season.id);
		ofy().save().entity(league).now();
		
		return season;
	}

	@Override
	public Match createMatch(Match match, EventCard[] eventCards, EventGoal[] eventGoals,
			EventChangePlayer[] eventChangePlayers) {
		Logger logger = Logger.getLogger("NameOfYourLogger");
		logger.log(Level.SEVERE, "this message should get logged");
		
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
		return match;
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
	
	
	
}