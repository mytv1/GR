package giddyhero.soccersystem.client.manager.ui.team;

import giddyhero.soccersystem.client.HistoryToken;
import giddyhero.soccersystem.client.SystemManager;
import giddyhero.soccersystem.client.manager.ui.player.TablePlayer;
import giddyhero.soccersystem.client.manager.ui.player.WindowCreatePlayer;
import giddyhero.soccersystem.client.share.CSSUtils;
import giddyhero.soccersystem.shared.model.Player;
import giddyhero.soccersystem.shared.model.Team;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;

public class PanelTeamAll2 extends FlowPanel {

	Button btCreate = new Button("New Team");
	TableTeam tblTeam;

	public PanelTeamAll2() {
		super();
		init();
	}

	private void init() {
		initButtonCreate();
		tblTeam = new TableTeam();
		setAllTeamData();
		add(tblTeam);
		add(new PanelTeamAll());
	}

	private void initButtonCreate() {
		CSSUtils.setMarginTop(btCreate, 10);
		CSSUtils.setMarginBottom(btCreate, 20);
		btCreate.setPixelSize(120, 40);
		btCreate.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				
			}
		});
		add(btCreate);		
	}

	public void setAllTeamData() {
		SystemManager.Service.team.getAllTeams(new AsyncCallback<List<Team>>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("get all team fail");
			}

			@Override
			public void onSuccess(List<Team> result) {
				tblTeam.setData(result);
			}
		});				
		
	}

}
