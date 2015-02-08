package giddyhero.soccersystem.client;

import giddyhero.soccersystem.shared.Position;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void greetServer(String input, AsyncCallback<String> callback)
			throws IllegalArgumentException;

	void initDataStore(AsyncCallback<Void> asyncCallback);

	void getAllCountryNames(AsyncCallback<String[]> callback);

}
