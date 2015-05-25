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
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class PanelMenu extends FlowPanel{
	public final static float WIDTH = 0.6f, HEIGHT = 1f;
	HorizontalPanel pnHeader = new HorizontalPanel();
	PanelSelector[] pnSelectors = new PanelSelector[6];
//	static final String BACKGROUND_COLOR = "#898989";
//	static final String HIGHLIGHT_COLOR = "#ababab";
	static final String HEADER_BACKGROUND_COLOR = "black";
	static final String BACKGROUND_COLOR = "black";
	static final String HIGHLIGHT_COLOR = "green";
	
	public PanelMenu() {
		super();
		style();
		initBaseParam();
		initPanelHeader();
		initPanelSelector();
	}
	
	private void style() {
		Style style = pnHeader.getElement().getStyle();
//		style.setBackgroundColor("#565656");
		style.setBackgroundColor(HEADER_BACKGROUND_COLOR);
		style.setColor("white");
		style.setProperty("borderBottomStyle", "solid");
		style.setProperty("borderBottomColor", "darkgray");
		style.setProperty("borderBottomWidth", "2px");
		
		style = getElement().getStyle();
		style.setBackgroundColor(BACKGROUND_COLOR);
	}

	public void setHighlight(String place){
		PanelSelector pnSelector = null;
		if (place.equalsIgnoreCase("news"))
			pnSelector = pnSelectors[1];
		else if (place.equalsIgnoreCase("mypage"))
			pnSelector = pnSelectors[0];
		else if (place.equalsIgnoreCase("livescore"))
			pnSelector = pnSelectors[2];
		else if (place.equalsIgnoreCase("league"))
			pnSelector = pnSelectors[3];
		else if (place.equalsIgnoreCase("games"))
			pnSelector = pnSelectors[4];
		else if (place.equalsIgnoreCase("store"))
			pnSelector = pnSelectors[5];
		if (pnSelector != null)
		{
			for (PanelSelector selector : pnSelectors) {
				if (selector != pnSelector)
					selector.getElement().getStyle().setBackgroundColor(BACKGROUND_COLOR);
				else
					selector.getElement().getStyle().setBackgroundColor(HIGHLIGHT_COLOR);	
			}
			
			
		}
	}
	

	private void initPanelSelector() {
		VerticalPanel container = new VerticalPanel();
		
		pnSelectors[0] = new PanelSelector(ClientBundleMobile.INST.get().icMenuMyPage(),"My Page");
		container.add(pnSelectors[0]);
		pnSelectors[1] = new PanelSelector(ClientBundleMobile.INST.get().icMenuNews(),"News");
		container.add(pnSelectors[1]);
		pnSelectors[2] = new PanelSelector(ClientBundleMobile.INST.get().icMenuLiveScore(),"Live Score");
		container.add(pnSelectors[2]);
		pnSelectors[3] = new PanelSelector(ClientBundleMobile.INST.get().icMenuLeague(),"League");
		container.add(pnSelectors[3]);
		pnSelectors[4] = new PanelSelector(ClientBundleMobile.INST.get().icMenuGames(),"Games");
		container.add(pnSelectors[4]);
		pnSelectors[5] = new PanelSelector(ClientBundleMobile.INST.get().icMenuStore(),"Store");
		container.add(pnSelectors[5]);
		add(container);
	}

	private void initBaseParam() {
		CSSUtils.Mobile.setSizePercent(this, 0.6f, 1f);
		
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
		lbTitle.getElement().getStyle().setFontSize(150, Unit.PCT);
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
			CSSUtils.Mobile.setSizePercent(Line.this, 0.6f, 0.005f);
		}
	}

	class PanelSelector extends FocusPanel{
		HorizontalPanel container = new HorizontalPanel();
		Label lbTitle = new Label();
		Image img = new Image();
		SimplePanel spImageContainer = new SimplePanel(img);
		final static float HEIGHT = 0.1f;
		
		public PanelSelector(ImageResource img,String title) {
			super();
			initBaseParam();
			initImage(img);
			lbTitle.setText(title);
			style();
		}
		
		private void style(){
			Style style = container.getElement().getStyle();
			style.setProperty("borderBottomStyle", "solid");
			style.setProperty("borderBottomColor", "darkgray");
			style.setProperty("borderBottomWidth", "2px");
			
			style = img.getElement().getStyle();
			style.setMarginLeft(20, Unit.PCT);
			style.setMarginTop(5, Unit.PCT);

			style = lbTitle.getElement().getStyle();
			style.setColor("white");
			style.setFontSize(150, Unit.PCT);
			style.setMarginLeft(5, Unit.PCT);
			style.setMarginTop(15, Unit.PCT);
		}
		
		public void initBaseParam() {
			CSSUtils.Mobile.setSizePercent(container, WIDTH, HEIGHT);
			CSSUtils.Mobile.setSizePercent(spImageContainer, WIDTH*0.45f, HEIGHT);
			CSSUtils.Mobile.setSizePercent(img, WIDTH*0.25f, HEIGHT*0.75f);
			CSSUtils.Mobile.setWidthPercent(lbTitle, WIDTH*0.55f);
			
			container.add(spImageContainer);
			container.add(lbTitle);
			setWidget(container);
		}


		private void initImage(ImageResource resource) {
			img.setResource(resource);
		}
	}
}
