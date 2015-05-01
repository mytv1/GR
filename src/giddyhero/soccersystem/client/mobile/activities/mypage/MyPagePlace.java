package giddyhero.soccersystem.client.mobile.activities.mypage;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicPlace;
import giddyhero.soccersystem.shared.model.News;

import com.google.gwt.place.shared.PlaceTokenizer;

public class MyPagePlace extends BasicPlace {
	
	public MyPagePlace(){
		super();
		setToken("news");
	}
	
	public static class MyPagePlaceTokenizer implements PlaceTokenizer<MyPagePlace>{

		@Override
		public MyPagePlace getPlace(String token) {
			return new MyPagePlace();
		}

		@Override
		public String getToken(MyPagePlace place) {
			return place.getToken();
		}
	}
}