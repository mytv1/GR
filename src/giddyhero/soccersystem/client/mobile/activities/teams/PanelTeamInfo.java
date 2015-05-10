package giddyhero.soccersystem.client.mobile.activities.teams;


import giddyhero.soccersystem.client.MobileEntryPoint;
import giddyhero.soccersystem.client.mobile.activities.mypage.PanelInfo.PanelLineInfo;
import giddyhero.soccersystem.client.mobile.activities.player.PlayerPlace;
import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.share.CSSUtils;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class PanelTeamInfo extends VerticalPanel{
	PanelBasicInfo pnBasicInfo = new PanelBasicInfo();
	PanelManagerInfo pnManagerInfo = new PanelManagerInfo();
	PanelPlayerInfo pnPlayerInfo = new PanelPlayerInfo();
	
	public PanelTeamInfo() {
		super();
		init();
	}

	private void init() {
		add(pnBasicInfo);
		add(pnManagerInfo);
		add(pnPlayerInfo);
	}

	public class PanelBasicInfo extends VerticalPanel{

		Label lbTitle = new Label("Information");
		Image imgLogo = new Image(ClientBundleMobile.INST.get().icTeamLogoTemp());
		Label lbManager, lbStadium, lbEstablish = new Label();
		VerticalPanel vpLine = new VerticalPanel();
		HorizontalPanel hp = new HorizontalPanel();
		
		public PanelBasicInfo() {
			super();
			init();
			style();
		}

		private void init() {
			add(lbTitle);
			
			add(hp);
			
			hp.add(imgLogo);
			
			
			PanelLineInfo pnName = new PanelLineInfo("Club", " Bayer Munich");
			PanelLineInfo pnStadium = new PanelLineInfo("Stadium", " Arena");
			PanelLineInfo pnEstablish = new PanelLineInfo("Establish", " 1982");
			vpLine.add(pnName);
			vpLine.add(pnStadium);
			vpLine.add(pnEstablish);
			
			hp.add(vpLine);
		}

		private void style() {
			CSSUtils.Mobile.setSizePercent(lbTitle, 0.90f, 0.03f);
			lbTitle.addStyleName(ClientBundleMobile.INST.get().style().lbTitle());
			
			CSSUtils.Mobile.setSizePercent(imgLogo, 0.25f, 0.15f);
			Style style = imgLogo.getElement().getStyle();
			style.setPaddingTop(11.5, Unit.PCT);
			style.setPaddingLeft(20, Unit.PCT);
			
			CSSUtils.Mobile.setSizePercent(vpLine, 0.65f, 0.15f);
			 style = vpLine.getElement().getStyle();
			style.setPaddingTop(7.5, Unit.PCT);
			style.setPaddingLeft(20, Unit.PCT);	
			
			style = getElement().getStyle();
			style.setMarginTop(2, Unit.PCT);
			style.setMarginBottom(5, Unit.PCT);
		}
	}
	
	public class PanelManagerInfo extends VerticalPanel{
		Label lbTitle = new Label("Manager");
		Image imgLogo = new Image(ClientBundleMobile.INST.get().icManagerTemp());
		VerticalPanel vpLine = new VerticalPanel();
		HorizontalPanel hp = new HorizontalPanel();
		
		public PanelManagerInfo() {
			super();
			init();
			style();
		}
		

		private void init() {
			add(lbTitle);

			add(hp);
			hp.add(imgLogo);
			
			PanelLineInfo pnName = new PanelLineInfo("Name", " Luis Enrique");
			PanelLineInfo pnStadium = new PanelLineInfo("Birth", "8/5/1970");
			PanelLineInfo pnEstablish = new PanelLineInfo("Nationality", " Spain");
			vpLine.add(pnName);
			vpLine.add(pnStadium);
			vpLine.add(pnEstablish);
			
			hp.add(vpLine);
		}

		private void style() {
			CSSUtils.Mobile.setSizePercent(lbTitle, 0.90f, 0.03f);
			lbTitle.addStyleName(ClientBundleMobile.INST.get().style().lbTitle());
			
			CSSUtils.Mobile.setSizePercent(imgLogo, 0.25f, 0.15f);
			Style style = imgLogo.getElement().getStyle();
			style.setPaddingTop(11.5, Unit.PCT);
			style.setPaddingLeft(20, Unit.PCT);
			

			CSSUtils.Mobile.setSizePercent(vpLine, 0.65f, 0.15f);
			 style = vpLine.getElement().getStyle();
			style.setPaddingTop(7.5, Unit.PCT);
			style.setPaddingLeft(20, Unit.PCT);	
			
			style = getElement().getStyle();
			style.setMarginTop(2, Unit.PCT);
			style.setMarginBottom(5, Unit.PCT);
		}
	}
	
	public class PanelPlayerInfo extends VerticalPanel{
		Label lbTitle = new Label("Player");
		FlexTable tblPlayer = new FlexTable();
		Label lbRank = new Label("R"), lbLogo = new Label("Player"), lbName = new Label("Name"), 
				lbBirth = new Label("Birth"),lbAppearance = new Label(
				"App"),lbGoals = new Label("G"),lbAssist = new Label("A");
		
		public PanelPlayerInfo() {
			super();	
			init();
			style();
			setTempData();
		}
		

		private void init() {
			add(lbTitle);

			CSSUtils.Mobile.setWidthPercent(tblPlayer, 0.96f);
			CSSUtils.Mobile.setWidthPercent(lbRank, 0.06f);
			CSSUtils.Mobile.setWidthPercent(lbLogo, 0.1f);
			CSSUtils.Mobile.setWidthPercent(lbName, 0.2f);
			CSSUtils.Mobile.setWidthPercent(lbBirth, 0.15f);
			CSSUtils.Mobile.setWidthPercent(lbAppearance, 0.05f);
			CSSUtils.Mobile.setWidthPercent(lbGoals, 0.05f);
			CSSUtils.Mobile.setWidthPercent(lbAssist, 0.05f);

			tblPlayer.setWidget(0, 0, lbRank);
			tblPlayer.setWidget(0, 1, lbLogo);
			tblPlayer.setWidget(0, 2, lbName);
			tblPlayer.setWidget(0, 3, lbBirth);
			tblPlayer.setWidget(0, 4, lbAppearance);
			tblPlayer.setWidget(0, 5, lbGoals);
			tblPlayer.setWidget(0, 6, lbAssist);
			
			add(tblPlayer);
		}
		
		private void setTempData() {
			for (int i = 1; i <= 20; i++) {
				tblPlayer.setText(i, 0, "" + i);
				Image imgTeamLogoTemp = new Image(ClientBundleMobile.INST.get().icPlayerTemp1());
				CSSUtils.Mobile.setSizePercent(imgTeamLogoTemp, 0.05f, 0.025f);
				tblPlayer.setWidget(i, 1, imgTeamLogoTemp);
				Label lbName = new Label("Lionel Messi");
				lbName.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						MobileEntryPoint.clientFactory.getPlaceController().goTo(new PlayerPlace());
					}
				});
				lbName.addStyleName(ClientBundleMobile.INST.get().style().hyperlink());
				tblPlayer.setWidget(i, 2, lbName);
				tblPlayer.setText(i, 3, "8/8/1987");
				tblPlayer.setText(i, 4, "33");
				tblPlayer.setText(i, 5, "15");
				tblPlayer.setText(i, 6, "5");
			}

		}

		private void style() {
			CSSUtils.Mobile.setSizePercent(lbTitle, 0.90f, 0.03f);
			lbTitle.addStyleName(ClientBundleMobile.INST.get().style().lbTitle());
			
			tblPlayer.addStyleName(ClientBundleMobile.INST.get().style().tblLeagueScore());
			tblPlayer.getRowFormatter().addStyleName(0, ClientBundleMobile.INST.get().style().tblLeagueScoreRow());
		}
	}
}
