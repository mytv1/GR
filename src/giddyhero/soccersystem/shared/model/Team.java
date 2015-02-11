package giddyhero.soccersystem.shared.model;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Team  implements SerializableEntity{
	@Id public Long id;
	public String name;
	public String stadiumName;
	public int establishYear;
	public String nation;
	public long managerId;
	public long[] playerIds;
	public String logoUrl = "";
	
	private Team(){
		
	}
	
	public Team(String name, String logoUrl, String stadiumName, int establishYear, String nation, long managerId, long[] playersIds){
		this.name = name;
		this.logoUrl = logoUrl;
		this.stadiumName = stadiumName;
		this.establishYear = establishYear;
		this.nation = nation;
		this.managerId = managerId;
		this.playerIds = playersIds;
	}

	@Override
	public String toString() {
		return ""+id+" -- "+name+" --- "+stadiumName+" --- "+establishYear+" --- "+nation;
	}
	
	
}
