package giddyhero.soccersystem.client.mobile.widget;

import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.share.CSSUtils;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class PanelInfo extends HorizontalPanel{
	
	protected Image imgLogo = new Image();
	protected FlexTable tblInfo = new FlexTable();
	SimplePanel spImage = new SimplePanel(imgLogo);
	SimplePanel spTable = new SimplePanel(tblInfo);
	
	public PanelInfo() {
		super();
		style();
		add(spImage);
		add(spTable);
	}

	private void style() {
		CSSUtils.Mobile.setSizePercent(spImage, 0.3f, 0.2f);
		CSSUtils.Mobile.setSizePercent(imgLogo, 0.25f, 0.15f);
		Style style = imgLogo.getElement().getStyle();
		style.setPaddingLeft(10, Unit.PCT);
		style.setPaddingTop(10, Unit.PCT);
		CSSUtils.Mobile.setSizePercent(spTable, 0.6f, 0.2f);
		style = spTable.getElement().getStyle();
		style.setPaddingLeft(10, Unit.PCT);
		style.setPaddingTop(10, Unit.PCT);
	}
	
	public void addRow(String title, String content){
		Label lbTitle = new Label(title);
		CSSUtils.Mobile.setWidthPercent(lbTitle, 0.2f);
		Style style = lbTitle.getElement().getStyle();
		style.setFontWeight(FontWeight.BOLD);
		style.setFontSize(120, Unit.PCT);
		
		Label lbContent = new Label(": "+content);
		 style = lbContent.getElement().getStyle();
		style.setFontSize(120, Unit.PCT);
		int count = tblInfo.getRowCount();
		tblInfo.setWidget(count, 0, lbTitle);
		tblInfo.setWidget(count, 1, lbContent);
	}
	

}
