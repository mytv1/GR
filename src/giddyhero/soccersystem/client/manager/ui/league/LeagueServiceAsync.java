package giddyhero.soccersystem.client.manager.ui.league;

import giddyhero.soccersystem.shared.model.League;
import giddyhero.soccersystem.shared.model.News;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LeagueServiceAsync {

	void createNewLeague(League league, AsyncCallback<Void> callback);

	void getAllLeague(AsyncCallback<League[]> callback);

}
