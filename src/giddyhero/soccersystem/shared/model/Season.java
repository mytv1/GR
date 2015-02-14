package giddyhero.soccersystem.shared.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Season implements SerializableEntity{
	public @Id long id;
	
	public Season() {
		// TODO Auto-generated constructor stub
	}
}
