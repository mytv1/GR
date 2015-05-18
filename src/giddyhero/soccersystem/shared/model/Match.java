package giddyhero.soccersystem.shared.model;

import com.google.gwt.view.client.ProvidesKey;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Match implements SerializableEntity {

	public static final ProvidesKey<Match> KEY_PROVIDER = new ProvidesKey<Match>() {
		@Override
		public Object getKey(Match item) {
			return item == null ? null : item.id;
		}
	};

	public @Id
	Long id;
	@Index	public long seasonId = 0;
	public int matchDay = 0;
	public long homeTeamId = 0;
	public long awayTeamId = 0;
	public long[] homeLineUp;
	public long[] awayLineUp;
	public long[] homeSub;
	public long[] awaySub;
	public long[] eventCardIds;
	public long[] eventGoalIds;
	public long[] eventPlayerChangeIds;
	public String status = "";
	public String minutes = "";
	public String dateString = "";
	public String homeTeamName = "";
	public String awayTeamName = "";
	public int goalsHomeTeam = 0;
	public int goalsAwayTeam = 0;

	public Match() {
	}

	public Match(String dateString, long homeId, long awayId, long[] homeLineUp, long[] awayLineUp, long[] homeSub,
			long[] awaySub, long[] eventCardIds, long[] eventGoalIds, long[] eventPlayerChangeIds, String status,
			String minutes) {
		setBaseAttributes(dateString, homeId, awayId, homeLineUp, awayLineUp, homeSub, awaySub, status, minutes);
		setEvents(eventCardIds, eventGoalIds, eventPlayerChangeIds);
	}

	public Match(String time, long homeId, long awayId) {
		this.dateString = time;
		this.homeTeamId = homeId;
		this.awayTeamId = awayId;
	}

	public Match(String time, long homeId, long awayId, long seasonId) {
		this(time, homeId, awayId);
		this.seasonId = seasonId;
	}

	public Match(String date, String status, int matchDay, String homeTeamName, String awayTeamName) {
		this.dateString = date;
		this.status = status;
		this.matchDay = matchDay;
		this.homeTeamName = homeTeamName;
		this.awayTeamName = awayTeamName;
	}

	public Match(String date, String status, String homeTeamName, String awayTeamName) {
		this.dateString = date;
		this.status = status;
		this.homeTeamName = homeTeamName;
		this.awayTeamName = awayTeamName;
	}

	public Match(String date, String status, int matchDay, String homeTeamName, String awayTeamName, int goalsHomeTeam,
			int goalsAwayTeam) {
		this.dateString = date;
		this.status = status;
		this.matchDay = matchDay;
		this.homeTeamName = homeTeamName;
		this.awayTeamName = awayTeamName;
		this.goalsHomeTeam = goalsHomeTeam;
		this.goalsAwayTeam = goalsAwayTeam;
	}

	public void setBaseAttributes(String dateString, long homeId, long awayId, long[] homeLineUp, long[] awayLineUp,
			long[] homeSub, long[] awaySub, String status, String minutes) {
		this.dateString = dateString;
		this.homeTeamId = homeId;
		this.awayTeamId = awayId;
		this.awayLineUp = awayLineUp;
		this.homeLineUp = homeLineUp;
		this.homeSub = homeSub;
		this.awaySub = awaySub;
		this.status = status;
		this.minutes = minutes;
	}

	public void setEvents(long[] eventCardIds, long[] eventGoalIds, long[] eventPlayerChangeIds) {
		this.eventCardIds = eventCardIds;
		this.eventGoalIds = eventGoalIds;
		this.eventPlayerChangeIds = eventPlayerChangeIds;
	}

	public static String[] getAvailableStatus() {
		String[] status = { "waiting", "playing", "pending", "ended" };
		return status;
	}

//	@Override
//	public String toString() {
//		String str = "";
//		str += "Home : " + homeTeamId + "\n";
//		for (int i = 0; i < homeLineUp.length; i++) {
//			str += i + ". " + homeLineUp[i] + "\n";
//		}
//
//		if (homeSub != null)
//			for (int i = 0; i < homeSub.length; i++) {
//				str += "Sub " + i + " : " + homeSub[i] + "\n";
//			}
//
//		if (awayLineUp != null)
//			for (int i = 0; i < awayLineUp.length; i++) {
//				str += i + ". " + awayLineUp[i] + "\n";
//			}
//
//		if (awaySub != null)
//			for (int i = 0; i < awaySub.length; i++) {
//				str += "Sub " + i + " : " + awaySub[i] + "\n";
//			}
//
//		if (eventCardIds != null)
//			for (int i = 0; i < eventCardIds.length; i++) {
//				str += "Card " + i + " : " + eventCardIds[i] + "\n";
//			}
//
//		if (eventGoalIds != null)
//			for (int i = 0; i < eventGoalIds.length; i++) {
//				str += "Goal " + i + " : " + eventGoalIds[i] + "\n";
//			}
//
//		if (eventPlayerChangeIds != null)
//			for (int i = 0; i < eventPlayerChangeIds.length; i++) {
//				str += "ChangePlayer " + i + " : " + eventPlayerChangeIds[i] + "\n";
//			}
//
//		return str;
//	}

	public boolean isEqual(Match comparingMatch) {
		if (comparingMatch.homeTeamName.equalsIgnoreCase(homeTeamName)
				&& comparingMatch.awayTeamName.equalsIgnoreCase(awayTeamName))
			return true;
		return false;
	}

}
