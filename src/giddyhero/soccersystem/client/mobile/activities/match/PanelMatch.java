package giddyhero.soccersystem.client.mobile.activities.match;

import giddyhero.soccersystem.client.share.CSSUtils;
import giddyhero.soccersystem.shared.model.MatchDetailShort;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;


public class PanelMatch extends HorizontalPanel {
	Label lbTime = new Label(), lbHome = new Label(), lbAway = new Label(), lbVS = new Label(" VS ");
	Image imgHome = new Image(), imgAway = new Image();
	final static float HEIGHT = 0.06f, WIDTH = 0.98f;
	MatchDetailShort match;

	public PanelMatch(MatchDetailShort match) {
		this();
		setMatchDetailShort(match);
	}

	public PanelMatch() {
		super();
		initBaseParam();
		initElements();
	}

	private void initElements() {
		Style style;
		CSSUtils.Mobile.setSizePercent(lbTime, 0.1f, HEIGHT);
		style = lbTime.getElement().getStyle();
		style.setBackgroundColor("#bbbbbb");
		style.setTextAlign(Style.TextAlign.CENTER);
		style.setPaddingTop(7, Unit.PCT);
		add(lbTime);

		style = lbHome.getElement().getStyle();
		style.setFontSize(150, Unit.PCT);
		style.setPaddingTop(7, Unit.PCT);
		add(lbHome);

		CSSUtils.Mobile.setSizePercent(imgHome, 0.075f, HEIGHT * 0.9f);
		style = imgHome.getElement().getStyle();
		style.setMarginTop(10, Unit.PCT);
		add(imgHome);

		style = lbVS.getElement().getStyle();
		style.setFontSize(120, Unit.PCT);
		style.setPaddingTop(30, Unit.PCT);
		style.setColor("#888888");
		style.setFontWeight(Style.FontWeight.BOLD);
		add(lbVS);

		CSSUtils.Mobile.setSizePercent(imgAway, 0.075f, HEIGHT * 0.9f);
		style = imgAway.getElement().getStyle();
		style.setMarginTop(10, Unit.PCT);
		add(imgAway);

		style = lbAway.getElement().getStyle();
		style.setFontSize(150, Unit.PCT);
		style.setPaddingTop(7, Unit.PCT);
		add(lbAway);
	}

	private void initBaseParam() {
		CSSUtils.Mobile.setSizePercent(PanelMatch.this, WIDTH, HEIGHT);
		Style style = getElement().getStyle();
		style.setBackgroundColor("#cccccc");
		style.setMargin(1, Unit.PCT);

	}

	public void setMatchDetailShort(MatchDetailShort match) {
		this.match = match;
		lbTime.setText(match.time);
		lbHome.setText(match.homeName);
		imgHome.setUrl(match.homeUrl);
		lbAway.setText(match.awayName);
		imgAway.setUrl(match.awayUrl);

		String text = match.score.equalsIgnoreCase("") ? " VS " : match.score;
		lbVS.setText(text);
	}
}
