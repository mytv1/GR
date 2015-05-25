package giddyhero.soccersystem.client.manager.ui.widget;

import giddyhero.soccersystem.client.manager.widget.GHFlowPanel;
import giddyhero.soccersystem.client.share.CSSUtils;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Label;

public class ButtonMenuLevel2 extends FocusPanel {

	protected Label lbName = null;
	protected GHFlowPanel ghFlowPanel = new GHFlowPanel();
	final String BACKGROUND_COLOR = "darkgray";

	public ButtonMenuLevel2(String name) {
		super();
		style();
		init();
		initGHFlowPanel();
		initNameLabel(name);
	}

	private void style() {
		Style style = ghFlowPanel.getElement().getStyle();
		style.setBackgroundColor(CSSUtils.Manager.MENU_BACKGROUND_COLOR);
		style.setColor(CSSUtils.Manager.MENU_TEXT_COLOR);
	
	}

	public Style getFlowPanelStyle() {
		return ghFlowPanel.getElement().getStyle();
	}

	private void init() {
		addMouseOutHandler(new MouseOutHandler() {

			@Override
			public void onMouseOut(MouseOutEvent event) {
				ghFlowPanel.setBackgroundColor(CSSUtils.Manager.MENU_BACKGROUND_COLOR);
			}
		});

		addMouseOverHandler(new MouseOverHandler() {

			@Override
			public void onMouseOver(MouseOverEvent event) {
				ghFlowPanel.setBackgroundColor(CSSUtils.Manager.MENU_BACKGROUND_HIGH_LIGHT);

			}
		});
	}

	private void initGHFlowPanel() {
		ghFlowPanel.getElement().getStyle().setCursor(Cursor.POINTER);
		ghFlowPanel.setWidth("100%");
		ghFlowPanel.setPostion("relative");
		ghFlowPanel.setHeight(30);
		add(ghFlowPanel);
	}

	private void initNameLabel(String name) {
		lbName = new Label(name);
//		lbName.setFontSize("medium");
//		lbName.setFontWeight("bold");
//		lbName.setPostion("absolute");
//		lbName.setLeft(40);
//		lbName.setTop(5);
		CSSUtils.setFontSize(lbName, "medium");
		CSSUtils.setFontWeight(lbName, "bold");
		CSSUtils.setPosition(lbName, "absolute");
		CSSUtils.setLeft(lbName, 40);
		CSSUtils.setTop(lbName, 5);
		// lbName.setBottom(10);

		ghFlowPanel.add(lbName);
	}
	
	public GHFlowPanel getGhFlowPanel() {
		return ghFlowPanel;
	}
	
	public Label getLbName() {
		return lbName;
	}
}
