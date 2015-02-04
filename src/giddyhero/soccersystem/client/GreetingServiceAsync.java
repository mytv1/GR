package giddyhero.soccersystem.client;

import giddyhero.soccersystem.shared.model.Position;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void greetServer(String input, AsyncCallback<String> callback)
			throws IllegalArgumentException;

	void createStandardPositions(AsyncCallback<Void> asyncCallback);

	void initDataStore(AsyncCallback<Void> asyncCallback);

	void getStandardSoccerPosition(AsyncCallback<Position[]> callback);

}
