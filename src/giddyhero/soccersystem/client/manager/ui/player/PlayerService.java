package giddyhero.soccersystem.client.manager.ui.player;

import java.util.List;

import giddyhero.soccersystem.shared.model.Player;
import giddyhero.soccersystem.shared.model.Team;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("player")
public interface PlayerService  extends RemoteService{
	
	Player savePlayer(Player player);
	
	void deletePlayer(long id);
	
	int clearAllPlayers();
	
	Player getFirstPlayer();
	
	List<Player> getAllPlayers();
	
	Player getPlayer(long id);
	
	List<Player>  getPlayers(long[] ids);
	
	List<Player> getAllPlayerOfTeam(long teamId);
	
	List<Player>  savePlayers(List<Player> players);
}
