package giddyhero.soccersystem.client.mobile.activities.home;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicPlace;

import com.google.gwt.place.shared.PlaceTokenizer;

public class HomePlace extends BasicPlace {
	
	public HomePlace(){
		super();
		setToken("news");
	}
	
	public static class HomePlaceTokenizer implements PlaceTokenizer<HomePlace>{

		@Override
		public HomePlace getPlace(String token) {
			return new HomePlace();
		}

		@Override
		public String getToken(HomePlace place) {
			return place.getToken();
		}
	}
}