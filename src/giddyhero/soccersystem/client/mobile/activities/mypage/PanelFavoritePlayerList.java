package giddyhero.soccersystem.client.mobile.activities.mypage;

import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.share.CSSUtils;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.mgwt.ui.client.widget.button.Button;

public class PanelFavoritePlayerList extends VerticalPanel {

	Button btAdd = new Button("Add Player");

	public PanelFavoritePlayerList() {
		super();
		add(btAdd);

		TeamWidget teamWidget1 = new TeamWidget();
		teamWidget1.lbName.setText("Lionel Messi");
		teamWidget1.lbNational.setText("Nation : Argentina");
		teamWidget1.lbHeight.setText("Height : 171");
		teamWidget1.lbTeam.setText("Team : Barcalona");
		teamWidget1.imgLogo.setResource(ClientBundleMobile.INST.get().icPlayerTemp1());
		teamWidget1.lbNote.setText("Next Match : 24-4-2015  Real Madrid  (2 days left)");
		add(teamWidget1);

		TeamWidget teamWidget2 = new TeamWidget();
		teamWidget2.lbName.setText("Christiano Ronaldo");
		teamWidget2.lbNational.setText("Nation : Portugal");
		teamWidget2.lbHeight.setText("Height : 185");
		teamWidget2.lbTeam.setText("Team : Real Madrid");
		teamWidget2.imgLogo.setResource(ClientBundleMobile.INST.get().icPlayerTemp2());
		teamWidget2.lbNote.setText("Playing!  (89') Real Madrid 2 - 2 Aletico Madrid");
		add(teamWidget2);
	}

	class TeamWidget extends HorizontalPanel {

		public Image imgLogo = new Image();
		public Label lbName = new Label(), lbNational = new Label(), lbTeam = new Label(), lbNote = new Label(),
				lbHeight = new Label();
		

		public TeamWidget() {
			super();
			init();
			style();
		}

		private void style() {
			CSSUtils.Mobile.setSizePercent(TeamWidget.this, 0.95f, 0.2f);
			Style style = getElement().getStyle();
			style.setBorderStyle(BorderStyle.SOLID);
			style.setBackgroundColor("#9d9d9d");
			style.setMarginLeft(2.5, Unit.PCT);
			style.setMarginBottom(2.5, Unit.PCT);
			style.setProperty("borderTopLeftRadius", "10px");
			style.setProperty("borderTopRightRadius", "10px");
			style.setProperty("borderBottomLeftRadius", "10px");
			style.setProperty("borderBottomRightRadius", "10px");
		}

		private void init() {
			Style style;
			CSSUtils.Mobile.setSizePercent(imgLogo, 0.25f, 0.15f);
			style = imgLogo.getElement().getStyle();
			style.setMargin(7.5, Unit.PCT);
			add(imgLogo);

			VerticalPanel vp = new VerticalPanel();
			add(vp);

			style = lbName.getElement().getStyle();
			style.setFontSize(150, Unit.PCT);
			style.setFontWeight(FontWeight.BOLD);
			vp.add(lbName);
			
			vp.add(lbNational);
			vp.add(lbTeam);
			vp.add(lbHeight);

			HorizontalPanel hp = new HorizontalPanel();
			vp.add(hp);

			lbNote.setSize("225px", "30px");
			style = lbNote.getElement().getStyle();
			style.setFontWeight(FontWeight.BOLD);
			vp.add(lbNote);
		}
	}

}
