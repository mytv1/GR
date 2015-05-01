package giddyhero.soccersystem.client.mobile.activities.match;

import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.share.CSSUtils;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.mgwt.ui.client.util.CssUtil;

public class PanelMatchLineUpEvent extends VerticalPanel{
	
	Label lbDetail = new Label("Detail"), lbLineUp = new Label("Line up"), lbStatus = new Label("Playing : 75'");
	PanelMatchEvent pnEvent = new PanelMatchEvent();
	HorizontalPanel hpLineUp = new HorizontalPanel(), hpSustitution = new HorizontalPanel();
	PanelLineUp pnHomeLU = new PanelLineUp("Bayer Munich"), pnAwayLU = new PanelLineUp("Borussia Dortmund")
	  		,pnSubHome = new PanelLineUp("Substitution"), pnSubAway = new PanelLineUp("Substitution");
	
	public PanelMatchLineUpEvent() {
		super();
		init();
		style();
	}

	private void style() {
		CSSUtils.Mobile.setWidthPercent(lbDetail, 0.9f);
		CSSUtils.Mobile.setWidthPercent(lbLineUp, 0.9f);
		CSSUtils.Mobile.setWidthPercent(lbStatus, 1f);
		lbStatus.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		lbDetail.addStyleName(ClientBundleMobile.INST.get().style().lbTitle());
		lbLineUp.addStyleName(ClientBundleMobile.INST.get().style().lbTitle());
	}

	private void init() {
		add(lbDetail);
		add(lbStatus);
		pnEvent.setTempComplexData();
		add(pnEvent);
		add(lbLineUp);
		
		add(hpLineUp);
		pnHomeLU.setTempData();
		hpLineUp.add(pnHomeLU);
		pnAwayLU.setTempData();
		hpLineUp.add(pnAwayLU);
		
		add(hpSustitution);
		pnSubHome.setTempDataSub();
		hpSustitution.add(pnSubHome);
		pnSubAway.setTempDataSub();
		hpSustitution.add(pnSubAway);
	}
	
	class PanelLineUp extends VerticalPanel{
		
		Label lbTitle = new Label("Bayer Munich");
		
		public PanelLineUp() {
			super();
			init();
			style();
			
		}
		
		public PanelLineUp(String title){
			this();
			lbTitle.setText(title);
		}
		
		private void init(){
			add(lbTitle);
			
		}
		
		private void style(){
			CSSUtils.Mobile.setWidthPercent(this, 0.5f);
			lbTitle.addStyleName(ClientBundleMobile.INST.get().style().lbTitleLineUp());
		}
		
		public void setTempData(){
			for (int i = 0; i < 11; i++) {
				add(new PanelLineUpLine());	
			}
		}
		
		public void setTempDataSub(){
			for (int i = 0; i < 5; i++) {
				add(new PanelLineUpLine());	
			}
		}
		
		class PanelLineUpLine extends HorizontalPanel{
			
			Label lbPlayerNumber = new Label("12"), lbPlayerName = new Label("David Ospina");
			
			public PanelLineUpLine() {
				super();
				
				CSSUtils.Mobile.setWidthPercent(this, 0.4f);
				Style style = getElement().getStyle();
				style.setMarginLeft(5f, Unit.PCT);
				style.setBorderWidth(1, Unit.PX);
				style.setBorderStyle(BorderStyle.SOLID);
				
				CSSUtils.Mobile.setWidthPercent(lbPlayerNumber, 0.1f);
				CSSUtils.Mobile.setWidthPercent(lbPlayerName, 0.3f);
				
				style = lbPlayerNumber.getElement().getStyle();
				style.setTextAlign(TextAlign.CENTER);
				style.setFontWeight(FontWeight.BOLD);
				add(lbPlayerNumber);	
				
				style = lbPlayerName.getElement().getStyle();
				style.setTextAlign(TextAlign.CENTER);
				add(lbPlayerName);
			}
		}
	}
	

}
