package giddyhero.soccersystem.shared.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Nation {
	@Id public long id;
	String name;
}
