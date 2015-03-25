package giddyhero.soccersystem.client.manager.ui.match.event;

import giddyhero.soccersystem.shared.model.EventChangePlayer;
import giddyhero.soccersystem.shared.model.Player;
import giddyhero.soccersystem.shared.model.Team;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;

public class ChangePlayerWidget extends Composite {

	private static GoalWidgetUiBinder uiBinder = GWT.create(GoalWidgetUiBinder.class);

	interface GoalWidgetUiBinder extends UiBinder<Widget, ChangePlayerWidget> {
	}
	
	Player[] homePlayers, awayPlayers;
	Team homeTeam, awayTeam;
	@UiField
	FlexTable tblAdd, tblResult;
	ListBox lbxPlayerIn, lbxPlayerOut, lbxTime;
	Button btAdd;

	public ChangePlayerWidget() {
		initWidget(uiBinder.createAndBindUi(this));
		initTable();
	}
	
	private void initTable() {
		tblAdd.setText(0, 0, "In");
		tblAdd.setText(0, 1, "Out");
		tblAdd.setText(0, 2, "Time");
		tblAdd.setText(0, 3, "Add");
		
		initTimeListBox();
		initAddButton();
		initPlayerListBox();
		tblAdd.setWidget(1, 0, lbxPlayerIn);
		tblAdd.setWidget(1, 1, lbxPlayerOut);
		tblAdd.setWidget(1, 2, lbxTime);
		tblAdd.setWidget(1, 3, btAdd);
		
		tblResult.setText(0, 0, "Time");
		tblResult.setText(0, 1, "In");
		tblResult.setText(0, 2, "Out");
		tblResult.setText(0, 3, "Remove");

	}

	private void initPlayerListBox() {
		lbxPlayerIn = new ListBox();
		lbxPlayerOut = new ListBox();
	}

	private void initAddButton() {
		btAdd = new Button("+");
		btAdd.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				int row = tblResult.getRowCount();
				tblResult.setText(row, 0, lbxTime.getItemText(lbxTime.getSelectedIndex()));
				
				int inPlayerIndex = lbxPlayerIn.getSelectedIndex();
				final long inPlayerId = Long.parseLong(lbxPlayerIn.getValue(inPlayerIndex));
				String inPlayerName = lbxPlayerIn.getItemText(inPlayerIndex);
				tblResult.setText(row, 1, inPlayerName+"-"+inPlayerId);
				
				int outPlayerIndex = lbxPlayerIn.getSelectedIndex();
				final long outPlayerId = Long.parseLong(lbxPlayerIn.getValue(outPlayerIndex));
				String outPlayerName = lbxPlayerIn.getItemText(outPlayerIndex);
				tblResult.setText(row, 1, outPlayerName+"-"+outPlayerId);
				
				tblResult.setText(row, 2, outPlayerName+"-"+outPlayerId);
				
				Button btRemove = new Button("-");
				btRemove.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						removeRowByPlayerId(inPlayerId);
					}

				});
				tblResult.setWidget(row, 3, btRemove);
			}
		});
	}
	
	private void removeRowByPlayerId(long selectedPlayerId) {
		int row = tblResult.getRowCount();
		
		for (int i = 0; i < row; i++) {
			String text = tblResult.getText(i, 1);
			int i1 = text.indexOf('-');
			if (i1 != - 1){
				Long id = Long.parseLong(text.substring(i1+1, text.length()));
				if (id == selectedPlayerId)
				{
					tblResult.removeRow(i);
					break;
				}
			}
			

		}
	}

	private void initTimeListBox() {
		lbxTime = new ListBox();
		for (int i = 1; i <= 45; i++) {
			lbxTime.addItem(""+i);
		}
		lbxTime.addItem("45+1");
		lbxTime.addItem("45+2");
		lbxTime.addItem("45+3");
		lbxTime.addItem("45+4");
		lbxTime.addItem("45+5");
		
		for (int i = 46; i <= 90; i++) {
			lbxTime.addItem(""+i);
		}
		lbxTime.addItem("90+1");
		lbxTime.addItem("90+2");
		lbxTime.addItem("90+3");
		lbxTime.addItem("90+4");
		lbxTime.addItem("90+5");		
	}
	
	public void setHome(Team homeTeam,Player[] homePlayers) {
		this.homePlayers = homePlayers;
		this.homeTeam = homeTeam;
		setPlayers();
	}
	
	public void setAway(Team awayTeam, Player[] awayPlayers) {
		this.awayPlayers = awayPlayers;
		this.awayTeam = awayTeam;
		setPlayers();
	}

	public void setPlayers() {
		reset();
		if (awayPlayers != null) 
		for (int i = 0; i < awayPlayers.length; i++) {
			Player player = awayPlayers[i];
			lbxPlayerIn.addItem(player.name+" ("+awayTeam.name+")", player.id+"");
			lbxPlayerOut.addItem(player.name+" ("+awayTeam.name+")", player.id+"");
		}
		
		if (homePlayers != null)
		for (int i = 0; i < homePlayers.length; i++) {
			Player player = homePlayers[i];
			lbxPlayerIn.addItem(player.name+" ("+homeTeam.name+")", player.id+"");
			lbxPlayerOut.addItem(player.name+" ("+homeTeam.name+")", player.id+"");
		}
	}

	private void reset() {
		lbxPlayerIn.clear();		
		lbxPlayerOut.clear();
	}
	
	public EventChangePlayer[] getEventChangePlayers(){
		EventChangePlayer[] cards = new EventChangePlayer[tblResult.getRowCount()-1];
		for (int i = 1; i < tblResult.getRowCount(); i++) {
			String time = tblResult.getText(i, 0);
			String inPlayerText = tblResult.getText(i, 1);
			Long inPlayerId = Long.parseLong(inPlayerText.substring(inPlayerText.indexOf('-')+1, inPlayerText.length()));
			
			String outPlayerText = tblResult.getText(i, 1);
			Long outPlayerId = Long.parseLong(outPlayerText.substring(outPlayerText.indexOf('-')+1, outPlayerText.length()));
			
			EventChangePlayer eventChangePlayer = new EventChangePlayer(inPlayerId, outPlayerId, time);
			cards[i-1] = eventChangePlayer;
		}
		return cards;
	}
}
