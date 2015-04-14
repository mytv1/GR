package giddyhero.soccersystem.client.mobile.activities.basic;

import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.share.CSSUtils;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.mgwt.ui.client.widget.panel.scroll.ScrollEndEvent;
import com.googlecode.mgwt.ui.client.widget.panel.scroll.ScrollEndEvent.Handler;
import com.googlecode.mgwt.ui.client.widget.panel.scroll.ScrollPanel;

public class PanelMain extends VerticalPanel {
	public PanelHeader pnHeader;
	public ScrollPanel pnScroll = new ScrollPanel();
	public VerticalPanel pnMiddle = new VerticalPanel();

	public PanelMain() {
		super();
		initBaseParam();
		initPanelHeader();
		initPanelScroll();
	}

	private void initPanelScroll() {
		CSSUtils.Mobile.setSizePercent(pnScroll, 1f, 0.925f);
		pnScroll.add(pnMiddle);
		add(pnScroll);
		pnScroll.addScrollEndHandler(new Handler() {

			@Override
			public void onScrollEnd(ScrollEndEvent event) {
				pnScroll.refresh();
			}
		});

	}

	private void initPanelHeader() {
		pnHeader = new PanelHeader();
		add(pnHeader);
	}

	private void initBaseParam() {
		CSSUtils.Mobile.setSizePercent(this, 1f, 1f);
		getElement().getStyle().setBorderStyle(BorderStyle.SOLID);
	}

	public class PanelHeader extends HorizontalPanel {

		public Image imgMenu;
		public Label lbTitle;
		public Image imgSetting;
		final static float HEIGHT = 0.075f;

		public PanelHeader() {
			super();
			initBaseParam();
			initMenuImage();
			initLabelTitle();
			initImageSetting();
		}

		private void initImageSetting() {
			imgSetting = new Image(ClientBundleMobile.INST.get().icSetting());
			CSSUtils.Mobile.setSizePercent(imgSetting, 0.1f, HEIGHT);
			add(imgSetting);
		}

		private void initLabelTitle() {
			lbTitle = new Label("News");
			CSSUtils.Mobile.setSizePercent(lbTitle, 0.75f, HEIGHT);
			lbTitle.getElement().getStyle().setTextAlign(Style.TextAlign.CENTER);
			lbTitle.getElement().getStyle().setFontSize(300, Unit.PCT);
			add(lbTitle);
		}

		private void initMenuImage() {
			imgMenu = new Image(ClientBundleMobile.INST.get().icMenu());
			CSSUtils.Mobile.setSizePercent(imgMenu, 0.1f, HEIGHT);
			add(imgMenu);

		}

		private void initBaseParam() {
			CSSUtils.Mobile.setSizePercent(this, 1f, HEIGHT);
			getElement().getStyle().setProperty("borderTopWidth", "0px");
			getElement().getStyle().setProperty("borderLeftWidth","0px");
			getElement().getStyle().setProperty("borderBottomWidth", "2%");
			getElement().getStyle().setProperty("borderRightWidth", "0px");
			getElement().getStyle().setProperty("borderBottomColor", "#aaaaaa");
			getElement().getStyle().setBorderStyle(BorderStyle.SOLID);
		}
	}
}

