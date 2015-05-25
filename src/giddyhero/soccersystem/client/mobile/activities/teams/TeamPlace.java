package giddyhero.soccersystem.client.mobile.activities.teams;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicPlace;
import giddyhero.soccersystem.shared.model.News;
import giddyhero.soccersystem.shared.model.Team;

import com.google.gwt.place.shared.PlaceTokenizer;

public class TeamPlace extends BasicPlace {
	
	private Team team;

	public TeamPlace(){
		super();
	}
	
	public Team getTeam() {
		return team;
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


	public void setTeam(Team team) {
		this.team = team;
	}
}