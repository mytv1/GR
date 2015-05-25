package giddyhero.soccersystem.client.mobile.activities.livescore;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicViewImpl;
import giddyhero.soccersystem.client.mobile.activities.match.PanelGroupMatch;
import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.mobile.widget.SSTabBarButton;
import giddyhero.soccersystem.client.mobile.widget.SSTabPanel;
import giddyhero.soccersystem.client.share.CSSUtils;
import giddyhero.soccersystem.shared.model.MatchDetailShort;

import java.util.ArrayList;

import com.google.gwt.dom.client.Style.Unit;
import com.googlecode.mgwt.ui.client.widget.panel.scroll.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabBarAppearance;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabPanel;

public class LiveScoreViewImpl extends BasicViewImpl implements LiveScoreView {
	PanelGroupMatch pnGroupPlaying;
	PanelGroupMatch pnGroupPrevious;
	PanelGroupMatch pnGroupUpcomming;
	SSTabPanel tabPanel = new SSTabPanel();
	SSTabBarButton btPlaying = new SSTabBarButton( ClientBundleMobile.INST.get().liveScorePlaying(), "Playing"), btPrevious = new SSTabBarButton( ClientBundleMobile.INST.get().liveScorePrevious(), "Previous"),
			btUpComming = new SSTabBarButton(ClientBundleMobile.INST.get().liveScoreUpcomming(), "Upcoming");

	public LiveScoreViewImpl() {
		super();
		init();
		pnMenu.setHighlight("livescore");
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

		pnGroupPlaying = new PanelGroupMatch("Premier League");
		ArrayList<MatchDetailShort> listPlayingMatch = new ArrayList<MatchDetailShort>();
		listPlayingMatch.add(matchPlaying);
		listPlayingMatch.add(matchPlaying);
		pnGroupPlaying.setMatchList(listPlayingMatch);

		ArrayList<MatchDetailShort> listPreviousMatch = new ArrayList<MatchDetailShort>();
		listPreviousMatch.add(matchPrevious);
		listPreviousMatch.add(matchPrevious);
		pnGroupPrevious = new PanelGroupMatch("Laliga");
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
		pnGroupUpcomming = new PanelGroupMatch("Bundesliga");
		pnGroupUpcomming.setMatchList(listUpcommingMatch);

		CSSUtils.Mobile.setSizePercent(tabPanel, 1f, 0.91f);
		tabPanel.add(btPlaying, pnGroupPlaying);

		tabPanel.add(btPrevious, pnGroupPrevious);

		ScrollPanel sp = new ScrollPanel();
		sp.setWidget(pnGroupUpcomming);
		CSSUtils.Mobile.setSizePercent(sp, 1f, 0.83f);
		tabPanel.add(btUpComming, sp);
		tabPanel.setSelectionHandler(btPlaying,btPrevious,btUpComming); 
		pnMain.pnMiddle.add(tabPanel);
		pnMain.pnScroll.setScrollingEnabledY(false);
	}



}

