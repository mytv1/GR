package giddyhero.soccersystem.client.manager.ui.league;

import giddyhero.soccersystem.client.manager.ui.league.season.PanelSeasonCreate;
import giddyhero.soccersystem.shared.model.Season;

import com.google.gwt.user.client.ui.FlowPanel;

public class PanelLeagueAll extends FlowPanel{
	
	TableLeagueAll tblLeagueAll = new TableLeagueAll();
	Season[] seasons;
	PanelSeasonCreate seasonCreatePanel = new PanelSeasonCreate();
		
	public PanelLeagueAll() {
		super();
		init();
	}

	private void init() {
		initSeasonCreatePanel();
		initTableLeague();
	}

	private void initTableLeague() {
		tblLeagueAll.setSeasonCreatePanel(seasonCreatePanel);
		add(tblLeagueAll);		
	}

	private void initSeasonCreatePanel() {
		seasonCreatePanel.setVisible(false);
		add(seasonCreatePanel);
	}
}
