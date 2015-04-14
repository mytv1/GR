package giddyhero.soccersystem.client.mobile.activities.livescore;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicPlace;
import giddyhero.soccersystem.shared.model.News;

import com.google.gwt.place.shared.PlaceTokenizer;

public class LiveScorePlace extends BasicPlace {
	
	public LiveScorePlace(){
		super();
		setToken("livescore");
	}
	
	public static class LiveScorePlaceTokenizer implements PlaceTokenizer<LiveScorePlace>{

		@Override
		public LiveScorePlace getPlace(String token) {
			return new LiveScorePlace();
		}

		@Override
		public String getToken(LiveScorePlace place) {
			return place.getToken();
		}
	}
}