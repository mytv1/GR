package giddyhero.soccersystem.client.mobile.activities.mypage;

import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.share.CSSUtils;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.mgwt.ui.client.widget.button.Button;

public class PanelInfo extends HorizontalPanel {

	Image imgAvatar = new Image();
	PanelLineInfo lbName = new PanelLineInfo("Name","Dam Vinh Hung"), lbFb = new PanelLineInfo("Facebook","www.facebook.com/UsaltBold"), lbItem = new PanelLineInfo(
			"Item","15"), lbPoint = new PanelLineInfo("Point","350"), lbCoin = new PanelLineInfo("Coin","2500$");
	Button btViewItem = new Button("View"), btCharge = new Button("Charge");

	public PanelInfo() {
		super();
		init();
		style();
	}

	private void style() {
		addStyleName(ClientBundleMobile.INST.get().style().pnMyPageInfo());
	}

	private void init() {
		avatar();
		baseinfo();
	}

	private void baseinfo() {
		VerticalPanel vp = new VerticalPanel();
		Style style = vp.getElement().getStyle();
//		CSSUtils.Mobile.setSizePercent(vp, 0.7f, 0.2f);
		style.setPaddingLeft(10, Unit.PCT);
		style.setMarginTop(2.5, Unit.PCT);
		add(vp);

		vp.add(lbName);
		vp.add(lbItem);

		btViewItem.addStyleName(ClientBundleMobile.INST.get().style().btSS());
		style = btViewItem.getElement().getStyle();
		style.setDisplay(Display.INLINE);
		lbItem.add(btViewItem);

		vp.add(lbPoint);

		btCharge.addStyleName(ClientBundleMobile.INST.get().style().btSS());
		style = btCharge.getElement().getStyle();
		style.setDisplay(Display.INLINE);
		
		lbCoin.add(btCharge);
		vp.add(lbCoin);
	}

	private void avatar() {
		imgAvatar.setResource(ClientBundleMobile.INST.get().avatarNotAvailable());
		CSSUtils.Mobile.setSizePercent(imgAvatar, 0.3f, 0.2f);
		Style style = imgAvatar.getElement().getStyle();
		style.setPaddingLeft(15, Unit.PCT);
		add(imgAvatar);
	}

	public static class PanelLineInfo extends HorizontalPanel {

		public Label lbBold = new Label();
		public Label lbContent = new Label();

		public PanelLineInfo(String boldText) {
			super();
			initLabelBold(boldText);
			style();
		}
		
		public PanelLineInfo(String boldText, String content) {
			this(boldText);
			lbContent.setText(" "+content);
		}

		private void style() {
			Style style = getElement().getStyle();
			style.setMarginBottom(8.5, Unit.PCT);
		}

		private void initLabelBold(String boldText) {
			lbBold.setText(boldText + " : ");
			CSSUtils.Mobile.setWidthPercent(lbBold, 0.22f);
			Style style = lbBold.getElement().getStyle();
			style.setFontWeight(FontWeight.BOLD);
			style.setFontSize(120, Unit.PCT);
			add(lbBold);

			lbContent.setText(" Unknow");
			style = lbContent.getElement().getStyle();
			style.setFontSize(120, Unit.PCT);
			add(lbContent);
			
//			add(new Button("Button"));
		}

		public void setText(String text) {
			lbContent.setText(text);
		}

	}

}
