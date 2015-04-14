package giddyhero.soccersystem.client.mobile.activities.livescore;

import giddyhero.soccersystem.client.MobileEntryPoint;
import giddyhero.soccersystem.client.mobile.activities.ClientFactory;
import giddyhero.soccersystem.client.mobile.activities.basic.BasicActivity;
import giddyhero.soccersystem.shared.model.News;
import giddyhero.soccersystem.shared.model.Team;

import java.util.List;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.event.shared.EventBus;

public class LiveScoreActivity extends BasicActivity{
	
	private LiveScoreView view;
	
	public LiveScoreActivity(ClientFactory clientFactory, Place place) {
		super(clientFactory, place);
		view = clientFactory.getLiveScoreView();
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		super.start(panel, eventBus);
		panel.setWidget(view);
		bind();
	}
	
	
	@Override
	public void bind() {
		view.setHeaderTitle("Livescore");
	}

}
