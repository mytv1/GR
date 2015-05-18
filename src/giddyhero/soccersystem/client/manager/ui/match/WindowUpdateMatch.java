package giddyhero.soccersystem.client.manager.ui.match;

import giddyhero.soccersystem.client.HistoryToken;
import giddyhero.soccersystem.client.SystemManager;
import giddyhero.soccersystem.client.manager.ui.match.event.CardWidget;
import giddyhero.soccersystem.client.manager.ui.match.event.ChangePlayerWidget;
import giddyhero.soccersystem.client.manager.ui.match.event.GoalWidget;
import giddyhero.soccersystem.shared.model.Match;
import giddyhero.soccersystem.shared.model.Player;
import giddyhero.soccersystem.shared.model.Team;

import java.util.Date;
import java.util.List;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;

public class WindowUpdateMatch extends HorizontalPanel {
	PanelMatchUpdateTeam pnMatchCreateTeamHome = new PanelMatchUpdateTeam(),
			pnMatchCreateTeamAway = new PanelMatchUpdateTeam();
	PanelMatchInfo pnMatchInfo = new PanelMatchInfo();
	Match match;
	Team teamHome, teamAway;
	Player[] playerHome, playerAway;

	public WindowUpdateMatch() {
		super();
		init();
		getMatchBasicData();
	}

