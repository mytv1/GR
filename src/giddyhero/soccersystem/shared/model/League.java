package giddyhero.soccersystem.shared.model;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class League implements SerializableEntity {
	public @Id Long id;
	public String info = "";
	public String name = "";
	public List<Long> seasonIds = new ArrayList<>();
	public boolean isTable;

	private League() {
		// TODO Auto-generated constructor stub
	}

	public League(String name, String info) {
		this.name = name;
		this.info = info;
	}

	public void setSeasonIds(List<Long> seasonIds ) {
		this.seasonIds = seasonIds;
	}

	public void addSeason(long seasonId) {
		seasonIds.add(seasonId);
//		if (seasonIds == null) {
//			seasonIds = new long[1];
//			seasonIds[0] = seasonId;
//		}else{
//			long[] clone = new long[seasonIds.length+1];
//			for (int i = 0; i < seasonIds.length; i++) {
//				clone[i] = seasonIds[i];
//			}
//			clone[seasonIds.length] = seasonId;
//			seasonIds = clone;
//		}
	}
}
