package giddyhero.soccersystem.client.mobile.activities.store;

import giddyhero.soccersystem.client.share.CSSUtils;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.Float;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class PanelItem extends VerticalPanel {

	Image img = new Image();
	Label lbDescription = new Label();

	public PanelItem() {
		super();
		init();
		style();
	}

	public PanelItem(ImageResource resource, String des) {
		this();
		img.setResource(resource);
		lbDescription.setText(des);
	}

	private void style() {
		CSSUtils.Mobile.setSizePercent(this, 0.3f, 0.25f);
		CSSUtils.Mobile.setSizePercent(img, 0.25f, 0.15f);
		CSSUtils.Mobile.setSizePercent(lbDescription, 0.28f, 0.05f);
		Style style = getElement().getStyle();
		style.setFloat(Float.LEFT);
		style.setMargin(1, Unit.PCT);

		style = img.getElement().getStyle();
		style.setMarginLeft(8, Unit.PCT);
		style.setBorderStyle(BorderStyle.SOLID);
		style.setBorderColor("black");
		
		style = lbDescription.getElement().getStyle();
		style.setFontWeight(FontWeight.BOLD);
		style.setMarginLeft(3, Unit.PCT);
	}

	private void init() {
		add(img);
		add(lbDescription);

	}

}
