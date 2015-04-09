package giddyhero.soccersystem.client;

import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;

public class HistoryToken {

	public final static String LEAGUE = "league";
	public final static String LEAGUE_CREATE = "league/create";
	public static final String MAIN = "main";
	public static final String TEAM = "team";
	public static final String PLAYER = "player";
	public static final String NEWS = "news/all";
	public static final String SEASON = "season/id=";
	public static final String NEWS_CREATE = "news/create";
	public static final String MATCH_UPDATE_WINDOW = "match/id=";
	public static final String MainPage = "";
	public static final String TEST = "test";
	public static final String BLANK = "";
	public static final String MATCH_CREATE_IN_SEASON_WINDOW = "match/create/seasonId=";
	public static final String WINDOW_CREATE_PLAYER = "player/createNew";
	public static final String WINDOW_CREATE_TEAM = "team/createNew";
	
	public static class Utils{
		
		public static long getSeasonIdFromMatchCreateToken(){
			String token = History.getToken();
			String idStr = token.replaceAll(MATCH_CREATE_IN_SEASON_WINDOW, "");
			return Long.parseLong(idStr);
		}
		
		public static long getMatchIdFromMatchUpdateToken(){
			String token = History.getToken();
			String idStr = token.replaceAll(MATCH_UPDATE_WINDOW, "");
			return Long.parseLong(idStr);
		}
	}
}
