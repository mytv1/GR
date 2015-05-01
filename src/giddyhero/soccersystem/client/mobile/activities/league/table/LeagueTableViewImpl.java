package giddyhero.soccersystem.client.mobile.activities.league.table;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicViewImpl;
import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.share.CSSUtils;

import com.google.gwt.dom.client.Style.Unit;
import com.googlecode.mgwt.ui.client.widget.panel.scroll.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabBarAppearance;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabBarButton;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabPanel;

public class LeagueTableViewImpl extends BasicViewImpl implements LeagueTableView {

	PanelLeagueInfo pnLeagueInfo = new PanelLeagueInfo();
	PanelLeagueMatches pnLeagueMatches = new PanelLeagueMatches();
	
	public LeagueTableViewImpl() {
		super();
		setStandAloneViewMode();
		init();
		pnMain.pnScroll.setScrollingEnabledY(false);
	}


	public void setData() {
	}

	private void init() {
		
		TabPanel tabPanel = new TabPanel();
		CSSUtils.Mobile.setSizePercent(tabPanel, 1f, 0.9f);
		
		ScrollPanel sp = new ScrollPanel();
		sp.setWidget(pnLeagueInfo);
		CSSUtils.Mobile.setSizePercent(sp, 1f, 0.82f);
		tabPanel.add(new ButtonLeagueInfo(), sp);
		
		sp = new ScrollPanel();
		sp.setWidget(pnLeagueMatches);
		CSSUtils.Mobile.setSizePercent(sp, 1f, 0.82f);
		tabPanel.add(new ButtonLeagueMatches(),sp);
		
		pnMain.pnMiddle.add(tabPanel);
	}
	
	class ButtonLeagueInfo  extends TabBarButton {

		public ButtonLeagueInfo() {
			this(TabPanel.DEFAULT_APPEARANCE);
		}

		public ButtonLeagueInfo(TabBarAppearance appearance) {
			super(appearance, ClientBundleMobile.INST.get().liveScoreUpcomming(),
					 ClientBundleMobile.INST.get().liveScoreUpcommingBack());			

			setText("Info");
			text.getStyle().setTop(2, Unit.PX);
		}
	}

	class ButtonLeagueMatches  extends TabBarButton {

		public ButtonLeagueMatches() {
			this(TabPanel.DEFAULT_APPEARANCE);
		}

		public ButtonLeagueMatches(TabBarAppearance appearance) {
			super(appearance, ClientBundleMobile.INST.get().liveScorePrevious(),
					 ClientBundleMobile.INST.get().liveScorePreviousBack());

			setText("Matches");
			text.getStyle().setTop(2, Unit.PX);
		}
	}


}
