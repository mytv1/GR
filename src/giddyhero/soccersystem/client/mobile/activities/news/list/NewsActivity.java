package giddyhero.soccersystem.client.mobile.activities.news.list;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;

import giddyhero.soccersystem.client.mobile.activities.ClientFactory;
import giddyhero.soccersystem.client.mobile.activities.basic.BasicActivity;
import giddyhero.soccersystem.client.mobile.activities.news.detail.NewsDetailPlace;

public class NewsActivity extends BasicActivity{
	
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
		NewsItem[] newsItems = view.getNewsItems();
		for (int i = 0; i < newsItems.length; i++) {
			FocusPanel focusPanel = new FocusPanel();
			NewsItem newsItem = newsItems[i];
			newsItem.setClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					NewsDetailPlace newsDetailPlace = new NewsDetailPlace();
					newsDetailPlace.setNewId(1);
					clientFactory.getPlaceController()
					.goTo(newsDetailPlace);					
				}
			});
//			newsItem.addAttachHandler(new ClickHandler() {
//				
//				@Override
//				public void onClick(ClickEvent event) {
//					Window.alert("tap tap tap");					
//				}
//			});
//			focusPanel.add(newsItem);
//			focusPanel.addClickHandler(new ClickHandler() {
//				
//				@Override
//				public void onClick(ClickEvent event) {
//					Window.alert("tap tap tap");
//				}
//			});
		}
	}
	
	
	


}
