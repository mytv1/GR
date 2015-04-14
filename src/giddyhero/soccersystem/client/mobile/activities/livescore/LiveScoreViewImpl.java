package giddyhero.soccersystem.client.mobile.activities.livescore;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicViewImpl;
import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.share.CSSUtils;
import giddyhero.soccersystem.shared.model.MatchDetailShort;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.mgwt.ui.client.widget.panel.scroll.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.tabbar.ContactsTabBarButton;
import com.googlecode.mgwt.ui.client.widget.tabbar.HistoryTabBarButton;
import com.googlecode.mgwt.ui.client.widget.tabbar.MostViewedTabBarButton;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabBarAppearance;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabBarButton;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabPanel;
import com.googlecode.mgwt.ui.client.widget.tabbar.resources.TabBarImageHolder;

public class LiveScoreViewImpl extends BasicViewImpl implements LiveScoreView {
	PanelGroupMatch pnGroupPlaying;
	PanelGroupMatch pnGroupPrevious;
	PanelGroupMatch pnGroupUpcomming;

	public LiveScoreViewImpl() {
		super();
		init();
	}

	private void init() {
		MatchDetailShort matchPlaying = new MatchDetailShort(0L, 0L, 0L, "Chelsea", "Liverpool", "68'",
				"http://upload.wikimedia.org/wikipedia/vi/thumb/5/5c/Chelsea_crest.svg/1024px-Chelsea_crest.svg.png",
				"http://upload.wikimedia.org/wikipedia/vi/b/b2/Liverpool_FC_logo.png", " 2 - 1 ");
		MatchDetailShort matchPrevious = new MatchDetailShort(0L, 0L, 0L, "Chelsea", "Liverpool", "14/3 20:30",
				"http://upload.wikimedia.org/wikipedia/vi/thumb/5/5c/Chelsea_crest.svg/1024px-Chelsea_crest.svg.png",
				"http://upload.wikimedia.org/wikipedia/vi/b/b2/Liverpool_FC_logo.png", "2 - 4");
		MatchDetailShort matchUpcomming = new MatchDetailShort(0L, 0L, 0L, "Chelsea", "Liverpool", "14/4 23:30",
				"http://upload.wikimedia.org/wikipedia/vi/thumb/5/5c/Chelsea_crest.svg/1024px-Chelsea_crest.svg.png",
				"http://upload.wikimedia.org/wikipedia/vi/b/b2/Liverpool_FC_logo.png", "");

		pnGroupPlaying = new PanelGroupMatch("PLAYING");
		ArrayList<MatchDetailShort> listPlayingMatch = new ArrayList<MatchDetailShort>();
		listPlayingMatch.add(matchPlaying);
		listPlayingMatch.add(matchPlaying);
		pnGroupPlaying.setMatchList(listPlayingMatch);

		ArrayList<MatchDetailShort> listPreviousMatch = new ArrayList<MatchDetailShort>();
		listPreviousMatch.add(matchPrevious);
		listPreviousMatch.add(matchPrevious);
		pnGroupPrevious = new PanelGroupMatch("PREVIOUS");
		pnGroupPrevious.setMatchList(listPreviousMatch);

		ArrayList<MatchDetailShort> listUpcommingMatch = new ArrayList<MatchDetailShort>();
		listUpcommingMatch.add(matchUpcomming);
		listUpcommingMatch.add(matchUpcomming);
		listUpcommingMatch.add(matchUpcomming);
		listUpcommingMatch.add(matchUpcomming);
		listUpcommingMatch.add(matchUpcomming);
		listUpcommingMatch.add(matchUpcomming);
		listUpcommingMatch.add(matchUpcomming);
		listUpcommingMatch.add(matchUpcomming);
		listUpcommingMatch.add(matchUpcomming);
		listUpcommingMatch.add(matchUpcomming);
		listUpcommingMatch.add(matchUpcomming);
		listUpcommingMatch.add(matchUpcomming);
		listUpcommingMatch.add(matchUpcomming);
		listUpcommingMatch.add(matchUpcomming);
		pnGroupUpcomming = new PanelGroupMatch("UPCOMMING");
		pnGroupUpcomming.setMatchList(listUpcommingMatch);

		TabPanel tabPanel = new TabPanel();
		CSSUtils.Mobile.setSizePercent(tabPanel, 1f, 0.9f);
		tabPanel.add(new ButtonMatchPlaying(), pnGroupPlaying);

		tabPanel.add(new ButtonMatchPrevious(),pnGroupPrevious);

		ScrollPanel sp = new ScrollPanel();
		sp.setWidget(pnGroupUpcomming);
		CSSUtils.Mobile.setSizePercent(sp, 1f, 0.8f);
		tabPanel.add(new ButtonMatchUpcomming(), sp );
		
		// Tab tabPlaying = new Tab();
		// tabPlaying.setWidget(pnGroupPlaying);
		// tabPlaying.setButton(new TabBarButtonBase(new
		// TabBarDefaultAppearance(), ClientBundleMobile.INSTANCE
		// .getBundle().icMenuGames(),
		// ClientBundleMobile.INSTANCE.getBundle().icMenuGames()));

		// pnMain.pnMiddle.add(pnGroupPlaying);
		// pnMain.pnMiddle.add(pnGroupPrevious);
		// pnMain.pnMiddle.add(pnGroupUpcomming);

		pnMain.pnMiddle.add(tabPanel);
		pnMain.pnScroll.setScrollingEnabledY(false);
	}
	
