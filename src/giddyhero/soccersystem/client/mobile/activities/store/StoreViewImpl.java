package giddyhero.soccersystem.client.mobile.activities.store;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicViewImpl;
import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.share.CSSUtils;

import com.google.gwt.dom.client.Style.Unit;
import com.googlecode.mgwt.ui.client.widget.panel.scroll.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabBarAppearance;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabBarButton;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabPanel;

public class StoreViewImpl extends BasicViewImpl implements StoreView {
	PanelInventory pnInventory = new PanelInventory();
	PanelStore pnStore = new PanelStore();
	
	public StoreViewImpl() {
		super();
		init();
	}

	private void init() {
		TabPanel tabPanel = new TabPanel();
		CSSUtils.Mobile.setSizePercent(tabPanel, 1f, 0.9f);
		
		ScrollPanel sp = new ScrollPanel(); 
		sp.setWidget(pnInventory);
		CSSUtils.Mobile.setSizePercent(sp, 1f, 0.82f);
		tabPanel.add(new ButtonInventory(), sp);
		
		sp = new ScrollPanel();
		sp.setWidget(pnStore);
		CSSUtils.Mobile.setSizePercent(sp, 1f, 0.82f);
		tabPanel.add(new ButtonStore(),sp);
		
		pnMain.pnMiddle.add(tabPanel);
		
		pnMain.pnScroll.setScrollingEnabledY(false);
	}
	
	class ButtonInventory  extends TabBarButton {

		public ButtonInventory() {
			this(TabPanel.DEFAULT_APPEARANCE);
		}

		public ButtonInventory(TabBarAppearance appearance) {
			super(appearance, ClientBundleMobile.INST.get().icInventory(),
					 ClientBundleMobile.INST.get().icInventoryBack());

			setText("Inventory");
			text.getStyle().setTop(2, Unit.PX);
		}
	}
	
	class ButtonStore  extends TabBarButton {

		public ButtonStore() {
			this(TabPanel.DEFAULT_APPEARANCE);
		}

		public ButtonStore(TabBarAppearance appearance) {
			super(appearance, ClientBundleMobile.INST.get().icStore(),
					 ClientBundleMobile.INST.get().icStoreBack());

			setText("Store");
			text.getStyle().setTop(2, Unit.PX);
		}
	}




}
