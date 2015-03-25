package giddyhero.soccersystem.client.mobile.activities.news.detail;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicView;

public interface NewsDetailView extends BasicView {
	void addContent(String title, String imgUrl, String content);
}
