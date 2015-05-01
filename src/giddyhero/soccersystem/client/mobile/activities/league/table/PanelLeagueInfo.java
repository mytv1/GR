package giddyhero.soccersystem.client.mobile.activities.league.table;

import giddyhero.soccersystem.client.MobileEntryPoint;
import giddyhero.soccersystem.client.mobile.activities.teams.TeamPlace;
import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.share.CSSUtils;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class PanelLeagueInfo extends VerticalPanel{

	PanelTableLeague pnTblLeague = new PanelTableLeague();
	PanelTopScorePlayer pnTopScore = new PanelTopScorePlayer();
	PanelTopAssistPlayer pnTopAssist = new PanelTopAssistPlayer();
	
	public PanelLeagueInfo() {
		super();
		init();
	}
	
	public void setData() {
	}

	private void init() {
		add(pnTblLeague);
		add(pnTopScore);
		add(pnTopAssist);
	}
	
	public static class PanelTableLeague extends VerticalPanel {
		Label lbTitle = new Label("Table");
		Label lbRank = new Label("Rank"), lbLogo = new Label("Team"), lbName = new Label("Name"), lbPlayed = new Label(
				"P"), lbPoints = new Label("PTS"), lbWin = new Label("W"), lbDraw = new Label("D"), lbLose = new Label(
				"L");
		FlexTable tblScore = new FlexTable();

		public PanelTableLeague() {
			super();
			init();
			style();
		}

		private void style() {
			addStyleName(ClientBundleMobile.INST.get().style().panelLeagueScoreTable());
			
			CSSUtils.Mobile.setSizePercent(lbTitle, 0.90f, 0.03f);
			lbTitle.addStyleName(ClientBundleMobile.INST.get().style().lbTitle());

			tblScore.addStyleName(ClientBundleMobile.INST.get().style().tblLeagueScore());
			tblScore.getRowFormatter().addStyleName(0, ClientBundleMobile.INST.get().style().tblLeagueScoreRow());

		}

		private void init() {
			add(lbTitle);
			initTable();
			setTempData();
		}

		private void initTable() {
			CSSUtils.Mobile.setWidthPercent(tblScore, 0.96f);
			CSSUtils.Mobile.setWidthPercent(lbRank, 0.1f);
			CSSUtils.Mobile.setWidthPercent(lbLogo, 0.1f);
			CSSUtils.Mobile.setWidthPercent(lbName, 0.25f);
			CSSUtils.Mobile.setWidthPercent(lbPlayed, 0.05f);
			CSSUtils.Mobile.setWidthPercent(lbWin, 0.05f);
			CSSUtils.Mobile.setWidthPercent(lbDraw, 0.05f);
			CSSUtils.Mobile.setWidthPercent(lbLose, 0.05f);
			CSSUtils.Mobile.setWidthPercent(lbPoints, 0.05f);

			tblScore.setWidget(0, 0, lbRank);
			tblScore.setWidget(0, 1, lbLogo);
			tblScore.setWidget(0, 2, lbName);
			tblScore.setWidget(0, 3, lbPlayed);
			tblScore.setWidget(0, 4, lbWin);
			tblScore.setWidget(0, 5, lbDraw);
			tblScore.setWidget(0, 6, lbLose);
			tblScore.setWidget(0, 7, lbPoints);

			add(tblScore);
		}

		private void setTempData() {
			for (int i = 1; i <= 20; i++) {
				tblScore.setText(i, 0, "" + i);
				Image imgTeamLogoTemp = new Image(ClientBundleMobile.INST.get().icTeamLogoTemp());
				CSSUtils.Mobile.setSizePercent(imgTeamLogoTemp, 0.05f, 0.025f);
				tblScore.setWidget(i, 1, imgTeamLogoTemp);
				Label lbTeam = new Label("Chelsea");
				lbTeam.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						MobileEntryPoint.clientFactory.getPlaceController().goTo(new TeamPlace());
					}
				});
				tblScore.setWidget(i, 2, lbTeam);
				tblScore.setText(i, 3, "33");
				tblScore.setText(i, 4, "25");
				tblScore.setText(i, 5, "5");
				tblScore.setText(i, 6, "3");
				tblScore.setText(i, 7, "77");
			}

		}

	}

	public static class PanelTopScorePlayer extends VerticalPanel{
		
		Label lbTitle = new Label("Top Scored");
		Label lbRank = new Label("Rank"), lbLogo = new Label("Player"), lbName = new Label("Name"), lbPlayed = new Label(
				"Appearance"),lbTeam = new Label("Team"), lbScored = new Label("Scored");
		FlexTable tblPlayer = new FlexTable();
		
		public PanelTopScorePlayer() {
			super();
			init();
			style();
			setTempData();	
		}

		private void style() {
			CSSUtils.Mobile.setSizePercent(lbTitle, 0.90f, 0.03f);
			lbTitle.addStyleName(ClientBundleMobile.INST.get().style().lbTitle());
			
			tblPlayer.addStyleName(ClientBundleMobile.INST.get().style().tblLeagueScore());
			tblPlayer.getRowFormatter().addStyleName(0, ClientBundleMobile.INST.get().style().tblLeagueScoreRow());
		}

		private void init() {
			add(lbTitle);
			initTable();
		}

		private void initTable() {
			CSSUtils.Mobile.setWidthPercent(tblPlayer, 0.96f);
			CSSUtils.Mobile.setWidthPercent(lbRank, 0.06f);
			CSSUtils.Mobile.setWidthPercent(lbLogo, 0.1f);
			CSSUtils.Mobile.setWidthPercent(lbName, 0.2f);
			CSSUtils.Mobile.setWidthPercent(lbTeam, 0.2f);
			CSSUtils.Mobile.setWidthPercent(lbPlayed, 0.1f);
			CSSUtils.Mobile.setWidthPercent(lbScored, 0.1f);

			tblPlayer.setWidget(0, 0, lbRank);
			tblPlayer.setWidget(0, 1, lbLogo);
			tblPlayer.setWidget(0, 2, lbName);
			tblPlayer.setWidget(0, 3, lbTeam);
			tblPlayer.setWidget(0, 4, lbPlayed);
			tblPlayer.setWidget(0, 5, lbScored);
			
			add(tblPlayer);
		}
		

		private void setTempData() {
			for (int i = 1; i <= 5; i++) {
				tblPlayer.setText(i, 0, "" + i);
				Image imgTeamLogoTemp = new Image(ClientBundleMobile.INST.get().icPlayerTemp1());
				CSSUtils.Mobile.setSizePercent(imgTeamLogoTemp, 0.05f, 0.025f);
				tblPlayer.setWidget(i, 1, imgTeamLogoTemp);
				tblPlayer.setText(i, 2, "Sergio Aguero");
				tblPlayer.setText(i, 3, "Manchester City");
				tblPlayer.setText(i, 4, "33");
				tblPlayer.setText(i, 5, "35");
			}

		}

	}
	

	public static class PanelTopAssistPlayer extends VerticalPanel{
		
		Label lbTitle = new Label("Top Assist");
		Label lbRank = new Label("Rank"), lbLogo = new Label("Player"), lbName = new Label("Name"), lbPlayed = new Label(
				"Appearance"),lbTeam = new Label("Team"), lbAssist = new Label("Assist");
		FlexTable tblPlayer = new FlexTable();
		
		public PanelTopAssistPlayer() {
			super();
			init();
			style();
			setTempData();	
		}

		private void style() {
			CSSUtils.Mobile.setSizePercent(lbTitle, 0.90f, 0.03f);
			lbTitle.addStyleName(ClientBundleMobile.INST.get().style().lbTitle());
			
			tblPlayer.addStyleName(ClientBundleMobile.INST.get().style().tblLeagueScore());
			tblPlayer.getRowFormatter().addStyleName(0, ClientBundleMobile.INST.get().style().tblLeagueScoreRow());
		}

		private void init() {
			add(lbTitle);
			initTable();
		}

		private void initTable() {
			CSSUtils.Mobile.setWidthPercent(tblPlayer, 0.96f);
			CSSUtils.Mobile.setWidthPercent(lbRank, 0.06f);
			CSSUtils.Mobile.setWidthPercent(lbLogo, 0.1f);
			CSSUtils.Mobile.setWidthPercent(lbName, 0.2f);
			CSSUtils.Mobile.setWidthPercent(lbTeam, 0.2f);
			CSSUtils.Mobile.setWidthPercent(lbPlayed, 0.1f);
			CSSUtils.Mobile.setWidthPercent(lbAssist, 0.1f);

			tblPlayer.setWidget(0, 0, lbRank);
			tblPlayer.setWidget(0, 1, lbLogo);
			tblPlayer.setWidget(0, 2, lbName);
			tblPlayer.setWidget(0, 3, lbTeam);
			tblPlayer.setWidget(0, 4, lbPlayed);
			tblPlayer.setWidget(0, 5, lbAssist);
			
			add(tblPlayer);
		}
		

		private void setTempData() {
			for (int i = 1; i <= 5	; i++) {
				tblPlayer.setText(i, 0, "" + i);
				Image imgTeamLogoTemp = new Image(ClientBundleMobile.INST.get().icPlayerTemp2());
				CSSUtils.Mobile.setSizePercent(imgTeamLogoTemp, 0.05f, 0.025f);
				tblPlayer.setWidget(i, 1, imgTeamLogoTemp);
				tblPlayer.setText(i, 2, "Sergio Aguero");
				tblPlayer.setText(i, 3, "Chelsea");
				tblPlayer.setText(i, 4, "33");
				tblPlayer.setText(i, 5, "35");
			}

		}

	}
	


}
