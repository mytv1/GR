package giddyhero.soccersystem.server;

import giddyhero.soccersystem.client.manager.ui.player.PlayerService;
import giddyhero.soccersystem.shared.model.Player;

import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import static com.googlecode.objectify.ObjectifyService.ofy;

@SuppressWarnings("serial")
public class PlayerServiceImpl extends RemoteServiceServlet implements
		PlayerService {

	@Override
	public void addNewPlayer(Player player) {
		ofy().save().entities(player).now();
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

}
