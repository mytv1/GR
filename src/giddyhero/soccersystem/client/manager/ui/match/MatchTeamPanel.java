package giddyhero.soccersystem.client.manager.ui.match;

import giddyhero.soccersystem.client.SystemManager;
import giddyhero.soccersystem.shared.model.Player;
import giddyhero.soccersystem.shared.model.Team;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class MatchTeamPanel extends Composite{

	private static MatchTeamPanelUiBinder uiBinder = GWT.create(MatchTeamPanelUiBinder.class);

	interface MatchTeamPanelUiBinder extends UiBinder<Widget, MatchTeamPanel> {
	}
	
	public interface TeamChoose {
		void onTeamChange(Team team, Player[] players);
	}
	
	@UiField
	ListBox lbxTeamChoose;
	@UiField
	Label lbTeam;
	ArrayList<ListBox> alLineUp = new ArrayList<ListBox>(), alSubstitude = new ArrayList<ListBox>();
	@UiField
	VerticalPanel vpLineUp, vpSubstitution;
//	boolean isHomeTeam = false;
	TeamChoose teamChoose;
	List<Team> teams;

	public MatchTeamPanel() {
		initWidget(uiBinder.createAndBindUi(this));
		
		initTeamChoose();
	}
	
	public void setTeamChoose(TeamChoose teamChoose) {
		this.teamChoose = teamChoose;
	}
	
	public void setHomeTeam(boolean isHomeTeam) {
//		this.isHomeTeam = isHomeTeam;
		if (isHomeTeam)
			lbTeam.setText("Home team");
		else
			lbTeam.setText("Away team");
	}

	private void initPlayerListBox(Player[] players) {
		alLineUp.clear();
		vpLineUp.clear();
		alSubstitude.clear();
		vpSubstitution.clear();
		for (int i = 0; i < 11; i++) {
			ListBox lbx = new ListBox();
			for (int j = 0; j < players.length; j++) {
				Player player = players[j];
				lbx.addItem(player.name, player.id+"");
			}
			alLineUp.add(lbx);
			vpLineUp.add(lbx);
		}
		
		for (int i = 0; i < 3; i++) {
			ListBox lbx = new ListBox();
			for (int j = 0; j < players.length; j++) {
				Player player = players[j];
				lbx.addItem(player.name, player.id+"");
			}
			alSubstitude.add(lbx);
			vpSubstitution.add(lbx);
		}
	}

	private void initLineUpAndSubstitude() {
		long teamId = Long.parseLong(lbxTeamChoose.getValue(lbxTeamChoose.getSelectedIndex()));
//		Window.alert("team Id : "+teamId);
		SystemManager.Service.player.getAllPlayerOfTeam(teamId, new AsyncCallback<List<Player>>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("failure : "+caught.toString());				
			}

			@Override
			public void onSuccess(List<Player> result) {
//				Window.alert(result.length+"---");
				Player[] players = new Player[result.size()];
				initPlayerListBox(result.toArray(players));
				teamChoose.onTeamChange(teams.get(lbxTeamChoose.getSelectedIndex()), players);
			}
		});
		
	}
	
	

	private void initTeamChoose() {
		lbxTeamChoose.addChangeHandler(new ChangeHandler() {
			
			@Override
			public void onChange(ChangeEvent event) {
				initLineUpAndSubstitude();
			}
		});
		
		SystemManager.Service.team.getAllTeams(new AsyncCallback<List<Team>>() {
			
			@Override
			public void onSuccess(List<Team> result) {
				teams = result;
				for (Team team : result) {
					lbxTeamChoose.addItem(team.name,""+ team.id);	
				}
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				
			}
		});
		
		initDefaultPlayers();
	}

	private void initDefaultPlayers() {
		for (int i = 0; i < 11; i++) {
			ListBox lbx = new ListBox();
				lbx.addItem("Pick Team First");
			vpLineUp.add(lbx);
		}
		
		for (int i = 0; i < 3; i++) {
			ListBox lbx = new ListBox();
			lbx.addItem("Pick Team First");
			vpSubstitution.add(lbx);
		}		
	}

	public long[] getLineUpPlayerIds() {
		return getPlayerIds(alLineUp);
	}

	public long[] getSubstitudePlayerIds() {
		return getPlayerIds(alSubstitude);
	}
	
	private long[] getPlayerIds(ArrayList<ListBox> al){
		long[] playerIds = new long[al.size()];
		for (int i = 0; i < playerIds.length; i++) {
			ListBox lbx = al.get(i);
			int selectedIndex = lbx.getSelectedIndex();
			long value = Long.parseLong(lbx.getValue(selectedIndex));
			playerIds[i] = value;
		}
		return playerIds;
	}
	
	
	
	
	
}
