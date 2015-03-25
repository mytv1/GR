package giddyhero.soccersystem.client.manager.ui.player;

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
import com.google.gwt.user.client.ui.Widget;

import giddyhero.soccersystem.client.SoccerSystem;
import giddyhero.soccersystem.client.manager.ui.widget.TableFormInput;
import giddyhero.soccersystem.shared.Position;
import giddyhero.soccersystem.shared.model.News;
import giddyhero.soccersystem.shared.model.Player;

public class TableCreatePlayer extends TableFormInput{
	
	TextBoxStandard tbName = new TextBoxStandard("500px"), 
			tbAvatarImgUrl =  new TextBoxStandard("500px"),
		    tbHeight =  new TextBoxStandard("200px");
	TextAreaStandard taContent =  new TextAreaStandard("800px","200px");
	ListBox lbPositions = new ListBox() , lbDay = new ListBox(),
			lbMonth = new ListBox(), lbYear = new ListBox(), lbNationality = new ListBox();
	Player[] players;
	
	
	public TableCreatePlayer() {
		super();
		init();
	}

	private void init() {
		initLabelColumn();
		initBirthHolder();
		initPositionListBox();
		initNationalityList();
		initFormColumn();
	}

	private void initFormColumn() {
		setWidget(0, 1, tbName);
		setWidget(1, 1, tbAvatarImgUrl);
		setWidget(2, 1, initBirthHolder());
		setWidget(3, 1, tbHeight);
		setWidget(4, 1, lbPositions);
		setWidget(5, 1, lbNationality);	
	}
	
	private void initNationalityList() {
		SoccerSystem.Service.general.getAllCountryNames(new AsyncCallback<String[]>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Get nationality failure");				
			}

			@Override
			public void onSuccess(String[] result) {
				String[] locales = result;
				for (int i = 0; i < locales.length; i++) {
					lbNationality.addItem(locales[i]);
				}
			}
		});
	}
	
	private FlowPanel initBirthHolder(){
		FlowPanel flowPanel = new FlowPanel();
		initBirthdayList();
		flowPanel.add(lbDay);
		flowPanel.add(lbMonth);
		flowPanel.add(lbYear);
		return flowPanel;
	}
	
	private void initPositionListBox() {
		for(Entry<Integer, String> entry : Position.positions.entrySet()) {
		    String value = entry.getValue();
		    lbPositions.addItem(value);
		}
		
	}

	private void initLabelColumn() {
		setWidget(0, 0, new LabelStandard("Name"));
		setWidget(1, 0, new LabelStandard("Avatar Image Url"));
		setWidget(2, 0, new LabelStandard("Birth"));
		setWidget(3, 0, new LabelStandard("Height"));
		setWidget(4, 0, new LabelStandard("Position"));
		setWidget(5, 0, new LabelStandard("Nationality"));		
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
	
	public Player getPlayer(){
		String name = tbName.getText();
		int year = Integer.parseInt(lbYear.getItemText(lbYear.getSelectedIndex()));
		int month = Integer.parseInt(lbMonth.getItemText(lbMonth.getSelectedIndex()));
		int day = Integer.parseInt(lbDay.getItemText(lbDay.getSelectedIndex()));
		
		int height = Integer.parseInt(tbHeight.getText());
		int positionId = lbPositions.getSelectedIndex();
		String nationality = lbNationality.getItemText(lbNationality.getSelectedIndex());
		String avatarUrl = tbAvatarImgUrl.getText();
		return new Player(name, year, month, day, height, positionId, nationality, avatarUrl);
	}

	
//	public News getNews(){
//		String title = tbName.getText();
//		String titleUrl = tbAvatarImgUrl.getText();
//		String category = lbCategory.getItemText(lbCategory.getSelectedIndex());
////		long taggedPlayerId = getTaggedPlayer();
//		String content = taContent.getText();
//		
//		News news = new News(title, titleUrl, category, 0, content);
//		return news;
//	}
//	
	
//	private long getTaggedPlayer(){
//		String value = lbTaggedPlayer.getValue(lbTaggedPlayer.getSelectedIndex());
//		if (value != null)
//			return Long.parseLong(value);
//		else
//			return -1;
//	}
}
