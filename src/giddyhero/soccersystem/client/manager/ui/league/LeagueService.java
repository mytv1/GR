package giddyhero.soccersystem.client.manager.ui.league;

import giddyhero.soccersystem.shared.model.League;
import giddyhero.soccersystem.shared.model.News;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("league")
public interface LeagueService extends RemoteService{
	void createNewLeague(League league);
	
	League[] getAllLeague();
}
