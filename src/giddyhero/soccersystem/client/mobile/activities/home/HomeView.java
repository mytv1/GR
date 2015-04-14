package giddyhero.soccersystem.client.mobile.activities.home;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicView;
import giddyhero.soccersystem.client.mobile.activities.basic.PanelMenu;
import giddyhero.soccersystem.client.mobile.activities.home.HomeViewImpl.PanelNews;
import giddyhero.soccersystem.shared.model.News;

import java.util.List;

public interface HomeView  extends BasicView {
	
	List<PanelNews>  addNews(List<News> news);

}
