package giddyhero.soccersystem.client.mobile.activities.games.knowledgechallenge;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicPlace;
import giddyhero.soccersystem.shared.model.News;

import com.google.gwt.place.shared.PlaceTokenizer;

public class GameKCPlace extends BasicPlace {
	
	public GameKCPlace(){
		super();
		setToken("Knowledge Challenge");
	}
	
	public static class GamesKCPlaceTokenizer implements PlaceTokenizer<GameKCPlace>{

		@Override
		public GameKCPlace getPlace(String token) {
			return new GameKCPlace();
		}

		@Override
		public String getToken(GameKCPlace place) {
			return place.getToken();
		}
	}
}