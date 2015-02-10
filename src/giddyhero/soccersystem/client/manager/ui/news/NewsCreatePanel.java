package giddyhero.soccersystem.client.manager.ui.news;

import giddyhero.soccersystem.client.SoccerSystem;
import giddyhero.soccersystem.client.SoccerSystem.Service;
import giddyhero.soccersystem.shared.model.News;
import giddyhero.soccersystem.shared.model.Player;

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
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class NewsCreatePanel extends Composite{

	private static NewsCreatePanelUiBinder uiBinder = GWT
			.create(NewsCreatePanelUiBinder.class);

	interface NewsCreatePanelUiBinder extends UiBinder<Widget, NewsCreatePanel> {
	}
	
	@UiField
	Button btConfirm;
	@UiField
	TextBox tbTitle, tbTitleImage;
	@UiField
	TextArea taContent;
	@UiField
	ListBox lbCategory, lbTaggedPlayer;
	Player[] players;
	

	public NewsCreatePanel() {
		initWidget(uiBinder.createAndBindUi(this));
		initCategoryListBox();
		initTaggedPlayer();
	}


	private void initTaggedPlayer() {
		SoccerSystem.Service.player.getAllPlayers(new AsyncCallback<Player[]>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Get all player error! "+caught.toString());
			}

			@Override
			public void onSuccess(Player[] result) {
				players = result;
				lbTaggedPlayer.addItem(null,"-1");
				for (int i = 0; i < result.length; i++) {
					Player player = players[i];
					lbTaggedPlayer.addItem(player.name,""+player.id);
				}
			}
		});
	}


	private void initCategoryListBox() {
		lbCategory.addItem("Premier League");
		lbCategory.addItem("Laliga");
		lbCategory.addItem("Bundesliga");
		lbCategory.addItem("UEFA Champion League");
		lbCategory.addItem("V-League");
		lbCategory.addItem("Transfer");
	}


	@UiHandler("btConfirm")
	void onClick(ClickEvent e) {
		String title = tbTitle.getText();
		String titleUrl = tbTitleImage.getText();
		String category = lbCategory.getItemText(lbCategory.getSelectedIndex());
		long taggedPlayerId = getTaggedPlayer();
		String content = taContent.getText();
		
		News news = new News(title, titleUrl, category, taggedPlayerId, content);
		SoccerSystem.Service.news.addNews(news, new AsyncCallback<Void>() {
			
			@Override
			public void onSuccess(Void result) {
				Window.alert("Add news success ");				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Add news fail "+caught.toString());
			}
		});
	}
	
	private long getTaggedPlayer(){
		String value = lbTaggedPlayer.getValue(lbTaggedPlayer.getSelectedIndex());
		if (value != null)
			return Long.parseLong(value);
		else
			return -1;
	}

}
