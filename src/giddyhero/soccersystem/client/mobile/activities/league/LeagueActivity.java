package giddyhero.soccersystem.client.mobile.activities.league;

import giddyhero.soccersystem.client.MobileEntryPoint;
import giddyhero.soccersystem.client.mobile.activities.ClientFactory;
import giddyhero.soccersystem.client.mobile.activities.basic.BasicActivity;
import giddyhero.soccersystem.client.mobile.activities.league.LeagueViewImpl.MModelLeague;
import giddyhero.soccersystem.client.mobile.activities.league.LeagueViewImpl.MModelNation;
import giddyhero.soccersystem.client.mobile.activities.league.table.LeagueTablePlace;
import giddyhero.soccersystem.shared.model.News;
import giddyhero.soccersystem.shared.model.Team;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.event.shared.EventBus;

public class LeagueActivity extends BasicActivity{
	
	private LeagueView view;
	
	public LeagueActivity(ClientFactory clientFactory, Place place) {
		super(clientFactory, place);
		view = clientFactory.getLeagueView();
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
	}

	private void test() {
		ArrayList<MModelNation> nations = new ArrayList<>();
		MModelNation nation = new MModelNation("England",
				"http://upload.wikimedia.org/wikipedia/en/thumb/b/be/Flag_of_England.svg/1280px-Flag_of_England.svg.png");
		nation.leagues.add(new MModelLeague("Premier League",
				"https://pbs.twimg.com/profile_images/1466012174/PL-Twitter-Icon_400x400.jpg"));
		nation.leagues.add(new MModelLeague("Championship",
				"http://du8znpjowa92.cloudfront.net/wp-content/uploads/2015/04/championship-logo4.jpg"));
		nations.add(nation);

		nation = new MModelNation(
				"Spain",
				"http://upload.wikimedia.org/wikipedia/commons/thumb/e/ed/Flag_of_Spain_(Civil)_alternate_colours.svg/2000px-Flag_of_Spain_(Civil)_alternate_colours.svg.png");
		nation.leagues.add(new MModelLeague("Laliga", "http://theaosn.com/wp-content/uploads/la-liga2-1406205593.jpg"));
		nations.add(nation);

		nation = new MModelNation("Italia",
				"http://www.theflagshop.co.uk/ekmps/shops/speed/images/italian-italy-flag-130-p.jpg");
		nation.leagues.add(new MModelLeague("Serie A",
				"http://worldsoccertalk.com/wp-content/uploads/2013/10/serie-a-logo.jpg"));
		nations.add(nation);

		nation = new MModelNation("UEFA Champion League",
				"http://upload.wikimedia.org/wikipedia/vi/e/e2/UEFA_Champions_League_logo.png");
		nations.add(nation);

		nation = new MModelNation("Vietnam", "http://www.skydoor.net/Download?mode=photo&id=6516");
		nations.add(nation);
		nations.add(nation);
		nations.add(nation);
		nations.add(nation);
		nations.add(nation);
		nations.add(nation);
		nations.add(nation);
		nations.add(nation);
		nations.add(nation);
		nations.add(nation);
		nations.add(nation);
		nations.add(nation);
		
		List<HasClickHandlers> pnLeagues = view.setData(nations);
		for (HasClickHandlers hasClickHandlers : pnLeagues) {
			hasClickHandlers.		addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					clientFactory.getPlaceController().goTo(new LeagueTablePlace());
				}
			});
		}
	}
}
