package giddyhero.soccersystem.client.manager.ui.player;

import giddyhero.soccersystem.shared.model.Player;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PlayerServiceAsync {

	void addNewPlayer(String name,  int day,int month,int year, int height, int positionId,
			String nationality, String avatarUrl, AsyncCallback<Player> callback);

	void getAllPlayers(AsyncCallback<Player[]> callback);

	void getPlayer(long id, AsyncCallback<Player> callback);

	void savePlayers(Player[] players, AsyncCallback<Void> callback);

	void getPlayers(long[] ids, AsyncCallback<Player[]> callback);

	void getAllPlayerOfTeam(long teamId, AsyncCallback<Player[]> callback);

	void addNewPlayer(Player player, AsyncCallback<Player> callback);

}
