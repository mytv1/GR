package giddyhero.soccersystem.client.mobile.activities.match;

import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.share.CSSUtils;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.mgwt.ui.client.widget.button.Button;

public class PanelMatchBetting extends VerticalPanel {

	Label lbTitle = new Label("Betting"), lbResult = new Label("Result"), lbScore = new Label("Score");
	PanelCoin pnCoin = new PanelCoin();
	PanelBettingResult pnResult = new PanelBettingResult();
	PanelBettingScore pnScore = new PanelBettingScore();

	public PanelMatchBetting() {
		super();
		init();
		style();
	}

	private void init() {
		add(lbTitle);
		add(pnCoin);
		add(lbResult);
		add(pnResult);
		add(lbScore);
		add(pnScore);
	}

	private void style() {
		lbTitle.addStyleName(ClientBundleMobile.INST.get().style().lbTitle());
		lbResult.addStyleName(ClientBundleMobile.INST.get().style().lbTitle());
		lbScore.addStyleName(ClientBundleMobile.INST.get().style().lbTitle());
		
		CSSUtils.Mobile.setWidthPercent(lbTitle, 0.9f);
		CSSUtils.Mobile.setWidthPercent(lbResult, 0.4f);
		CSSUtils.Mobile.setWidthPercent(lbScore, 0.4f);
	}

	

	class PanelBettingResult extends VerticalPanel {
		Label  lbHome = new Label("Barcalona Win"), lbDraw = new Label("Draw"),
				lbAway = new Label("Arsenal Win"), lbHomeRate = new Label("0.5"), lbDrawRate = new Label("2.0"), lbAwayRate = new Label("2.5");
		Button btSave = new Button("Save");
		TextBox tbHome = new TextBox(), tbDraw = new TextBox(), tbAway = new TextBox();
		FlexTable tblBetting = new FlexTable();

		public PanelBettingResult() {
			super();
			init();
			style();
		}

		private void init() {
			tblBetting.setWidget(0, 0, lbHome);
			tblBetting.setWidget(0, 1, lbDraw);
			tblBetting.setWidget(0, 2, lbAway);
			
			tblBetting.setWidget(1, 0, lbHomeRate);
			tblBetting.setWidget(1, 1, lbDrawRate);
			tblBetting.setWidget(1, 2, lbAwayRate);
			
			tblBetting.setWidget(2, 0, tbHome);
			tblBetting.setWidget(2, 1, tbDraw);
			tblBetting.setWidget(2, 2, tbAway);
			
			add(tblBetting);
			add(btSave);
		}

		private void style() {
			CSSUtils.Mobile.setWidthPercent(PanelBettingResult.this, 0.9f);
			CSSUtils.Mobile.setWidthPercent(tblBetting, 0.9f);
			CSSUtils.Mobile.setWidthPercent(tbHome, 0.25f);
			CSSUtils.Mobile.setWidthPercent(tbDraw, 0.25f);
			CSSUtils.Mobile.setWidthPercent(tbAway, 0.25f);
			Style style = getElement().getStyle();
			style.setMargin(3, Unit.PCT);
			style.setPadding(2, Unit.PCT);
			style.setBackgroundColor("#787878");
			style.setColor("#FFFFFF");

			style = btSave.getElement().getStyle();
			style.setMarginLeft(37, Unit.PCT);
			style.setWidth(20, Unit.PCT);

			style = tblBetting.getElement().getStyle();
			style.setTextAlign(TextAlign.CENTER);
		}
	}
	
	class PanelBettingScore extends VerticalPanel{
		FlexTable tblScore = new FlexTable();
		Label lbHome = new Label("Barcalona"), lbAway = new Label("Arsenal"), lbScore = new Label("Score"), lbBet = new Label("Your Bet ");
		TextBox tbHome = new TextBox(), tbAway = new TextBox(), tbCoin = new TextBox();
		Button btSave = new Button("Save");
		HorizontalPanel hp = new HorizontalPanel();
		
		public PanelBettingScore() {
			super();
			init();
			style();
		}
		
		private void init(){
			tblScore.setWidget(0, 0, lbHome);
			tblScore.setWidget(0, 2, lbAway);
			
			tblScore.setWidget(1, 0, tbHome);
			tblScore.setText(1, 1, ":");
			tblScore.setWidget(1, 2, tbAway);
			
			add(tblScore);
			
//			hp.add(new Label("Your Bet : "));
//			hp.add(tbCoin);
			
			add(lbBet);
			add(tbCoin);
			add(btSave);
		}
		
		private void style(){
			CSSUtils.Mobile.setWidthPercent(PanelBettingScore.this, 0.9f);
			CSSUtils.Mobile.setWidthPercent(tblScore, 0.9f);
			CSSUtils.Mobile.setWidthPercent(tbHome, 0.2f);
			CSSUtils.Mobile.setWidthPercent(tbAway, 0.2f);
			CSSUtils.Mobile.setWidthPercent(tbCoin, 0.3f);
			Style style = getElement().getStyle();
			style.setMargin(3, Unit.PCT);
			style.setPadding(2, Unit.PCT);
			style.setBackgroundColor("#787878");
			style.setColor("#FFFFFF");
			
			style = tblScore.getElement().getStyle();
			style.setTextAlign(TextAlign.CENTER);
			
			style = lbBet.getElement().getStyle();
			style.setMarginLeft(43, Unit.PCT);
			
			style = tbCoin.getElement().getStyle();
			style.setMarginLeft(32, Unit.PCT);
			
			style = btSave.getElement().getStyle();
			style.setMarginLeft(37, Unit.PCT);
			style.setWidth(20, Unit.PCT);
		}
	}
}
