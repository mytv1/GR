package giddyhero.soccersystem.client.manager.ui.player;

import java.sql.Date;

import giddyhero.soccersystem.shared.model.Player;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PlayerServiceAsync {

	void addNewPlayer(String name,  int day,int month,int year, int height, int positionId,
			String nationality, String avatarUrl, AsyncCallback<Player> callback);

	void getAllPlayers(AsyncCallback<Player[]> callback);

	void getPlayer(long id, AsyncCallback<Player> callback);

}
