package giddyhero.soccersystem.client.manager.ui.player;

import giddyhero.soccersystem.client.SoccerSystem;
import giddyhero.soccersystem.shared.model.Player;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;

public class PlayerAllPanel extends Composite  {

	private static PlayerAllPanelUiBinder uiBinder = GWT
			.create(PlayerAllPanelUiBinder.class);

	interface PlayerAllPanelUiBinder extends
			UiBinder<Widget, PlayerAllPanel> {
	}
	
	@UiField
	FlexTable tblPlayers;

	public PlayerAllPanel() {
		initWidget(uiBinder.createAndBindUi(this));
		initTable();
	}


	private void initTable() {
		tblPlayers.setText(0, 0, "ID");
		tblPlayers.setText(0, 1, "Name");
		tblPlayers.setText(0, 2, "Birth");
		tblPlayers.setText(0, 3, "Team");
		tblPlayers.setText(0, 4, "Nationality");
		tblPlayers.setText(0, 5, "Position");
		tblPlayers.setText(0, 6, "Height");
		tblPlayers.setText(0, 7, "Weight");
		
		// Example player
		tblPlayers.setText(1, 0, "1");
		tblPlayers.setText(1, 1, "Christiano Ronaldo");
		tblPlayers.setText(1, 2, "1-1-1986");
		tblPlayers.setText(1, 3, "Real Madrid");
		tblPlayers.setText(1, 4, "Portugal");
		tblPlayers.setText(1, 5, "Center Middlefield");
		tblPlayers.setText(1, 6, "188");
		tblPlayers.setText(1, 7, "66");
		
		SoccerSystem.playerService.getAllPlayers(new AsyncCallback<Player[]>() {
			
			@Override
			public void onSuccess(Player[] result) {
				Window.alert("Get all player success");
				Player[] players = result;			
				for(int i = 0;i < players.length;i++){
					Player player = players[i];
					tblPlayers.setText(2+i, 0, ""+player.id);
					tblPlayers.setText(2+i, 1, ""+player.name);
					tblPlayers.setText(2+i, 2, ""+player.birth);
					tblPlayers.setText(2+i, 3, "");
					tblPlayers.setText(2+i, 4, "");
					tblPlayers.setText(2+i, 5, "");
					tblPlayers.setText(2+i, 6, ""+player.height);
					tblPlayers.setText(2+i, 7, ""+player.weight);
					
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Get all player failure"+caught.toString());
			}
		});
				
	}


	public PlayerAllPanel(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}



}
