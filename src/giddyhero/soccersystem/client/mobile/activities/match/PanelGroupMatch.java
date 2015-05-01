package giddyhero.soccersystem.client.mobile.activities.match;

import giddyhero.soccersystem.shared.model.MatchDetailShort;

import java.util.List;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;


public class PanelGroupMatch extends VerticalPanel {

	Label lbGroupTitle = new Label();
	VerticalPanel vpMatches = new VerticalPanel();

	List<MatchDetailShort> matchList;

	public PanelGroupMatch(String title) {
		super();
		initBaseParam();
		initElements(title);
	}

	private void initBaseParam() {
		Style style;
		style = getElement().getStyle();
		style.setBackgroundColor("#eeeeee");
		style.setMarginBottom(2, Unit.PCT);
	}

	private void initElements(String title) {

		Style style;
		lbGroupTitle.setText(title);
		style = lbGroupTitle.getElement().getStyle();
		style.setBackgroundColor("#666666");
		style.setPadding(1, Unit.PCT);
		style.setColor("#FFFFFF");
		add(lbGroupTitle);

		add(vpMatches);
	}

	public void setMatchList(List<MatchDetailShort> matchList) {
		this.matchList = matchList;
		for (MatchDetailShort matchDetailShort : matchList) {
			PanelMatch pnMatch = new PanelMatch(matchDetailShort);
			vpMatches.add(pnMatch);

		}
	}

	public void setMatchDetailShort(MatchDetailShort matchDetailShort) {
		PanelMatch pnMatch = new PanelMatch(matchDetailShort);
		vpMatches.add(pnMatch);
	}
}