package giddyhero.soccersystem.client.manager.ui.news;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;

import giddyhero.soccersystem.client.SoccerSystem;
import giddyhero.soccersystem.client.manager.ui.widget.TableFormInput;
import giddyhero.soccersystem.shared.model.News;
import giddyhero.soccersystem.shared.model.Player;

public class TableCreateNews extends TableFormInput{
	
	ListBox lbCategory = new ListBox();
	TextBoxStandard tbTitle = new TextBoxStandard("500px"), tbTitleImage =  new TextBoxStandard("500px");
	TextAreaStandard taContent =  new TextAreaStandard("800px","200px");
	ListBox bTaggedPlayer;
	Player[] players;
	
	
	public TableCreateNews() {
		super();
		
		init();
	}

	private void init() {
		setWidget(0, 0, new LabelStandard("Tile"));
		setWidget(1, 0, new LabelStandard("Tile Image Url"));
		setWidget(2, 0, new LabelStandard("Category"));
		setWidget(3, 0, new LabelStandard("Content"));
		
		initCategoryListBox();
		
		setWidget(0, 1, tbTitle);
		setWidget(1, 1, tbTitleImage);
		setWidget(2, 1, lbCategory);
		setWidget(3, 1, taContent);
	}

	private void initCategoryListBox() {
		lbCategory.addItem("Premier League");
		lbCategory.addItem("Laliga");
		lbCategory.addItem("Bundesliga");
		lbCategory.addItem("UEFA Champion League");
		lbCategory.addItem("V-League");
		lbCategory.addItem("Transfer");		
	}
//	
//	private void initTaggedPlayer() {
//		SoccerSystem.Service.player.getAllPlayers(new AsyncCallback<Player[]>() {
//
//			@Override
//			public void onFailure(Throwable caught) {
//				Window.alert("Get all player error! "+caught.toString());
//			}
//
//			@Override
//			public void onSuccess(Player[] result) {
//				players = result;
//				lbTaggedPlayer.addItem(null,"-1");
//				for (int i = 0; i < result.length; i++) {
//					Player player = players[i];
//					lbTaggedPlayer.addItem(player.name,""+player.id);
//				}
//			}
//		});
//	}
	
	
	public News getNews(){
		String title = tbTitle.getText();
		String titleUrl = tbTitleImage.getText();
		String category = lbCategory.getItemText(lbCategory.getSelectedIndex());
//		long taggedPlayerId = getTaggedPlayer();
		String content = taContent.getText();
		
		News news = new News(title, titleUrl, category, 0, content);
		return news;
	}
	
	
//	private long getTaggedPlayer(){
//		String value = lbTaggedPlayer.getValue(lbTaggedPlayer.getSelectedIndex());
//		if (value != null)
//			return Long.parseLong(value);
//		else
//			return -1;
//	}
}
