package giddyhero.soccersystem.client.manager.ui.news;

import giddyhero.soccersystem.shared.model.News;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("news")
public interface NewsService extends RemoteService{
	void addNews(News news);
	
	News[] getAllNews();
	
	void registerRelateEntity();
}
