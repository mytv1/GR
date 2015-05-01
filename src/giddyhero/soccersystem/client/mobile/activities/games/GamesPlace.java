package giddyhero.soccersystem.client.mobile.activities.games;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicPlace;
import giddyhero.soccersystem.shared.model.News;

import com.google.gwt.place.shared.PlaceTokenizer;

public class GamesPlace extends BasicPlace {
	
	public GamesPlace(){
		super();
		setToken("news");
	}
	
	public static class GamesPlaceTokenizer implements PlaceTokenizer<GamesPlace>{

		@Override
		public GamesPlace getPlace(String token) {
			return new GamesPlace();
		}

		@Override
		public String getToken(GamesPlace place) {
			return place.getToken();
		}
	}
}