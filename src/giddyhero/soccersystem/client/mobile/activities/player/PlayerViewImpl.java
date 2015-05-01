package giddyhero.soccersystem.client.mobile.activities.player;

import com.google.gwt.user.client.ui.Label;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicViewImpl;
import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.share.CSSUtils;

public class PlayerViewImpl extends BasicViewImpl implements PlayerView {

	Label lbTitle = new Label("Info"), lbStatistics = new Label("Statistics");
	PanelPlayerInfo pnInfo = new PanelPlayerInfo();
	
	public PlayerViewImpl() {
		super();
		init();
		style();
	}

	private void style() {
		CSSUtils.Mobile.setWidthPercent(lbTitle, 0.9f);
		CSSUtils.Mobile.setWidthPercent(lbStatistics, 0.9f);
		lbTitle.addStyleName(ClientBundleMobile.INST.get().style().lbTitle());
		lbStatistics.addStyleName(ClientBundleMobile.INST.get().style().lbTitle());
	}

	private void init() {
		pnMain.pnMiddle.add(lbTitle);
		pnMain.pnMiddle.add(pnInfo);
		pnMain.pnMiddle.add(lbStatistics);
	}

}
