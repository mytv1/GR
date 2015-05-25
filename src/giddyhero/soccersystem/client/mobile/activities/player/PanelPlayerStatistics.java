package giddyhero.soccersystem.client.mobile.activities.player;

import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.mobile.widget.PanelInfo;
import giddyhero.soccersystem.client.share.CSSUtils;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sun.security.ntlm.Client;

public class PanelPlayerStatistics extends FlexTable{
	
	public PanelPlayerStatistics() {
		super();
		init();
		style();
		
	}

	private void init() {
		addRow("Goal", "N/A");
		addRow("Assist", "N/A");
		addRow("Appearance", "N/A");
		addRow("Goal per match", "N/A");
		addRow("Red Card", "N/A");
		addRow("Yellow Card", "N/A");
		addRow("Fouls", "N/A");
		addRow("Tackles", "N/A");

	}
	private void style() {
		Style style = getElement().getStyle();
		style.setMarginLeft(5, 	Unit.PCT);
		
//		for (int i = 0; i < getRowCount(); i++) {
//			if (i%2 == 0 )
//				getRowFormatter().getElement(i).getStyle().setBackgroundColor("#989898");
//		}
	}
	
	public void addRow(String title, String content){
		
		
		Label lbTitle = new Label(title);
		CSSUtils.Mobile.setSizePercent(lbTitle, 0.5f,0.05f);
		lbTitle.addStyleName(ClientBundleMobile.INST.get().style().tblInfoRow());
		Style style = lbTitle.getElement().getStyle();
//		style.setFontWeight(FontWeight.BOLD);
		
		Label lbContent = new Label(content);
		CSSUtils.Mobile.setWidthPercent(lbContent, 0.4f);
		 style = lbContent.getElement().getStyle();
		 style.setTextAlign(TextAlign.CENTER);
		 style.setFontSize(150, Unit.PCT);
		int count = getRowCount();
		setWidget(count, 0, lbTitle);
		setWidget(count, 1, lbContent);
		
		if (count%2 == 0)
			getRowFormatter().getElement(count).getStyle().setBackgroundColor("#989898");
	}
	

}
