package giddyhero.soccersystem.client.manager.ui.news;

import giddyhero.soccersystem.client.SoccerSystem;
import giddyhero.soccersystem.shared.model.News;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class NewsAllPanel extends Composite {

	private static NewsAllPanelUiBinder uiBinder = GWT
			.create(NewsAllPanelUiBinder.class);

	interface NewsAllPanelUiBinder extends UiBinder<Widget, NewsAllPanel> {
	}

	@UiField
	FlexTable tblNews;

	public NewsAllPanel() {
		initWidget(uiBinder.createAndBindUi(this));
		initNewsTable();
	}

	private void initNewsTable() {
		tblNews.setText(0, 0, "ID");
		tblNews.setText(0, 1, "Title");
		tblNews.setText(0, 2, "Title Image");
		tblNews.setText(0, 3, "Category");
		tblNews.setText(0, 4, "Tagged Player");
		tblNews.setText(0, 5, "Content");
		
		SoccerSystem.newsService
				.getAllNews(new AsyncCallback<News[]>() {

					@Override
					public void onSuccess(News[] result) {
						News[] newsList = result;
						for (int i = 0; i < newsList.length; i++) {
							News news = newsList[i];
							ScrollPanel scrollPanel = new ScrollPanel();
							TextArea tbContent = new TextArea();
//							scrollPanel.setPixelSize(300, 150);
							tbContent.setText(news.content);
							tbContent.setPixelSize(300, 150);
							scrollPanel.add(tbContent);
							
							tblNews.setText(1 + i, 0, "" + news.id);
							tblNews.setText(1 + i, 1, "" + news.title);
							tblNews.setWidget(1+i, 2, getImageOfNews(news.titleImageUrl));
							tblNews.setText(1 + i, 3, "" + news.category);
							tblNews.setText(1 + i, 4, "" + news.taggedPlayer);
							tblNews.setWidget(1+i, 5, scrollPanel);
						}
					}

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Get all news failure"
								+ caught.toString());
					}
				});
	}
	
	private Image getImageOfNews(String url){
		Image image = new Image();
		image.setPixelSize(240, 120);
		if (url != null)
			image.setUrl(url);
		return image;
	}

}
