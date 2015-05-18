package giddyhero.soccersystem.client.manager.ui.player;

import java.util.List;

import giddyhero.soccersystem.shared.model.Player;
import giddyhero.soccersystem.shared.model.Team;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PlayerServiceAsync {

	void getAllPlayers(AsyncCallback<List<Player>> callback);

	void getPlayer(long id, AsyncCallback<Player> callback);

//	void savePlayers(Player[] players, AsyncCallback<Void> callback);

	void getPlayers(long[] ids, AsyncCallback<List<Player>> callback);

	void getAllPlayerOfTeam(long teamId, AsyncCallback<List<Player>> callback);

	void savePlayer(Player player, AsyncCallback<Player> callback);

	void deletePlayer(long id, AsyncCallback<Void> callback);

	void getFirstPlayer(AsyncCallback<Player> callback);


	void savePlayers(List<Player> players, AsyncCallback<List<Player>> callback);

	void clearAllPlayers(AsyncCallback<Integer> callback);

}
