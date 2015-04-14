package giddyhero.soccersystem.client.mobile.activities.basic;

import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;

public interface BasicView extends IsWidget{
	
	VerticalPanel getPanelMiddle();
	
	Image getImageMenu();
	
	PanelMenu getPanelMenu();
	

	void setHeaderTitle(String str);
	
}
