package giddyhero.soccersystem.client.manager.ui.news;

import java.util.List;

import giddyhero.soccersystem.shared.model.News;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("news")
public interface NewsService extends RemoteService{
	News saveNews(News news);
	
	void deleteNews(long newsId);
	
	List<News> getAllNews();
	
	void registerRelateEntity();
}
