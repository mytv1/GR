package giddyhero.soccersystem.client.mobile.activities.basic;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class BasicPlace extends Place{
	private String token = "";
		
	public String getToken(){
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	public static class BasicPlaceTokenizer implements PlaceTokenizer<BasicPlace>{

		@Override
		public BasicPlace getPlace(String token) {
			return new BasicPlace();
		}

		@Override
		public String getToken(BasicPlace place) {
			return place.getToken();
		}
		
	}
	
}
