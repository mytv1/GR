package giddyhero.soccersystem.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GeneralServiceAsync {
	void greetServer(String input, AsyncCallback<String> callback)
			throws IllegalArgumentException;

	void registerAllEntity(AsyncCallback<Void> asyncCallback);

	void getAllCountryNames(AsyncCallback<String[]> callback);

	void deleteEntity(int type, long entityId, AsyncCallback<Boolean> callback);

	void deleteEntities(int type, long[] entityId, AsyncCallback<Void> callback);

}
