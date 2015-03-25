package giddyhero.soccersystem.client.mobile.activities.news.list;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicPlace;

import com.google.gwt.place.shared.PlaceTokenizer;

public class NewsPlace extends BasicPlace{
	
	public NewsPlace() {
		super();
		setToken("news");
	}
	
	public static class NewsPlaceTokenizer implements PlaceTokenizer<NewsPlace>{

		@Override
		public NewsPlace getPlace(String token) {
			return new NewsPlace();
		}

		@Override
		public String getToken(NewsPlace place) {
			return place.getToken();
		}
		
	}

}
