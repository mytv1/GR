package giddyhero.soccersystem.client.mobile.activities.basic;

import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.IsWidget;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;

public interface BasicView extends IsWidget{
	HasTapHandlers getButtonBack();	
	
	HasText getHeader();
}