	class ButtonMatchPlaying  extends TabBarButton {

		public ButtonMatchPlaying() {
			this(TabPanel.DEFAULT_APPEARANCE);
		}

		public ButtonMatchPlaying(TabBarAppearance appearance) {
			super(appearance, ClientBundleMobile.INST.get().liveScorePlaying(),
					 ClientBundleMobile.INST.get().liveScorePlayingBack());

			setText("Playing");
			text.getStyle().setTop(2, Unit.PX);
		}
	}
	
	class ButtonMatchPrevious  extends TabBarButton {

		public ButtonMatchPrevious() {
			this(TabPanel.DEFAULT_APPEARANCE);
		}

		public ButtonMatchPrevious(TabBarAppearance appearance) {
			super(appearance, ClientBundleMobile.INST.get().liveScorePrevious(),
					 ClientBundleMobile.INST.get().liveScorePreviousBack());

			setText("Previous");
			text.getStyle().setTop(2, Unit.PX);
		}
	}

	class ButtonMatchUpcomming  extends TabBarButton {

		public ButtonMatchUpcomming() {
			this(TabPanel.DEFAULT_APPEARANCE);
		}

		public ButtonMatchUpcomming(TabBarAppearance appearance) {
			super(appearance, ClientBundleMobile.INST.get().liveScoreUpcomming(),
					 ClientBundleMobile.INST.get().liveScoreUpcommingBack());

			setText("Upcomming");
			text.getStyle().setTop(2, Unit.PX);
		}
	}


	class PanelGroupMatch extends VerticalPanel {

		Label lbGroupTitle = new Label();
		VerticalPanel vpMatches = new VerticalPanel();

		List<MatchDetailShort> matchList;

		public PanelGroupMatch(String title) {
			super();
			initBaseParam();
			initElements(title);
		}

		private void initBaseParam() {
			Style style;
			style = getElement().getStyle();
			style.setBackgroundColor("#eeeeee");
			style.setMarginBottom(2, Unit.PCT);
		}

		private void initElements(String title) {

			Style style;
			lbGroupTitle.setText(title);
			style = lbGroupTitle.getElement().getStyle();
			style.setBackgroundColor("#666666");
			style.setPadding(1, Unit.PCT);
			style.setColor("#FFFFFF");
			add(lbGroupTitle);

			add(vpMatches);
		}

		public void setMatchList(List<MatchDetailShort> matchList) {
			this.matchList = matchList;
			for (MatchDetailShort matchDetailShort : matchList) {
				PanelMatch pnMatch = new PanelMatch(matchDetailShort);
				vpMatches.add(pnMatch);

			}
		}
	}

	class PanelMatch extends HorizontalPanel {
		Label lbTime = new Label(), lbHome = new Label(), lbAway = new Label(), lbVS = new Label(" VS ");
		Image imgHome = new Image(), imgAway = new Image();
		final static float HEIGHT = 0.06f, WIDTH = 0.98f;
		MatchDetailShort match;

		public PanelMatch(MatchDetailShort match) {
			super();
			initBaseParam();
			initElements();
			setMatchDetailShort(match);
		}

		private void initElements() {
			Style style;
			CSSUtils.Mobile.setSizePercent(lbTime, 0.1f, HEIGHT);
			style = lbTime.getElement().getStyle();
			style.setBackgroundColor("#bbbbbb");
			style.setTextAlign(Style.TextAlign.CENTER);
			style.setPaddingTop(7, Unit.PCT);
			add(lbTime);

			style = lbHome.getElement().getStyle();
			style.setFontSize(150, Unit.PCT);
			style.setPaddingTop(7, Unit.PCT);
			add(lbHome);

			CSSUtils.Mobile.setSizePercent(imgHome, 0.075f, HEIGHT * 0.9f);
			style = imgHome.getElement().getStyle();
			style.setMarginTop(10, Unit.PCT);
			add(imgHome);

			style = lbVS.getElement().getStyle();
			style.setFontSize(120, Unit.PCT);
			style.setPaddingTop(30, Unit.PCT);
			style.setColor("#888888");
			style.setFontWeight(Style.FontWeight.BOLD);
			add(lbVS);

			CSSUtils.Mobile.setSizePercent(imgAway, 0.075f, HEIGHT * 0.9f);
			style = imgAway.getElement().getStyle();
			style.setMarginTop(10, Unit.PCT);
			add(imgAway);

			style = lbAway.getElement().getStyle();
			style.setFontSize(150, Unit.PCT);
			style.setPaddingTop(7, Unit.PCT);
			add(lbAway);
		}

		private void initBaseParam() {
			CSSUtils.Mobile.setSizePercent(PanelMatch.this, WIDTH, HEIGHT);
			Style style = getElement().getStyle();
			style.setBackgroundColor("#cccccc");
			style.setMargin(1, Unit.PCT);

		}

		public void setMatchDetailShort(MatchDetailShort match) {
			this.match = match;
			lbTime.setText(match.time);
			lbHome.setText(match.homeName);
			imgHome.setUrl(match.homeUrl);
			lbAway.setText(match.awayName);
			imgAway.setUrl(match.awayUrl);

			String text = match.score.equalsIgnoreCase("") ? " VS " : match.score;
			lbVS.setText(text);
		}
	}
}
