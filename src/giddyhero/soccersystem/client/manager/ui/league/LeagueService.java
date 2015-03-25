package giddyhero.soccersystem.client.manager.ui.league;

import giddyhero.soccersystem.shared.model.EventCard;
import giddyhero.soccersystem.shared.model.EventChangePlayer;
import giddyhero.soccersystem.shared.model.EventGoal;
import giddyhero.soccersystem.shared.model.League;
import giddyhero.soccersystem.shared.model.Match;
import giddyhero.soccersystem.shared.model.Season;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("league")
public interface LeagueService extends RemoteService{
	void saveLeague(League league);
	
	League[] getAllLeague();
	
	Season[] getAllSeason();
	
	Season createNewSeason(League league, Season season);
	
	Match createMatch(Match match, EventCard[] eventCards, EventGoal[] eventGoals, EventChangePlayer[] eventChangePlayers);
	
	long[] saveEventCard(EventCard[] eventCards);
}
