package giddyhero.soccersystem.client.mobile.activities.home;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicViewImpl;
import giddyhero.soccersystem.client.share.CSSUtils;
import giddyhero.soccersystem.shared.model.News;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class HomeViewImpl extends BasicViewImpl implements HomeView {
	
	public HomeViewImpl() {
		super();
		pnMenu.setHighlight("news");
	}

	
	class PanelNews extends VerticalPanel{
		public Image imgMain = new Image();
		Label lbTitle = new Label(), lbAuthor = new Label();
		Image imgLike = new Image(), imgShare = new Image(), imgComment = new Image();
		public News news;
		
		public PanelNews(News news) {
			super();
			this.news = news;
			initBaseParam();
			init(news);
		}
		
		private void initBaseParam() {
			CSSUtils.Mobile.setSizePercent(PanelNews.this, 0.9f, 0.4f);
			getElement().getStyle().setMargin(5, Unit.PCT);
		}

		private void init(News news) {
			imgMain.setUrl(news.titleImageUrl);
			CSSUtils.Mobile.setSizePercent(imgMain, 0.9f, 0.3f);
			add(imgMain);
			
			lbTitle.setText(news.title);
			lbTitle.getElement().getStyle().setFontSize(150, Unit.PCT);
			add(lbTitle);
			
			lbAuthor.setText("Author : Anonymous");
			lbAuthor.getElement().getStyle().setFontSize(120, Unit.PCT);
			add(lbAuthor);
		}
	}


	@Override
	public List<PanelNews> addNews(List<News> newsList) {
		List<PanelNews> panelNews = new ArrayList<PanelNews>();
		for (News news : newsList) {
			PanelNews pnNews = new PanelNews(news);
			super.pnMain.pnMiddle.add(pnNews);
			panelNews.add(pnNews);
		}
		return panelNews;
	}
}

