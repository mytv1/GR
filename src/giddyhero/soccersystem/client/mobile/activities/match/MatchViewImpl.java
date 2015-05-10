package giddyhero.soccersystem.client.mobile.activities.match;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicViewImpl;
import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.share.CSSUtils;

import com.google.gwt.dom.client.Style.Unit;
import com.googlecode.mgwt.ui.client.widget.panel.scroll.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabBarAppearance;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabBarButton;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabPanel;

public class MatchViewImpl extends BasicViewImpl implements MatchView {
	
	PanelMatchInfo pnInfo = new PanelMatchInfo();
	PanelMatchLineUpEvent pnDetail = new PanelMatchLineUpEvent();
	PanelMatchStatistics pnStatistics = new PanelMatchStatistics();
	PanelMatchBetting pnBetting = new PanelMatchBetting();
	PanelMatchChatRoom pnChatRoom = new PanelMatchChatRoom();
	
	public MatchViewImpl() {
		super();
		setHasMenuButtonMode();
		init();
		pnMain.pnScroll.setScrollingEnabledY(false);
		pnMain.pnHeader.lbTitle.setText("Match");
	}

	private void init() {
		TabPanel tabPanel = new TabPanel();
		CSSUtils.Mobile.setSizePercent(tabPanel, 1f, 0.9f);
		
		ScrollPanel sp = new ScrollPanel(); 
		sp.setWidget(pnInfo);
		CSSUtils.Mobile.setSizePercent(sp, 1f, 0.82f);
		tabPanel.add(new ButtonMatchInfo(), sp);
		
		sp = new ScrollPanel();
		sp.setWidget(pnDetail);
		CSSUtils.Mobile.setSizePercent(sp, 1f, 0.82f);
		tabPanel.add(new ButtonMatchDetail(),sp);
		
		sp = new ScrollPanel();
		sp.setWidget(pnStatistics);
		CSSUtils.Mobile.setSizePercent(sp, 1f, 0.82f);
		tabPanel.add(new ButtonMatchStatistics(),sp);
		
		sp = new ScrollPanel();
		sp.setWidget(pnBetting);
		CSSUtils.Mobile.setSizePercent(sp, 1f, 0.82f);
		tabPanel.add(new ButtonMatchBetting(),sp);
		
		CSSUtils.Mobile.setSizePercent(sp, 1f, 0.82f);
		tabPanel.add(new ButtonMatchChatRoom(),pnChatRoom);
		
		pnMain.pnMiddle.add(tabPanel);
	}

	class ButtonMatchInfo  extends TabBarButton {

		public ButtonMatchInfo() {
			this(TabPanel.DEFAULT_APPEARANCE);
		}

		public ButtonMatchInfo(TabBarAppearance appearance) {
			super(appearance, ClientBundleMobile.INST.get().liveScoreUpcomming(),
					 ClientBundleMobile.INST.get().liveScoreUpcommingBack());			

			setText("Info");
			text.getStyle().setTop(2, Unit.PX);
		}
	}

	class ButtonMatchDetail  extends TabBarButton {

		public ButtonMatchDetail() {
			this(TabPanel.DEFAULT_APPEARANCE);
		}

		public ButtonMatchDetail(TabBarAppearance appearance) {
			super(appearance, ClientBundleMobile.INST.get().liveScorePrevious(),
					 ClientBundleMobile.INST.get().liveScorePreviousBack());

			setText("Detail");
			text.getStyle().setTop(2, Unit.PX);
		}
	}
	
	class ButtonMatchStatistics  extends TabBarButton {

		public ButtonMatchStatistics() {
			this(TabPanel.DEFAULT_APPEARANCE);
		}

		public ButtonMatchStatistics(TabBarAppearance appearance) {
			super(appearance, ClientBundleMobile.INST.get().liveScorePlaying(),
					 ClientBundleMobile.INST.get().liveScorePlayingBack());

			setText("Statistics");
			text.getStyle().setTop(2, Unit.PX);
		}
	}
	
	class ButtonMatchBetting  extends TabBarButton {

		public ButtonMatchBetting() {
			this(TabPanel.DEFAULT_APPEARANCE);
		}

		public ButtonMatchBetting(TabBarAppearance appearance) {
			super(appearance, ClientBundleMobile.INST.get().icBetting(),
					 ClientBundleMobile.INST.get().icBettingBack());

			setText("Betting");
			text.getStyle().setTop(2, Unit.PX);
		}
	}
	
	class ButtonMatchChatRoom  extends TabBarButton {

		public ButtonMatchChatRoom() {
			this(TabPanel.DEFAULT_APPEARANCE);
		}

		public ButtonMatchChatRoom(TabBarAppearance appearance) {
			super(appearance, ClientBundleMobile.INST.get().icChatRoom(),
					 ClientBundleMobile.INST.get().icChatRoomBack());

			setText("ChatRoom");
			text.getStyle().setTop(2, Unit.PX);
		}
	}
}

