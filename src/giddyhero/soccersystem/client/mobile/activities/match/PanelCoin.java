package giddyhero.soccersystem.client.mobile.activities.match;

import giddyhero.soccersystem.client.share.CSSUtils;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.googlecode.mgwt.ui.client.widget.button.Button;

public class PanelCoin extends HorizontalPanel {

	Label lbTitle = new Label("Your Coins : "), lbCoins = new Label("789");
	Button btCharge = new Button("Charge");
	float HEIGHT = 0.05f;

	public PanelCoin() {
		super();
		add(lbTitle);
		add(lbCoins);
		add(btCharge);
		init();
		style();
	}

	private void init() {
	}

	private void style() {
		CSSUtils.Mobile.setSizePercent(PanelCoin.this, 0.5f, HEIGHT);
		CSSUtils.Mobile.setSizePercent(lbTitle, 0.2f, HEIGHT);
		CSSUtils.Mobile.setSizePercent(lbCoins, 0.1f, HEIGHT);
		CSSUtils.Mobile.setWidthPercent(btCharge, 0.2f);

		Style style = getElement().getStyle();
		style.setMarginLeft(25, Unit.PCT);
		style.setBackgroundColor("#787878");
		style.setColor("#FFFFFF");

		style = lbTitle.getElement().getStyle();
		style.setTextAlign(TextAlign.CENTER);
		style.setMarginTop(20, Unit.PCT);

		style = lbCoins.getElement().getStyle();
		style.setTextAlign(TextAlign.CENTER);
		style.setFontSize(150, Unit.PCT);
		style.setMarginTop(30, Unit.PCT);
	}

}