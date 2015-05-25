package giddyhero.soccersystem.client.mobile.activities.player;

import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.mobile.widget.PanelInfo;
import giddyhero.soccersystem.client.share.CSSUtils;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Unit;
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
		imgLogo.setResource(ClientBundleMobile.INST.get().avatarNotAvailable());
		
		addRow("Name", "N/A");
		addRow("Position", "N/A");
		addRow("Nationality", "N/A");
		addRow("Birth", "N/A");
		addRow("Shirt Number", "N/A");
	}

	private void style() {
//		Style style = imgLogo.getElement().getStyle();
//		style.setPaddingLeft(20, Unit.PCT);
//		style.setPaddingTop(20, Unit.PCT);
	}

	private void init() {
	}

	public void setPlayerInfo(String name, String birth, String avatarUrl, String nationality, String position,
			int jerseyNumber) {
		if (!avatarUrl.equalsIgnoreCase(""))
			imgLogo.setUrl(avatarUrl);
		tblInfo.removeAllRows();
		addRow("Name", name);
		addRow("Position", position);
		addRow("Nationality", nationality);
		addRow("Birth", birth);
		addRow("Shirt Number", jerseyNumber+"");
	}

}

