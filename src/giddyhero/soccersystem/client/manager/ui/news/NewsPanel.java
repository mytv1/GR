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
import com.google.gwt.user.client.ui.Widget;

public class NewsPanel extends Composite {

	private static NewsPanelUiBinder uiBinder = GWT
			.create(NewsPanelUiBinder.class);

	interface NewsPanelUiBinder extends UiBinder<Widget, NewsPanel> {
	}

	@UiField
	FlexTable tblNews;

	public NewsPanel() {
		initWidget(uiBinder.createAndBindUi(this));
		initNewsTable();
	}

	private void initNewsTable() {
		tblNews.setText(0, 0, "ID");
		tblNews.setText(0, 1, "Title");
		SoccerSystem.newsService
				.getAllNews(new AsyncCallback<News[]>() {

					@Override
					public void onSuccess(News[] result) {
						Window.alert("Get all player success");
						News[] newsList = result;
						for (int i = 0; i < newsList.length; i++) {
							News news = newsList[i];
							tblNews.setText(1 + i, 0, "" + news.id);
							tblNews.setText(1 + i, 1, "" + news.title);
						}
					}

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Get all player failure"
								+ caught.toString());
					}
				});
	}

}
