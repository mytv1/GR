package giddyhero.soccersystem.client.manager.ui.news;

import giddyhero.soccersystem.client.SoccerSystem;
import giddyhero.soccersystem.shared.model.News;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class NewNewsPanel extends Composite{

	private static NewNewsPanelUiBinder uiBinder = GWT
			.create(NewNewsPanelUiBinder.class);

	interface NewNewsPanelUiBinder extends UiBinder<Widget, NewNewsPanel> {
	}
	
	@UiField
	Button btConfirm;
	@UiField
	TextBox tbTitle;
	@UiField
	TextArea taContent;

	public NewNewsPanel() {
		initWidget(uiBinder.createAndBindUi(this));
	}


	public NewNewsPanel(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("btConfirm")
	void onClick(ClickEvent e) {
		News news = new News(tbTitle.getText(), taContent.getText());
		SoccerSystem.newsService.addNews(news, new AsyncCallback<Void>() {
			
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

}
