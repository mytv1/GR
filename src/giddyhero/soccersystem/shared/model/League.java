package giddyhero.soccersystem.shared.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class League implements SerializableEntity{
	public @Id Long id;
	public String info;
	public String name;
	public long[] seasonIds;
	
	private League() {
		// TODO Auto-generated constructor stub
	}
	
	public League(String name, String info) {
		this.name = name;
		this.info = info;
	}
	
	public void setSeasonIds(long[] seasonIds) {
		this.seasonIds = seasonIds;
	}
}
