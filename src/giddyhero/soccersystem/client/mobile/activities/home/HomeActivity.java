package giddyhero.soccersystem.client.mobile.activities.home;

import giddyhero.soccersystem.client.mobile.activities.ClientFactory;
import giddyhero.soccersystem.client.mobile.activities.basic.BasicActivity;
import giddyhero.soccersystem.client.mobile.activities.news.list.NewsPlace;
import giddyhero.soccersystem.client.mobile.activities.player.PlayerPlace;
import giddyhero.soccersystem.client.mobile.activities.team.TeamPlace;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;

public class HomeActivity extends BasicActivity {

	private HomeView view;

	public HomeActivity(ClientFactory clientFactory, Place place) {
		super(clientFactory, place);
		view = clientFactory.getHomeView();
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		super.start(panel, eventBus);
		view.getHeader().setText("Home");
		panel.setWidget(view);
		bind();
	}

	@Override
	public void bind() {
		addHandlerRegistration(view.getButtonNews().addTapHandler(
				new TapHandler() {

					@Override
					public void onTap(TapEvent event) {
						clientFactory.getPlaceController()
								.goTo(new NewsPlace());
					}
				}));
		
		addHandlerRegistration(view.getButtonPlayer().addTapHandler(
				new TapHandler() {

					@Override
					public void onTap(TapEvent event) {
						PlayerPlace playerPlace = new PlayerPlace();
						clientFactory.getPlaceController()
								.goTo(playerPlace);
					}
				}));
		addHandlerRegistration(view.getButtonTeam().addTapHandler(
				new TapHandler() {

					@Override
					public void onTap(TapEvent event) {
						TeamPlace teamPlace = new TeamPlace();
						clientFactory.getPlaceController()
								.goTo(teamPlace);
					}
				}));
	}

}
