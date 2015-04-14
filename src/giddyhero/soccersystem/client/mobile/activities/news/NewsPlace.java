package giddyhero.soccersystem.client.mobile.activities.news;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicPlace;
import giddyhero.soccersystem.shared.model.News;

import com.google.gwt.place.shared.PlaceTokenizer;

public class NewsPlace extends BasicPlace {
	News news;
	
	public NewsPlace(){
		super();
		setToken("news");
	}
	
	public void setNews(News news) {
		this.news = news;
	}
	
	public News getNews() {
		return news;
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