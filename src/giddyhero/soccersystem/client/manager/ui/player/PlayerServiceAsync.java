package giddyhero.soccersystem.client.manager.ui.player;

import giddyhero.soccersystem.shared.model.Player;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PlayerServiceAsync {

	void addNewPlayer(Player player, AsyncCallback<Void> callback);

	void getAllPlayers(AsyncCallback<Player[]> callback);

}
