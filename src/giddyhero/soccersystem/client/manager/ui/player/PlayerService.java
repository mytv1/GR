package giddyhero.soccersystem.client.manager.ui.player;

import giddyhero.soccersystem.shared.model.Player;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("player")
public interface PlayerService  extends RemoteService{
	void addNewPlayer(Player player);
	
	Player[] getAllPlayers();
}
