package giddyhero.soccersystem.client.mobile.activities.team;

import java.util.Iterator;

import com.google.appengine.api.datastore.Entity;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Image;
import com.google.web.bindery.event.shared.EventBus;

import giddyhero.soccersystem.client.MobileEntryPoint;
import giddyhero.soccersystem.client.WidgetUtils;
import giddyhero.soccersystem.client.mobile.activities.ClientFactory;
import giddyhero.soccersystem.client.mobile.activities.basic.BasicActivity;
import giddyhero.soccersystem.client.mobile.activities.player.PlayerPlace;
import giddyhero.soccersystem.shared.Position;
import giddyhero.soccersystem.shared.model.Player;
import giddyhero.soccersystem.shared.model.SerializableEntity;
import giddyhero.soccersystem.shared.model.Team;

public class TeamActivity extends BasicActivity{
	
	private TeamView view;

	public TeamActivity(ClientFactory clientFactory, Place place) {
		super(clientFactory, place);
		view = clientFactory.getTeamView();
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		super.start(panel, eventBus);
		view.getHeader().setText("Team");
		panel.setWidget(view);
		bind();
	}
	
	

	@Override
	public void bind() {
//		bindWithCorrectTeam();
		bindWithFirstTeamInDB();
		
	}
	
	private void bindWithFirstTeamInDB() {
		MobileEntryPoint.Service.team.getAllTeams(new AsyncCallback<Team[]>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Get all team fall : "+caught.toString());
			}

			@Override
			public void onSuccess(Team[] result) {
				Team team = result[0];
				view.getImgLogo().setUrl(team.logoUrl);
				view.getLbEstablishYear().setText("Establish : "+team.establishYear);
				view.getLbManager().setText("Manager : N/A");
				view.getLbName().setText("Name : "+team.name);
				view.getLbNation().setText("Nation : "+team.nation);
				view.getLbStadium().setText("Stadium : "+team.stadiumName);
				view.getLbNumOfPlayer().setText("Players : "+team.playerIds.length);
				fillPlayersTable(view.getTblPlayers(),team.playerIds);				
			}
		});		
	}

	private void bindWithCorrectTeam() {
		TeamPlace teamPlace = (TeamPlace)place;
		teamPlace.teamId = 5654313976201216L;
		long teamId = teamPlace.getTeamId();
		
		MobileEntryPoint.Service.team.getTeam(teamId, new AsyncCallback<Team>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Get team fall");
			}

			@Override
			public void onSuccess(Team team) {
				view.getImgLogo().setUrl(team.logoUrl);
				view.getLbEstablishYear().setText("Establish : "+team.establishYear);
				view.getLbManager().setText("Manager : N/A");
				view.getLbName().setText("Name : "+team.name);
				view.getLbNation().setText("Nation : "+team.nation);
				view.getLbStadium().setText("Stadium : "+team.stadiumName);
				view.getLbNumOfPlayer().setText("Players : "+team.playerIds.length);
				fillPlayersTable(view.getTblPlayers(),team.playerIds);
			}

		});		
	}

	private void fillPlayersTable(final FlexTable tblPlayers, long[] playerIds) {
		MobileEntryPoint.Service.player.getPlayers(playerIds, new AsyncCallback<Player[]>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("get player of team failure");
			}

			@Override
			public void onSuccess(Player[] result) {
				Window.alert("get player of team sucess");
				for (int i = 0; i < result.length; i++) {
					Player player = result[i];
					tblPlayers.setWidget(1 + i, 0, createLinkAvatar(player));
					tblPlayers.setText(1 + i, 1, player.name);
					tblPlayers.setText(1 + i, 2, WidgetUtils.dmyToString(player.day, player.month, player.year));
					tblPlayers.setText(1 + i, 3, player.nationality);
					tblPlayers.setText(1 + i, 4, Position.getPositionNameById(player.positionId));
					tblPlayers.setText(1 + i, 5, player.height+"");
				}
			}
		});
	}
	
	private Image createLinkAvatar(final Player player){
		Image imgAvatar = WidgetUtils.createImageIgnoseNull(player.avatarUrl, 40,40);
		imgAvatar.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				PlayerPlace playerPlace = new PlayerPlace();
				playerPlace.setPlayerId(player.id);
				clientFactory.getPlaceController()
						.goTo(playerPlace);
			}
		});
		return imgAvatar;
	}
	
	


}
