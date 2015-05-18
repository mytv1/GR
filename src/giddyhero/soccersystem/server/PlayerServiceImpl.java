package giddyhero.soccersystem.server;

import static com.googlecode.objectify.ObjectifyService.ofy;
import giddyhero.soccersystem.client.manager.ui.player.PlayerService;
import giddyhero.soccersystem.shared.model.Player;
import giddyhero.soccersystem.shared.model.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.Key;
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
	public List<Player>  getAllPlayers() {
		List<Player> playerList = ofy().load().type(Player.class).list();
		return new ArrayList<Player>(playerList);
	}

	@Override
	public Player getPlayer(long id) {
		Ref<Player> player = ofy().load().type(Player.class).id(id);
		return player.get();
	}


	@Override
	public List<Player> getPlayers(long[] ids) {
		ArrayList<Long> idList = new ArrayList<>();
		for (int i = 0; i < ids.length; i++) {
			idList.add(ids[i]);
		}
		Map<Long, Player> playerList = ofy().load().type(Player.class).ids(idList);
		return new ArrayList<Player>(playerList.values());
	}

	@Override
	public List<Player> getAllPlayerOfTeam(long teamId) {
			List<Player> playerList = ofy().load().type(Player.class).filter("currentTeamId", teamId).list();
			return new ArrayList<Player>(playerList);
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

	@Override
	public List<Player> savePlayers(List<Player> players) {
		Map<Key<Player>, Player> map = ofy().save().entities(players).now();
		List<Player> playerList = new ArrayList<Player>(map.values()); 
		return playerList;
	}

	@Override
	public int clearAllPlayers() {
		List<Player> playerList = ofy().load().type(Player.class).list();
		ofy().delete().entities(playerList).now();
		return 0;
	}

}
