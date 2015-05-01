package giddyhero.soccersystem.client.mobile.activities.teams;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicViewImpl;
import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.share.CSSUtils;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.mgwt.ui.client.widget.panel.scroll.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabBarAppearance;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabBarButton;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabPanel;

public class TeamViewImpl extends BasicViewImpl implements TeamView {
	
	PanelTeamInfo pnTeamInfo = new PanelTeamInfo();
	PanelTeamMatches pnTeamMatches = new PanelTeamMatches();
	
	public TeamViewImpl() {
		super();
		setHasMenuButtonMode();
		init();
		pnMain.pnScroll.setScrollingEnabledY(false);
		pnMain.pnHeader.lbTitle.setText("Team");
	}

	private void init() {
		TabPanel tabPanel = new TabPanel();
		CSSUtils.Mobile.setSizePercent(tabPanel, 1f, 0.9f);
		
		ScrollPanel sp = new ScrollPanel(); 
		sp.setWidget(pnTeamInfo);
		CSSUtils.Mobile.setSizePercent(sp, 1f, 0.82f);
		tabPanel.add(new ButtonTeamInfo(), sp);
		
		sp = new ScrollPanel();
		sp.setWidget(pnTeamMatches);
		CSSUtils.Mobile.setSizePercent(sp, 1f, 0.82f);
		tabPanel.add(new ButtonTeamMatches(),sp);
		
		pnMain.pnMiddle.add(tabPanel);
	}

	class ButtonTeamInfo  extends TabBarButton {

		public ButtonTeamInfo() {
			this(TabPanel.DEFAULT_APPEARANCE);
		}

		public ButtonTeamInfo(TabBarAppearance appearance) {
			super(appearance, ClientBundleMobile.INST.get().liveScoreUpcomming(),
					 ClientBundleMobile.INST.get().liveScoreUpcommingBack());			

			setText("Info");
			text.getStyle().setTop(2, Unit.PX);
		}
	}

	class ButtonTeamMatches  extends TabBarButton {

		public ButtonTeamMatches() {
			this(TabPanel.DEFAULT_APPEARANCE);
		}

		public ButtonTeamMatches(TabBarAppearance appearance) {
			super(appearance, ClientBundleMobile.INST.get().liveScorePrevious(),
					 ClientBundleMobile.INST.get().liveScorePreviousBack());

			setText("Matches");
			text.getStyle().setTop(2, Unit.PX);
		}
	}
}

