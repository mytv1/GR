package giddyhero.soccersystem.server;

import giddyhero.soccersystem.client.manager.ui.player.PlayerService;
import giddyhero.soccersystem.shared.model.Player;

import java.sql.Date;
import java.util.List;

import com.google.appengine.api.datastore.Entity;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.Ref;

import static com.googlecode.objectify.ObjectifyService.ofy;

@SuppressWarnings("serial")
public class PlayerServiceImpl extends RemoteServiceServlet implements
		PlayerService {

	@Override
	public Player addNewPlayer(String name, int day, int month, int year,
			int height, int positionId, String nationality, String avatarUrl) {
		Player player = new Player(name, day, month, year, height, positionId,
				nationality, avatarUrl);
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

}
