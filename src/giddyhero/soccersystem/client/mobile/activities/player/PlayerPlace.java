package giddyhero.soccersystem.client.mobile.activities.player;

import com.google.gwt.place.shared.PlaceTokenizer;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicPlace;

public class PlayerPlace extends BasicPlace{
	long playerId;
	
	public PlayerPlace() {
		super();
		setToken("player");
	}
	
	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}
	
	public long getPlayerId() {
		return playerId;
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

}
