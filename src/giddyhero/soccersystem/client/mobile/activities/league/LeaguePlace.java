package giddyhero.soccersystem.client.mobile.activities.league;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicPlace;
import giddyhero.soccersystem.shared.model.News;

import com.google.gwt.place.shared.PlaceTokenizer;

public class LeaguePlace extends BasicPlace {
	
	public LeaguePlace(){
		super();
	}
	
	
	public static class LeaguePlaceTokenizer implements PlaceTokenizer<LeaguePlace>{

		@Override
		public LeaguePlace getPlace(String token) {
			return new LeaguePlace();
		}

		@Override
		public String getToken(LeaguePlace place) {
			return place.getToken();
		}
	}
}