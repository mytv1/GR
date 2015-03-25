package giddyhero.soccersystem.client.mobile.activities.greeting;

import giddyhero.soccersystem.client.mobile.activities.ClientFactory;
import giddyhero.soccersystem.client.mobile.activities.basic.BasicActivity;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.event.shared.EventBus;

public class GreetingActivity extends BasicActivity{
	
	private GreetingView view;

	public GreetingActivity(ClientFactory clientFactory, Place place) {
		super(clientFactory, place);
		view = clientFactory.getGreetingView();
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		super.start(panel, eventBus);
		view.getHeader().setText("");
		panel.setWidget(view);
	}

	
}
