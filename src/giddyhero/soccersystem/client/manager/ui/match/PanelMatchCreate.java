package giddyhero.soccersystem.client.manager.ui.match;

import giddyhero.soccersystem.client.manager.ui.match.event.CardWidget;
import giddyhero.soccersystem.client.manager.ui.match.event.ChangePlayerWidget;
import giddyhero.soccersystem.client.manager.ui.match.event.GoalWidget;
import giddyhero.soccersystem.shared.Utils;
import giddyhero.soccersystem.shared.model.Match;
import giddyhero.soccersystem.shared.model.Player;
import giddyhero.soccersystem.shared.model.Team;

import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;

public class PanelMatchCreate extends Composite {

	private static MatchCreatePanelUiBinder uiBinder = GWT.create(MatchCreatePanelUiBinder.class);

//	@UiField
//	PanelMatchCreateTeam mtpHome, mtpAway;
	@UiField
	ListBox lbxStatus, lbxTime;
	@UiField
	DateBox dateBox;
	Player[] homePlayers, awayPlayers;
	Team homeTeam, awayTeam;
	@UiField
	GoalWidget goalWidget;
	@UiField
	CardWidget cardWidget;
	@UiField
	ChangePlayerWidget changePlayerWidget;
	@UiField
	Button btConfirm;

	interface MatchCreatePanelUiBinder extends UiBinder<Widget, PanelMatchCreate> {
	}

	public PanelMatchCreate() {
		initWidget(uiBinder.createAndBindUi(this));
		initMatchTeamPanel();
		initMatchStatus();
		initTimeListBox();
	}

	private void initTimeListBox() {
		for (int i = 0; i <= 45; i++) {
			lbxTime.addItem("" + i);
		}
		lbxTime.addItem("45+1");
		lbxTime.addItem("45+2");
		lbxTime.addItem("45+3");
		lbxTime.addItem("45+4");
		lbxTime.addItem("45+5");

		for (int i = 46; i <= 90; i++) {
			lbxTime.addItem("" + i);
		}
		lbxTime.addItem("90+1");
		lbxTime.addItem("90+2");
		lbxTime.addItem("90+3");
		lbxTime.addItem("90+4");
		lbxTime.addItem("90+5");
	}

	private void initMatchStatus() {
		String[] status = Match.getAvailableStatus();
		for (int i = 0; i < status.length; i++) {
			lbxStatus.addItem(status[i]);
		}
	}

	private void initMatchTeamPanel() {
//		mtpHome.setHomeTeam(true);
//		mtpHome.setTeamChoose(tcHomeTeam);
//		mtpAway.setHomeTeam(false);
//		mtpAway.setTeamChoose(tcAwayTeam);
	}

//	TeamChoose tcAwayTeam = new TeamChoose() {
//
//		@Override
//		public void onTeamChange(Team team, Player[] players) {
//			homeTeam = team;
//			homePlayers = players;
//			goalWidget.setHome(team, players);
//			cardWidget.setHome(team, players);
//			changePlayerWidget.setHome(team, players);
//		}
//	};
//
//	TeamChoose tcHomeTeam = new TeamChoose() {
//
//		@Override
//		public void onTeamChange(Team team, Player[] players) {
//			awayTeam = team;
//			awayPlayers = players;
//			goalWidget.setAway(team, players);
//			cardWidget.setAway(team, players);
//			changePlayerWidget.setAway(team, players);
//		}
//	};

	@UiHandler("btConfirm")
	void onClickBtConfirm(ClickEvent e) {
//		long homeTeamId = homeTeam.id;
//		long awayTeamId = awayTeam.id;
//		long[] homeLineUp = mtpHome.getLineUpPlayerIds();
//		long[] awayLineUp = mtpAway.getLineUpPlayerIds();
//		long[] homeSub = mtpHome.getSubstitudePlayerIds();
//		long[] awaySub = mtpAway.getSubstitudePlayerIds();
//		String status = lbxStatus.getItemText(lbxStatus.getSelectedIndex());
//		String minutes = lbxTime.getItemText(lbxTime.getSelectedIndex());
//		// test();
//		Date date = dateBox.getValue();
//		String dateString = DateTimeFormat.getFormat(Utils.DATE_FORMAT_STR).format(date);
//
//		Match match = new Match();
//		match.setBaseAttributes(dateString, homeTeamId, awayTeamId, homeLineUp, awayLineUp, homeSub, awaySub, status, minutes);
//
//		EventCard[] eventCards = cardWidget.getEventCard();
//
//		EventGoal[] eventGoals = goalWidget.getEventGoals();
//
//		EventChangePlayer[] eventChangePlayers = changePlayerWidget.getEventChangePlayers();
//
//		SoccerSystem.Service.league.createMatch(match, eventCards, eventGoals, eventChangePlayers,
//				new AsyncCallback<Match>() {
//
//					@Override
//					public void onSuccess(Match match) {
//						Window.alert("success id : " +match.toString());
//					}
//
//					@Override
//					public void onFailure(Throwable caught) {
//						Window.alert("failure "+caught.toString());
//					}
//				});

	}

	private void test() {
		Date date = dateBox.getValue();
		String dateString = DateTimeFormat.getFormat(Utils.DATE_FORMAT_STR).format(date);
		Window.alert("Date : " + dateString);
	}

}
