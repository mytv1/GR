package giddyhero.soccersystem.server;

import static com.googlecode.objectify.ObjectifyService.ofy;
import giddyhero.soccersystem.client.manager.ui.news.NewsService;
import giddyhero.soccersystem.shared.model.News;
import giddyhero.soccersystem.shared.model.Player;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Ref;

public class NewsServiceImpl extends RemoteServiceServlet implements NewsService{

	@Override
	public News saveNews(News news) {
		Key<News> keyNews = ofy().save().entity(news).now();
		news.id = keyNews.getId();
		return news;
	}

	@Override
	public List<News> getAllNews() {
		List<News> newsList = ofy().load().type(News.class).list();
		ArrayList<News> news = new ArrayList<News>(newsList);
		return news;
	}

	@Override
	public void registerRelateEntity() {
		ObjectifyService.register(News.class);
	}

	@Override
	public void deleteNews(long newsId) {
		ofy().delete().type(News.class).id(newsId);
	}

}
