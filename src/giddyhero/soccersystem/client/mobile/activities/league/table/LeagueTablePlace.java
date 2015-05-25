package giddyhero.soccersystem.client.mobile.activities.league.table;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicPlace;
import giddyhero.soccersystem.shared.model.News;

import com.google.gwt.place.shared.PlaceTokenizer;

public class LeagueTablePlace extends BasicPlace {
	public String leagueName = "";
	
	public LeagueTablePlace(){
		super();
	}
	
	
	public static class LeagueTablePlaceTokenizer implements PlaceTokenizer<LeagueTablePlace>{

		@Override
		public LeagueTablePlace getPlace(String token) {
			return new LeagueTablePlace();
		}

		@Override
		public String getToken(LeagueTablePlace place) {
			return place.getToken();
		}
	}


	public void setLeagueName(String text) {
		leagueName = text;
	}
}