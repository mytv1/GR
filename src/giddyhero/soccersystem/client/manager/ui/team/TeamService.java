package giddyhero.soccersystem.client.manager.ui.team;

import java.util.List;

import giddyhero.soccersystem.shared.model.Team;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("team")
public interface TeamService extends RemoteService {
	List<Team> getAllTeams();
	
	Team saveTeam(Team team);
	
	List<Team> saveTeams(List<Team> teams);

	Team getTeam(long teamId);
	
	void deleteTeam(long teamId);
	

	List<Team> getTeamsOfIds(List<Long> ids);
}
