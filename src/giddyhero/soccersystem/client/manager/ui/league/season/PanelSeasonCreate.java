package giddyhero.soccersystem.client.manager.ui.league.season;

import giddyhero.soccersystem.client.SystemManager;
import giddyhero.soccersystem.client.manager.ui.widget.TableFormInput;
import giddyhero.soccersystem.shared.model.League;
import giddyhero.soccersystem.shared.model.Season;

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
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class PanelSeasonCreate extends TableFormInput {

	TextBox tbYear = new TextBoxStandard("100px");
	Label lbLeagueName = new Label();
	Button btConfirm = new Button("Create");
	League league;

	public PanelSeasonCreate() {
		super();
		init();
	}
	
	private void init(){
		initLabelColumn();
		initContentColumn();
	}
	
	private void initLabelColumn() {
		setWidget(0, 0, new LabelStandard("New Season"));
		setWidget(0, 1, lbLeagueName);
		setWidget(1, 0, new LabelStandard("Year"));
	}

	private void initContentColumn() {
		setWidget(1, 1, tbYear);
		setWidget(2, 1, btConfirm);
		btConfirm.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				int year = Integer.parseInt(tbYear.getText());
				Season season = new Season(year);
				season.leagueId = league.id;
				SystemManager.Service.league.createNewSeason(league, season, new AsyncCallback<Season>() {
					
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
		});
	}

	public void setLeague(League league) {
		this.league = league;
		lbLeagueName.setText(league.name);
	}
	
}
