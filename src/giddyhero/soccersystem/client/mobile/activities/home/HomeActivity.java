package giddyhero.soccersystem.client.mobile.activities.home;

import giddyhero.soccersystem.client.MobileEntryPoint;
import giddyhero.soccersystem.client.mobile.activities.ClientFactory;
import giddyhero.soccersystem.client.mobile.activities.basic.BasicActivity;
import giddyhero.soccersystem.client.mobile.activities.basic.BasicPlace;
import giddyhero.soccersystem.client.mobile.activities.home.HomeViewImpl.PanelNews;
import giddyhero.soccersystem.client.mobile.activities.news.NewsPlace;
import giddyhero.soccersystem.shared.model.News;
import giddyhero.soccersystem.shared.model.Team;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.event.shared.EventBus;

public class HomeActivity extends BasicActivity{
	
	private HomeView view;
	
	
	public HomeActivity(ClientFactory clientFactory, Place place) {
		super(clientFactory, place);
		view = clientFactory.getHomeView();
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		super.start(panel, eventBus);
		panel.setWidget(view);
		bind();
	}
	
	void setData(){
		MobileEntryPoint.Service.news.getAllNews(new AsyncCallback<List<News>>() {
			
			@Override
			public void onSuccess(List<News> result) {
				List<PanelNews> panelNewsList = view.addNews(result);
				for (final PanelNews pnNews : panelNewsList) {
					pnNews.imgMain.addClickHandler(new ClickHandler() {
						
						@Override
						public void onClick(ClickEvent event) {
							NewsPlace newsPlace = new NewsPlace();
							newsPlace.setNews(pnNews.news);
							clientFactory.getPlaceController().goTo(newsPlace);
						}
					});
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("get news fail"+caught.toString());
			}
		});
		
	}
	
	@Override
	public void bind() {
		view.setHeaderTitle("News");
		setData();
		
	}

}
