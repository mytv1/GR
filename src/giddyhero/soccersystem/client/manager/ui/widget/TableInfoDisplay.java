package giddyhero.soccersystem.client.manager.ui.widget;

import giddyhero.soccersystem.client.CSSClass;
import giddyhero.soccersystem.client.manager.resources.SSClientBundleBaseThemeManager;
import giddyhero.soccersystem.client.manager.widget.SSFlexTable;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.ToggleButton;

public class TableInfoDisplay extends SSFlexTable{

	public TableInfoDisplay() {
		super();
		init();
	}

	private void init() {
		setStyleName(CSSClass.TABLE_INFO);
	}
	
	
}
