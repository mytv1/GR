package giddyhero.soccersystem.client.manager.ui.widget;

import giddyhero.soccersystem.client.manager.widget.GHFlowPanel;
import giddyhero.soccersystem.client.manager.widget.GHLabel;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.FocusPanel;

public class ButtonMenuLevel2 extends FocusPanel {

	protected GHLabel lbName = null;
	protected GHFlowPanel ghFlowPanel = new GHFlowPanel();

	public ButtonMenuLevel2(String name) {
		super();
		init();
		initGHFlowPanel();
		initNameLabel(name);
	}

	public Style getFlowPanelStyle() {
		return ghFlowPanel.getElement().getStyle();
	}

	private void init() {
		addMouseOutHandler(new MouseOutHandler() {

			@Override
			public void onMouseOut(MouseOutEvent event) {
				ghFlowPanel.setBackgroundColor("#FFFFFF");
			}
		});

		addMouseOverHandler(new MouseOverHandler() {

			@Override
			public void onMouseOver(MouseOverEvent event) {
				ghFlowPanel.setBackgroundColor("#EEEEEE");

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
		lbName = new GHLabel(name);
		lbName.setFontSize("medium");
		lbName.setFontWeight("bold");
		lbName.setPostion("absolute");
		lbName.setLeft(40);
		lbName.setTop(5);
		// lbName.setBottom(10);

		ghFlowPanel.add(lbName);
	}
	
	public GHFlowPanel getGhFlowPanel() {
		return ghFlowPanel;
	}
	
	public GHLabel getLbName() {
		return lbName;
	}
}
