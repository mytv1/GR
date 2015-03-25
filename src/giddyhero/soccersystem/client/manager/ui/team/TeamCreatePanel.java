package giddyhero.soccersystem.client.manager.ui.team;

import giddyhero.soccersystem.client.SoccerSystem;
import giddyhero.soccersystem.client.manager.ui.team.TeamCreatePanel.PlayerListGroup.PlayerSelectedGroup;
import giddyhero.soccersystem.shared.model.Player;
import giddyhero.soccersystem.shared.model.Team;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class TeamCreatePanel extends Composite {

	private static TeamCreatePanelUiBinder uiBinder = GWT
			.create(TeamCreatePanelUiBinder.class);

	interface TeamCreatePanelUiBinder extends UiBinder<Widget, TeamCreatePanel> {
	}
	
	@UiField
	Button btConfirm;
	@UiField
	ListBox lbYear;
	@UiField
	TextBox tbName, tbStadiumName, tbNation, tbLogoUrl;
	@UiField
	VerticalPanel mainPanel, pnAddPlayer;
	Player[] players;
	ArrayList<PlayerSelectedGroup> selectedPlayerGroups = new ArrayList<>();

	public TeamCreatePanel() {
		initWidget(uiBinder.createAndBindUi(this));
		initYearListBox();
		pnAddPlayer.add(new PlayerListGroup());
	}

	private void initYearListBox() {
		for(int i = 1850;i <= 2015;i ++){
			lbYear.addItem(""+i);
		}
	}

	@UiHandler("btConfirm")
	void onClick(ClickEvent e) {
		Player[] selectedPlayers = getAllSelectedPlayer();
		saveNewTeam(selectedPlayers);
	}
	
	private void updateCurrentTeamOfSelectedPlayers(Team team,Player[] selectedPlayers) {
		for (Player player : selectedPlayers) {
			player.currentTeamId = team.id;
		}
		SoccerSystem.Service.player.savePlayers(selectedPlayers, new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Save current team of player failure :"+caught.toString());
			}

			@Override
			public void onSuccess(Void result) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	private void saveNewTeam(final Player[] selectedPlayers) {
		String name = tbName.getText();
		String stadiumName = tbStadiumName.getText();
		String nation = tbNation.getText();
		String logoUrl = tbLogoUrl.getText();
		int establishYear = Integer.parseInt(lbYear.getItemText(lbYear.getSelectedIndex()));
		
		long[] playerIds = new long[selectedPlayers.length];
		for (int i = 0; i < playerIds.length; i++) {
			playerIds[i] = selectedPlayers[i].id;
		}
		long managerId = -1;
		Team team = new Team(name,logoUrl, stadiumName, establishYear,nation, managerId, playerIds);
		SoccerSystem.Service.team.addNewTeam(team, new AsyncCallback<Team>() {
			
			@Override
			public void onSuccess(Team team) {
				Window.alert("Success");		
				updateCurrentTeamOfSelectedPlayers(team,selectedPlayers);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Failure"+caught.toString());				
			}
		});		
		
	}

	public class PlayerListGroup extends FlowPanel{
		ListBox lbPlayers;
		Button btAdd;
		
		public PlayerListGroup() {
			super();
			getAllPlayer();
		}

		private void initAddButton() {
			btAdd = new Button("Add");
			btAdd.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					int index = lbPlayers.getSelectedIndex();
					long id = Long.parseLong(lbPlayers.getValue(index));
					Player player = getPlayerOfId(id);
					PlayerSelectedGroup playerSelectedGroup = new PlayerSelectedGroup(player);
					pnAddPlayer.add(playerSelectedGroup);
					selectedPlayerGroups.add(playerSelectedGroup);
					lbPlayers.removeItem(index);
				}
			});
			add(btAdd);
		}

		private void initListPlayers() {
			lbPlayers = new ListBox();
			for (Player player : players) {
				lbPlayers.addItem(player.name, player.id+"");
			}
			add(lbPlayers);
		}

		private void getAllPlayer() {
			SoccerSystem.Service.player.getAllPlayers(new AsyncCallback<Player[]>() {

				@Override
				public void onFailure(Throwable caught) {
					Window.alert("Get all player error"+caught.toString());
				}

				@Override
				public void onSuccess(Player[] result) {
					Window.alert("Get all player : "+result.length+" success ");
					players = result;
					initListPlayers();
					initAddButton();
				}
			});
		}
		
		class PlayerSelectedGroup extends FlowPanel{
			TextBox tbPlayer;
			Button btDelete;
			Player player;
			
			public PlayerSelectedGroup(Player player){
				super();
				this.player = player;
				add(createTextBox());
				add(createDeleteButton());
			}

			private Widget createDeleteButton() {
				btDelete = new Button("Delete");
				btDelete.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						selectedPlayerGroups.remove(PlayerSelectedGroup.this);
						removeFromParent();
						restoreToListBox();
					}

					private void restoreToListBox() {
						lbPlayers.addItem(player.name,""+player.id);
					}
				});
				return btDelete;
			}

			private Widget createTextBox() {
				tbPlayer = new TextBox();
				tbPlayer.setReadOnly(true);
				tbPlayer.setText(player.name);
				return tbPlayer;
			}
			
			public Player getPlayer() {
				return player;
			}

		}
	}
	
	private Player getPlayerOfId(long id){
		for (int i = 0; i < players.length; i++) {
			if (players[i].id == id)
				return players[i];
		}
		return null;
	}
	
	private Player[] getAllSelectedPlayer(){
		int size = selectedPlayerGroups.size();
		Player[] selectedPlayers = new Player[size];
		for (int i = 0; i < size; i++) {
			PlayerSelectedGroup playerSelectedGroup = selectedPlayerGroups.get(i);
			selectedPlayers[i] = playerSelectedGroup.getPlayer();
		}
		return selectedPlayers;
	}

}
