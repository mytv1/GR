package giddyhero.soccersystem.client.mobile.activities.league.table;

import java.util.ArrayList;

import giddyhero.soccersystem.client.mobile.activities.match.PanelGroupMatch;
import giddyhero.soccersystem.shared.model.MatchDetailShort;

import com.google.gwt.user.client.ui.VerticalPanel;

public class PanelLeagueMatches extends VerticalPanel{
	
	PanelGroupMatch pnLastedMatches = new PanelGroupMatch("Lasted Matches");
	PanelGroupMatch pnPlayingMatches = new PanelGroupMatch("Playing");
	PanelGroupMatch pnUpcommingMatches = new PanelGroupMatch("Upcomming");
	
	public PanelLeagueMatches() {
		super();
		init();
		setTempData();
	}

	private void setTempData() {
		MatchDetailShort matchPlaying = new MatchDetailShort(0L, 0L, 0L, "Chelsea", "Liverpool", "68'",
				"http://upload.wikimedia.org/wikipedia/vi/thumb/5/5c/Chelsea_crest.svg/1024px-Chelsea_crest.svg.png",
				"http://upload.wikimedia.org/wikipedia/vi/b/b2/Liverpool_FC_logo.png", " 2 - 1 ");
		MatchDetailShort matchLasted = new MatchDetailShort(0L, 0L, 0L, "Chelsea", "Liverpool", "14/3 20:30",
				"http://upload.wikimedia.org/wikipedia/vi/thumb/5/5c/Chelsea_crest.svg/1024px-Chelsea_crest.svg.png",
				"http://upload.wikimedia.org/wikipedia/vi/b/b2/Liverpool_FC_logo.png", "2 - 4");
		MatchDetailShort matchUpcomming = new MatchDetailShort(0L, 0L, 0L, "Chelsea", "Liverpool", "14/4 23:30",
				"http://upload.wikimedia.org/wikipedia/vi/thumb/5/5c/Chelsea_crest.svg/1024px-Chelsea_crest.svg.png",
				"http://upload.wikimedia.org/wikipedia/vi/b/b2/Liverpool_FC_logo.png", "");

		ArrayList<MatchDetailShort> listLastedMatch = new ArrayList<MatchDetailShort>();
		listLastedMatch.add(matchLasted);
		listLastedMatch.add(matchLasted);
		listLastedMatch.add(matchLasted);
		listLastedMatch.add(matchLasted);
		pnLastedMatches.setMatchList(listLastedMatch);
		
		ArrayList<MatchDetailShort> listPlayingMatch = new ArrayList<MatchDetailShort>();
		listPlayingMatch.add(matchPlaying);
		listPlayingMatch.add(matchPlaying);
		pnPlayingMatches.setMatchList(listPlayingMatch);
		
		ArrayList<MatchDetailShort> listUpcommingMatch = new ArrayList<MatchDetailShort>();
		listUpcommingMatch.add(matchUpcomming);
		listUpcommingMatch.add(matchUpcomming);
		listUpcommingMatch.add(matchUpcomming);
		listUpcommingMatch.add(matchUpcomming);
		listUpcommingMatch.add(matchUpcomming);
		listUpcommingMatch.add(matchUpcomming);
		pnUpcommingMatches.setMatchList(listUpcommingMatch);
	}

	private void init() {
		
		add(pnLastedMatches);
		
		add(pnPlayingMatches);
		
		add(pnUpcommingMatches);
	}

}
