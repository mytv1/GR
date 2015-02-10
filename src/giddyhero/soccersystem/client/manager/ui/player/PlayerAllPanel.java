package giddyhero.soccersystem.client.manager.ui.player;

import giddyhero.soccersystem.client.SoccerSystem;
import giddyhero.soccersystem.client.SoccerSystem.Service;
import giddyhero.soccersystem.client.manager.ui.general.EditDeletePanel;
import giddyhero.soccersystem.shared.Position;
import giddyhero.soccersystem.shared.model.Player;
import giddyhero.soccersystem.shared.model.SerializableEntity;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

public class PlayerAllPanel extends Composite {

	private static PlayerAllPanelUiBinder uiBinder = GWT
			.create(PlayerAllPanelUiBinder.class);

	interface PlayerAllPanelUiBinder extends UiBinder<Widget, PlayerAllPanel> {
	}

	@UiField
	FlexTable tblPlayers;

	public PlayerAllPanel() {
		initWidget(uiBinder.createAndBindUi(this));
		initTable();
	}

	private void initTable() {
		tblPlayers.setText(0, 0, "ID");
		tblPlayers.setText(0, 1, "Avatar");
		tblPlayers.setText(0, 2, "Name");
		tblPlayers.setText(0, 3, "Birth");
		tblPlayers.setText(0, 4, "Team");
		tblPlayers.setText(0, 5, "Nationality");
		tblPlayers.setText(0, 6, "Position");
		tblPlayers.setText(0, 7, "Height");
		tblPlayers.setText(0, 8, "Action");

		// Example player
		tblPlayers.setText(1, 0, "1");
		tblPlayers.setText(1, 1, "Sample");
		tblPlayers.setText(1, 2, "Christiano Ronaldo");
		tblPlayers.setText(1, 3, "1-1-1986");
		tblPlayers.setText(1, 4, "Real Madrid");
		tblPlayers.setText(1, 5, "Portugal");
		tblPlayers.setText(1, 6, "Center Middlefield");
		tblPlayers.setText(1, 7, "188");
		tblPlayers.setText(1, 8, "Sample");

		SoccerSystem.Service.player.getAllPlayers(new AsyncCallback<Player[]>() {

			@Override
			public void onSuccess(Player[] result) {
				Window.alert("Get all player success");
				Player[] players = result;
				for (int i = 0; i < players.length; i++) {
					Player player = players[i];
					tblPlayers.setText(2 + i, 0, "" + player.id);
					tblPlayers.setWidget(2 + i, 1, player.getAvatar());
					tblPlayers.setText(2 + i, 2, "" + player.name);
					tblPlayers.setText(2 + i, 3, "" + player.day + " - "
							+ player.month + " - " + player.year);
					tblPlayers.setText(2 + i, 4, "");
					tblPlayers.setText(2 + i, 5, "" + player.nationality);
					tblPlayers.setText(
							2 + i,
							6,
							""
									+ Position
											.getPositionNameById(player.positionId));
					tblPlayers.setText(2 + i, 7, "" + player.height);
					tblPlayers.setWidget(2 + i, 8, createCustomActionPanel(player.id));
				}
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Get all player failure" + caught.toString());
			}
		});

	}

	protected Widget createCustomActionPanel(final long entityId) {
		EditDeletePanel editDeletePanel = new EditDeletePanel();
		editDeletePanel.getBtDelete().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				SoccerSystem.Service.general.deleteEntity(
						SerializableEntity.PLAYER, entityId,
						new AsyncCallback<Boolean>() {

							@Override
							public void onFailure(Throwable caught) {
								Window.alert("Delete player failure");
							}

							@Override
							public void onSuccess(Boolean result) {
								Window.alert("Delete player success");
							}
						});
			}
		});
		return editDeletePanel;
	}

	public PlayerAllPanel(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
