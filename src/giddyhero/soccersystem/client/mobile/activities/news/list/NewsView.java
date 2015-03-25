package giddyhero.soccersystem.client.mobile.activities.news.list;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicView;
import giddyhero.soccersystem.shared.model.News;

public interface NewsView extends BasicView{
	NewsItem[] getNewsItems();
	
	void addNewsListContent(News[] newsList);
}
