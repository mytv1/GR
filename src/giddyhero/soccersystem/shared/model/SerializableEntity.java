package giddyhero.soccersystem.shared.model;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;

public interface SerializableEntity extends IsSerializable, Serializable{
	public static int PLAYER = 1;
	public static int NEWS = 2;
	public static int TEAM = 3;
	public static int NATION = 4;
	
}
