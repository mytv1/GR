package giddyhero.soccersystem.client.mobile.activities.teams;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicViewImpl;
import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.mobile.widget.SSTabBarButton;
import giddyhero.soccersystem.client.mobile.widget.SSTabPanel;
import giddyhero.soccersystem.client.share.CSSUtils;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.googlecode.mgwt.ui.client.widget.panel.scroll.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabBarAppearance;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabBarButton;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabPanel;

public class TeamViewImpl extends BasicViewImpl implements TeamView {
	
	PanelTeamInfo pnTeamInfo = new PanelTeamInfo();
	PanelTeamMatches pnTeamMatches = new PanelTeamMatches();
	SSTabPanel tabPanel = new SSTabPanel();
	SSTabBarButton btInfo = new SSTabBarButton(ClientBundleMobile.INST.get().liveScoreUpcomming(), "Info"),
			btMatches = new SSTabBarButton( ClientBundleMobile.INST.get().liveScorePrevious(), "Matches");
	
	public TeamViewImpl() {
		super();
		setHasMenuButtonMode();
		init();
		pnMain.pnScroll.setScrollingEnabledY(false);
	}

	private void init() {
		
		CSSUtils.Mobile.setSizePercent(tabPanel, 1f, 0.91f);
		
		ScrollPanel sp = new ScrollPanel(); 
		sp.setWidget(pnTeamInfo);
		CSSUtils.Mobile.setSizePercent(sp, 1f, 0.82f);
		tabPanel.add(btInfo, sp);
		
		sp = new ScrollPanel();
		sp.setWidget(pnTeamMatches);
		CSSUtils.Mobile.setSizePercent(sp, 1f, 0.82f);
		tabPanel.add(btMatches,sp);
		tabPanel.setSelectionHandler(btInfo,btMatches);
		
		pnMain.pnMiddle.add(tabPanel);
	}


	@Override
	public void setName(String name) {
		if (!name.equalsIgnoreCase(""))
		pnTeamInfo.pnBasicInfo.pnName.lbContent.setText(name);
	}

	@Override
	public void setAvatar(String url) {
		if (!url.equalsIgnoreCase(""))
		pnTeamInfo.pnBasicInfo.imgLogo.setUrl(url);		
	}

	@Override
	public void setNation(String text) {
			if (!text.equalsIgnoreCase(""))
		pnTeamInfo.pnBasicInfo.pnNation.lbContent.setText(text);
	}

	@Override
	public HasClickHandlers addPlayer(String name, String avatarUrl, String birth, int jerseyNumber) {
		return pnTeamInfo.pnPlayerInfo.addPlayer(name,avatarUrl,birth,jerseyNumber);
	}

	@Override
	public void setTempData() {
		pnTeamInfo.pnPlayerInfo.setTempData();
	}
}

