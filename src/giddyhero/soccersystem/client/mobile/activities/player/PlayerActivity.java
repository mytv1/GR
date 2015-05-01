package giddyhero.soccersystem.client.mobile.activities.player;

import giddyhero.soccersystem.client.mobile.activities.ClientFactory;
import giddyhero.soccersystem.client.mobile.activities.basic.BasicActivity;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.event.shared.EventBus;

public class PlayerActivity extends BasicActivity{
	
	private PlayerView view;
	
	public PlayerActivity(ClientFactory clientFactory, Place place) {
		super(clientFactory, place);
		view = clientFactory.getPlayerView();
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		super.start(panel, eventBus);
		panel.setWidget(view);
		bind();
	}
	
	@Override
	public void bind() {
		view.setHeaderTitle("Player");
	}

}
