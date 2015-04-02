package giddyhero.soccersystem.client.manager.ui.match;

import giddyhero.soccersystem.client.SystemManager;
import giddyhero.soccersystem.shared.model.Player;
import giddyhero.soccersystem.shared.model.Team;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class PanelMatchUpdateTeam extends VerticalPanel{
	
	Label lbTeam = new Label("Team Name"), lbLineUp = new Label("LineUp"), lbSub = new Label("Substitution"), lbTeamName = new Label();
	ArrayList<ListBox> alLineUp = new ArrayList<ListBox>(), alSubstitude = new ArrayList<ListBox>();
	VerticalPanel vpLineUp = new VerticalPanel(), vpSubstitution = new VerticalPanel();
	Team team;
	Player[] players;

	public PanelMatchUpdateTeam() {
		super();
		init();
		style();
	}
	
	private void style() {
		Style style = lbLineUp.getElement().getStyle();
		style.setMarginTop(20, Unit.PX);
		
		style = lbSub.getElement().getStyle();
		style.setMarginTop(20, Unit.PX);
	}

	private void init() {
		initDefaultPlayers();
		add(lbTeam);
		add(lbTeamName);
		add(lbLineUp);
		add(vpLineUp);
		add(lbSub);
		add(vpSubstitution);
	}
	
	public void setTeam(Team team) {
		this.team = team;
		lbTeamName.setText(team.name);
	}

	public void setPlayers(Player[] players) {
		this.players = players;
		initPlayerListBox();
		
	}

	
	public void setHomeTeam(boolean isHomeTeam) {
		if (isHomeTeam)
			lbTeam.setText("Home team");
		else
			lbTeam.setText("Away team");
	}

	private void initPlayerListBox() {
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
