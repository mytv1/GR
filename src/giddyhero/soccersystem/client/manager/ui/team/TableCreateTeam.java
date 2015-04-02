package giddyhero.soccersystem.client.manager.ui.team;

import java.util.ArrayList;
import java.util.Map.Entry;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import giddyhero.soccersystem.client.SystemManager;
import giddyhero.soccersystem.client.manager.ui.team.TableCreateTeam.PlayerListGroup.PlayerSelectedGroup;
import giddyhero.soccersystem.client.manager.ui.widget.TableFormInput;
import giddyhero.soccersystem.shared.Position;
import giddyhero.soccersystem.shared.model.News;
import giddyhero.soccersystem.shared.model.Player;
import giddyhero.soccersystem.shared.model.Team;

public class TableCreateTeam extends TableFormInput {

	TextBoxStandard tbName = new TextBoxStandard("500px"), tbStadiumName = new TextBoxStandard("500px"),
			tbNation = new TextBoxStandard("500px"), tbLogoUrl = new TextBoxStandard("500px");

	TextAreaStandard taContent = new TextAreaStandard("800px", "200px");
	ListBox lbYear = new ListBox();
	VerticalPanel vpPlayers = new VerticalPanel();
	Player[] players;
	ArrayList<PlayerSelectedGroup> selectedPlayerGroups = new ArrayList<>();

	public TableCreateTeam() {
		super();
		init();
	}

	private void init() {
		initLabelColumn();
		initFormColumn();
	}

	private void initFormColumn() {
		setWidget(0, 1, tbName);
		setWidget(1, 1, tbLogoUrl);
		setWidget(2, 1, lbYear);
		setWidget(3, 1, tbStadiumName);
		setWidget(4, 1, tbNation);
		setWidget(5, 1, vpPlayers);

		initYearListBox();
		vpPlayers.add(new PlayerListGroup());
	}
	

	private void initLabelColumn() {
		setWidget(0, 0, new LabelStandard("Name"));
		setWidget(1, 0, new LabelStandard("Logo Url"));
		setWidget(2, 0, new LabelStandard("Establish Year"));
		setWidget(3, 0, new LabelStandard("Stadium Name"));
		setWidget(4, 0, new LabelStandard("Nation"));
	}
	
	private void initYearListBox() {
		for(int i = 1850;i <= 2015;i ++){
			lbYear.addItem(""+i);
		}
	}	
	
	private Player getPlayerOfId(long id){
		for (int i = 0; i < players.length; i++) {
			if (players[i].id == id)
				return players[i];
		}
		return null;
	}
	
	public Player[] getAllSelectedPlayer(){
		int size = selectedPlayerGroups.size();
		Player[] selectedPlayers = new Player[size];
		for (int i = 0; i < size; i++) {
			PlayerSelectedGroup playerSelectedGroup = selectedPlayerGroups.get(i);
			selectedPlayers[i] = playerSelectedGroup.getPlayer();
		}
		return selectedPlayers;
	}
	
	public Team getTeam() {
		Player[] selectedPlayers = getAllSelectedPlayer();
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
		Team team = new Team(name,logoUrl, stadiumName, establishYear,nation);
		return team;
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
					vpPlayers.add(playerSelectedGroup);
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
			SystemManager.Service.player.getAllPlayers(new AsyncCallback<Player[]>() {

				@Override
				public void onFailure(Throwable caught) {
					Window.alert("Get all player error"+caught.toString());
				}

				@Override
				public void onSuccess(Player[] result) {
//					Window.alert("Get all player : "+result.length+" success ");
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


}
