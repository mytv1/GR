package giddyhero.soccersystem.client.mobile.activities.store;

import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.share.CSSUtils;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.mgwt.ui.client.widget.panel.scroll.ScrollPanel;

public class PanelStore extends VerticalPanel {

	PanelSearch pnSearch = new PanelSearch();
	Label lbMostSelled = new Label("Most Selled"), lbNewRelease = new Label("New Release"), lbSaleOff = new Label("Sale Off");
	PanelItemList pnMostSell = new PanelItemList(), pnNewRelease = new PanelItemList(), pnSaleOff = new PanelItemList();
	
	public PanelStore() {
		super();
		init();
		style();
	}

	private void style() {
		lbMostSelled.addStyleName(ClientBundleMobile.INST.get().style().lbTitle());
		CSSUtils.Mobile.setWidthPercent(lbMostSelled, 0.9f);
		
		lbNewRelease.addStyleName(ClientBundleMobile.INST.get().style().lbTitle());
		CSSUtils.Mobile.setWidthPercent(lbNewRelease, 0.9f);
		
		lbSaleOff.addStyleName(ClientBundleMobile.INST.get().style().lbTitle());
		CSSUtils.Mobile.setWidthPercent(lbSaleOff, 0.9f);
	}

	private void init() {
		add(pnSearch);
		add(lbMostSelled);
		add(pnMostSell);
		add(lbNewRelease);
		add(pnNewRelease);
		add(lbSaleOff);
		add(pnSaleOff);
	}

	class PanelSearch extends HorizontalPanel {
		public static final float HEIGHT = 0.1f;
		TextBox tbSearch = new TextBox();
		Image imgSearch = new Image(ClientBundleMobile.INST.get().icSearch());

		public PanelSearch() {
			super();
			init();
			style();
		}

		private void style() {
			CSSUtils.Mobile.setSizePercent(tbSearch, 0.4f, 0.03f);
			CSSUtils.Mobile.setSizePercent(imgSearch, 0.075f, 0.05f);

			Style style = getElement().getStyle();
			style.setMargin(3, Unit.PCT);
			style.setMarginLeft(30, Unit.PCT);

			style = imgSearch.getElement().getStyle();
			style.setMarginLeft(50, Unit.PCT);
			
		}

		private void init() {
			add(tbSearch);
			add(imgSearch);
		}
	}

	class PanelItemList extends ScrollPanel {
		HorizontalPanel pnContainer = new HorizontalPanel();

		public PanelItemList() {
			super();
			init();
			style();
			setTempData();
		}

		private void setTempData() {
			pnContainer.add(new PanelItem(ClientBundleMobile.INST.get().playerShirtTemp(),
					"Christiano Ronaldo - Real Mandrid - Home - 14-15"));
			pnContainer.add(new PanelItem(ClientBundleMobile.INST.get().icItemBall(), "Worldcup 14-15's ball"));
			pnContainer.add(new PanelItem(ClientBundleMobile.INST.get().icItemJacket(), "Arsenal - Jacket - 14-15"));
			pnContainer.add(new PanelItem(ClientBundleMobile.INST.get().icItemShoe(),
					"Messi - Barcalona - Shoe - 14-15"));
			pnContainer.add(new PanelItem(ClientBundleMobile.INST.get().icItemStadium(), "Stadium - Real Madrid"));
			pnContainer.add(new PanelItem(ClientBundleMobile.INST.get().icItemTrophy(), "Trophy - Premier League"));
			pnContainer.add(new PanelItem(ClientBundleMobile.INST.get().icItemWhistle(), "Whistle - Colina - 14-15"));
		}

		private void init() {
			add(pnContainer);
		}

		private void style() {
			CSSUtils.Mobile.setWidthPercent(this, 1f);
		}
	}
}
