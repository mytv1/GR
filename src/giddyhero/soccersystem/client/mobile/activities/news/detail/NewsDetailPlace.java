package giddyhero.soccersystem.client.mobile.activities.news.detail;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicPlace;

import com.google.gwt.place.shared.PlaceTokenizer;

public class NewsDetailPlace extends BasicPlace{
	int newsId;
	String content;
	String title;
	String imgUrl;
	
	public NewsDetailPlace() {
		super();
		setToken("newsdetail");
	}
	
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setNewId(int newsId) {
		this.newsId = newsId;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return content;
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
