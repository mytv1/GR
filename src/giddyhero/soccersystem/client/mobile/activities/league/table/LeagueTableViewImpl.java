package giddyhero.soccersystem.client.mobile.activities.league.table;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicViewImpl;
import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.mobile.widget.SSTabBarButton;
import giddyhero.soccersystem.client.mobile.widget.SSTabPanel;
import giddyhero.soccersystem.client.share.CSSUtils;
import giddyhero.soccersystem.shared.model.Standing;
import giddyhero.soccersystem.shared.model.Team;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.googlecode.mgwt.ui.client.widget.panel.scroll.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabBarAppearance;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabBarButton;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabPanel;

public class LeagueTableViewImpl extends BasicViewImpl implements LeagueTableView {

	PanelLeagueInfo pnLeagueInfo = new PanelLeagueInfo();
	PanelLeagueMatches pnLeagueMatches = new PanelLeagueMatches();
	SSTabPanel tabPanel = new SSTabPanel();
	SSTabBarButton btTable = new SSTabBarButton(ClientBundleMobile.INST.get().liveScoreUpcomming(), "Table"), btMatches
			= new SSTabBarButton(ClientBundleMobile.INST.get().liveScorePrevious(), "Matches");
	
	public LeagueTableViewImpl() {
		super();
		setStandAloneViewMode();
		init();
		pnMain.pnScroll.setScrollingEnabledY(false);
	}



	private void init() {
		
		CSSUtils.Mobile.setSizePercent(tabPanel, 1f, 0.91f);
		
		ScrollPanel sp = new ScrollPanel();
		sp.setWidget(pnLeagueInfo);
		CSSUtils.Mobile.setSizePercent(sp, 1f, 0.82f);
		tabPanel.add(btTable, sp);
		
		sp = new ScrollPanel();
		sp.setWidget(pnLeagueMatches);
		CSSUtils.Mobile.setSizePercent(sp, 1f, 0.82f);
		tabPanel.add(btMatches,sp);
		
		tabPanel.setSelectionHandler(btTable, btMatches);
		
		pnMain.pnMiddle.add(tabPanel);
	}
	

	@Override
	public HasClickHandlers setStanding(Standing standing, Team team) {
		return pnLeagueInfo.pnTblLeague.setStanding(standing, team);
	}



	@Override
	public void clearTableTempData() {
		pnLeagueInfo.pnTblLeague.clearTempData();
	}



}
