package giddyhero.soccersystem.client.mobile.activities.mypage;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicViewImpl;
import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.mobile.widget.SSTabBarButton;
import giddyhero.soccersystem.client.mobile.widget.SSTabPanel;
import giddyhero.soccersystem.client.share.CSSUtils;

import com.googlecode.mgwt.ui.client.widget.tabbar.TabBarAppearance;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabPanel;

public class MyPageViewImpl extends BasicViewImpl implements MyPageView {

	PanelInfo pnInfo = new PanelInfo();
	SSTabPanel tabPanel = new SSTabPanel();
	SSTabBarButton btInfo = new SSTabBarButton(ClientBundleMobile.INST.get().icUser(),"Info"), btTeam = new SSTabBarButton(ClientBundleMobile.INST.get().icTeam(), "Favourite Team"), 
			btPlayer = new SSTabBarButton(ClientBundleMobile.INST.get().liveScorePlaying(), "Favourite Player"),
			btGames = new SSTabBarButton(ClientBundleMobile.INST.get().icGames(), "Games");

	public MyPageViewImpl() {
		super();
		setHasMenuButtonMode();
		pnMain.pnHeader.lbTitle.setText("My Page");
		init();
	}

	private void init() {
		pnMain.pnScroll.setScrollingEnabledY(false);

		pnMain.pnMiddle.add(tabPanel);

		tabPanel.add(btInfo, pnInfo);
		tabPanel.add(btTeam, new PanelFavoriteTeamList());
		tabPanel.add(btPlayer, new PanelFavoritePlayerList());
		tabPanel.add(btGames, new PanelGameAchivement());
		tabPanel.setSelectionHandler(btInfo,btTeam,btPlayer,btGames);


		CSSUtils.Mobile.setSizePercent(tabPanel, 1f, 0.91f);
	}


}
