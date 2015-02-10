package giddyhero.soccersystem.client.manager.ui.team;

import giddyhero.soccersystem.client.SoccerSystem;
import giddyhero.soccersystem.client.SoccerSystem.Service;
import giddyhero.soccersystem.shared.model.Team;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;

public class TeamAllPanel extends Composite {

	private static TeamAllPanelUiBinder uiBinder = GWT
			.create(TeamAllPanelUiBinder.class);

	interface TeamAllPanelUiBinder extends UiBinder<Widget, TeamAllPanel> {
	}

	@UiField
	FlexTable tblTeam;
	
	public TeamAllPanel() {
		initWidget(uiBinder.createAndBindUi(this));
		initTable();
	}


	private void initTable() {
		tblTeam.setText(0, 0, "ID");
		tblTeam.setText(0, 1, "Name");
		tblTeam.setText(0, 2, "Establish Year");
		tblTeam.setText(0, 3, "Stadium");
		tblTeam.setText(0, 4, "Nation");
		tblTeam.setText(0, 5, "Players");
		
		// Example player
		tblTeam.setText(1, 0, "-1");
		tblTeam.setText(1, 1, "Arsenal");
		tblTeam.setText(1, 2, "1986");
		tblTeam.setText(1, 3, "Fly Emirates");
		tblTeam.setText(1, 4, "England");
		tblTeam.setText(1, 5, "34");
		
		SoccerSystem.Service.team.getAllTeams(new AsyncCallback<Team[]>() {
			
			@Override
			public void onSuccess(Team[] result) {
				Window.alert("Get all player success");
				Team[] teams = result;			
				for(int i = 0;i < teams.length;i++){
					Team team = teams[i];
					tblTeam.setText(2+i, 0, ""+team.id);
					tblTeam.setText(2+i, 1, ""+team.name);
					tblTeam.setText(2+i, 2, ""+team.establishYear);
					tblTeam.setText(2+i, 3, ""+team.stadiumName);
					tblTeam.setText(2+i, 4, ""+team.nation);
					tblTeam.setText(2+i, 5, "0");
					
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Get all player failure"+caught.toString());
			}
		});
				
	}


}

