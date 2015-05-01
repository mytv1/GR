package giddyhero.soccersystem.client.mobile.activities.match;

import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.share.CSSUtils;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class PanelMatchInfo extends VerticalPanel {

	Label lbStatus = new Label("Playing"), lbPerformance = new Label("Performance");
	PanelMatchDetail1 pnNextMatch = new PanelMatchDetail1();
	PanelTeamPerformance pnPerformanceHome = new PanelTeamPerformance(),
			pnPerformanceAway = new PanelTeamPerformance();

	public PanelMatchInfo() {
		super();
		init();
		style();
	}

	private void init() {
		add(lbStatus);
		add(pnNextMatch);
		add(lbPerformance);
		
		HorizontalPanel hp = new HorizontalPanel();
		CSSUtils.Mobile.setWidthPercent(hp, 1.0f);
		add(hp);
		hp.add(pnPerformanceHome);
		hp.add(pnPerformanceAway);
	}

	private void style() {
		lbStatus.addStyleName(ClientBundleMobile.INST.get().style().lbTitle());
		lbPerformance.addStyleName(ClientBundleMobile.INST.get().style().lbTitle());
	}

}
