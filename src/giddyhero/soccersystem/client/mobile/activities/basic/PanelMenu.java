package giddyhero.soccersystem.client.mobile.activities.basic;

import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.share.CSSUtils;

import com.google.gwt.canvas.dom.client.Context2d.TextAlign;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

public class PanelMenu extends FlowPanel{
	public final static float WIDTH = 0.6f, HEIGHT = 1f;
	HorizontalPanel pnHeader = new HorizontalPanel();
	PanelSelector[] pnSelectors = new PanelSelector[6];
	
	public PanelMenu() {
		super();
		initBaseParam();
		initPanelHeader();
		initPanelSelector();
	}
	
	public void setHighlight(String place){
		PanelSelector pnSelector = null;
		if (place.equalsIgnoreCase("news"))
			pnSelector = pnSelectors[1];
		else if (place.equalsIgnoreCase("livescore"))
			pnSelector = pnSelectors[2];
		else if (place.equalsIgnoreCase("league"))
			pnSelector = pnSelectors[3];
		else if (place.equalsIgnoreCase("teams"))
			pnSelector = pnSelectors[4];
		else if (place.equalsIgnoreCase("games"))
			pnSelector = pnSelectors[5];
		if (pnSelector != null)
		{
			for (PanelSelector selector : pnSelectors) {
				if (selector != pnSelector)
					selector.getElement().getStyle().setBackgroundColor("#dfe2e2");
				else
					selector.getElement().getStyle().setBackgroundColor("#aaaaaa");	
			}
			
			
		}
	}
	

	private void initPanelSelector() {
		add(new Line());
		pnSelectors[0] = new PanelSelector(ClientBundleMobile.INST.get().icMenuMyPage());
		add(pnSelectors[0]);
		add(new Line());
		pnSelectors[1] = new PanelSelector(ClientBundleMobile.INST.get().icMenuNews());
		add(pnSelectors[1]);
		add(new Line());
		pnSelectors[2] = new PanelSelector(ClientBundleMobile.INST.get().icMenuLiveScore());
		add(pnSelectors[2]);
		add(new Line());
		pnSelectors[3] = new PanelSelector(ClientBundleMobile.INST.get().icMenuLeague());
		add(pnSelectors[3]);
		add(new Line());
		pnSelectors[4] = new PanelSelector(ClientBundleMobile.INST.get().icMenuTeams());
		add(pnSelectors[4]);
		add(new Line());
		pnSelectors[5] = new PanelSelector(ClientBundleMobile.INST.get().icMenuGames());
		add(pnSelectors[5]);
		add(new Line());
	}

	private void initBaseParam() {
		CSSUtils.Mobile.setSizePercent(this, 0.6f, 1f);
		getElement().getStyle().setBorderStyle(BorderStyle.SOLID);
	}

	private void initPanelHeader() {
		Style style;
		CSSUtils.Mobile.setSizePercent(pnHeader, 0.6f, 0.15f);
		add(pnHeader);
		
		Image imgLogo = new Image(ClientBundleMobile.INST.get().icLogo());
		style = imgLogo.getElement().getStyle();
		CSSUtils.Mobile.setSizePercent(imgLogo, 0.2f, 0.1f);
		style.setMargin(17.3, Unit.PCT);
		pnHeader.add(imgLogo);
		
		Label lbTitle = new Label("Soccer Network");
		CSSUtils.Mobile.setWidthPercent(lbTitle, 0.3f);
		lbTitle.getElement().getStyle().setTextAlign(Style.TextAlign.CENTER);
		lbTitle.getElement().getStyle().setFontSize(18, Unit.PX);
		lbTitle.getElement().getStyle().setFontWeight(FontWeight.BOLD);
		lbTitle.getElement().getStyle().setMarginTop(18.5, Unit.PCT);
		pnHeader.add(lbTitle);
	}
	
	class Line extends Image{
		
		public Line(){
			super(ClientBundleMobile.INST.get().icMenuLine());
			style();
		}

		private void style() {
			CSSUtils.Mobile.setSizePercent(Line.this, 0.54f, 0.005f);
			getElement().getStyle().setMarginLeft(3, Unit.PCT);
			getElement().getStyle().setMarginRight(3, Unit.PCT);
		}
	}

	class PanelSelector extends FlowPanel{
		Image img;
		final static float HEIGHT = 0.075f;
		
		public PanelSelector(ImageResource img) {
			super();
			initBaseParam();
			initImage(img);
		}
		
		public void initBaseParam() {
			CSSUtils.Mobile.setSizePercent(PanelSelector.this, WIDTH, HEIGHT);
		}


		private void initImage(ImageResource resource) {
			img = new Image(resource);
			CSSUtils.Mobile.setSizePercent(img, WIDTH, HEIGHT);
			add(img);
		}
	}
}
