package giddyhero.soccersystem.client.mobile.activities.home2;

import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;

public class PanelHeader extends HorizontalPanel{

	Image imgBack = new Image();
	
	public PanelHeader() {
		super();
		imgBack.setResource(ClientBundleMobile.INSTANCE.getBundle().icMenu());
		imgBack.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Window.alert("Click");
			}
		});
	}
}
