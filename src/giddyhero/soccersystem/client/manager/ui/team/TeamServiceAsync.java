package giddyhero.soccersystem.client.manager.ui.team;

import java.util.List;

import giddyhero.soccersystem.shared.model.Team;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface TeamServiceAsync {

	void getAllTeams(AsyncCallback<List<Team>> callback);

	void saveTeam(Team team, AsyncCallback<Team> callback);

	void getTeam(long teamId, AsyncCallback<Team> callback);

	void deleteTeam(long teamId, AsyncCallback<Void> callback);

}
