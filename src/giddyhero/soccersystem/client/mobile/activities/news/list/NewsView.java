package giddyhero.soccersystem.client.mobile.activities.news.list;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicView;

import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;

public interface NewsView extends BasicView{
	NewsItem[] getNewsItems();
}
