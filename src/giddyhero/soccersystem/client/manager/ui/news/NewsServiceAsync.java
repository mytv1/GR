package giddyhero.soccersystem.client.manager.ui.news;

import giddyhero.soccersystem.shared.model.News;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface NewsServiceAsync {

	void addNews(News news, AsyncCallback<Void> callback);

	void getAllNews(AsyncCallback<News[]> callback);

}
