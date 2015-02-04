package giddyhero.soccersystem.client.mobile.activities.greeting;

import com.google.gwt.place.shared.PlaceTokenizer;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicPlace;
import giddyhero.soccersystem.client.mobile.activities.home.HomePlace;

public class GreetingPlace extends BasicPlace{

	public GreetingPlace() {
		super();
		setToken("Greeting");
	}
	
	public static class HomePlaceTokenizer implements PlaceTokenizer<GreetingPlace>{

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
