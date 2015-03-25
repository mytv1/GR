package giddyhero.soccersystem.client.manager.ui.widget;

import giddyhero.soccersystem.client.manager.widget.GHFlowPanel;
import giddyhero.soccersystem.client.manager.widget.GHLabel;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

public class ButtonMenuLevel1 extends GHFlowPanel{
	
	ButtonMenuLevel2 btParent;
	GHFlowPanel pnHolder = new GHFlowPanel();

	public ButtonMenuLevel1(String btParentName) {
		super();
		initBtParent(btParentName);
		initHolder();
	}
	
	
	private void initHolder() {
		add(pnHolder);
//		pnHolder.setWidth(btParent.getGhFlowPanel().getPixelWidth());
		pnHolder.setVisible(false);
	}


	private void initBtParent(String btParentName) {
		btParent = new ButtonMenuLevel2(btParentName);
		btParent.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				boolean isVisible = pnHolder.isVisible();
				pnHolder.setVisible(!isVisible);
			}
		});
		add(btParent);
	}
		
	
	public void addChildButton(ButtonMenuLevel2 button){
		pnHolder.add(button);
		setChildStyleToButton(button);
	}


	private void setChildStyleToButton(ButtonMenuLevel2 button) {
		GHLabel ghLabel = button.getLbName(); 
		ghLabel.setLeft(50);
		ghLabel.setFontSize("small");
		ghLabel.setFontWeight("normal");
	}

}
