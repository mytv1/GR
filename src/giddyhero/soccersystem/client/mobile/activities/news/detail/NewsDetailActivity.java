package giddyhero.soccersystem.client.mobile.activities.news.detail;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.event.shared.EventBus;

import giddyhero.soccersystem.client.mobile.activities.ClientFactory;
import giddyhero.soccersystem.client.mobile.activities.basic.BasicActivity;

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
