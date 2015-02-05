package giddyhero.soccersystem.client.mobile.activities.news.list;

import giddyhero.soccersystem.client.ClientUtils;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;

public class NewsItem extends Composite {

	private static NewsItemUiBinder uiBinder = GWT
			.create(NewsItemUiBinder.class);

	interface NewsItemUiBinder extends UiBinder<Widget, NewsItem> {
	}

	ClickHandler clickHandler;
	@UiField
	Image imgMain;
	@UiField
	Label lbTitle;
	@UiField
	VerticalPanel pnMain;

	public NewsItem(String imgUrl, String title) {
		initWidget(uiBinder.createAndBindUi(this));
		initImage(imgUrl);
		initLabel(title);
	}

	private void initLabel(String title) {
		this.lbTitle.setText(title);
		lbTitle.setWidth((int) (ClientUtils.getWidth() * 0.8) + "px");
	}

	private void initImage(String imgUrl) {
		imgMain.setUrl(imgUrl);
		int width = (int) (ClientUtils.getWidth() * 0.8);
		int height = (int) (ClientUtils.getHeight() * 0.3);
		imgMain.setWidth(width + "px");
		imgMain.setHeight(height + "px");
	}

	public void setClickHandler(ClickHandler clickHandler) {
		this.clickHandler = clickHandler;
	}
	
	@UiHandler("imgMain")
	void handleClick(ClickEvent e) {
		clickHandler.onClick(e);
	
	}

}
