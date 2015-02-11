package giddyhero.soccersystem.client.manager.ui.player;

import giddyhero.soccersystem.client.SoccerSystem;
import giddyhero.soccersystem.client.SoccerSystem.Service;
import giddyhero.soccersystem.shared.Position;
import giddyhero.soccersystem.shared.model.Player;

import java.sql.Date;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.i18n.rebind.LocaleUtils;
import com.google.gwt.i18n.shared.GwtLocale;
import com.google.gwt.i18n.shared.GwtLocaleFactory;
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

public class PlayerCreatePanel extends Composite {

	private static PlayerCreatePanelUiBinder uiBinder = GWT
			.create(PlayerCreatePanelUiBinder.class);

	interface PlayerCreatePanelUiBinder extends UiBinder<Widget, PlayerCreatePanel> {
	}


	@UiField
	Button btConfirm;
	@UiField
	ListBox lbPositions, lbDay, lbMonth, lbYear, lbNationality;
	@UiField
	TextBox tbName, tbHeight, tbAvatarUrl;

	public PlayerCreatePanel() {
		initWidget(uiBinder.createAndBindUi(this));
		initUI();
	}

	private void initUI() {
		initPositionListBox();
		initConfirmButton();
		initBirthdayList();
		initNationalityList();
	}

	private void initNationalityList() {
		SoccerSystem.Service.general.getAllCountryNames(new AsyncCallback<String[]>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Locale failure");				
			}

			@Override
			public void onSuccess(String[] result) {
				Window.alert("Locale success");
				String[] locales = result;
				for (int i = 0; i < locales.length; i++) {
					lbNationality.addItem(locales[i]);
				}
			}
		});
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
		for(Entry<Integer, String> entry : Position.positions.entrySet()) {
		    String value = entry.getValue();
		    lbPositions.addItem(value);
		}
		
	}

	@UiHandler("btConfirm")
	void onClick(ClickEvent e) {
		String name = tbName.getText();
		int year = Integer.parseInt(lbYear.getItemText(lbYear.getSelectedIndex()));
		int month = Integer.parseInt(lbMonth.getItemText(lbMonth.getSelectedIndex()));
		int day = Integer.parseInt(lbDay.getItemText(lbDay.getSelectedIndex()));
		
		int height = Integer.parseInt(tbHeight.getText());
		int positionId = lbPositions.getSelectedIndex();
		String nationality = lbNationality.getItemText(lbNationality.getSelectedIndex());
		String avatarUrl = tbAvatarUrl.getText();
		
//		Player player = new Player(name, new Date(year, month, day), height, positionId,nationality,avatarUrl);
		Window.alert("name "+name
				 +"\n "+day+" - "+month+" - "+year
				 +"\nheight "+height
				 +"\n position id : "+positionId
				 +"\n nationality : "+nationality
				 +"\n Avatar Url : "+avatarUrl);
		SoccerSystem.Service.player.addNewPlayer(name,year , month,day , height, positionId,nationality,avatarUrl, new AsyncCallback<Player>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Failure : "+caught.toString());
			}

			@Override
			public void onSuccess(Player player) {
				Window.alert("Success : "+player.toString());
				
			}
		});
	}
	


}
