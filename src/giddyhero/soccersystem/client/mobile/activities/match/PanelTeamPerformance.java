package giddyhero.soccersystem.client.mobile.activities.match;

import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.share.CSSUtils;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class PanelTeamPerformance extends VerticalPanel{

	PanelTeamWinRatePerformance pnPerformance = new PanelTeamWinRatePerformance();
	PanelTextInfoPerformance pnText = new PanelTextInfoPerformance();
	
	public PanelTeamPerformance() {
		super();
		init();
		style();
	}

	private void style() {
		addStyleName(ClientBundleMobile.INST.get().style().pnPerformance());
	}

	private void init() {
		add(pnPerformance);
		add(pnText);
	}

	class PanelTeamWinRatePerformance extends HorizontalPanel{
		
		public PanelTeamWinRatePerformance() {
			super();
			CSSUtils.Mobile.setSizePercent(this, 0.5f,0.1f);
			setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
			style();
			setTempData();
		}

		private void style(){
			Style style = getElement().getStyle();
			style.setMarginLeft(2.5, Unit.PCT);
		}
	
		
		private void setTempData() {
			for (int i = 0; i < 5; i++) {
				add(new ImagePerformance());
				
			}
		}
		
		class ImagePerformance extends Image{
			
			public ImagePerformance() {
				super();
				temp();
			}

			private void temp() {
				int i = Random.nextInt()%3;
				switch (i) {
				case 0:
					setResource(ClientBundleMobile.INST.get().icWin());
					break;
				case 1:
					setResource(ClientBundleMobile.INST.get().icDraw());
					break;
				case 2:
					setResource(ClientBundleMobile.INST.get().icLose());
					break;
				default:
					setResource(ClientBundleMobile.INST.get().icWin());
					break;
				}
				
			}
		}
	}
	
	class PanelTextInfoPerformance extends VerticalPanel{
		
		public PanelTextInfoPerformance() {
			super();
			init();
		}
		
		private void init(){
			Label lbInfo = new Label("Barca has 5 win in row");
			lbInfo.getElement().getStyle().setMargin(3, Unit.PCT);
			add(lbInfo);
			
			 lbInfo = new Label("When against Arsenal, Barca won 75%");
			lbInfo.getElement().getStyle().setMargin(3, Unit.PCT);
			add(lbInfo);
			
			 lbInfo = new Label("Barca win 80% match in home this season");
			lbInfo.getElement().getStyle().setMargin(3, Unit.PCT);
			add(lbInfo);
			
			 lbInfo = new Label("Barca goals average is 4.5 > Arsenal = 2.4");
			lbInfo.getElement().getStyle().setMargin(3, Unit.PCT);
			add(lbInfo);
			
			 lbInfo = new Label("Barca has full position for this game");
			lbInfo.getElement().getStyle().setMargin(3, Unit.PCT);
			add(lbInfo);
		}
	}
}
