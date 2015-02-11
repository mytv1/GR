package giddyhero.soccersystem.server;

import giddyhero.soccersystem.client.MobileEntryPoint;
import giddyhero.soccersystem.client.manager.ui.player.PlayerService;
import giddyhero.soccersystem.shared.model.Player;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
//		Player[] players = new Player[playerList.size()];
//		for (int i = 0; i < playerList.size(); i++) {
//			players[i] = playerList.get(i);
//		}
		return players;
	}

}
