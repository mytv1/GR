package giddyhero.soccersystem.client.mobile.activities.match;

import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.share.CSSUtils;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.WidgetCollection;

public class PanelMatchEvent extends VerticalPanel {

	public PanelMatchEvent() {
		super();
		init();
		style();

	}

	public void setTempBasicData() {
		add(new PanelEventGoal(true, "25", "Alexis Sanchez"));
		add(new PanelEventGoal(true, "35", "Christiano Ronaldo"));
		add(new PanelEventGoal(true, "45+1", "Ramadel Falcao"));
		add(new PanelEventGoal(false, "65", "Ibrahimovic"));
	}

	public void setTempComplexData() {
		add(new PanelEventGoal(true, "25", "Alexis Sanchez"));
		add(new PanelEventGoal(true, "35", "Christiano Ronaldo"));
		add(new PanelEventChangePlayer(true, "36", "Alexis Sanchez", "Zanetti"));
		add(new PanelEventCard(true, "38", "Christiano Ronaldo", false));
		add(new PanelEventGoal(true, "45+1", "Ramadel Falcao"));
		add(new PanelEventGoal(false, "65", "Ibrahimovic"));
		add(new PanelEventCard(false, "68", "Ibrahimovic", true));
		add(new PanelEventChangePlayer(false, "68", "Ibrahimovic", "Diego Costa"));
		
		setHightLine();
	}

	private void setHightLine() {
		WidgetCollection collection = getChildren();
		for (int i = 0;i < collection.size();i++) {
			Widget widget = collection.get(i);
			if (i % 2 == 0)
				widget.getElement().getStyle().setBackgroundColor("#989898");
		}
	}

	private void init() {

	}

	private void style() {
		addStyleName(ClientBundleMobile.INST.get().style().pnMatchInfo());
	}

	class PanelEventLine extends HorizontalPanel {
		boolean isHome = true;
		protected HorizontalPanel hpLeft = new HorizontalPanel();
		protected HorizontalPanel hpRight = new HorizontalPanel();
		protected Label lbTime = new Label("");
		Image imgEvent = new Image();
		Label lbContent = new Label();

		public PanelEventLine(boolean isHome) {
			super();
			this.isHome = isHome;
			CSSUtils.Mobile.setWidthPercent(this, 0.9f);
			getElement().getStyle().setMarginLeft(5, Unit.PCT);
			
			CSSUtils.Mobile.setWidthPercent(hpLeft, 0.4f);
			CSSUtils.Mobile.setWidthPercent(lbTime, 0.1f);
			CSSUtils.Mobile.setWidthPercent(hpRight, 0.4f);
			setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
			hpLeft.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
			hpRight.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

			imgEvent.addStyleName(ClientBundleMobile.INST.get().style().imgEvent());
			CSSUtils.Mobile.setSizePercent(imgEvent, 0.04f, 0.025f);

			lbContent.addStyleName(ClientBundleMobile.INST.get().style().lbEventContent());
			lbContent.getElement().getStyle().setMarginLeft(20, Unit.PCT);
			CSSUtils.Mobile.setWidthPercent(lbContent, 0.25f);

			lbTime.addStyleName(ClientBundleMobile.INST.get().style().lbEventContent());

			super.add(hpLeft);
			super.add(lbTime);
			super.add(hpRight);
		}

		@Override
		public void add(Widget w) {
			if (isHome)
				hpLeft.add(w);
			else
				hpRight.add(w);
		}

	}

	class PanelEventGoal extends PanelEventLine {

		public PanelEventGoal(boolean isHome, String minutes, String playerName) {
			super(isHome);

			lbTime.setText("(" + minutes + ")");

			imgEvent.setResource(ClientBundleMobile.INST.get().icBall());
			add(imgEvent);

			lbContent.setText(playerName);
			add(lbContent);
		}

	}

	class PanelEventCard extends PanelEventLine {

		public PanelEventCard(boolean isHome, String minutes, String playerName, boolean isYellowCard) {
			super(isHome);

			lbTime.setText("(" + minutes + ")");

			if (isYellowCard)
				imgEvent.setResource(ClientBundleMobile.INST.get().icYellowCard());
			else
				imgEvent.setResource(ClientBundleMobile.INST.get().icRedCard());
			add(imgEvent);

			lbContent.setText(playerName);
			add(lbContent);
		}
	}

	class PanelEventChangePlayer extends PanelEventLine {

		public PanelEventChangePlayer(boolean isHome, String minutes, String playerOut, String playerIn) {
			super(isHome);

			lbTime.setText("(" + minutes + ")");

			imgEvent.setResource(ClientBundleMobile.INST.get().icChangePlayer());
			add(imgEvent);

			lbContent.setText("" + playerOut + " --> " + playerIn);
			add(lbContent);
		}
	}
}