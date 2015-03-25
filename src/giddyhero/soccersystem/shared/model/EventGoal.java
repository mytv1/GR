package giddyhero.soccersystem.shared.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;


@Entity
public class EventGoal implements SerializableEntity{
	public @Id  Long id;
	public long playerId;
	public String time;
	
	private EventGoal(){
		
	}
	
	public EventGoal(long playerId, String time){
		this.playerId = playerId;
		this.time = time;
	}
	
	@Override
	public String toString() {
		return "Player Id : "+playerId+"\n Time : "+time;
	}
}