package giddyhero.soccersystem.client.manager.ui.league.season;

import giddyhero.soccersystem.shared.model.League;
import giddyhero.soccersystem.shared.model.Season;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class SeasonOverViewPanel extends Composite  {

	private static SeasonOverViewPanelUiBinder uiBinder = GWT.create(SeasonOverViewPanelUiBinder.class);

	interface SeasonOverViewPanelUiBinder extends UiBinder<Widget, SeasonOverViewPanel> {
	}
	
	@UiField
	Label lbLeague, lbSeason;
	@UiField
	FlexTable tblMatches;
	
	League league;
	Season season;

	public SeasonOverViewPanel(League league, Season season) {
		initWidget(uiBinder.createAndBindUi(this));
		this.league = league;
		this.season = season;
		lbLeague.setText(league.name);
		lbSeason.setText(season.year+"");
	}
	
	

}
