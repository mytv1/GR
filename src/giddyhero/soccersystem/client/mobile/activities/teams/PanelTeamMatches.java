package giddyhero.soccersystem.client.mobile.activities.teams;


import giddyhero.soccersystem.client.mobile.activities.match.PanelGroupMatch;
import giddyhero.soccersystem.client.mobile.activities.match.PanelMatchDetail1;
import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.shared.model.MatchDetailShort;

import java.util.ArrayList;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class PanelTeamMatches extends VerticalPanel{
	Label lbNextMatch = new Label("NOW!");
	PanelGroupMatch pnLastedMatch = new PanelGroupMatch("Lasted Match");
	PanelGroupMatch pnAllMatch = new PanelGroupMatch("All Match");
	PanelMatchDetail1 pnNextMatch = new PanelMatchDetail1();
	
	public PanelTeamMatches() {
		super();
		lbNextMatch.addStyleName(ClientBundleMobile.INST.get().style().lbTitle());
		add(lbNextMatch);
		add(pnNextMatch);
		add(pnLastedMatch);
		add(pnAllMatch);
		test();
	}
	

	private void test() {
		MatchDetailShort matchPlaying = new MatchDetailShort(0L, 0L, 0L, "Chelsea", "Liverpool", "68'",
				"http://upload.wikimedia.org/wikipedia/vi/thumb/5/5c/Chelsea_crest.svg/1024px-Chelsea_crest.svg.png",
				"http://upload.wikimedia.org/wikipedia/vi/b/b2/Liverpool_FC_logo.png", " 2 - 1 ");
		MatchDetailShort matchPrevious = new MatchDetailShort(0L, 0L, 0L, "Chelsea", "Liverpool", "14/3 20:30",
				"http://upload.wikimedia.org/wikipedia/vi/thumb/5/5c/Chelsea_crest.svg/1024px-Chelsea_crest.svg.png",
				"http://upload.wikimedia.org/wikipedia/vi/b/b2/Liverpool_FC_logo.png", "2 - 4");
		MatchDetailShort matchUpcomming = new MatchDetailShort(0L, 0L, 0L, "Chelsea", "Liverpool", "14/4 23:30",
				"http://upload.wikimedia.org/wikipedia/vi/thumb/5/5c/Chelsea_crest.svg/1024px-Chelsea_crest.svg.png",
				"http://upload.wikimedia.org/wikipedia/vi/b/b2/Liverpool_FC_logo.png", "");
//		pnNextMatch.setMatchDetailShort(matchUpcomming);
		pnLastedMatch.setMatchDetailShort(matchPrevious);
		ArrayList<MatchDetailShort> listAllMatch = new ArrayList<MatchDetailShort>();
		listAllMatch.add(matchPrevious);
		listAllMatch.add(matchPrevious);
		listAllMatch.add(matchPrevious);
		listAllMatch.add(matchPrevious);
		listAllMatch.add(matchPrevious);
		listAllMatch.add(matchPrevious);
		listAllMatch.add(matchPrevious);
		listAllMatch.add(matchUpcomming);
		listAllMatch.add(matchUpcomming);
		listAllMatch.add(matchUpcomming);
		listAllMatch.add(matchUpcomming);
		listAllMatch.add(matchUpcomming);
		listAllMatch.add(matchUpcomming);
		listAllMatch.add(matchUpcomming);
		pnAllMatch.setMatchList(listAllMatch);
	}
	
}
