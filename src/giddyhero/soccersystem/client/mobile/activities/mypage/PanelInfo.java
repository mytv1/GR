package giddyhero.soccersystem.client.mobile.activities.mypage;

import giddyhero.soccersystem.client.share.CSSUtils;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.mgwt.ui.client.widget.button.Button;

public class PanelInfo extends HorizontalPanel {

	Image imgAvatar = new Image();
	PanelLineInfo lbName = new PanelLineInfo("Name","Usalt Bold"), lbFb = new PanelLineInfo("Facebook","www.facebook.com/UsaltBold"), lbItem = new PanelLineInfo(
			"Item","15"), lbPoint = new PanelLineInfo("Point","350"), lbCoin = new PanelLineInfo("Coin","2500$");
	Button btViewItem = new Button("View"), btCharge = new Button("Charge");

	public PanelInfo() {
		super();
		init();
		style();
	}

	private void style() {
		Style style = getElement().getStyle();
		style.setPaddingTop(5, Unit.PCT);
		style.setWidth(100, Unit.PCT);
		style.setHeight(25, Unit.PCT);
	}

	private void init() {
		avatar();
		baseinfo();
	}

	private void baseinfo() {
		VerticalPanel vp = new VerticalPanel();
		Style style = vp.getElement().getStyle();
		CSSUtils.Mobile.setSizePercent(vp, 0.7f, 0.2f);
		style.setPaddingLeft(15, Unit.PCT);
		add(vp);

		vp.add(lbName);
//		vp.add(lbFb);
		vp.add(lbItem);
		style = btViewItem.getElement().getStyle();
//		style.setMarginLeft(40, Unit.PCT);
		style.setDisplay(Display.INLINE);
		lbItem.add(btViewItem);

		vp.add(lbPoint);

		style = btCharge.getElement().getStyle();
		style.setDisplay(Display.INLINE);
//		style.setMarginLeft(40, Unit.PCT);
		lbCoin.add(btCharge);
		vp.add(lbCoin);
	}

	private void avatar() {
		imgAvatar.setUrl("http://www.bin.vn/uploads/article/noavatar_1418273249.jpg");
		CSSUtils.Mobile.setSizePercent(imgAvatar, 0.3f, 0.2f);
		Style style = imgAvatar.getElement().getStyle();
		style.setPaddingLeft(15, Unit.PCT);
		add(imgAvatar);
	}

	public static class PanelLineInfo extends HorizontalPanel {

		Label lbBold = new Label();
		Label lbContent = new Label();

		public PanelLineInfo(String boldText) {
			super();
			initLabelBold(boldText);
			style();
		}
		
		public PanelLineInfo(String boldText, String content) {
			this(boldText);
			lbContent.setText(content);
		}

		private void style() {
			Style style = getElement().getStyle();
			style.setMarginBottom(5, Unit.PCT);
		}

		private void initLabelBold(String boldText) {
			lbBold.setText(boldText + " : ");
			Style style = lbBold.getElement().getStyle();
			style.setFontWeight(FontWeight.BOLD);
			style.setFontSize(120, Unit.PCT);
			add(lbBold);

			lbContent.setText(" Unknow");
			style = lbContent.getElement().getStyle();
//			style.setWidth(60, Unit.PCT);
//			style.setPaddingLeft(15, Unit.PCT);
			style.setFontSize(120, Unit.PCT);
			add(lbContent);
			
//			add(new Button("Button"));
		}

		public void setText(String text) {
			lbContent.setText(text);
		}

	}

}
