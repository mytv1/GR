package giddyhero.soccersystem.client.mobile.activities.news.detail;

import giddyhero.soccersystem.client.mobile.activities.AppPlaceHistoryMapper;
import giddyhero.soccersystem.client.mobile.activities.ClientFactory;
import giddyhero.soccersystem.client.mobile.activities.basic.BasicActivity;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;

public class NewsDetailActivity extends BasicActivity{
	
	private NewsDetailView view;

	public NewsDetailActivity(ClientFactory clientFactory, Place place) {
		super(clientFactory, place);
		view = clientFactory.getNewsDetailView();
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		super.start(panel, eventBus);
		view.getHeader().setText("News Detail");
		panel.setWidget(view);
		bind();
	}

	@Override
	public void bind() {
		NewsDetailPlace newsDetailPlace = (NewsDetailPlace)place; 
		view.addContent(newsDetailPlace.getTitle(),newsDetailPlace.getImgUrl(),newsDetailPlace.getContent());		
	}
	
	
	


}
