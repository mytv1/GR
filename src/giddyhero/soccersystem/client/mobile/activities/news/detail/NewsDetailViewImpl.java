package giddyhero.soccersystem.client.mobile.activities.news.detail;

import giddyhero.soccersystem.client.ClientUtils;
import giddyhero.soccersystem.client.mobile.activities.basic.BasicViewImpl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.ui.client.widget.button.Button;

public class NewsDetailViewImpl extends BasicViewImpl implements NewsDetailView {

	private static NewsDetailViewImplUiBinder uiBinder = GWT
			.create(NewsDetailViewImplUiBinder.class);

	interface NewsDetailViewImplUiBinder extends
			UiBinder<Widget, NewsDetailViewImpl> {
	}

	@UiField
	VerticalPanel mainPanel;
	@UiField
	Image imgMain;
	@UiField
	Label lbContent;
	private int newsId;

	public NewsDetailViewImpl() {
		super();
		this.layout.getScrollPanel().setWidget(uiBinder.createAndBindUi(this));
		this.layout.getHeaderBackButton().setVisible(false);
		mainPanel.setHeight(ClientUtils.getHeight()
				- this.layout.getHeaderPanel().getOffsetHeight() + "px");
	}
	
	private void initLabelContent(String content) {
		this.lbContent
				.setText(content);

		lbContent.setWidth((int) (ClientUtils.getWidth() * 0.8) + "px");
	}

	private void initImage(String imgUrl) {
		imgMain.setUrl(imgUrl);
		int width = (int) (ClientUtils.getWidth() * 0.8);
		int height = (int) (ClientUtils.getHeight() * 0.3);
		imgMain.setWidth(width + "px");
		imgMain.setHeight(height + "px");
	}

//	public void addContent(int newsId) {
//		initImage("images/messi.jpg");
//		initLabelContent("");
//	}

	@Override
	public void addContent(String title, String imgUrl, String content) {
		initImage(imgUrl);
		initLabelContent(content);		
	}

}
