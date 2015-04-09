package giddyhero.soccersystem.shared.model;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Season implements SerializableEntity{
	public @Id Long id;
	public int year;
	public List<Long> matchIds = new ArrayList<Long>();
	public long leagueId;
	public List<Long> scoreIds = new ArrayList<Long>(40);
	
	public Season() {
		// TODO Auto-generated constructor stub
	}
	
	public Season(int year) {
		this.year = year;
	}
	
	public void setMatchIds(List<Long> matchIds) {
		this.matchIds = matchIds;
	}
	
	public void setLeagueId(long leagueId) {
		this.leagueId = leagueId;
	}
	
	
}
