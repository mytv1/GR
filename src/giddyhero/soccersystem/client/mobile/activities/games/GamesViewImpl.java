package giddyhero.soccersystem.client.mobile.activities.games;

import giddyhero.soccersystem.client.MobileEntryPoint;
import giddyhero.soccersystem.client.mobile.activities.basic.BasicViewImpl;
import giddyhero.soccersystem.client.mobile.activities.games.knowledgechallenge.GameKCPlace;
import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.share.CSSUtils;
import giddyhero.soccersystem.client.share.CSSUtils.Mobile;
import giddyhero.soccersystem.shared.model.News;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class GamesViewImpl extends BasicViewImpl implements GamesView {

	public GamesViewImpl() {
		super();
		setHasMenuButtonMode();
		init();
	}

	private void init() {
		pnMain.pnHeader.lbTitle.setText("Games");
		Game game1 = new Game(ClientBundleMobile.INST.get().game1(), "Knowledge Challenge (Offline)",
				"How much you know about your favorite team? Let's challenge and take some awsome item.");
		Game game2 = new Game(ClientBundleMobile.INST.get().game5(), "Fan Fighting (Online)",
				"Do you want a match of fan before match begin? Your knowledge is your weapon. Let's fight.");
		Game game3 = new Game(ClientBundleMobile.INST.get().game3(), "Bet (Online)",
				"Easy to be rick, you know that. Let's bet some item and wait till the match end.");
		Game game4 = new Game(ClientBundleMobile.INST.get().game4(), "Free Kick (Offline)",
				"Show to your friend your soccer's skill. Let's enjoy it when you are waiting the match.");
		Game game5 = new Game(ClientBundleMobile.INST.get().game2(), "Predict (Online)",
				"You know which score will be, let's predict for free and get the points.");
		
		pnMain.pnMiddle.add(new ClickableContainer(game1));
		pnMain.pnMiddle.add(new ClickableContainer(game2));
		pnMain.pnMiddle.add(new ClickableContainer(game3));
		pnMain.pnMiddle.add(new ClickableContainer(game4));
		pnMain.pnMiddle.add(new ClickableContainer(game5));
	}
	
	class ClickableContainer extends FocusPanel{
		PanelGameIntro pnGameIntro;
		
		public ClickableContainer(Game game) {
			super();
			pnGameIntro = new PanelGameIntro(game);
			add(pnGameIntro);
			addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					MobileEntryPoint.clientFactory.getPlaceController().goTo(new GameKCPlace());
				}
			});
		}
		
	}

	class PanelGameIntro extends HorizontalPanel {

		Image imgIcon = new Image();
		Label lbTitle = new Label(), lbDescription = new Label();

		public PanelGameIntro(Game game) {
			super();
			
			CSSUtils.Mobile.setWidthPercent(PanelGameIntro.this, 0.95f);
			Style style = getElement().getStyle();
			style.setBorderStyle(BorderStyle.SOLID);
			style.setMargin(2, Unit.PCT);
			
			style = imgIcon.getElement().getStyle();
			imgIcon.setResource(game.imgIcon);
			add(imgIcon);
			CSSUtils.Mobile.setSizePercent(imgIcon, 0.25f, 0.15f);
			style.setPadding(5, Unit.PCT);

			VerticalPanel vp = new VerticalPanel();
			style = vp.getElement().getStyle();
			style.setPadding(5, Unit.PCT);
			add(vp);

			lbTitle.setText(game.title);
			style = lbTitle.getElement().getStyle();
			style.setFontWeight(FontWeight.BOLD);
			style.setFontSize(150, Unit.PCT);
			vp.add(lbTitle);

			lbDescription.setText(game.description);
			style = lbDescription.getElement().getStyle();
			style.setPaddingTop(5, Unit.PCT);
			vp.add(lbDescription);
			
		}
	}

	class Game {
		public ImageResource imgIcon;
		public String title = "Title", description = "Description";

		public Game(ImageResource imgIcon, String title, String description) {
			this.imgIcon = imgIcon;
			this.title = title;
			this.description = description;
		}
	}
}
