package giddyhero.soccersystem.server;

import static com.googlecode.objectify.ObjectifyService.ofy;
import giddyhero.soccersystem.client.manager.ui.team.TeamService;
import giddyhero.soccersystem.shared.model.Match;
import giddyhero.soccersystem.shared.model.Player;
import giddyhero.soccersystem.shared.model.Standing;
import giddyhero.soccersystem.shared.model.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.Key;

@SuppressWarnings("serial")
public class TeamServiceImpl extends RemoteServiceServlet implements TeamService {

	@Override
	public List<Team> getAllTeams() {
		List<Team> teamList = ofy().load().type(Team.class).list();
//		Team[] teams = new Team[teamList.size()];
//		for (int i = 0; i < teamList.size(); i++) {
//			teams[i] = teamList.get(i);
//		}
		ArrayList<Team> teams = new ArrayList<Team>(teamList);
		return teams;
	}

	@Override
	public Team saveTeam(Team team) {
		Key<Team> result = ofy().save().entity(team).now();
		team.id = result.getId();
		return team;
	}

	@Override
	public Team getTeam(long teamId) {
		return ofy().load().type(Team.class).id(teamId).get();
	}

	@Override
	public void deleteTeam(long teamId) {
		ofy().delete().type(Team.class).id(teamId);
	}

	@Override
	public List<Team> saveTeams(List<Team> teams) {
		Map<Key<Team>, Team> map = ofy().save().entities(teams).now();
		return  new ArrayList<Team>(map.values());
	}
	
}
