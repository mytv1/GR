package giddyhero.soccersystem.client.manager.ui.team;

import giddyhero.soccersystem.shared.model.Team;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface TeamServiceAsync {

	void getAllTeams(AsyncCallback<Team[]> callback);

	void addNewTeam(Team team, AsyncCallback<Void> callback);

}
