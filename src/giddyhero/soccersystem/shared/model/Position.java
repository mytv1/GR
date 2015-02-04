package giddyhero.soccersystem.shared.model;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Position implements Serializable, IsSerializable{
	private static final long serialVersionUID = 1L;
	@Id long id;
	String name;
	
	private Position() {
		// TODO Auto-generated constructor stub
	}
	
	public Position(long id,String name) {
		this.id = id;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public long getId() {
		return id;
	}
	
//	public static Key<Position> key(long id) {
//		return Key.create(new com.google.appengine.api.datastore.KeyFactory.Builder(key));
//	}
	
}
