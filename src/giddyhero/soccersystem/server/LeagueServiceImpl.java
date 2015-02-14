package giddyhero.soccersystem.server;

import java.util.List;

import giddyhero.soccersystem.client.GeneralService;
import giddyhero.soccersystem.client.manager.ui.league.LeagueService;
import giddyhero.soccersystem.shared.model.League;
import giddyhero.soccersystem.shared.model.Team;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import static com.googlecode.objectify.ObjectifyService.ofy;

@SuppressWarnings("serial")
public class LeagueServiceImpl extends RemoteServiceServlet implements
		LeagueService {

	@Override
	public void createNewLeague(League league) {
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
	
}