package giddyhero.soccersystem.client.mobile.activities.news.list;

import giddyhero.soccersystem.client.ClientUtils;
import giddyhero.soccersystem.client.mobile.activities.basic.BasicViewImpl;
import giddyhero.soccersystem.shared.model.News;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class NewsViewImpl extends BasicViewImpl implements NewsView{

	private static NewsViewImplUiBinder uiBinder = GWT
			.create(NewsViewImplUiBinder.class);

	interface NewsViewImplUiBinder extends UiBinder<Widget, NewsViewImpl> {
	}
	NewsItem[] newItems;
	
	@UiField
	protected VerticalPanel mainPanel;
	
	public NewsViewImpl() {
		super();
		this.layout.getScrollPanel().setWidget(uiBinder.createAndBindUi(this));
		this.layout.getHeaderBackButton().setVisible(false);
		mainPanel.setHeight(ClientUtils.getHeight()
				-this.layout.getHeaderPanel().getOffsetHeight() +"px");
		
	}

	@Override
	public void addNewsListContent(News[] newsList) {
				newItems = new NewsItem[newsList.length];
				for (int j = 0; j < newsList.length; j++) {
					News news = newsList[j];
					NewsItem item =
							new NewsItem(news.titleImageUrl, news.title);
					mainPanel.add(item);
					newItems[j] = item;
				}
		
	}

	@Override
	public NewsItem[] getNewsItems() {
		return newItems;
	}

}
