package giddyhero.soccersystem.client;

import giddyhero.soccersystem.shared.model.SerializableEntity;

import com.google.appengine.api.datastore.Entity;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GeneralServiceAsync {
	void greetServer(String input, AsyncCallback<String> callback)
			throws IllegalArgumentException;

	void registerAllEntity(AsyncCallback<Void> asyncCallback);

	void getAllCountryNames(AsyncCallback<String[]> callback);

	void deleteEntity(int type, long entityId, AsyncCallback<Boolean> callback);

}
