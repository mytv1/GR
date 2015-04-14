package giddyhero.soccersystem.client.manager.ui.news;

import java.util.List;

import giddyhero.soccersystem.shared.model.News;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface NewsServiceAsync {

	void saveNews(News news, AsyncCallback<News> callback);

	void getAllNews(AsyncCallback<List<News>> callback);

	void registerRelateEntity(AsyncCallback<Void> callback);

	void deleteNews(long newsId, AsyncCallback<Void> callback);

}
