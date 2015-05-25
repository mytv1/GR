package giddyhero.soccersystem.client.mobile.widget;

import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.Window;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabBarAppearance;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabBarButton;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabPanel;

public class SSTabBarButton extends TabBarButton {

	public SSTabBarButton(TabBarAppearance appearance, ImageResource imageResource, ImageResource selectedResource) {
		super(appearance, imageResource, selectedResource);
		style();
	}
	
	public SSTabBarButton(ImageResource imageResource, String text) {
		this(TabPanel.DEFAULT_APPEARANCE, imageResource, imageResource);
		setText(text);
	}


	private void style() {
		setStylePrimaryName("mgwt-TabBar-Button");
		getElement().getFirstChildElement().setClassName("mgwt-TabBar-Button-icon");
		getElement().getFirstChildElement().getNextSiblingElement().setClassName("mgwt-TabBar-Button-text");
	}

}