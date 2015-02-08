package giddyhero.soccersystem.client.mobile.activities.news.list;

import giddyhero.soccersystem.client.ClientUtils;
import giddyhero.soccersystem.client.MobileEntryPoint;
import giddyhero.soccersystem.client.mobile.activities.basic.BasicViewImpl;
import giddyhero.soccersystem.shared.model.News;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.ui.client.widget.button.Button;

public class NewsViewImpl extends BasicViewImpl implements NewsView{

	private static NewsViewImplUiBinder uiBinder = GWT
			.create(NewsViewImplUiBinder.class);

	interface NewsViewImplUiBinder extends UiBinder<Widget, NewsViewImpl> {
	}
	NewsItem[] newItems;
	
	@UiField
	protected VerticalPanel mainPanel;
	
	public NewsViewImpl() {
		super();
		this.layout.getScrollPanel().setWidget(uiBinder.createAndBindUi(this));
		this.layout.getHeaderBackButton().setVisible(false);
		mainPanel.setHeight(ClientUtils.getHeight()
				-this.layout.getHeaderPanel().getOffsetHeight() +"px");
		
	}

	@Override
	public void addNewsListContent(News[] newsList) {
//		MobileEntryPoint.newsService.getAllNews(new AsyncCallback<News[]>() {
//			
//			@Override
//			public void onSuccess(News[] result) {
//				Window.alert("Suceess : "+result.length);
				newItems = new NewsItem[newsList.length];
				for (int j = 0; j < newsList.length; j++) {
					News news = newsList[j];
					NewsItem item =
							new NewsItem(news.titleImageUrl, news.title);
//					Window.alert(news.toString());
					mainPanel.add(item);
					newItems[j] = item;
				}
//						
//			}
//			
//			@Override
//			public void onFailure(Throwable caught) {
//				Window.alert("Failure : "+caught.toString());
//			}
//		});
		
	}

	@Override
	public NewsItem[] getNewsItems() {
		return newItems;
	}

}
