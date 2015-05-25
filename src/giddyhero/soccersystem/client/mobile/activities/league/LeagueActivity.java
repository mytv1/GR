package giddyhero.soccersystem.client.mobile.activities.league;

import giddyhero.soccersystem.client.MobileEntryPoint;
import giddyhero.soccersystem.client.mobile.activities.ClientFactory;
import giddyhero.soccersystem.client.mobile.activities.basic.BasicActivity;
import giddyhero.soccersystem.client.mobile.activities.league.LeagueViewImpl.MModelLeague;
import giddyhero.soccersystem.client.mobile.activities.league.LeagueViewImpl.MModelNation;
import giddyhero.soccersystem.client.mobile.activities.league.LeagueViewImpl.PanelNationLeague.PanelLeague;
import giddyhero.soccersystem.client.mobile.activities.league.table.LeagueTablePlace;
import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
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

public class LeagueActivity extends BasicActivity {

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
		MModelNation england = new MModelNation("England",
				ClientBundleMobile.INST.get().icNationEngland());
		MModelLeague premierLeague = new MModelLeague("Premier League",
				ClientBundleMobile.INST.get().icLeaguePremierLeague());
		england.leagues.add(premierLeague);
		nations.add(england);

		MModelNation nation = new MModelNation("Spain",
				ClientBundleMobile.INST.get().icNationSpain());
		nation.leagues.add(new MModelLeague("Primera Division", ClientBundleMobile.INST.get().icLeaguePrimeraDivision()));
		nations.add(nation);

		nation = new MModelNation("Italia",
				ClientBundleMobile.INST.get().icNationItalia());
		nation.leagues.add(new MModelLeague("Serie A",
				ClientBundleMobile.INST.get().icLeagueSeriaA()));
		nations.add(nation);
		
		nation = new MModelNation("France",
				ClientBundleMobile.INST.get().icNationFrance());
		nation.leagues.add(new MModelLeague("League 1",
				ClientBundleMobile.INST.get().icLeagueLeagueOne()));
		nations.add(nation);
		
		nation = new MModelNation("Germany",
				ClientBundleMobile.INST.get().icNationGermany());
		nation.leagues.add(new MModelLeague("Bundesliga",
				ClientBundleMobile.INST.get().icLeagueBundesliga()));
		nations.add(nation);


		List<PanelLeague> pnLeagues = view.setData(nations);
		for (final PanelLeague pnLeague : pnLeagues) {
			pnLeague.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					LeagueTablePlace place = new LeagueTablePlace();
					place.setLeagueName(pnLeague.lbLeague.getText());
					clientFactory.getPlaceController().goTo(place);
				}
			});
		}
	}
}
