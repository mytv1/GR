package giddyhero.soccersystem.client.mobile.activities.greeting;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicPlace;

import com.google.gwt.place.shared.PlaceTokenizer;

public class GreetingPlace extends BasicPlace{

	public GreetingPlace() {
		super();
		setToken("Greeting");
	}
	
	public static class GreetingPlaceTokenizer implements PlaceTokenizer<GreetingPlace>{

		@Override
		public GreetingPlace getPlace(String token) {
			return new GreetingPlace();
		}

		@Override
		public String getToken(GreetingPlace place) {
			return place.getToken();
		}
		
	}

}
