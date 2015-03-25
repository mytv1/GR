package giddyhero.soccersystem.client.manager.ui.league;

import giddyhero.soccersystem.client.SoccerSystem;
import giddyhero.soccersystem.shared.model.League;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class LeagueCreatePanel extends Composite {

	private static LeagueCreatePanelUiBinder uiBinder = GWT.create(LeagueCreatePanelUiBinder.class);

	interface LeagueCreatePanelUiBinder extends UiBinder<Widget, LeagueCreatePanel> {
	}
	
	@UiField
	TextBox tbName;
	@UiField
	TextArea taInfo;

	public LeagueCreatePanel() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiHandler("btConfirm")
	void onClickConfirmButton(ClickEvent e) {
		League league = new League(tbName.getText(), taInfo.getText());
		SoccerSystem.Service.league.saveLeague(league, new AsyncCallback<Void>() {
			
			@Override
			public void onSuccess(Void result) {
				Window.alert("new league success");
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("new league failure");				
			}
		});
	}
	


}
