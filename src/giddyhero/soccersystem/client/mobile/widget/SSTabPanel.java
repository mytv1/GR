package giddyhero.soccersystem.client.mobile.widget;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabBarButton;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabPanel;

public class SSTabPanel extends TabPanel{
	
	public SSTabPanel() {
		super();
	}
	
	public void setSelectionHandler(final TabBarButton... buttons) {
		addSelectionHandler(new SelectionHandler<Integer>() {

			@Override
			public void onSelection(SelectionEvent<Integer> event) {
				int selection = event.getSelectedItem().intValue();
				for (int i = 0; i < buttons.length; i++) {
					TabBarButton button = buttons[i];
					if (i == selection)
						button.addStyleName("mgwt-TabBar-Button-selected");
					else
						button.removeStyleName("mgwt-TabBar-Button-selected");
				}
			}
		});		
		buttons[0].getParent().setStylePrimaryName("mgwt-TabBar");
		buttons[0].addStyleName("mgwt-TabBar-Button-selected");
	}

}
