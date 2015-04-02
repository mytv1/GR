package giddyhero.soccersystem.client.manager.ui.player;

import giddyhero.soccersystem.shared.model.Player;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PlayerServiceAsync {

	void getAllPlayers(AsyncCallback<Player[]> callback);

	void getPlayer(long id, AsyncCallback<Player> callback);

	void savePlayers(Player[] players, AsyncCallback<Void> callback);

	void getPlayers(long[] ids, AsyncCallback<Player[]> callback);

	void getAllPlayerOfTeam(long teamId, AsyncCallback<Player[]> callback);

	void savePlayer(Player player, AsyncCallback<Player> callback);

	void deletePlayer(long id, AsyncCallback<Void> callback);

	void getFirstPlayer(AsyncCallback<Player> callback);

}
