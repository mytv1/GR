package giddyhero.soccersystem.client.mobile.activities.match;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicPlace;
import giddyhero.soccersystem.shared.model.News;

import com.google.gwt.place.shared.PlaceTokenizer;

public class MatchPlace extends BasicPlace {
	
	public MatchPlace(){
		super();
	}
	
	
	public static class MatchPlaceTokenizer implements PlaceTokenizer<MatchPlace>{

		@Override
		public MatchPlace getPlace(String token) {
			return new MatchPlace();
		}

		@Override
		public String getToken(MatchPlace place) {
			return place.getToken();
		}
	}
}