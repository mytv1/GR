package giddyhero.soccersystem.client.mobile.activities.league.table;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicView;
import giddyhero.soccersystem.client.mobile.activities.league.LeagueViewImpl.MModelNation;
import giddyhero.soccersystem.shared.model.News;
import giddyhero.soccersystem.shared.model.Standing;
import giddyhero.soccersystem.shared.model.Team;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.HasClickHandlers;

public interface LeagueTableView  extends BasicView {


	HasClickHandlers setStanding(Standing standing, Team team);

	void clearTableTempData();

	
	
}
