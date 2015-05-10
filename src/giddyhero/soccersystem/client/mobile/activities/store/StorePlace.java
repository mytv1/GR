package giddyhero.soccersystem.client.mobile.activities.store;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicPlace;
import giddyhero.soccersystem.shared.model.News;

import com.google.gwt.place.shared.PlaceTokenizer;

public class StorePlace extends BasicPlace {
	
	public StorePlace(){
		super();
		setToken("Store");
	}
	
	public static class StorePlaceTokenizer implements PlaceTokenizer<StorePlace>{

		@Override
		public StorePlace getPlace(String token) {
			return new StorePlace();
		}

		@Override
		public String getToken(StorePlace place) {
			return place.getToken();
		}
	}
}