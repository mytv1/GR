package giddyhero.soccersystem.client.manager.ui.news;

import giddyhero.soccersystem.client.SystemManager;
import giddyhero.soccersystem.client.WidgetUtils;
import giddyhero.soccersystem.client.manager.ui.widget.TableInfoDisplay;
import giddyhero.soccersystem.shared.model.News;
import giddyhero.soccersystem.shared.model.SerializableEntity;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextArea;

public class PanelNewsAll extends TableInfoDisplay{


	public PanelNewsAll() {
		super();
		initNewsTable();
	}

	private void initNewsTable() {
		initHeader();
		initContent();
	}
	
	private void initContent() {
		SystemManager.Service.news.getAllNews(new AsyncCallback<News[]>() {

			@Override
			public void onSuccess(News[] result) {
				News[] newsList = result;
				for (int i = 0; i < newsList.length; i++) {
					final News news = newsList[i];
					ScrollPanel scrollPanel = new ScrollPanel();
					TextArea tbContent = new TextArea();
					tbContent.setText(news.content);
					tbContent.setPixelSize(300, 150);
					scrollPanel.add(tbContent);
					
					setWidget(1 + i, 0, WidgetUtils.createIdLabel(news.id, 40, 30)); 
					setText(1 + i, 1, "" + news.title);
					setWidget(1+i, 2, getImageOfNews(news.titleImageUrl));
					setText(1 + i, 3, "" + news.category);
					setWidget(1 + i, 4,  WidgetUtils.createIdLabel(news.taggedPlayer, 40, 30));
					setWidget(1+i, 5, scrollPanel);
					ActionPanel actionPanel = new ActionPanel();
					actionPanel.btDelete.addClickHandler(new ClickHandler() {
						
						@Override
						public void onClick(ClickEvent event) {
							SystemManager.Service.general.deleteEntity(SerializableEntity.NEWS, news.id, new AsyncCallback<Boolean>() {

								@Override
								public void onFailure(Throwable caught) {
									Window.alert("Delete failure");
								}

								@Override
								public void onSuccess(Boolean result) {
									Window.alert("Delete success");							
								}
								
							});
						}
					});
					setWidget(1+i, 6, actionPanel);
				}
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Get all news failure"
						+ caught.toString());
			}
		});		
	}

	private void initHeader() {
		setText(0, 0, "ID");
		setText(0, 1, "Title");
		setText(0, 2, "Title Image");
		setText(0, 3, "Category");
		setText(0, 4, "Tagged");
		setText(0, 5, "Content");
		setText(0, 6, "Action");		
	}

	private Image getImageOfNews(String url){
		Image image = new Image();
		image.setPixelSize(240, 120);
		if (url != null)
			image.setUrl(url);
		return image;
	}
	
	
}
