package giddyhero.soccersystem.client.mobile.activities.match;

import giddyhero.soccersystem.client.MobileEntryPoint;
import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.share.CSSUtils;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class PanelMatchDetail1 extends VerticalPanel {
	
	Label lbTime = new Label("Time : 15/8/2015 - 20:30 GMT+7"), lbStatus = new Label("64'"),
			lbReferee = new Label("Referee : Colina"), lbStadium = new Label("Stadium : Emirates"),
			lbHomeCode = new Label("HUL"), lbAwayCode = new Label("ARS"), lbScore = new Label(" 3 - 1");
	HorizontalPanel hp1 = new HorizontalPanel(), hp2 = new HorizontalPanel();
	Image imgLogoHome = new Image(), imgLogoAway = new Image();
	PanelMatchEvent pnEvent = new PanelMatchEvent();

	public PanelMatchDetail1() {
		super();
		init();
		style();
	}

	private void style() {
		CSSUtils.Mobile.setWidthPercent(this, 1.0f);
//		addStyleName(ClientBundleMobile.INST.get().style().pnMatchInfo());
		Style style = getElement().getStyle();
		style.setMarginTop(2, Unit.PCT);
		style.setMarginBottom(5, Unit.PCT);
		
	}

	private void init() {
		lbTime.addStyleName(ClientBundleMobile.INST.get().styleNextMatch().lbTime());
		add(lbTime);
		
		imgLogoHome.setResource(ClientBundleMobile.INST.get().icTeamLogoTemp());
		imgLogoHome.addStyleName(ClientBundleMobile.INST.get().styleNextMatch().imgLogo());
		CSSUtils.Mobile.setSizePercent(imgLogoHome, 0.2f, 0.125f);
		
		hp1.add(imgLogoHome);
		lbHomeCode.addStyleName(ClientBundleMobile.INST.get().styleNextMatch().lbTeamCode());
		CSSUtils.Mobile.setSizePercent(lbHomeCode, 0.15f, 0.04f);
		hp1.add(lbHomeCode);
		
		VerticalPanel vp = new VerticalPanel();
		CSSUtils.Mobile.setSizePercent(vp, 0.3f,0.125f);
		lbScore.addStyleName(ClientBundleMobile.INST.get().styleNextMatch().lbScore());
		lbScore.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				MobileEntryPoint.clientFactory.getPlaceController().goTo(new MatchPlace());
			}
		});
		vp.add(lbScore);
		
		lbStatus.addStyleName(ClientBundleMobile.INST.get().styleNextMatch().lbStatus());
		vp.add(lbStatus);
		hp1.add(vp);
		lbAwayCode.addStyleName(ClientBundleMobile.INST.get().styleNextMatch().lbTeamCode());
		CSSUtils.Mobile.setSizePercent(lbAwayCode, 0.15f, 0.04f);
		hp1.add(lbAwayCode);
		
		imgLogoAway.addStyleName(ClientBundleMobile.INST.get().styleNextMatch().imgLogo());
		imgLogoAway.setResource(ClientBundleMobile.INST.get().icTeamLogoTemp2());
		CSSUtils.Mobile.setSizePercent(imgLogoAway, 0.2f, 0.125f);
		hp1.add(imgLogoAway);
		
		CSSUtils.Mobile.setWidthPercent(hp1, 0.25f);
		add(hp1);
		
		hp2.add(lbStadium);
		hp2.add(lbReferee);
		lbStadium.addStyleName(ClientBundleMobile.INST.get().styleNextMatch().lbCenter());
		lbReferee.addStyleName(ClientBundleMobile.INST.get().styleNextMatch().lbCenter());
		CSSUtils.Mobile.setWidthPercent(lbStadium, 0.5f);
		CSSUtils.Mobile.setWidthPercent(lbReferee, 0.5f);
		add(hp2);
		
		pnEvent.setTempBasicData();
		add(pnEvent);
	}

	
}
