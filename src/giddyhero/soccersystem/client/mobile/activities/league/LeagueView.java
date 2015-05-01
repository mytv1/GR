package giddyhero.soccersystem.client.mobile.activities.league;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicView;
import giddyhero.soccersystem.client.mobile.activities.league.LeagueViewImpl.MModelNation;
import giddyhero.soccersystem.shared.model.News;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.HasClickHandlers;

public interface LeagueView  extends BasicView {

	List<HasClickHandlers> setData(List<MModelNation> nations);

	
}
