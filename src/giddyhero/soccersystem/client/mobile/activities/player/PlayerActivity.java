package giddyhero.soccersystem.client.mobile.activities.player;

import giddyhero.soccersystem.client.MobileEntryPoint;
import giddyhero.soccersystem.client.mobile.activities.ClientFactory;
import giddyhero.soccersystem.client.mobile.activities.basic.BasicActivity;
import giddyhero.soccersystem.shared.Position;
import giddyhero.soccersystem.shared.model.Player;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.event.shared.EventBus;

public class PlayerActivity extends BasicActivity{
	
	private PlayerView view;
	private PlayerPlace playerPlace;

	public PlayerActivity(ClientFactory clientFactory, Place place) {
		super(clientFactory, place);
		view = clientFactory.getPlayerView();
		this.playerPlace = (PlayerPlace) place;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		super.start(panel, eventBus);
		view.getHeader().setText("Player");
		panel.setWidget(view);
		bind();
	}

	@Override
	public void bind() {
		long playerId = playerPlace.playerId;
		
//		if (playerId != -1)
//			bindPlayerById(playerId);
//		else
			bindFirstPlayerInDb();
		
	}

	private void bindFirstPlayerInDb() {
		MobileEntryPoint.Service.player.getAllPlayers(new AsyncCallback<Player[]>() {


			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Get player failure");				
			}
			@Override
			public void onSuccess(Player[] players) {
				Player player = players[0];
				view.getLbName().setText("Name : "+player.name);
				view.getImgAvatar().setUrl(player.avatarUrl);
				view.getLbBirth().setText("Birth : "+player.birth);
				view.getLbCurrentTeam().setText("Current Team : N/A");
				view.getLbNationality().setText("Nationality : "+player.nationality);
				view.getLbPosition().setText("Position : "+Position.getPositionNameById(player.positionId));
				view.getLbHeight().setText("Height : "+player.height);
			}
		});		
	}

	private void bindPlayerById(long playerId) {
		MobileEntryPoint.Service.player.getPlayer(playerId, new AsyncCallback<Player>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Get player failure");						
			}

			@Override
			public void onSuccess(Player player) {
				view.getLbName().setText("Name : "+player.name);
				view.getImgAvatar().setUrl(player.avatarUrl);
				view.getLbBirth().setText("Birth : "+player.birth);
				view.getLbCurrentTeam().setText("Current Team : N/A");
				view.getLbNationality().setText("Nationality : "+player.nationality);
				view.getLbPosition().setText("Position : "+Position.getPositionNameById(player.positionId));
				view.getLbHeight().setText("Height : "+player.height);				
			}
		});
	}
	
	
	


}
