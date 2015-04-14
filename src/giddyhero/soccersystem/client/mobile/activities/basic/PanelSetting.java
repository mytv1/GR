package giddyhero.soccersystem.client.mobile.activities.basic;


import giddyhero.soccersystem.client.share.CSSUtils;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class PanelSetting extends VerticalPanel{
	PanelHeader pnHeader;
	
	public PanelSetting() {
		super();
		initBaseParam();
		initPanelHeader();
	}
	
	private void initPanelHeader() {
		pnHeader = new PanelHeader();
		add(pnHeader);
	}

	private void initBaseParam() {
		CSSUtils.Mobile.setSizePercent(this, 0.6f, 1f);
		
	}

	public class PanelHeader extends HorizontalPanel{
		Label lbTitle = new Label("Setting");
		final static float HEIGHT = 0.2f;
		
		public PanelHeader(){
			super();
			initBaseParam();
			initLabelTitle();
		}
		
		private void initLabelTitle() {
			lbTitle.getElement().getStyle().setFontSize(400, Unit.PCT);
			lbTitle.getElement().getStyle().setTextAlign(Style.TextAlign.CENTER);
			add(lbTitle);
		}

		private void initBaseParam() {
			CSSUtils.Mobile.setSizePercent(PanelHeader.this, 0.6f, HEIGHT);
			
		}
	}
	
	public class PanelElement extends FlowPanel{
		
		public PanelElement() {
			super();
		}
	}

}
