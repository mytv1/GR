package giddyhero.soccersystem.server;

import static com.googlecode.objectify.ObjectifyService.ofy;
import giddyhero.soccersystem.client.manager.ui.player.PlayerService;
import giddyhero.soccersystem.shared.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.Ref;

@SuppressWarnings("serial")
public class PlayerServiceImpl extends RemoteServiceServlet implements
		PlayerService {

	
	@Override
	public Player savePlayer(Player player) {
		ofy().save().entities(player).now();
		return player;
	}

	@Override
	public Player[] getAllPlayers() {
		List<Player> playerList = ofy().load().type(Player.class).list();
		Player[] players = new Player[playerList.size()];
		for (int i = 0; i < playerList.size(); i++) {
			players[i] = playerList.get(i);
		}
		return players;
	}

	@Override
	public Player getPlayer(long id) {
		Ref<Player> player = ofy().load().type(Player.class).id(id);
		return player.get();
	}

	@Override
	public void savePlayers(Player[] player) {
		ofy().save().entities(player).now();
	}

	@Override
	public Player[] getPlayers(long[] ids) {
		ArrayList<Long> idList = new ArrayList<>();
		for (int i = 0; i < ids.length; i++) {
			idList.add(ids[i]);
		}
		Map<Long, Player> playerList = ofy().load().type(Player.class).ids(idList);
		Player[] players = new Player[playerList.size()];
		int i =0;
		for(Entry<Long, Player> entry : playerList.entrySet()) {
			players[i] = entry.getValue();
		    i++;
		}
		return players;
	}

	@Override
	public Player[] getAllPlayerOfTeam(long teamId) {
		List<Player> playerList = ofy().load().type(Player.class).list();
		Player[] players;
		ArrayList<Player> alPlayers = new ArrayList<Player>();
		
		int i =0;
		for(Player player : playerList) {
			if (player.currentTeamId == teamId)
			{
				alPlayers.add(player);
				i++;
			}
		}
		
		players = new Player[i];
		for (int j = 0; j < i; j++) {
			players[j] = alPlayers.get(j);
		}
		return players;
		
	//		List<Player> playerList = ofy().load().type(Player.class).filter("currentTeamId", teamId).list();
	//		Player[] players = new Player[playerList.size()];
	//		for (int i = 0; i < playerList.size(); i++) {
	//			players[i] = playerList.get(i);
	//		}
	//		return players;
	}

	@Override
	public void deletePlayer(long id) {
		ofy().delete().type(Player.class).id(id);
	}

	@Override
	public Player getFirstPlayer() {
		Ref<Player> playerRef = ofy().load().type(Player.class).first();
		return playerRef.get();
	}

}
