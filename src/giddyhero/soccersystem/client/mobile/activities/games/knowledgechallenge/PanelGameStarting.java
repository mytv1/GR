package giddyhero.soccersystem.client.mobile.activities.games.knowledgechallenge;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicViewImpl;
import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.share.CSSUtils;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.widget.button.Button;

public class PanelGameStarting extends VerticalPanel {
	Label lbTitle = new Label("Rule Pack"), lbQuestionTitle = new Label("Question :"), lbChallengeTitle = new Label(
			"Challenge :"), lbPointTitle = new Label("Point : "), lbTimeTitle = new Label("Time : ");
	Label lbQuestion = new Label("20"), lbChallenge = new Label("80%"), lbPoint = new Label("5"), lbTime = new Label(
			"60s");
	Button btStart = new Button("Start");
	FlexTable tblInfo = new FlexTable();

	public PanelGameStarting() {
		super();
		init();
		style();
		setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
	}

	private void init() {
		add(lbTitle);

		tblInfo.setWidget(0, 0, lbQuestionTitle);
		tblInfo.setWidget(1, 0, lbChallengeTitle);
		tblInfo.setWidget(2, 0, lbPointTitle);
		tblInfo.setWidget(3, 0, lbTimeTitle);

		tblInfo.setWidget(0, 1, lbQuestion);
		tblInfo.setWidget(1, 1, lbChallenge);
		tblInfo.setWidget(2, 1, lbPoint);
		tblInfo.setWidget(3, 1, lbTime);

		add(tblInfo);

		btStart.addTapHandler(new TapHandler() {
			
			@Override
			public void onTap(TapEvent event) {
				BasicViewImpl.pnMain.pnMiddle.clear();
				BasicViewImpl.pnMain.pnMiddle.add(new PanelGamePlaying());
				
//				VerticalPanel parent = (VerticalPanel) PanelGameStarting.this.getParent();
//				PanelGameStarting.this.removeFromParent();
//				parent.add(new PanelGamePlaying());
			}
		});
		add(btStart);
	}

	private void style() {
		CSSUtils.Mobile.setSizePercent(PanelGameStarting.this, 1.0f, 1.0f);

		Style style = lbTitle.getElement().getStyle();
		style.setFontSize(250, Unit.PCT);
		style.setFontWeight(FontWeight.BOLD);
		style.setTextAlign(TextAlign.CENTER);
		style.setPadding(5, Unit.PCT);
		style.setBackgroundColor("#787878");
		style.setColor("#FFFFFF");

		style = tblInfo.getElement().getStyle();
		style.setBorderStyle(BorderStyle.SOLID);
		style.setBackgroundColor("#787878");
		style.setProperty("borderRadius", "10%");
		CSSUtils.Mobile.setSizePercent(tblInfo, 0.7f, 0.35f);

		style.setBackgroundImage(ClientBundleMobile.INST.get().gamePackRule().getName());
		CSSUtils.setMarginCenter(tblInfo);

		style = btStart.getElement().getStyle();
		style.setWidth(90, Unit.PCT);
		style.setHeight(35, Unit.PCT);
		style.setFontSize(250, Unit.PCT);

		lbQuestionTitle.addStyleName(ClientBundleMobile.INST.get().style().lbGameStaringPn());
		lbQuestionTitle.addStyleName(ClientBundleMobile.INST.get().style().lbGameStaringPn());
		lbChallengeTitle.addStyleName(ClientBundleMobile.INST.get().style().lbGameStaringPn());
		lbPointTitle.addStyleName(ClientBundleMobile.INST.get().style().lbGameStaringPn());
		lbTimeTitle.addStyleName(ClientBundleMobile.INST.get().style().lbGameStaringPn());

		lbQuestion.addStyleName(ClientBundleMobile.INST.get().style().lbGameStaringPnValue());
		lbChallenge.addStyleName(ClientBundleMobile.INST.get().style().lbGameStaringPnValue());
		lbPoint.addStyleName(ClientBundleMobile.INST.get().style().lbGameStaringPnValue());
		lbTime.addStyleName(ClientBundleMobile.INST.get().style().lbGameStaringPnValue());

		tblInfo.setCellSpacing(20);
	}

}
