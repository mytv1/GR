package giddyhero.soccersystem.shared.model;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Team  implements Serializable, IsSerializable {
	@Id public Long id;
	public String name;
	public String stadiumName;
	public int establishYear;
	public String nation;
	
	private Team(){
		
	}
	
	public Team(String name, String stadiumName, int establishYear, String nation){
		this.name = name;
		this.stadiumName = stadiumName;
		this.establishYear = establishYear;
		this.nation = nation;
	}

	@Override
	public String toString() {
		return ""+id+" -- "+name+" --- "+stadiumName+" --- "+establishYear+" --- "+nation;
	}
	
	
}
