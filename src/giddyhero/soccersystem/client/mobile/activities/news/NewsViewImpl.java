package giddyhero.soccersystem.client.mobile.activities.news;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicViewImpl;
import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.share.CSSUtils;
import giddyhero.soccersystem.shared.model.News;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class NewsViewImpl extends BasicViewImpl implements NewsView {
	
	Label lbTitle = new Label();
	Image imgMain = new Image();
	Label lbContent = new Label();
	
	public NewsViewImpl() {
		super();
		setStandAloneViewMode();
		init();
	}

	private void init() {
		
		VerticalPanel vpMain = getPanelMiddle();
		Style style;
		
		/* Label Title */
		style = lbTitle.getElement().getStyle();
		style.setMarginLeft(2, Unit.PCT);
		style.setMarginRight(2, Unit.PCT);
		style.setMarginTop(2, Unit.PCT);
		style.setFontSize(150, Unit.PCT);
		vpMain.add(lbTitle);
		
		/* Image Main */
		style = imgMain.getElement().getStyle();
		CSSUtils.Mobile.setSizePercent(imgMain, 0.9f, 0.2f);
		style.setMargin(5, Unit.PCT);
		vpMain.add(imgMain);
		
		/*Label Content */
		style = lbContent.getElement().getStyle();
		style.setMarginLeft(2, Unit.PCT);
		style.setMarginRight(2, Unit.PCT);
		vpMain.add(lbContent);
		
	}

	@Override
	public void setNews(News news) {
		lbTitle.setText(news.title);
		
		imgMain.setUrl(news.titleImageUrl);
		
		lbContent.setText(news.content);
	}
	
}

