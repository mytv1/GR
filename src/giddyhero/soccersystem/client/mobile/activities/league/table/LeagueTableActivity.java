package giddyhero.soccersystem.client.mobile.activities.league.table;

import giddyhero.soccersystem.client.MobileEntryPoint;
import giddyhero.soccersystem.client.manager.ui.widget.TableInfoDisplay;
import giddyhero.soccersystem.client.mobile.activities.ClientFactory;
import giddyhero.soccersystem.client.mobile.activities.basic.BasicActivity;
import giddyhero.soccersystem.client.mobile.activities.league.LeagueViewImpl.MModelLeague;
import giddyhero.soccersystem.client.mobile.activities.league.LeagueViewImpl.MModelNation;
import giddyhero.soccersystem.shared.model.News;
import giddyhero.soccersystem.shared.model.Team;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.event.shared.EventBus;

public class LeagueTableActivity extends BasicActivity{
	
	private LeagueTableView view;
	
	public LeagueTableActivity(ClientFactory clientFactory, Place place) {
		super(clientFactory, place);
		view = clientFactory.getLeagueTableView();
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		super.start(panel, eventBus);
		panel.setWidget(view);
		bind();
	}
	
	
	@Override
	public void bind() {
		test();
		view.setHeaderTitle("Premier League");
	}

	private void test() {
		
		
	}
	
	public static class MModelLeagueTblRow{
		String teanName = "";
		String logoUrl = "";
		int play, win, draw, lose, gd, points;
		
	}

}
