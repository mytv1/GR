package giddyhero.soccersystem.client.mobile.activities.news.list;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;

import giddyhero.soccersystem.client.MobileEntryPoint;
import giddyhero.soccersystem.client.mobile.activities.ClientFactory;
import giddyhero.soccersystem.client.mobile.activities.basic.BasicActivity;
import giddyhero.soccersystem.client.mobile.activities.news.detail.NewsDetailPlace;
import giddyhero.soccersystem.shared.model.News;

public class NewsActivity extends BasicActivity {

	private NewsView view;

	public NewsActivity(ClientFactory clientFactory, Place place) {
		super(clientFactory, place);
		view = clientFactory.getNewsView();
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		super.start(panel, eventBus);
		view.getHeader().setText("News");
		panel.setWidget(view);
		bind();
	}

	@Override
	public void bind() {
		MobileEntryPoint.newsService.getAllNews(new AsyncCallback<News[]>() {

			@Override
			public void onSuccess(News[] result) {
				Window.alert("Suceess : " + result.length);
				view.addNewsListContent(result);
				setDetailNewsEvent(result);

			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Failure : " + caught.toString());
			}
		});
		
	}

	private void setDetailNewsEvent(News[] newsArray){
		NewsItem[] newsItems = view.getNewsItems();
		for (int i = 0; i < newsItems.length; i++) {
			NewsItem newsItem = newsItems[i];
			final NewsDetailPlace newsDetailPlace = new NewsDetailPlace();
			newsDetailPlace.setNewId(1);
			newsDetailPlace.setContent(newsArray[i].content);
			newsDetailPlace.setImgUrl(newsArray[i].titleImageUrl);
			newsDetailPlace.setTitle(newsArray[i].title);
			newsItem.setClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					
					clientFactory.getPlaceController()
					.goTo(newsDetailPlace);					
				}
			});
		}
	}

}
