package giddyhero.soccersystem.client;

import giddyhero.soccersystem.shared.model.SerializableEntity;

import com.google.appengine.api.datastore.Entity;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("general")
public interface GeneralService extends RemoteService{
	String greetServer(String name) throws IllegalArgumentException;
	
	void registerAllEntity();
	
	String[] getAllCountryNames();
	
	boolean deleteEntity(int type,long entityId);
}
