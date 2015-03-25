package giddyhero.soccersystem.client.manager.ui.team;

import giddyhero.soccersystem.client.SoccerSystem;
import giddyhero.soccersystem.client.manager.ui.widget.TableInfoDisplay;
import giddyhero.soccersystem.client.manager.ui.widget.TableInfoDisplay.ActionPanel;
import giddyhero.soccersystem.shared.model.SerializableEntity;
import giddyhero.soccersystem.shared.model.Team;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

public class TeamAllPanel extends TableInfoDisplay {
	
	
	public TeamAllPanel() {
		super();
		initTable();
	}


	private void initTable() {
		setText(0, 0, "ID");
		setText(0, 1, "Logo");
		setText(0, 2, "Name");
		setText(0, 3, "Establish Year");
		setText(0, 4, "Stadium");
		setText(0, 5, "Nation");
		setText(0, 6, "Players");
		setText(0, 7, "Actions");
		
		SoccerSystem.Service.team.getAllTeams(new AsyncCallback<Team[]>() {
			
			@Override
			public void onSuccess(Team[] result) {
				Window.alert("Get all player success");
				Team[] teams = result;			
				for(int i = 0;i < teams.length;i++){
					final Team team = teams[i];
					setText(2+i, 0, ""+team.id);
					setWidget(2+i, 1, getLogo(team.logoUrl));
					setText(2+i, 2, ""+team.name);
					setText(2+i, 3, ""+team.establishYear);
					setText(2+i, 4, ""+team.stadiumName);
					setText(2+i, 5, ""+team.nation);
					setText(2+i, 6, ""+team.playerIds.length);
					
//					EditDeletePanel editDeletePanel = new EditDeletePanel();
//					editDeletePanel.getBtDelete().addClickHandler(new ClickHandler() {
//						
//						@Override
//						public void onClick(ClickEvent event) {
//							SoccerSystem.Service.general.deleteEntity(SerializableEntity.TEAM, team.id, new AsyncCallback<Boolean>() {
//
//								@Override
//								public void onFailure(Throwable caught) {
//									Window.alert("Delete failure");
//								}
//
//								@Override
//								public void onSuccess(Boolean result) {
//									Window.alert("Delete success");
//								}
//								
//							});
//						}
//					});
					setWidget(2+i, 7, new ActionPanel());
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

