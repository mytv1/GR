package giddyhero.soccersystem.client.manager.ui.match.event;

import giddyhero.soccersystem.shared.Card;
import giddyhero.soccersystem.shared.model.EventCard;
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

public class CardWidget extends Composite {

	private static CardWidgetUiBinder uiBinder = GWT.create(CardWidgetUiBinder.class);

	interface CardWidgetUiBinder extends UiBinder<Widget, CardWidget> {
	}
	
	Player[] homePlayers, awayPlayers;
	Team homeTeam, awayTeam;
	@UiField
	FlexTable tblAdd, tblResult;
	ListBox lbxPlayer, lbxTime, lbxCardType;
	Button btAdd;

	public CardWidget() {
		initWidget(uiBinder.createAndBindUi(this));
		initTable();
	}
	
	private void initTable() {
		tblAdd.setText(0, 0, "Player");
		tblAdd.setText(0, 1, "Time");
		tblAdd.setText(0, 2, "Card Type");
		tblAdd.setText(0, 3, "Add");
		
		initTimeListBox();
		initCardTypeListBox();
		initAddButton();
		initPlayerListBox();
		tblAdd.setWidget(1, 0, lbxPlayer);
		tblAdd.setWidget(1, 1, lbxTime);
		tblAdd.setWidget(1, 2, lbxCardType);
		tblAdd.setWidget(1, 3, btAdd);
		
		tblResult.setText(0, 0, "Time");
		tblResult.setText(0, 1, "Player Name");
		tblResult.setText(0, 2, "Player Id");
		tblResult.setText(0, 3, "Card Type");
		tblResult.setText(0, 4, "Remove");

	}

	private void initCardTypeListBox() {
		lbxCardType = new ListBox();
		lbxCardType.addItem("Yellow", "1");
		lbxCardType.addItem("Red", "2");
	}

	private void initPlayerListBox() {
		lbxPlayer = new ListBox();
	}

	private void initAddButton() {
		btAdd = new Button("+");
		btAdd.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				int row = tblResult.getRowCount();
				tblResult.setText(row, 0, lbxTime.getItemText(lbxTime.getSelectedIndex()));
				int selectedPlayerIndex = lbxPlayer.getSelectedIndex();
				int selectedCardTypeIndex = lbxCardType.getSelectedIndex();
				final long selectedPlayerId = Long.parseLong(lbxPlayer.getValue(selectedPlayerIndex));
				tblResult.setText(row, 1, lbxPlayer.getItemText(selectedPlayerIndex));
				tblResult.setText(row, 2, lbxPlayer.getValue(selectedPlayerIndex));
				tblResult.setText(row, 3, Card.convertIntegerToCardType(Integer.parseInt(lbxCardType.getValue(selectedCardTypeIndex))));
				
				Button btRemove = new Button("-");
				btRemove.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						removeRowByPlayerId(selectedPlayerId);
					}

				});
				tblResult.setWidget(row, 4, btRemove);
			}
		});
	}
	
	private void removeRowByPlayerId(long selectedPlayerId) {
		int row = tblResult.getRowCount();
		for (int i = 0; i < row; i++) {
			if (tblResult.getText(i, 2).equalsIgnoreCase(""+selectedPlayerId))
				{
					tblResult.removeRow(i);
					break;
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
			lbxPlayer.addItem(player.name+" ("+awayTeam.name+")", player.id+"");
		}
		
		if (homePlayers != null)
		for (int i = 0; i < homePlayers.length; i++) {
			Player player = homePlayers[i];
			lbxPlayer.addItem(player.name+" ("+homeTeam.name+")", player.id+"");
		}
	}

	private void reset() {
		lbxPlayer.clear();		
	}
	
	
	public EventCard[] getEventCard(){
		EventCard[] cards = new EventCard[tblResult.getRowCount()-1];
		for (int i = 1; i < tblResult.getRowCount(); i++) {
			String time = tblResult.getText(i, 0);
			Long playerId = Long.parseLong(tblResult.getText(i, 2));
			String cardType = tblResult.getText(i, 3);
			EventCard eventCard = new EventCard(playerId, cardType, time);
			cards[i-1] = eventCard;
		}
		return cards;
	}

}
