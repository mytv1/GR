package giddyhero.soccersystem.client.mobile.activities.teams;


import giddyhero.soccersystem.client.MobileEntryPoint;
import giddyhero.soccersystem.client.mobile.activities.mypage.PanelInfo.PanelLineInfo;
import giddyhero.soccersystem.client.mobile.activities.player.PlayerPlace;
import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.share.CSSUtils;
import giddyhero.soccersystem.shared.model.Player;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
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
		Image imgLogo = new Image(ClientBundleMobile.INST.get().avatarNotAvailable());
		Label lbManager, lbStadium, lbEstablish = new Label();
		VerticalPanel vpLine = new VerticalPanel();
		HorizontalPanel hp = new HorizontalPanel();
		PanelLineInfo pnName = new PanelLineInfo("Club", "Not Avaiable");
		PanelLineInfo pnStadium = new PanelLineInfo("Stadium", "Not Avaiable");
		PanelLineInfo pnEstablish = new PanelLineInfo("Establish", "Not Avaiable");
		PanelLineInfo pnNation = new PanelLineInfo("Nation", "Not Avaiable");
		
		public PanelBasicInfo() {
			super();
			init();
			style();
		}

		private void init() {
			add(lbTitle);
			
			add(hp);
			
			hp.add(imgLogo);

			vpLine.add(pnName);
			vpLine.add(pnStadium);
			vpLine.add(pnEstablish);
			vpLine.add(pnNation);
			
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
		Image imgLogo = new Image(ClientBundleMobile.INST.get().avatarNotAvailable());
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
			
			PanelLineInfo pnName = new PanelLineInfo("Name", "Not Available");
			PanelLineInfo pnStadium = new PanelLineInfo("Birth", "Not Available");
			PanelLineInfo pnEstablish = new PanelLineInfo("Nationality", "Not Available");
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
		Label lbRank = new Label(""), lbLogo = new Label("Player"), lbName = new Label("Name"), 
				lbBirth = new Label("Birth"),lbAppearance = new Label(
				"Num"),lbGoals = new Label("G"),lbAssist = new Label("A");
		
		public PanelPlayerInfo() {
			super();	
			init();
			style();
		}
		

		private void init() {
			add(lbTitle);

			CSSUtils.Mobile.setSizePercent(tblPlayer, 0.96f,1.2f);
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
		
		public HasClickHandlers addPlayer(String name, String avatarUrl, String birth, int jerseyNumber) {
			int count = tblPlayer.getRowCount();
			tblPlayer.setText(count, 0, "" + count);
			Image imgTeamLogoTemp = new Image();
			if (avatarUrl.equalsIgnoreCase(""))
				imgTeamLogoTemp.setResource(ClientBundleMobile.INST.get().avatarNotAvailable());
			else
				imgTeamLogoTemp.setTitle(avatarUrl);
			
			CSSUtils.Mobile.setSizePercent(imgTeamLogoTemp, 0.05f, 0.025f);
			tblPlayer.setWidget(count, 1, imgTeamLogoTemp);
			Label lbName = new Label(name);
			lbName.addStyleName(ClientBundleMobile.INST.get().style().hyperlink());
			tblPlayer.setWidget(count, 2, lbName);
			tblPlayer.setText(count, 3, birth);
			tblPlayer.setText(count, 4, jerseyNumber+"");
			tblPlayer.setText(count, 5, "N/A");
			tblPlayer.setText(count, 6, "N/A");
			return lbName;
		}
		
		public void setTempData() {
			for (int i = 1; i <= 30; i++) {
				tblPlayer.setText(i, 0, "" + i);
				Image imgTeamLogoTemp = new Image(ClientBundleMobile.INST.get().avatarNotAvailable());
				CSSUtils.Mobile.setSizePercent(imgTeamLogoTemp, 0.05f, 0.025f);
				tblPlayer.setWidget(i, 1, imgTeamLogoTemp);
				Label lbName = new Label("N/A");
				lbName.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						MobileEntryPoint.clientFactory.getPlaceController().goTo(new PlayerPlace());
					}
				});
				lbName.addStyleName(ClientBundleMobile.INST.get().style().hyperlink());
				tblPlayer.setWidget(i, 2, lbName);
				tblPlayer.setText(i, 3, "N/A");
				tblPlayer.setText(i, 4, "N/A");
				tblPlayer.setText(i, 5, "N/A");
				tblPlayer.setText(i, 6, "N/A");
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
