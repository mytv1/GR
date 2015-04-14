package giddyhero.soccersystem.client.mobile.activities.news;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicView;
import giddyhero.soccersystem.shared.model.News;

import java.util.List;

public interface NewsView  extends BasicView {
	
	void setNews(News news);
}
