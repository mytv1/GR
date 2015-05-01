package giddyhero.soccersystem.client.mobile.activities.player;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicPlace;
import giddyhero.soccersystem.shared.model.News;

import com.google.gwt.place.shared.PlaceTokenizer;

public class PlayerPlace extends BasicPlace {
	
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
}