package giddyhero.soccersystem.client.manager.ui.team;

import giddyhero.soccersystem.shared.model.Team;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("team")
public interface TeamService extends RemoteService {
	Team[] getAllTeams();
	
	Team addNewTeam(Team team);

	Team getTeam(long teamId);
}
