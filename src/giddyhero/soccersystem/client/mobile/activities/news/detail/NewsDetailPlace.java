package giddyhero.soccersystem.client.mobile.activities.news.detail;

import com.google.gwt.place.shared.PlaceTokenizer;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicPlace;

public class NewsDetailPlace extends BasicPlace{
	int newsId;
	
	public NewsDetailPlace() {
		super();
		setToken("newsdetail");
	}
	
	public void setNewId(int newsId) {
		this.newsId = newsId;
	}
	
	public int getNewsId() {
		return newsId;
	}
	
	public static class NewsDetailPlaceTokenizer implements PlaceTokenizer<NewsDetailPlace>{

		@Override
		public NewsDetailPlace getPlace(String token) {
			return new NewsDetailPlace();
		}

		@Override
		public String getToken(NewsDetailPlace place) {
			return place.getToken();
		}
		
	}

}
