package giddyhero.soccersystem.server;

import static com.googlecode.objectify.ObjectifyService.ofy;
import giddyhero.soccersystem.client.manager.ui.team.TeamService;
import giddyhero.soccersystem.shared.model.Team;

import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.Key;

@SuppressWarnings("serial")
public class TeamServiceImpl extends RemoteServiceServlet implements TeamService {

	@Override
	public Team[] getAllTeams() {
		List<Team> teamList = ofy().load().type(Team.class).list();
		Team[] teams = new Team[teamList.size()];
		for (int i = 0; i < teamList.size(); i++) {
			teams[i] = teamList.get(i);
		}
		return teams;
	}

	@Override
	public Team addNewTeam(Team team) {
		Key<Team> result = ofy().save().entity(team).now();
		team.id = result.getId();
		return team;
	}

	@Override
	public Team getTeam(long teamId) {
		return ofy().load().type(Team.class).id(teamId).get();
	}
	
}
