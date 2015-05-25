package giddyhero.soccersystem.client.mobile.activities.player;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicPlace;
import giddyhero.soccersystem.shared.model.News;
import giddyhero.soccersystem.shared.model.Player;

import com.google.gwt.place.shared.PlaceTokenizer;

public class PlayerPlace extends BasicPlace {
	
	private Player player;

	public PlayerPlace(){
		super();
		setToken("player");
	}
	
	public static class PlayerPlaceTokenizer implements PlaceTokenizer<PlayerPlace>{

		@Override
		public PlayerPlace getPlace(String token) {
			return new PlayerPlace();
		}

		@Override
		public String getToken(PlayerPlace place) {
			return place.getToken();
		}
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return player;
	}
}