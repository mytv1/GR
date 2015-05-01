package giddyhero.soccersystem.client.mobile.activities.teams;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicPlace;
import giddyhero.soccersystem.shared.model.News;

import com.google.gwt.place.shared.PlaceTokenizer;

public class TeamPlace extends BasicPlace {
	
	public TeamPlace(){
		super();
	}
	
	
	public static class TeamPlaceTokenizer implements PlaceTokenizer<TeamPlace>{

		@Override
		public TeamPlace getPlace(String token) {
			return new TeamPlace();
		}

		@Override
		public String getToken(TeamPlace place) {
			return place.getToken();
		}
	}
}