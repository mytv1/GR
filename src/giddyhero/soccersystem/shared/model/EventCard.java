package giddyhero.soccersystem.shared.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class EventCard implements SerializableEntity{
	private static final long serialVersionUID = 1L;
	public @Id Long id;
	public long playerId;
	public String cardType;
	public String time;
	
	private EventCard() {
		
	}
	
	public EventCard(long playerId, String cardType,String time){
		this.playerId = playerId;
		this.cardType = cardType;
		this.time = time;
	}

	@Override
	public String toString() {
		return "Player Id : "+playerId+"\n Card Type : "+cardType+"\n Time : "+time;
	}
	
}