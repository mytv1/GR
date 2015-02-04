package giddyhero.soccersystem.server;

import giddyhero.soccersystem.client.manager.ui.news.NewsService;
import static com.googlecode.objectify.ObjectifyService.ofy;
import giddyhero.soccersystem.shared.model.News;

import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class NewsServiceImpl extends RemoteServiceServlet implements NewsService{

	@Override
	public void addNews(News news) {
		ofy().save().entities(news);
	}

	@Override
	public News[] getAllNews() {
		List<News> newsList = ofy().load().type(News.class).list();
		News[] news = new News[newsList.size()];
		for(int i = 0;i < newsList.size();i++){
			news[i] = newsList.get(i);
		}
		return news;
	}

}
