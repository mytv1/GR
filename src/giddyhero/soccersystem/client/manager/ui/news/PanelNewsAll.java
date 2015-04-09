package giddyhero.soccersystem.client.manager.ui.news;

import giddyhero.soccersystem.client.HistoryToken;
import giddyhero.soccersystem.client.SystemManager;
import giddyhero.soccersystem.client.manager.ui.player.WindowCreatePlayer;
import giddyhero.soccersystem.client.share.CSSUtils;
import giddyhero.soccersystem.shared.model.News;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SelectionChangeEvent.Handler;
import com.google.gwt.view.client.SingleSelectionModel;

public class PanelNewsAll extends FlowPanel {

	Button btCreate = new Button("New News");
	TableNews tableNews;
	TextArea taNewsContent = new TextArea();
	HorizontalPanel hp = new HorizontalPanel();
	
	public PanelNewsAll() {
		super();
		init();
		style();
	}

	private void style() {
		Style style = getElement().getStyle();
		style.setPosition(Position.ABSOLUTE);
	}

	private void init() {
		initButtonCreate();
		
		initTableNews();
		
		initContentTextArea();
		add(hp);
	}

	private void initTableNews() {
		tableNews = new TableNews();
		tableNews.setSize("600px", "400px");
		CSSUtils.setMargin(tableNews, 0);
		setAllPlayerData();
		hp.add(tableNews);		
	}

	private void initContentTextArea() {
		taNewsContent.setSize("350px", "400px");
		CSSUtils.setMargin(taNewsContent, 20);
		tableNews.getSelectionModel().addSelectionChangeHandler(new  Handler() {
			
			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				final News news = ((SingleSelectionModel<News>)tableNews.getSelectionModel()).getSelectedObject();
				taNewsContent.setText(news.content);
				taNewsContent.addChangeHandler(new ChangeHandler() {
					
					@Override
					public void onChange(ChangeEvent event) {
						news.content = taNewsContent.getText();
					}
				});
			}
		});
		
		hp.add(taNewsContent);	
	}

	private void initButtonCreate() {
		CSSUtils.setMarginTop(btCreate, 10);
		CSSUtils.setMarginBottom(btCreate, 20);
		btCreate.setPixelSize(120, 40);
		btCreate.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Window.open("Manager.html#"+HistoryToken.NEWS_CREATE, "window name", "width="+WindowCreatePlayer.WIDTH+", height="+WindowCreatePlayer.HEIGHT);
			}
		});
		add(btCreate);		
	}

	public void setAllPlayerData() {
		SystemManager.Service.news.getAllNews(new AsyncCallback<News[]>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("get all news fail : "+caught.toString());
			}

			@Override
			public void onSuccess(News[] result) {
				List<News> news = new ArrayList<News>();
				for (int i = 0; i < result.length; i++) {
					news.add(result[i]);
				}
				tableNews.setData(news);
				
			}
		});
	}

}
