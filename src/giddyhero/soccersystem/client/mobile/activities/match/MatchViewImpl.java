package giddyhero.soccersystem.client.mobile.activities.match;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicViewImpl;
import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.mobile.widget.SSTabBarButton;
import giddyhero.soccersystem.client.mobile.widget.SSTabPanel;
import giddyhero.soccersystem.client.share.CSSUtils;

import com.googlecode.mgwt.ui.client.widget.panel.scroll.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabPanel;

public class MatchViewImpl extends BasicViewImpl implements MatchView {

	PanelMatchInfo pnInfo = new PanelMatchInfo();
	PanelMatchLineUpEvent pnDetail = new PanelMatchLineUpEvent();
	PanelMatchStatistics pnStatistics = new PanelMatchStatistics();
	PanelMatchBetting pnBetting = new PanelMatchBetting();
	PanelMatchChatRoom pnChatRoom = new PanelMatchChatRoom();
	SSTabBarButton btInfo = new SSTabBarButton(ClientBundleMobile.INST.get().liveScoreUpcomming(), "Info"),
			btDetail = new SSTabBarButton(ClientBundleMobile.INST.get().liveScorePrevious(),

			"Detail"),
			btStatistics = new SSTabBarButton(ClientBundleMobile.INST.get().liveScorePlaying(), "Statistics"),
			btBetting = new SSTabBarButton(ClientBundleMobile.INST.get().icBetting(), "Betting"),
			btChatroom = new SSTabBarButton(ClientBundleMobile.INST.get().icChatRoom(), "Chatroom");
	SSTabPanel tabPanel = new SSTabPanel();

	public MatchViewImpl() {
		super();
		setHasMenuButtonMode();
		init();
		pnMain.pnScroll.setScrollingEnabledY(false);
		pnMain.pnHeader.lbTitle.setText("Match");
	}

	private void init() {

		CSSUtils.Mobile.setSizePercent(tabPanel, 1f, 0.91f);

		ScrollPanel sp = new ScrollPanel();
		sp.setWidget(pnInfo);
		CSSUtils.Mobile.setSizePercent(sp, 1f, 0.82f);
		tabPanel.add(btInfo, sp);

		sp = new ScrollPanel();
		sp.setWidget(pnDetail);
		CSSUtils.Mobile.setSizePercent(sp, 1f, 0.82f);
		tabPanel.add(btDetail, sp);

		sp = new ScrollPanel();
		sp.setWidget(pnStatistics);
		CSSUtils.Mobile.setSizePercent(sp, 1f, 0.82f);
		tabPanel.add(btStatistics, sp);

		sp = new ScrollPanel();
		sp.setWidget(pnBetting);
		CSSUtils.Mobile.setSizePercent(sp, 1f, 0.82f);
		tabPanel.add(btBetting, sp);

		CSSUtils.Mobile.setSizePercent(sp, 1f, 0.82f);
		tabPanel.add(btChatroom, pnChatRoom);

		tabPanel.setSelectionHandler(btInfo, btDetail, btStatistics, btBetting, btChatroom);

		pnMain.pnMiddle.add(tabPanel);
	}

}
