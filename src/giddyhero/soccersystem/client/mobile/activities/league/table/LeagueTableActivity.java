package giddyhero.soccersystem.client.mobile.activities.league.table;

import giddyhero.soccersystem.client.MobileEntryPoint;
import giddyhero.soccersystem.client.mobile.activities.ClientFactory;
import giddyhero.soccersystem.client.mobile.activities.basic.BasicActivity;
import giddyhero.soccersystem.client.mobile.activities.teams.TeamPlace;
import giddyhero.soccersystem.shared.model.Season;
import giddyhero.soccersystem.shared.model.Standing;
import giddyhero.soccersystem.shared.model.Team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.event.shared.EventBus;

public class LeagueTableActivity extends BasicActivity{
	
	private LeagueTableView view;
	Season season;
	List<Standing> standings;
	List<Team> teams;
	
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
		LeagueTablePlace ltPlace = (LeagueTablePlace)place;
		view.setHeaderTitle(ltPlace.leagueName);
		MobileEntryPoint.Service.league.getRecentSeasonName(ltPlace.leagueName, new AsyncCallback<Season>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Get recent season fail : "+caught.toString());
			}

			@Override
			public void onSuccess(Season season) {
				LeagueTableActivity.this.season = season;
				MobileEntryPoint.Service.league.getStandingsById(season.id, new AsyncCallback<List<Standing>>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Get season standings fail : "+caught.toString());						
					}

					@Override
					public void onSuccess(List<Standing> result) {
						standings = result;
						List<Long> teamIds = new ArrayList<Long>();
						for (Standing standing : result) {
							teamIds.add(standing.teamId);
						}
						MobileEntryPoint.Service.team.getAllTeams(new AsyncCallback<List<Team>>() {

							@Override
							public void onFailure(Throwable caught) {
								Window.alert("Get teams fail : "+caught.toString());					
								
							}

							@Override
							public void onSuccess(List<Team> result) {
								teams = result;
								view.clearTableTempData();
								setData();
							}

						
						});
						;
					}
				});
			}
		});
	}
	
	private void setData() {
		Collections.sort(standings, new Comparator<Standing>() {

			@Override
			public int compare(Standing o1, Standing o2) {
				int point1 = o1.win*3 + o1.draw;
				int point2 = o2.win*3 + o2.draw;
				int diff = point2 - point1;
				if (diff != 0)
					return point2-point1;
				else
					return ((o2.goalFor-o2.goalAgaints) - (o1.goalFor-o1.goalAgaints)); 
			}
		});
		for (Standing standing : standings) {
			for (final Team team : teams) {
				if (standing.teamId == team.id){
					HasClickHandlers label = view.setStanding(standing, team);
					label.addClickHandler(new ClickHandler() {
						
						@Override
						public void onClick(ClickEvent event) {
							TeamPlace teamPlace = new TeamPlace();
							teamPlace.setTeam(team);
							MobileEntryPoint.getClientFactory().getPlaceController().goTo(teamPlace);
						}
					});
					break;
				}
			}
		}								
	}

	
	public static class MModelLeagueTblRow{
		String teanName = "";
		String logoUrl = "";
		int play, win, draw, lose, gd, points;
		
	}

}
