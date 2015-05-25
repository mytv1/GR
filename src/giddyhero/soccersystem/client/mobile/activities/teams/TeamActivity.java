package giddyhero.soccersystem.client.mobile.activities.teams;

import giddyhero.soccersystem.client.MobileEntryPoint;
import giddyhero.soccersystem.client.mobile.activities.ClientFactory;
import giddyhero.soccersystem.client.mobile.activities.basic.BasicActivity;
import giddyhero.soccersystem.client.mobile.activities.player.PlayerPlace;
import giddyhero.soccersystem.shared.model.News;
import giddyhero.soccersystem.shared.model.Player;
import giddyhero.soccersystem.shared.model.Team;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.event.shared.EventBus;

public class TeamActivity extends BasicActivity{
	
	private TeamView view;
	List<Player> players;
	
	public TeamActivity(ClientFactory clientFactory, Place place) {
		super(clientFactory, place);
		view = clientFactory.getTeamView();
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		super.start(panel, eventBus);
		panel.setWidget(view);
		view.setHeaderTitle("Team");
		bind();
	}
	
	
	@Override
	public void bind() {
		Team team = ((TeamPlace)place).getTeam();
		if (team == null)
			{
				view.setTempData();
				return;
			}
		view.setAvatar(team.logoUrl);
		view.setName(team.name);
		view.setNation(team.nation);
		
		MobileEntryPoint.Service.player.getAllPlayerOfTeam(team.id, new AsyncCallback<List<Player>>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Get players of team fail :  "+caught.toString());
			}

			@Override
			public void onSuccess(List<Player> result) {
				players = result;
				for (final Player player : result) {
					HasClickHandlers lbName = view.addPlayer(player.name,player.avatarUrl,player.birth,player.jerseyNumber);
					lbName.addClickHandler(new ClickHandler() {
						
						@Override
						public void onClick(ClickEvent event) {
							PlayerPlace place = new PlayerPlace();
							place.setPlayer(player);
							MobileEntryPoint.clientFactory.getPlaceController().goTo(place);
						}
					});
				}
			}
		});
	}

}
