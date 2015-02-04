
package giddyhero.soccersystem.shared.model;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;


@Entity
public class Player  implements Serializable, IsSerializable{
	private static final long serialVersionUID = 1L;
	public @Id Long id;
	public String name;
	public String birth;
	public int height, weight;
	public Long positionId;
//	public Ref<Position> position;
	
    public Player() {}
    
    public Player(String name, String birth, int height, int weight, Position position) {
//    	this.id = (long) 145;
    	this.name = name;
    	this.birth = birth;
    	this.height = height;
    	this.weight = weight;
//    	this.position = Ref.create(Key.create(position));
    	
    }
}