	private void getMatchBasicData() {
		long matchId = HistoryToken.Utils.getMatchIdFromMatchUpdateToken();
		SystemManager.Service.league.getMatch(matchId, new AsyncCallback<Match>() {

			@Override
			public void onSuccess(Match result) {
				Window.alert("Get match success ");
				match = result;
//				pnMatchInfo.setMatchBasicData();
				SystemManager.Service.team.getTeam(match.homeTeamId, new AsyncCallback<Team>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Get home team fail");
					}

					@Override
					public void onSuccess(Team result) {
						Window.alert("Home team : ");
						teamHome = result;
						pnMatchCreateTeamHome.setTeam(teamHome);
						SystemManager.Service.player.getAllPlayerOfTeam(match.homeTeamId,
								new AsyncCallback<List<Player>>() {

									@Override
									public void onFailure(Throwable caught) {
										Window.alert("Get home team players fail");
									}

									@Override
									public void onSuccess(List<Player> result) {
										Player[] players = new Player[result.size()];
										playerHome = players;
										pnMatchCreateTeamHome.setPlayers(playerHome);
										pnMatchInfo.cardWidget.setHome(teamHome, playerHome);
										pnMatchInfo.changePlayerWidget.setHome(teamHome, playerHome);
										pnMatchInfo.goalWidget.setHome(teamHome, playerHome);
									}
								});
					}
				});
				SystemManager.Service.team.getTeam(match.awayTeamId, new AsyncCallback<Team>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Get home team fail");
					}

					@Override
					public void onSuccess(Team result) {
						Window.alert("Away team : ");
						teamAway = result;
						pnMatchCreateTeamAway.setTeam(teamAway);
						SystemManager.Service.player.getAllPlayerOfTeam(match.awayTeamId,
								new AsyncCallback<List<Player>>() {

									@Override
									public void onFailure(Throwable caught) {
										Window.alert("Get home team players fail");
									}

									@Override
									public void onSuccess(List<Player> result) {
										Player[] players = new Player[result.size()];
										playerAway = players;
										pnMatchCreateTeamAway.setPlayers(playerAway);
										pnMatchInfo.cardWidget.setAway(teamAway, playerAway);
										pnMatchInfo.changePlayerWidget.setAway(teamAway, playerAway);
										pnMatchInfo.goalWidget.setAway(teamAway, playerAway);
									}
								});
					}
				});

			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Get match data fail");
			}
		});
	}

	private void init() {
		add(pnMatchCreateTeamHome);
		add(pnMatchCreateTeamAway);
		add(pnMatchInfo);
		customStyle();
	}

	private void customStyle() {
		Style style;

		pnMatchCreateTeamHome.getElement().getStyle().setMargin(40, Unit.PX);
		pnMatchCreateTeamAway.getElement().getStyle().setMargin(40, Unit.PX);
		pnMatchCreateTeamAway.getElement().getStyle().setMarginLeft(0, Unit.PX);
		pnMatchInfo.getElement().getStyle().setMarginTop(40, Unit.PX);

		style = pnMatchInfo.pnDate.getElement().getStyle();
		style.setProperty("marginLeft", "auto");
		style.setProperty("marginRight", "auto");
		style.setMarginBottom(10, Unit.PX);

		style = pnMatchInfo.cardWidget.getElement().getStyle();
		style.setMargin(10, Unit.PX);

		style = pnMatchInfo.changePlayerWidget.getElement().getStyle();
		style.setMargin(10, Unit.PX);

		style = pnMatchInfo.goalWidget.getElement().getStyle();
		style.setMargin(10, Unit.PX);

		style = pnMatchInfo.pnStatus.getElement().getStyle();
		style.setProperty("marginLeft", "auto");
		style.setProperty("marginRight", "auto");
		style.setMarginTop(10, Unit.PX);
		style.setMarginBottom(10, Unit.PX);

		style = pnMatchInfo.btConfirm.getElement().getStyle();
		style.setProperty("marginLeft", "250px");
	}

	class PanelMatchInfo extends VerticalPanel {

		public PanelDate pnDate = new PanelDate();
		public CardWidget cardWidget = new CardWidget();
		public ChangePlayerWidget changePlayerWidget = new ChangePlayerWidget();
		public GoalWidget goalWidget = new GoalWidget();
		public PanelStatus pnStatus = new PanelStatus();
		public Button btConfirm = new Button("Confirm");

		public PanelMatchInfo() {
			super();
			init();

		}

		public void setMatchBasicData() {
			pnDate.dateBox.setValue(new Date(match.dateString));
			pnStatus.setTime(match.minutes);
			pnStatus.setStatus(match.status);
		}

		private void init() {
			// add(new Label("asdasd"));
			add(pnDate);
			add(cardWidget);
			add(changePlayerWidget);
			add(goalWidget);
			add(pnStatus);
			add(btConfirm);

			btConfirm.setPixelSize(120, 40);
			btConfirm.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {

				}
			});
		}

		class PanelDate extends HorizontalPanel {

			DateBox dateBox = new DateBox();

			public PanelDate() {
				super();
				init();
				style();
			}

			private void style() {
				dateBox.getElement().getStyle().setMarginLeft(40, Unit.PX);
			}

			private void init() {
				add(new Label("Time"));
				add(dateBox);
			}

			public Date getDate() {
				return dateBox.getValue();
			}
		}

		class PanelStatus extends HorizontalPanel {
			ListBox lbxStatus = new ListBox();
			ListBox lbxTime = new ListBox();

			public PanelStatus() {
				super();
				init();
			}

			public void setTime(String time) {
				for (int i = 1; i <= 95; i++) {
					if (lbxTime.getItemText(i).equalsIgnoreCase(time)) {
						lbxTime.setSelectedIndex(i);
						return;
					}
				}
			}

			public void setStatus(String givenStatus) {
				String[] status = Match.getAvailableStatus();
				for (int i = 0; i < status.length; i++) {
					if (lbxStatus.getItemText(i).equalsIgnoreCase(givenStatus)) {
						lbxStatus.setSelectedIndex(i);
						return;
					}
				}
			}

			private void init() {
				add(new Label("Time"));

				for (int i = 1; i <= 95; i++) {
					lbxTime.addItem("" + i);
				}
				lbxTime.getElement().getStyle().setMarginLeft(10, Unit.PX);
				add(lbxTime);

				Label lbStatus = new Label("Status");
				lbStatus.getElement().getStyle().setMarginLeft(30, Unit.PX);
				add(lbStatus);

				String[] status = Match.getAvailableStatus();
				for (int i = 0; i < status.length; i++) {
					lbxStatus.addItem(status[i]);
				}
				lbxStatus.getElement().getStyle().setMarginLeft(10, Unit.PX);
				add(lbxStatus);

			}
		}

	}

}
