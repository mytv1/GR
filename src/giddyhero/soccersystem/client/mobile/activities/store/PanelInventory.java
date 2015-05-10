package giddyhero.soccersystem.client.mobile.activities.store;

import giddyhero.soccersystem.client.mobile.activities.match.PanelCoin;
import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.share.CSSUtils;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.mgwt.ui.client.widget.panel.scroll.ScrollPanel;

public class PanelInventory extends VerticalPanel{
	
	PanelSort pnSort = new PanelSort();
	PanelCoin pnCoin = new PanelCoin();
	PanelMyItem pnMyItem = new PanelMyItem();
	Label lbMyItem = new Label("My Item"), lbCoins = new Label("Coins");
	
	public PanelInventory() {
		super();
		init();
		style();
		
	}

	private void init() {
		add(lbCoins);
		add(pnCoin);
		add(lbMyItem);
		add(pnSort);
		
		ScrollPanel sp = new ScrollPanel();
		sp.setWidget(pnMyItem);
		CSSUtils.Mobile.setSizePercent(sp, 1f, 0.7f);
		add(pnMyItem);
	}

	private void style() {
		CSSUtils.Mobile.setWidthPercent(lbCoins, 0.9f);
		lbCoins.addStyleName(ClientBundleMobile.INST.get().style().lbTitle());
		
		CSSUtils.Mobile.setWidthPercent(lbMyItem, 0.9f);
		lbMyItem.addStyleName(ClientBundleMobile.INST.get().style().lbTitle());
	}

	class PanelMyItem extends FlowPanel{
		
		public PanelMyItem() {
			super();
			setTempData();
			style();
		}
		
		private void setTempData() {
			add(new PanelItem(ClientBundleMobile.INST.get().playerShirtTemp(), "Christiano Ronaldo - Real Mandrid - Home - 14-15"));
			add(new PanelItem(ClientBundleMobile.INST.get().icItemBall(), "Worldcup 14-15's ball"));
			add(new PanelItem(ClientBundleMobile.INST.get().icItemJacket(), "Arsenal - Jacket - 14-15"));
			add(new PanelItem(ClientBundleMobile.INST.get().icItemShoe(), "Messi - Barcalona - Shoe - 14-15"));
			add(new PanelItem(ClientBundleMobile.INST.get().icItemStadium(), "Stadium - Real Madrid"));
			add(new PanelItem(ClientBundleMobile.INST.get().icItemTrophy(), "Trophy - Premier League"));
			add(new PanelItem(ClientBundleMobile.INST.get().icItemWhistle(), "Whistle - Colina - 14-15"));
		}

		private void style(){
			CSSUtils.Mobile.setWidthPercent(PanelMyItem.this, 1.0f);
			Style style = getElement().getStyle();
			style.setMarginLeft(1, Unit.PCT);
		}
	}
	
	class PanelSort extends HorizontalPanel{
		Label lbTitle = new Label("Sort By");
		ListBox lbTypes = new ListBox();
		
		public PanelSort() {
			super();
			init();
			style();
		}

		private void init() {
			add(lbTitle);
			
			lbTypes.addItem("All");
			lbTypes.addItem("Name");
			lbTypes.addItem("Type");
			lbTypes.addItem("Price");
			add(lbTypes);
		}

		private void style() {
			Style style = getElement().getStyle();
			style.setPaddingLeft(5, Unit.PCT);
			
			CSSUtils.Mobile.setWidthPercent(lbTitle, 0.2f);
			style = lbTitle.getElement().getStyle();
			style.setFontSize(130, Unit.PCT);
			style.setPadding(10, Unit.PCT);
			
			CSSUtils.Mobile.setSizePercent(lbTypes, 0.4f,0.05f);
		}
	}
}
