package giddyhero.soccersystem.client.mobile.activities.mypage;


import giddyhero.soccersystem.client.mobile.activities.mypage.PanelFavoritePlayerList.TeamWidget;
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

public class PanelFavoriteTeamList extends VerticalPanel{

	Button btAdd = new Button("Add Your Favourite Team");
	
	public PanelFavoriteTeamList() {
		super();
		btAdd.addStyleName(ClientBundleMobile.INST.get().style().btSSLarge());
		add(btAdd);
		
		PlayerWidget teamWidget1 = new PlayerWidget();
		teamWidget1.lbName.setText("Barcalona");
		teamWidget1.lbDescription.setText("Spain - Champion League attemp");
		teamWidget1.imgLogo.setResource(ClientBundleMobile.INST.get().icTeamLogoTemp());
		teamWidget1.lbNote.setText("Next Match : 24-4-2015  Real Madrid  (2 days left)");
		teamWidget1.setPerfomance(new int[]{1,1,0,-1,1});
		add(teamWidget1);
		
		PlayerWidget teamWidget2 = new PlayerWidget();
		teamWidget2.lbName.setText("Arsenal");
		teamWidget2.lbDescription.setText("England - 4nd in Premier League");
		teamWidget2.imgLogo.setResource(ClientBundleMobile.INST.get().icTeamLogoTemp2());
		teamWidget2.lbNote.setText("Playing!  (64') Arsenal 2 - 2 Liverpool");
		teamWidget2.setPerfomance(new int[]{1,0,-1,1,1});
		add(teamWidget2);
	}
	
	
	class PlayerWidget extends HorizontalPanel{
		
		public Image imgLogo = new Image();
		public Label lbName = new Label(), lbDescription = new Label(), lbNote = new Label();
		Image[] imgPerformance = new Image[5];
		
		public PlayerWidget() {
			super();
			init();
			style();
		}

		private void style() {
			CSSUtils.Mobile.setSizePercent(PlayerWidget.this, 0.95f, 0.2f);
			Style style = getElement().getStyle();
			style.setBorderStyle(BorderStyle.SOLID);
			style.setBackgroundColor(CSSUtils.Mobile.BACKGROUND_COLOR);
			style.setColor(CSSUtils.Mobile.TEXT_COLOR);
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
			vp.getElement().getStyle().setMarginTop(5, Unit.PCT);
			add(vp);
			
			style = lbName.getElement().getStyle();
			style.setFontSize(150, Unit.PCT);
			style.setFontWeight(FontWeight.BOLD);
			vp.add(lbName);
			
			vp.add(lbDescription);
			
			HorizontalPanel hp = new HorizontalPanel();
			vp.add(hp);
			for (int i = 0;i < 5; i++) {
				imgPerformance[i] = new Image();
				hp.add(imgPerformance[i]);
			}
			
			lbNote.setSize("225px", "30px");
			style = lbNote.getElement().getStyle();
			style.setFontWeight(FontWeight.BOLD);
			vp.add(lbNote);
		}
		
		public void setPerfomance(int[] pers){
			if (pers.length < 5)
				return;
			for (int i = 0; i < pers.length; i++) {
				switch (pers[i]) {
				case 1:
					imgPerformance[i].setResource(ClientBundleMobile.INST.get().icWin());
					break;
				case 0:
					imgPerformance[i].setResource(ClientBundleMobile.INST.get().icDraw());
					break;
				case -1:
					imgPerformance[i].setResource(ClientBundleMobile.INST.get().icLose());
					break;
				default:
					break;
				}
			}
		}
	}

}
