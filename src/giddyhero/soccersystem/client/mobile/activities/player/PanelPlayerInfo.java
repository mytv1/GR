package giddyhero.soccersystem.client.mobile.activities.player;

import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.mobile.widget.PanelInfo;
import giddyhero.soccersystem.client.share.CSSUtils;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class PanelPlayerInfo extends PanelInfo{
	
	public PanelPlayerInfo() {
		super();
		init();
		style();
		setTempData();
	}

	private void setTempData() {
		imgLogo.setResource(ClientBundleMobile.INST.get().icPlayerTemp1());
		
		addRow("Name", "Lionel Messi");
		addRow("Position", "Center Foward");
		addRow("Nationality", "Argentina");
		addRow("Height", "172");
	}

	private void style() {
	
	}

	private void init() {
	}

}

