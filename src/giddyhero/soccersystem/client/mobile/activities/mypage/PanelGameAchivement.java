package giddyhero.soccersystem.client.mobile.activities.mypage;

import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.mobile.widget.SSButton;
import giddyhero.soccersystem.client.share.CSSUtils;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.mgwt.ui.client.widget.button.Button;
import com.googlecode.mgwt.ui.client.widget.panel.scroll.ScrollPanel;

public class PanelGameAchivement extends ScrollPanel{
	VerticalPanel mainPanel = new VerticalPanel();
	
	public PanelGameAchivement() {
		super();
		GameWidget game1 = new GameWidget();
		game1.lbName.setText("Knowledge Challenge");
		game1.lbDescription.setText("Challenge your knowledge and get scores");
		game1.lbScore.setText("Score : 700");
		game1.lbRank.setText("World Rank : 15640");
		game1.imgLogo.setResource(ClientBundleMobile.INST.get().game1());
		game1.setAchivement(new int[]{1,2,2,1,1});
		
		GameWidget game2 = new GameWidget();
		game2.lbName.setText("Fan Fighting");
		game2.lbDescription.setText("Fighting with your friend by your knowledge");
		game2.lbScore.setText("Score : 700");
		game2.lbRank.setText("World Rank : 15640");
		game2.imgLogo.setResource(ClientBundleMobile.INST.get().game2());
		game2.setAchivement(new int[]{1,2,2});
		
		GameWidget game3 = new GameWidget();
		game3.lbName.setText("Free Kick");
		game3.lbDescription.setText("If you a player, what's score you can get?");
		game3.lbScore.setText("Score : 700");
		game3.lbRank.setText("World Rank : 15640");
		game3.imgLogo.setResource(ClientBundleMobile.INST.get().game4());
		game3.setAchivement(new int[]{3,2});
		
		mainPanel.add(game1);
		mainPanel.add(game2);
		mainPanel.add(game3);
		setWidget(mainPanel);
		CSSUtils.Mobile.setSizePercent(PanelGameAchivement.this, 1.0f, 0.83f);
	}

	class GameWidget extends HorizontalPanel{
		
		public Image imgLogo = new Image();
		public Label lbName = new Label(), lbDescription = new Label(), lbRank = new Label(), lbScore = new Label(), lbNote = new Label();
		Image[] imgAchivement = new Image[5];
		
		public GameWidget() {
			super();
			init();
			style();
		}

		private void style() {
			CSSUtils.Mobile.setSizePercent(GameWidget.this, 0.95f, 0.2f);
			Style style = getElement().getStyle();
			style.setBorderStyle(BorderStyle.SOLID);
			style.setBackgroundColor(CSSUtils.Mobile.BACKGROUND_COLOR);
			style.setColor(CSSUtils.Mobile.TEXT_COLOR);
			style.setMarginLeft(2.5, Unit.PCT);
			style.setMarginTop(1.5, Unit.PCT);
			style.setMarginBottom(1.5, Unit.PCT);
			style.setProperty("borderTopLeftRadius", "10px");
			style.setProperty("borderTopRightRadius", "10px");
			style.setProperty("borderBottomLeftRadius", "10px");
			style.setProperty("borderBottomRightRadius", "10px");
		}

		private void init() {
			Style style;
			VerticalPanel vp1 = new VerticalPanel();
			CSSUtils.Mobile.setSizePercent(imgLogo, 0.25f, 0.15f);
			style = imgLogo.getElement().getStyle();
			style.setMargin(7.5, Unit.PCT);
			vp1.add(imgLogo);
			SSButton btPlay = new SSButton("Play Now!");
			btPlay.getElement().getStyle().setMarginLeft(15, Unit.PCT);
			vp1.add(btPlay);
			add(vp1);
			
			VerticalPanel vp2 = new VerticalPanel();
			style = vp2.getElement().getStyle();
			style.setMarginLeft(7.5, Unit.PCT);
			style.setMarginTop(5, Unit.PCT);
			add(vp2);
			
			style = lbName.getElement().getStyle();
			style.setFontSize(150, Unit.PCT);
			style.setFontWeight(FontWeight.BOLD);
			vp2.add(lbName);
			
			lbDescription.setSize("255px", "30px");
			vp2.add(lbDescription);
			
			vp2.add(lbRank);
			
			vp2.add(lbScore);
			vp2.add(new Label("Achivement :"));
			
			HorizontalPanel hp = new HorizontalPanel();
			vp2.add(hp);
			for (int i = 0;i < 5; i++) {
				imgAchivement[i] = new Image();
				imgAchivement[i].setPixelSize(40, 40);
				hp.add(imgAchivement[i]);
			}
			
//			lbNote.setSize("235px", "30px");
//			style = lbNote.getElement().getStyle();
//			style.setFontWeight(FontWeight.BOLD);
//			vp2.add(lbNote);
		}
		
		public void setAchivement(int[] pers){
			for (int i = 0; i < pers.length; i++) {
				switch (pers[i]) {
				case 1:
					imgAchivement[i].setResource(ClientBundleMobile.INST.get().icAchivement1());
					break;
				case 2:
					imgAchivement[i].setResource(ClientBundleMobile.INST.get().icAchivement2());
					break;
				case 3:
					imgAchivement[i].setResource(ClientBundleMobile.INST.get().icAchivement3());
					break;
				default:
					break;
				}
			}
		}
	}
}
