package giddyhero.soccersystem.shared.model;

import com.google.gwt.view.client.ProvidesKey;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Team implements SerializableEntity {
	public static final ProvidesKey<Team> KEY_PROVIDER = new ProvidesKey<Team>() {
		@Override
		public Object getKey(Team item) {
			return item == null ? null : item.id;
		}
	};

	@Id
	public Long id;
	public String name;
	public String stadiumName;
	public int establishYear;
	public String nation;
	public String logoUrl = "";
	public long[] playerIds;

	private Team() {

	}

	public Team(String name, String logoUrl, String stadiumName, int establishYear, String nation) {
		this.name = name;
		this.logoUrl = logoUrl;
		this.stadiumName = stadiumName;
		this.establishYear = establishYear;
		this.nation = nation;
	}

	@Override
	public String toString() {
		return "" + id + " -- " + name + " --- " + stadiumName + " --- " + establishYear + " --- " + nation;
	}

}
