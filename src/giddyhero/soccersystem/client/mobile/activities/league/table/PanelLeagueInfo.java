package giddyhero.soccersystem.client.mobile.activities.league.table;

import giddyhero.soccersystem.client.MobileEntryPoint;
import giddyhero.soccersystem.client.mobile.activities.basic.BasicPlace;
import giddyhero.soccersystem.client.mobile.activities.player.PlayerPlace;
import giddyhero.soccersystem.client.mobile.activities.teams.TeamPlace;
import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.share.CSSUtils;
import giddyhero.soccersystem.shared.model.Standing;
import giddyhero.soccersystem.shared.model.Team;

import com.google.gwt.dom.client.Style.VerticalAlign;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class PanelLeagueInfo extends VerticalPanel {

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
		FlexTable tblStanding = new FlexTable();

		public PanelTableLeague() {
			super();
			init();
			style();
		}

		private void style() {
			getElement().getStyle().setVerticalAlign(VerticalAlign.TOP);
			CSSUtils.Mobile.setSizePercent(PanelTableLeague.this, 1f, 0.82f);
			addStyleName(ClientBundleMobile.INST.get().style().panelLeagueScoreTable());

			CSSUtils.Mobile.setSizePercent(lbTitle, 0.90f, 0.03f);
			lbTitle.addStyleName(ClientBundleMobile.INST.get().style().lbTitle());

			tblStanding.addStyleName(ClientBundleMobile.INST.get().style().tblLeagueScore());
			tblStanding.getRowFormatter().addStyleName(0, ClientBundleMobile.INST.get().style().tblLeagueScoreRow());

		}

		private void init() {
			add(lbTitle);
			initTable();
			setTempData();
		}
		

		private void setTempData() {
			for (int i = 1; i <= 20; i++) {
				tblStanding.setText(i, 0, "" + i);
				Image imgTeamLogoTemp = new Image(ClientBundleMobile.INST.get().avatarNotAvailable());
				CSSUtils.Mobile.setSizePercent(imgTeamLogoTemp, 0.05f, 0.025f);
				tblStanding.setWidget(i, 1, imgTeamLogoTemp);
				Label lbTeam = new Label("N/A");
				lbTeam.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						TeamPlace teamPlace = new TeamPlace();
						MobileEntryPoint.getClientFactory().getPlaceController().goTo(teamPlace);
					}
				});
				lbTeam.addStyleName(ClientBundleMobile.INST.get().style().hyperlink());
				tblStanding.setWidget(i, 2, lbTeam);
				tblStanding.setText(i, 3, "N/A");
				tblStanding.setText(i, 4, "N/A");
				tblStanding.setText(i, 5, "N/A");
				tblStanding.setText(i, 6, "N/A");
				tblStanding.setText(i, 7, "N/A");
				
			}

		}


		private void initTable() {
			CSSUtils.Mobile.setSizePercent(tblStanding, 0.96f, 0.02f);
			CSSUtils.Mobile.setWidthPercent(lbRank, 0.1f);
			CSSUtils.Mobile.setWidthPercent(lbLogo, 0.1f);
			CSSUtils.Mobile.setWidthPercent(lbName, 0.25f);
			CSSUtils.Mobile.setWidthPercent(lbPlayed, 0.05f);
			CSSUtils.Mobile.setWidthPercent(lbWin, 0.05f);
			CSSUtils.Mobile.setWidthPercent(lbDraw, 0.05f);
			CSSUtils.Mobile.setWidthPercent(lbLose, 0.05f);
			CSSUtils.Mobile.setWidthPercent(lbPoints, 0.05f);

			tblStanding.setWidget(0, 0, lbRank);
			tblStanding.setWidget(0, 1, lbLogo);
			tblStanding.setWidget(0, 2, lbName);
			tblStanding.setWidget(0, 3, lbPlayed);
			tblStanding.setWidget(0, 4, lbWin);
			tblStanding.setWidget(0, 5, lbDraw);
			tblStanding.setWidget(0, 6, lbLose);
			tblStanding.setWidget(0, 7, lbPoints);

			add(tblStanding);
		}
		
		public HasClickHandlers setStanding(Standing standing,Team team){
			int count = tblStanding.getRowCount();
			tblStanding.setText(count, 0, "" + count);
			Image imgTeamLogoTemp = new Image(team.logoUrl);
			CSSUtils.Mobile.setSizePercent(imgTeamLogoTemp, 0.05f, 0.025f);
			tblStanding.setWidget(count, 1, imgTeamLogoTemp);
			Label lbTeam = new Label(team.name);
			lbTeam.addStyleName(ClientBundleMobile.INST.get().style().hyperlink());
			tblStanding.setWidget(count, 2, lbTeam);
			int point = standing.win*3 + standing.draw;
			tblStanding.setText(count, 3, standing.played+"");
			tblStanding.setText(count, 4, standing.win+"");
			tblStanding.setText(count, 5, standing.draw+"");
			tblStanding.setText(count, 6, standing.lose+"");
			tblStanding.setText(count, 7, point+"");
			return lbTeam;
		}

		public void clearTempData() {
			int count = tblStanding.getRowCount();
			for (int i = 0; i < count-1; i++) {
				tblStanding.removeRow(1);
			}
		}

	}

	public static class PanelTopScorePlayer extends VerticalPanel {

		Label lbTitle = new Label("Top Scored");
		Label lbRank = new Label("Rank"), lbLogo = new Label("Player"), lbName = new Label("Name"),
				lbPlayed = new Label("Appearance"), lbTeam = new Label("Team"), lbScored = new Label("Scored");
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
				Image imgTeamLogoTemp = new Image(ClientBundleMobile.INST.get().avatarNotAvailable());
				CSSUtils.Mobile.setSizePercent(imgTeamLogoTemp, 0.05f, 0.025f);
				tblPlayer.setWidget(i, 1, imgTeamLogoTemp);
				Label lbPlayer = new Label("N/A");
				lbPlayer.addStyleName(ClientBundleMobile.INST.get().style().hyperlink());
				lbPlayer.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						MobileEntryPoint.clientFactory.getPlaceController().goTo(new PlayerPlace());
					}
				});
				tblPlayer.setWidget(i, 2, lbPlayer);
				Label lbTeam = new Label("N/A");
				lbTeam.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						MobileEntryPoint.clientFactory.getPlaceController().goTo(new TeamPlace());
					}
				});
				lbTeam.addStyleName(ClientBundleMobile.INST.get().style().hyperlink());
				tblPlayer.setWidget(i, 3, lbTeam);
				tblPlayer.setText(i, 4, "N/A");
				tblPlayer.setText(i, 5, "N/A");
			}

		}

	}

	public static class PanelTopAssistPlayer extends VerticalPanel {

		Label lbTitle = new Label("Top Assist");
		Label lbRank = new Label("Rank"), lbLogo = new Label("Player"), lbName = new Label("Name"),
				lbPlayed = new Label("Appearance"), lbTeam = new Label("Team"), lbAssist = new Label("Assist");
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
			for (int i = 1; i <= 5; i++) {
				tblPlayer.setText(i, 0, "" + i);
				Image imgTeamLogoTemp = new Image(ClientBundleMobile.INST.get().avatarNotAvailable());
				CSSUtils.Mobile.setSizePercent(imgTeamLogoTemp, 0.05f, 0.025f);
				tblPlayer.setWidget(i, 1, imgTeamLogoTemp);
				Label lbPlayer = new Label("N/A");
				lbPlayer.addStyleName(ClientBundleMobile.INST.get().style().hyperlink());
				lbPlayer.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						MobileEntryPoint.clientFactory.getPlaceController().goTo(new PlayerPlace());
					}
				});
				tblPlayer.setWidget(i, 2, lbPlayer);
				Label lbTeam = new Label("N/A");
				lbTeam.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						MobileEntryPoint.clientFactory.getPlaceController().goTo(new TeamPlace());
					}
				});
				lbTeam.addStyleName(ClientBundleMobile.INST.get().style().hyperlink());
				tblPlayer.setWidget(i, 3, lbTeam);
				tblPlayer.setText(i, 4, "N/A");
				tblPlayer.setText(i, 5, "N/A");
			}

		}

	}

}
