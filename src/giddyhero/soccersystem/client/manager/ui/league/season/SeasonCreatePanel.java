package giddyhero.soccersystem.client.manager.ui.league.season;

import giddyhero.soccersystem.client.SoccerSystem;
import giddyhero.soccersystem.shared.model.League;
import giddyhero.soccersystem.shared.model.Season;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class SeasonCreatePanel extends Composite {

	private static SeasonCreatePanelUiBinder uiBinder = GWT.create(SeasonCreatePanelUiBinder.class);

	interface SeasonCreatePanelUiBinder extends UiBinder<Widget, SeasonCreatePanel> {
	}
	
	@UiField
	TextBox tbYear;
	@UiField
	Label lbLeagueName;
	League league;

	public SeasonCreatePanel() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public void setLeague(League league) {
		this.league = league;
		lbLeagueName.setText(league.name);
	}
	
	@UiHandler("btConfirm")
	void onClickConfirmButton(ClickEvent e) {
		int year = Integer.parseInt(tbYear.getText());
		Season season = new Season(year);
		SoccerSystem.Service.league.createNewSeason(league, season, new AsyncCallback<Season>() {
			
			@Override
			public void onSuccess(Season result) {
				Window.alert("Create season success : "+result.year);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Create season failure");
			}
		});
	}

}
