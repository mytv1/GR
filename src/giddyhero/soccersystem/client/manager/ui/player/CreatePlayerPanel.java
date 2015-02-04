package giddyhero.soccersystem.client.manager.ui.player;

import giddyhero.soccersystem.client.SoccerSystem;
import giddyhero.soccersystem.shared.model.Player;
import giddyhero.soccersystem.shared.model.Position;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class CreatePlayerPanel extends Composite {

	private static CreatePlayerPanelUiBinder uiBinder = GWT
			.create(CreatePlayerPanelUiBinder.class);

	interface CreatePlayerPanelUiBinder extends UiBinder<Widget, CreatePlayerPanel> {
	}


	@UiField
	Button btConfirm;
	@UiField
	ListBox lbPositions, lbDay, lbMonth, lbYear;
	@UiField
	TextBox tbName, tbHeight, tbWeight;
	Position[] positions;

	public CreatePlayerPanel() {
		initWidget(uiBinder.createAndBindUi(this));
		initUI();
	}

	private void initUI() {
		initPositionListBox();
		initConfirmButton();
		initBirthdayList();
	}

	private void initBirthdayList() {
		for(int i = 1;i <= 31;i ++){
			lbDay.addItem(""+i);
		}
		for(int i = 1;i <= 12;i ++){
			lbMonth.addItem(""+i);
		}
		for(int i = 1970;i <= 2015;i ++){
			lbYear.addItem(""+i);
		}
	}

	private void initConfirmButton() {
		btConfirm.setText("OK");		
	}

	private void initPositionListBox() {
		SoccerSystem.greetingService.getStandardSoccerPosition(new AsyncCallback<Position[]>() {
			
			@Override
			public void onSuccess(Position[] result) {
				Window.alert("Success");
				for (Position position : result) {
					lbPositions.addItem(position.getName());
				}
				CreatePlayerPanel.this.positions = result;
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Failure : "+caught.toString());
				
			}
		});
				
		
	}

	@UiHandler("btConfirm")
	void onClick(ClickEvent e) {
//		Window.alert("Click!");
		String name = tbName.getText();
		String birth = lbDay.getItemText(lbDay.getSelectedIndex()) +"/"+ lbMonth.getItemText(lbMonth.getSelectedIndex()) +"/"+ lbYear.getItemText(lbYear.getSelectedIndex());
		int weight = Integer.parseInt(tbWeight.getText());
		int height = Integer.parseInt(tbHeight.getText());
		Position position = getPositionByName(lbPositions.getItemText(lbPositions.getSelectedIndex()));
		
		Player player = new Player(name, birth, height, weight, position);
		Window.alert("name "+name
					 +"\n birth "+birth
					 +"\nheight "+height
					 +"\n weight "+weight
					 +"\n position "+position.getName() +" id : "+position.getId());
		SoccerSystem.playerService.addNewPlayer(player, new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Failure : "+caught.toString());
			}

			@Override
			public void onSuccess(Void result) {
				Window.alert("Success : ");
				
			}
		});
	}
	
	public Position getPositionByName(String name){
		for (int i = 0; i < positions.length; i++) {
			if (positions[i].getName().equalsIgnoreCase(name))
				return positions[i];
		}
		return new Position(12, "");
	}


}
