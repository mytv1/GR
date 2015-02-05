package giddyhero.soccersystem.client.mobile.activities.news.detail;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicView;

import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;

public interface NewsDetailView extends BasicView{
	void addContent(int newsId);
}
