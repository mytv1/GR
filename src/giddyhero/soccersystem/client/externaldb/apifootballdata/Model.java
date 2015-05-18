package giddyhero.soccersystem.client.externaldb.apifootballdata;

import giddyhero.soccersystem.shared.model.Match;
import giddyhero.soccersystem.shared.model.Player;
import giddyhero.soccersystem.shared.model.Team;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsonUtils;

public class Model {
	/******************************************** Function *******************************************/

	public static FootBallDataSeasonInfo parseSeasonInfoJson(String jsonStr) {
		return JsonUtils.safeEval(jsonStr);
	}

	public static FootBallDataSeasonTeams parseSeasonTeamsJson(String jsonStr) {
		return JsonUtils.safeEval(jsonStr);
	}

	public static FootBallDataSeasonMatches parseSeasonMatchesJson(String jsonStr) {
		return JsonUtils.safeEval(jsonStr);
	}
	
	public static FootBallDataPlayers parseTeamPlayersJson(String jsonStr) {
		return JsonUtils.safeEval(jsonStr);
	}

	/******************************************** Model *******************************************/

	public static class FootBallDataSeasonMatches extends JavaScriptObject {

		protected FootBallDataSeasonMatches() {
		}

		public final native JsArray<FootBallDataMatch> getMatches() /*-{
			return this.fixtures;
		}-*/;
	}
	
	public static class FootBallDataPlayers extends JavaScriptObject {

		protected FootBallDataPlayers() {
		}

		public final native JsArray<FootBallDataPlayer> getPlayers() /*-{
			return this.players;
		}-*/;
	}

	public static class FootBallDataSeasonTeams extends JavaScriptObject {

		protected FootBallDataSeasonTeams() {
		}

		public final native JsArray<FootBallDataTeam> getTeams() /*-{
			return this.teams;
		}-*/;
	}

	public static class FootBallDataTeam extends JavaScriptObject {

		protected FootBallDataTeam() {
		}

		public final native String getName() /*-{
			return this.name;
		}-*/;

		public final native String getCode() /*-{
			return this.code;
		}-*/;

		public final native String getLogoUrl() /*-{
			return this.crestUrl;
		}-*/;
		
		public final native String getPlayersLink() /*-{
			return this._links.players.href;
		}-*/;

		public final Team toTeam() {
			Team team = new Team(getName(), getLogoUrl(), getCode());
			return team;
		}
	}
	
	public static class FootBallDataPlayer extends JavaScriptObject {

		protected FootBallDataPlayer() {
		}

		public final native String getName() /*-{
			return this.name;
		}-*/;

		public final native String getPosition() /*-{
			return this.position;
		}-*/;

		public final native int getJerseyNumber() /*-{
			if (this.jerseyNumber != null)
				return this.jerseyNumber;
			else 
				return 0;
		}-*/;
		
		public final native String getDateOfBirth() /*-{
			return this.dateOfBirth;
		}-*/;

		public final native String getNationality() /*-{
			return this.nationality;
		}-*/;

		public final Player toPlayer() {
			Player player = new Player(getName(), getPosition(), getJerseyNumber(), getDateOfBirth(), getNationality());
			return player;
		}

	}

	

	public static class FootBallDataMatch extends JavaScriptObject {

		protected FootBallDataMatch() {
		}

		public final native String getDate() /*-{
			return this.date;
		}-*/;

		public final native String getStatus() /*-{
			return this.status;
		}-*/;

		public final native int getMatchDay() /*-{
			return this.matchday;
		}-*/;

		public final native String getHomeTeamName() /*-{
			return this.homeTeamName;
		}-*/;

		public final native String getAwayTeamName() /*-{
			return this.awayTeamName;
		}-*/;

		public final native FootBallDataMatchResult getResult() /*-{
			return this.result;
		}-*/;
		
		public final Match toMatch() {
			Match match = new Match(getDate(), getStatus(), getMatchDay(),getHomeTeamName(), getAwayTeamName(),getResult().getGoalsHomeTeam(),getResult().getGoalsAwayTeam());
			return match;
		}
	}
	
	public static class FootBallDataMatchResult extends JavaScriptObject{
		
		protected FootBallDataMatchResult() {
			
		}
		
		public final native int getGoalsHomeTeam() /*-{
			return this.goalsHomeTeam;
		}-*/;
		
		public final native int getGoalsAwayTeam() /*-{
			return this.goalsAwayTeam;
		}-*/;
	}

	public static class FootBallDataSeasonInfo extends JavaScriptObject {

		protected FootBallDataSeasonInfo() {
		}

		// JSNI methods to get stock data.
		public final native String getCaption() /*-{
			return this.caption;
		}-*/;

		public final native double getLeague() /*-{
			return this.league;
		}-*/;

		public final native String getLastUpdate()/*-{
			return this.lastUpdated;
		}-*/;

	}
}
