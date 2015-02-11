package giddyhero.soccersystem.client.manager.ui.team;

import giddyhero.soccersystem.client.SoccerSystem;
import giddyhero.soccersystem.client.SoccerSystem.Service;
import giddyhero.soccersystem.client.manager.ui.general.EditDeletePanel;
import giddyhero.soccersystem.shared.model.SerializableEntity;
import giddyhero.soccersystem.shared.model.Team;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.ScrollPanel;
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
		tblTeam.setText(0, 1, "Logo");
		tblTeam.setText(0, 2, "Name");
		tblTeam.setText(0, 3, "Establish Year");
		tblTeam.setText(0, 4, "Stadium");
		tblTeam.setText(0, 5, "Nation");
		tblTeam.setText(0, 6, "Players");
		tblTeam.setText(0, 7, "Actions");
		
		SoccerSystem.Service.team.getAllTeams(new AsyncCallback<Team[]>() {
			
			@Override
			public void onSuccess(Team[] result) {
				Window.alert("Get all player success");
				Team[] teams = result;			
				for(int i = 0;i < teams.length;i++){
					final Team team = teams[i];
					tblTeam.setText(2+i, 0, ""+team.id);
					tblTeam.setWidget(2+i, 1, getLogo(team.logoUrl));
					tblTeam.setText(2+i, 2, ""+team.name);
					tblTeam.setText(2+i, 3, ""+team.establishYear);
					tblTeam.setText(2+i, 4, ""+team.stadiumName);
					tblTeam.setText(2+i, 5, ""+team.nation);
					tblTeam.setText(2+i, 6, ""+team.playerIds.length);
					
					EditDeletePanel editDeletePanel = new EditDeletePanel();
					editDeletePanel.getBtDelete().addClickHandler(new ClickHandler() {
						
						@Override
						public void onClick(ClickEvent event) {
							SoccerSystem.Service.general.deleteEntity(SerializableEntity.TEAM, team.id, new AsyncCallback<Boolean>() {

								@Override
								public void onFailure(Throwable caught) {
									Window.alert("Delete failure");
								}

								@Override
								public void onSuccess(Boolean result) {
									Window.alert("Delete success");
								}
								
							});
						}
					});
					tblTeam.setWidget(2+i, 7, editDeletePanel);
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Get all player failure"+caught.toString());
			}
		});
	}
	
	private Image getLogo(String url){
		Image logo = new Image();
		logo.setPixelSize(60, 60);
		if (url != null)
			logo.setUrl(url);
		return logo;
	}
	


}

