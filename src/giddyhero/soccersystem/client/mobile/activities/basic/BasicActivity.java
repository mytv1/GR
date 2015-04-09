package giddyhero.soccersystem.client.mobile.activities.basic;


import giddyhero.soccersystem.client.mobile.activities.ClientFactory;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;

public class BasicActivity extends MGWTAbstractActivity {
	protected ClientFactory clientFactory;
	protected Place place;
	
	public BasicActivity(ClientFactory clientFactory, Place place) {
		this.clientFactory = clientFactory;
		this.place = place;
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus){
		super.start(panel, eventBus);
	}
	
	public void bind(){
		
	}

}
