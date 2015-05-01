package giddyhero.soccersystem.client.mobile.activities.match;

import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.share.CSSUtils;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.dom.client.Style.VerticalAlign;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class PanelMatchStatistics extends VerticalPanel{
	
	Label lbTitle = new Label("Statistics");
	
	public PanelMatchStatistics() {
		super();
		init();
		style();
	}

	private void style() {
		Style style = getElement().getStyle();
		style.setVerticalAlign(VerticalAlign.MIDDLE);
		lbTitle.addStyleName(ClientBundleMobile.INST.get().style().lbTitle());
	}

	private void init() {
		add(lbTitle);
		add(new PanelStatisticsLine("Possession", 38, 62));
		add(new PanelStatisticsLine("Shot on", 2, 4));
		add(new PanelStatisticsLine("Shot off", 5, 6));
		add(new PanelStatisticsLine("Corner", 2, 6));
		add(new PanelStatisticsLine("Offside", 4, 3));
		add(new PanelStatisticsLine("Fouls", 10, 1));
		add(new PanelStatisticsLine("Yellow Card", 1, 0));
		add(new PanelStatisticsLine("Goal kicks", 4, 9));
		add(new PanelStatisticsLine("Treatment", 1, 1));
	}

	class PanelStatisticsLine extends HorizontalPanel{
		Label lbTitle = new Label();
		BarStat barHome = new BarStat(), barAway = new BarStat();
		float  HEIGHT= 0.05f;
		
		public PanelStatisticsLine(String content, int homePoint, int awayPoint) {
			super();
			init();
			style();
			lbTitle.setText(content);
			float percent = ((float)homePoint/((float)(homePoint+awayPoint)));
			barHome.init(true, percent, homePoint);
			barAway.init(false, (1-percent), awayPoint);
		}

		private void style() {
			CSSUtils.Mobile.setSizePercent(this, 0.9f, HEIGHT);
			Style style = getElement().getStyle();
			style.setMarginLeft(5, Unit.PCT);
			style.setVerticalAlign(VerticalAlign.MIDDLE);
			
//			Window.alert("HEIGHT : "+lbTitle);
//			CSSUtils.Mobile.setHeightPercent(lbTitle, HEIGHT);
			
			CSSUtils.Mobile.setWidthPercent(lbTitle, 0.2f);
			style = lbTitle.getElement().getStyle();
			style.setVerticalAlign(VerticalAlign.MIDDLE);
			style.setPaddingTop(10, Unit.PCT);
			style.setFontWeight(FontWeight.BOLD);
			style.setTextAlign(TextAlign.CENTER);
			
			CSSUtils.Mobile.setHeightPercent(barHome, HEIGHT);
			style = barHome.getElement().getStyle();
			style.setVerticalAlign(VerticalAlign.MIDDLE);
			
			CSSUtils.Mobile.setHeightPercent(barAway, HEIGHT);
			style = barAway.getElement().getStyle();
			style.setVerticalAlign(VerticalAlign.MIDDLE);
		}

		private void init() {
			add(barHome);
			add(lbTitle);
			add(barAway);
		}
		
		class BarStat extends HorizontalPanel{
			Label lbHome = new Label(""), lbAway = new Label(""), lbPoint = new Label();
			float WIDTH = 0.3f;
			HorizontalPanel hpBar = new HorizontalPanel();

			public BarStat() {
				super();
				style();
			}

			private void style() {
				CSSUtils.Mobile.setSizePercent(this, WIDTH+0.05f,HEIGHT);
				CSSUtils.Mobile.setWidthPercent(lbPoint, 0.05f);
				lbPoint.getElement().getStyle().setTextAlign(TextAlign.CENTER);
				lbHome.getElement().getStyle().setTextAlign(TextAlign.CENTER);
				lbAway.getElement().getStyle().setTextAlign(TextAlign.CENTER);
				setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
			}

			public void init(boolean isHome, float percent,int point) {
				lbPoint.setText(""+point);				
				if (isHome)
				{
					add(lbPoint);
					
					add(hpBar);
					CSSUtils.Mobile.setWidthPercent(lbAway, (1-percent)*WIDTH);
					hpBar.add(lbAway);
					
					lbHome.setText(""+Math.round((percent*100))+"%");
					CSSUtils.Mobile.setWidthPercent(lbHome, percent*WIDTH);
					lbHome.getElement().getStyle().setBackgroundColor("#FFFF00");
					hpBar.add(lbHome);
				}else
				{
					add(hpBar);
					lbAway.setText(""+Math.round((percent*100))+"%");
					lbAway.getElement().getStyle().setBackgroundColor("#FFFF00");
					CSSUtils.Mobile.setWidthPercent(lbAway, percent*WIDTH);
					hpBar.add(lbAway);
					
					CSSUtils.Mobile.setWidthPercent(lbHome, (1-percent)*WIDTH);
					hpBar.add(lbHome);
					add(lbPoint);
				}
				
				Style style = hpBar.getElement().getStyle();
				style.setBorderStyle(BorderStyle.SOLID);
				if (percent > 0.5f)
					style.setBorderWidth(4, Unit.PX);
				else
					style.setBorderWidth(1, Unit.PX);
				
			}
		}
	}
}
