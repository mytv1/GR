package giddyhero.soccersystem.shared.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class EventChangePlayer implements SerializableEntity{
	public @Id  Long id;
	public long inPlayer;
	public long outPlayer;
	String time;
	
	private EventChangePlayer(){
		
	}
	
	public EventChangePlayer(long inPlayer,long outPlayer, String time){
		this.inPlayer = inPlayer;
		this.outPlayer = outPlayer;
		this.time = time;
	}
	
	@Override
	public String toString() {
		return "In player : "+inPlayer+"\n Out player : "+outPlayer+"\n Time :"+time;
	}
}
