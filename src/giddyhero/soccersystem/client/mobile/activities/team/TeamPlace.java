package giddyhero.soccersystem.client.mobile.activities.team;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicPlace;

import com.google.gwt.place.shared.PlaceTokenizer;

public class TeamPlace extends BasicPlace{
	long teamId;
	
	public TeamPlace() {
		super();
		setToken("team");
	}
	
	public void setPlayerId(long teamId) {
		this.teamId = teamId;
	}
	
	public long getTeamId() {
		return teamId;
	}
	
	public static class TeamPlaceTokenizer implements PlaceTokenizer<TeamPlace>{

		@Override
		public TeamPlace getPlace(String token) {
			return new TeamPlace();
		}

		@Override
		public String getToken(TeamPlace place) {
			return place.getToken();
		}
		
	}

}
