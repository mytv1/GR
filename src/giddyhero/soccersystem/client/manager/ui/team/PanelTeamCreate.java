package giddyhero.soccersystem.client.manager.ui.team;

import giddyhero.soccersystem.client.SystemManager;
import giddyhero.soccersystem.client.share.CSSUtils;
import giddyhero.soccersystem.shared.model.Player;
import giddyhero.soccersystem.shared.model.Team;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;

public class PanelTeamCreate extends FlowPanel {

	TableCreateTeam tblCreatePlayer = new TableCreateTeam();

	public PanelTeamCreate() {
		super();
		init();
	}

	private void init() {
		initLabelTitle();
		add(tblCreatePlayer);
		initConfirmButton();
	}

	private void initConfirmButton() {
		Button btConfirm = new Button("Create");
		btConfirm.setSize("150px", "40px");
		btConfirm.setStyleName("center");
		btConfirm.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				Team team = tblCreatePlayer.getTeam();
				SystemManager.Service.team.saveTeam(team, new AsyncCallback<Team>() {
					
					@Override
					public void onSuccess(Team team) {
//						Window.alert("Success");		
						Player[] selectedPlayers = tblCreatePlayer.getAllSelectedPlayer();
						updateCurrentTeamOfSelectedPlayers(team,selectedPlayers);
					}
					
					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Failure"+caught.toString());				
					}
				});		
			}
		});

		add(btConfirm);
	}
	
	private void updateCurrentTeamOfSelectedPlayers(Team team,Player[] selectedPlayers) {
		for (Player player : selectedPlayers) {
			player.currentTeamId = team.id;
		}
		SystemManager.Service.player.savePlayers(selectedPlayers, new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Save current team of player failure :"+caught.toString());
			}

			@Override
			public void onSuccess(Void result) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	private void initLabelTitle() {
		Label lbTitle = new Label("Create New Team");
		lbTitle.setWidth("100%");
		CSSUtils.setFontSize(lbTitle, "x-large");
		CSSUtils.setTextAlign(lbTitle, Style.TextAlign.CENTER);
		lbTitle.getElement().getStyle().setPaddingBottom(20, Unit.PX);
		add(lbTitle);
	}
}
