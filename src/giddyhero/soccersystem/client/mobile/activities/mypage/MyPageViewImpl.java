package giddyhero.soccersystem.client.mobile.activities.mypage;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicViewImpl;
import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.share.CSSUtils;
import giddyhero.soccersystem.shared.model.News;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabBarAppearance;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabBarButton;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabPanel;

public class MyPageViewImpl extends BasicViewImpl implements MyPageView {
	
	PanelInfo pnInfo = new PanelInfo();
	TabPanel tabPanel = new TabPanel();
	
	public MyPageViewImpl() {
		super();
		setHasMenuButtonMode();
		pnMain.pnHeader.lbTitle.setText("MyPage");
		init();
	}

	private void init() {
		pnMain.pnScroll.setScrollingEnabledY(false);
		
		pnMain.pnMiddle.add(tabPanel);
		
		tabPanel.add(new ButtonInfo(), pnInfo);
		tabPanel.add(new ButtonFavoriteTeam(), new PanelFavoriteTeamList());
		tabPanel.add(new ButtonFavoritePlayer(), new PanelFavoritePlayerList());
		tabPanel.add(new ButtonGames(), new PanelGameAchivement());
		
		CSSUtils.Mobile.setSizePercent(tabPanel, 1f, 0.9f);
	}
	
	class ButtonInfo  extends TabBarButton {

		public ButtonInfo() {
			this(TabPanel.DEFAULT_APPEARANCE);
		}

		public ButtonInfo(TabBarAppearance appearance) {
			super(appearance, ClientBundleMobile.INST.get().icUser(),
					 ClientBundleMobile.INST.get().icUserBack());

			setText("Info");
			text.getStyle().setTop(2, Unit.PX);
		}
	}
	
	class ButtonFavoriteTeam  extends TabBarButton {

		public ButtonFavoriteTeam() {
			this(TabPanel.DEFAULT_APPEARANCE);
		}

		public ButtonFavoriteTeam(TabBarAppearance appearance) {
			super(appearance, ClientBundleMobile.INST.get().icTeam(),
					 ClientBundleMobile.INST.get().icTeamBack());

			setText("Favorite Team");
			text.getStyle().setTop(2, Unit.PX);
		}
	}
	
	class ButtonFavoritePlayer  extends TabBarButton {

		public ButtonFavoritePlayer() {
			this(TabPanel.DEFAULT_APPEARANCE);
		}

		public ButtonFavoritePlayer(TabBarAppearance appearance) {
			super(appearance, ClientBundleMobile.INST.get().liveScorePlaying(),
					 ClientBundleMobile.INST.get().liveScorePlayingBack());

			setText("Favorite Player");
			text.getStyle().setTop(2, Unit.PX);
		}
	}
	
	class ButtonGames  extends TabBarButton {

		public ButtonGames() {
			this(TabPanel.DEFAULT_APPEARANCE);
		}

		public ButtonGames(TabBarAppearance appearance) {
			super(appearance, ClientBundleMobile.INST.get().icGames(),
					 ClientBundleMobile.INST.get().icGamesBack());

			setText("Games");
			text.getStyle().setTop(2, Unit.PX);
		}
	}
	
}

