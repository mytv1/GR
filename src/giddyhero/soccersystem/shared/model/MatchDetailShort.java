package giddyhero.soccersystem.shared.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class MatchDetailShort implements SerializableEntity {
	public @Id
	Long id;
	public long matchId;
	public long homeId, awayId;
	public String homeName = "", awayName = "";
	public String time = "";
	public String homeUrl = "";
	public String awayUrl = "";
	public String score = "";

	private MatchDetailShort() {
	}

	public MatchDetailShort(long matchId, long homeId, long awayId, String homeName, String awayName, String time,
			String homeUrl, String awayUrl, String score) {
		this.matchId = matchId;
		this.homeId = homeId;
		this.awayId = awayId;
		this.homeName = homeName;
		this.awayName = awayName;
		this.time = time;
		this.homeUrl = homeUrl;
		this.awayUrl = awayUrl;
		this.score = score;
	}
}
