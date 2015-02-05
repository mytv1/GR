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
	
	private void initLabel(String title) {
		this.lbContent
				.setText("Tuy nhiên, có thực tế ít ai biết rằng, chính thủ thành David Ospina của Arsenal đã tác động không nhỏ để người đồng hương chuyển sang London thi đấu cho The Blues. Cụ thể, trước khi Juan Cuadrado quyết định đầu quân cho Chelsea, cầu thủ này đã hỏi ý kiến của David Ospina. Thủ môn của Arsenal đã tư vấn cho tân binh của The Blues khá nhiệt tình về cuộc sống ở London cũng như cách thích nghi với Premier League. Thậm chí, anh còn lên tiếng khuyên Juan Cuadrado nên gia nhập Chelsea. Chính vì vậy, sau khi Juan Cuadrado tới đầu quân cho đội chủ sân Stamford Bridge, David Ospina đã gửi lời chúc người đồng hương trên trang Instagram với nội dung: “Chúc mọi điều tốt đẹp nhất tới với anh, đồng đội”. Đáp lại, Juan Cuadrado đã cảm ơn David Ospina: “Cảm ơn vì lời mời, người đồng đội!”. Ở thời điểm này, David Ospina đã chiếm vị trí số 1 trong khung gỗ của Arsenal. Do đó, những người hâm mộ hoàn toàn có thể chờ đợi vào cuộc đọ sức của hai tuyển thủ Colombia này khi Arsenal đụng độ với Chelsea vào ngày 25/4.");

		lbContent.setWidth((int) (ClientUtils.getWidth() * 0.8) + "px");
	}

	private void initImage(String imgUrl) {
		imgMain.setUrl(imgUrl);
		int width = (int) (ClientUtils.getWidth() * 0.8);
		int height = (int) (ClientUtils.getHeight() * 0.3);
		imgMain.setWidth(width + "px");
		imgMain.setHeight(height + "px");
	}

	public void addContent(int newsId) {
		initImage("images/messi.jpg");
		initLabel("");
	}

}
