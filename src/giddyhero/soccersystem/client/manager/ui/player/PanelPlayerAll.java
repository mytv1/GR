package giddyhero.soccersystem.client.manager.ui.player;

import giddyhero.soccersystem.client.SoccerSystem;
import giddyhero.soccersystem.client.manager.ui.widget.TableInfoDisplay;
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
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;

public class PanelPlayerAll extends TableInfoDisplay {


	public PanelPlayerAll() {
		super();
		initTable();
	}

	private void initTable() {
		setText(0, 0, "ID");
		setText(0, 1, "Avatar");
		setText(0, 2, "Name");
		setText(0, 3, "Birth");
		setText(0, 4, "Team");
		setText(0, 5, "Nationality");
		setText(0, 6, "Position");
		setText(0, 7, "Height");
		setText(0, 8, "Action");

		// Example player
		setText(1, 0, "1");
		setText(1, 1, "Sample");
		setText(1, 2, "Christiano Ronaldo");
		setText(1, 3, "1-1-1986");
		setText(1, 4, "Real Madrid");
		setText(1, 5, "Portugal");
		setText(1, 6, "Center Middlefield");
		setText(1, 7, "188");
		setText(1, 8, "Sample");

		SoccerSystem.Service.player.getAllPlayers(new AsyncCallback<Player[]>() {

			@Override
			public void onSuccess(Player[] result) {
				Window.alert("Get all player success");
				Player[] players = result;
				for (int i = 0; i < players.length; i++) {
					Player player = players[i];
					setText(2 + i, 0, "" + player.id);
					setWidget(2 + i, 1, player.getAvatar());
					setText(2 + i, 2, "" + player.name);
					setText(2 + i, 3, "" + player.day + " - " + player.month + " - " + player.year);
					setText(2 + i, 4, "" + player.currentTeamId);
					setText(2 + i, 5, "" + player.nationality);
					setText(2 + i, 6, "" + Position.getPositionNameById(player.positionId));
					setText(2 + i, 7, "" + player.height);
					setWidget(2 + i, 8, new ActionPanel());
				}
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Get all player failure" + caught.toString());
			}
		});

	}

//	protected Widget createCustomActionPanel(final long entityId) {
//		EditDeletePanel editDeletePanel = new EditDeletePanel();
//		editDeletePanel.getBtDelete().addClickHandler(new ClickHandler() {
//
//			@Override
//			public void onClick(ClickEvent event) {
//				SoccerSystem.Service.general.deleteEntity(SerializableEntity.PLAYER, entityId,
//						new AsyncCallback<Boolean>() {
//
//							@Override
//							public void onFailure(Throwable caught) {
//								Window.alert("Delete player failure");
//							}
//
//							@Override
//							public void onSuccess(Boolean result) {
//								Window.alert("Delete player success");
//							}
//						});
//			}
//		});
//		return editDeletePanel;
//	}


}
