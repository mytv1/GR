package giddyhero.soccersystem.shared.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Season implements SerializableEntity{
	public @Id Long id;
	public int year;
//	public long[] matchIds;
	public long leagueId;
	
	public Season() {
		// TODO Auto-generated constructor stub
	}
	
	public Season(int year) {
		this.year = year;
	}
	
//	public void setMatchIds(long[] matchIds) {
//		this.matchIds = matchIds;
//	}
//	
	public void setLeagueId(long leagueId) {
		this.leagueId = leagueId;
	}
	
}
