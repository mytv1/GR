package giddyhero.soccersystem.client.manager.ui.league;

import java.util.Iterator;

import giddyhero.soccersystem.client.SoccerSystem;
import giddyhero.soccersystem.client.manager.ui.general.EditDeletePanel;
import giddyhero.soccersystem.shared.model.League;
import giddyhero.soccersystem.shared.model.SerializableEntity;
import giddyhero.soccersystem.shared.model.Team;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.ToggleButton;
import com.google.gwt.user.client.ui.Widget;

public class LeagueAllPanel extends Composite {

	private static LeagueAllPanelUiBinder uiBinder = GWT.create(LeagueAllPanelUiBinder.class);

	interface LeagueAllPanelUiBinder extends UiBinder<Widget, LeagueAllPanel> {
	}

	@UiField
	FlexTable tblLeague;
	@UiField 
	ToggleButton btNewLeague;
	@UiField
	LeagueCreatePanel pnNewLeague;
	
	public LeagueAllPanel() {
		initWidget(uiBinder.createAndBindUi(this));
		initTableBase();
		initNewLeagueButton();
		initTableData();
	}

	private void initNewLeagueButton() {
		pnNewLeague.setVisible(false);
	}

	@UiHandler("btNewLeague")
	void onButtonNewLeague(ClickEvent e) {
			pnNewLeague.setVisible(btNewLeague.isDown());
		
//		SoccerSystem.mainPage.addNewPanel(new LeagueCreatePanel());
	}
	
	private void initTableBase() {
		tblLeague.setText(0, 0, "ID");
		tblLeague.setText(0, 1, "Name");
		tblLeague.setText(0, 2, "Info");
		tblLeague.setText(0, 3, "Seasons");
		tblLeague.setText(0, 4, "Action");
	}

	private void initTableData() {
		SoccerSystem.Service.league.getAllLeague(new AsyncCallback<League[]>() {

			@Override
			public void onFailure(Throwable caught) {
				
			}

			@Override
			public void onSuccess(League[] result) {
				for (int i = 0; i < result.length; i++) {
					League league = result[i];
					tblLeague.setText(1+i, 0, ""+league.id);
					tblLeague.setText(1+i, 1, ""+league.name);
					tblLeague.setText(1+i, 2, league.info);
					tblLeague.setText(1+i, 3, "N/A");
					tblLeague.setWidget(1+i, 4, createCustomLeagueActionPanel(league));
				}
			}
			
			private Widget createCustomLeagueActionPanel(final League league) {
				EditDeletePanel editDeletePanel = new EditDeletePanel();
				editDeletePanel.getBtDelete().addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						SoccerSystem.Service.general.deleteEntity(SerializableEntity.LEAGUE, league.id, new AsyncCallback<Boolean>() {

							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub
								
							}

							@Override
							public void onSuccess(Boolean result) {
								Window.alert("Delete league success");
							}
						});
					}
				});
				return editDeletePanel;
			}
			
		});
		
	}
	
	
	
	
	
}
