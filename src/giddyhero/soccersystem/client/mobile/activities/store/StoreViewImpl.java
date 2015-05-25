package giddyhero.soccersystem.client.mobile.activities.store;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicViewImpl;
import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.mobile.widget.SSTabBarButton;
import giddyhero.soccersystem.client.mobile.widget.SSTabPanel;
import giddyhero.soccersystem.client.share.CSSUtils;

import com.google.gwt.dom.client.Style.Unit;
import com.googlecode.mgwt.ui.client.widget.panel.scroll.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabBarAppearance;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabBarButton;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabPanel;

public class StoreViewImpl extends BasicViewImpl implements StoreView {
	PanelInventory pnInventory = new PanelInventory();
	PanelStore pnStore = new PanelStore();
	SSTabPanel tabPanel = new SSTabPanel();
	SSTabBarButton btInventory = new SSTabBarButton(ClientBundleMobile.INST.get().icInventory(), "Inventory"),
			btStore = new SSTabBarButton(ClientBundleMobile.INST.get().icStore(), "Store");
	
	public StoreViewImpl() {
		super();
		init();
	}

	private void init() {
		
		CSSUtils.Mobile.setSizePercent(tabPanel, 1f, 0.91f);
		
		ScrollPanel sp = new ScrollPanel(); 
		sp.setWidget(pnInventory);
		CSSUtils.Mobile.setSizePercent(sp, 1f, 0.82f);
		tabPanel.add(btInventory, sp);
		
		sp = new ScrollPanel();
		sp.setWidget(pnStore);
		CSSUtils.Mobile.setSizePercent(sp, 1f, 0.82f);
		tabPanel.add(btStore,sp);
		
		tabPanel.setSelectionHandler(btInventory, btStore);
		
		pnMain.pnMiddle.add(tabPanel);
		
		pnMain.pnScroll.setScrollingEnabledY(false);
	}
	

}
