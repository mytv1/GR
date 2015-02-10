package giddyhero.soccersystem.client.manager.ui.team;

import giddyhero.soccersystem.client.SoccerSystem;
import giddyhero.soccersystem.client.SoccerSystem.Service;
import giddyhero.soccersystem.shared.model.Team;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class TeamCreatePanel extends Composite {

	private static TeamCreatePanelUiBinder uiBinder = GWT
			.create(TeamCreatePanelUiBinder.class);

	interface TeamCreatePanelUiBinder extends UiBinder<Widget, TeamCreatePanel> {
	}
	
	@UiField
	Button btConfirm;
	@UiField
	ListBox lbYear;
	@UiField
	TextBox tbName, tbStadiumName, tbNation;

	public TeamCreatePanel() {
		initWidget(uiBinder.createAndBindUi(this));
		initYearListBox();
	}

	private void initYearListBox() {
		for(int i = 1850;i <= 2015;i ++){
			lbYear.addItem(""+i);
		}
	}

	@UiHandler("btConfirm")
	void onClick(ClickEvent e) {
		String name = tbName.getText();
		String stadiumName = tbStadiumName.getText();
		String nation = tbNation.getText();
		int establishYear = Integer.parseInt(lbYear.getItemText(lbYear.getSelectedIndex()));
		Team team = new Team(name, stadiumName, establishYear,nation);
		SoccerSystem.Service.team.addNewTeam(team, new AsyncCallback<Void>() {
			
			@Override
			public void onSuccess(Void result) {
				Window.alert("Success");				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Failure"+caught.toString());				
			}
		});
		
	}

}
