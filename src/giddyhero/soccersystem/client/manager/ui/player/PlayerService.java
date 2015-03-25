package giddyhero.soccersystem.client.manager.ui.player;

import giddyhero.soccersystem.shared.model.Player;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("player")
public interface PlayerService  extends RemoteService{
	Player addNewPlayer(String name,  int day,int month,int year, int height, int positionId,String nationality, String avatarUrl);
	
	Player addNewPlayer(Player player);
	
	Player[] getAllPlayers();
	
	Player getPlayer(long id);
	
	Player[] getPlayers(long[] ids);
	
	Player[] getAllPlayerOfTeam(long teamId);
	
	void savePlayers(Player[] players);
}
