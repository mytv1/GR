package giddyhero.soccersystem.client.mobile.activities.basic;

import giddyhero.soccersystem.client.MobileEntryPoint;
import giddyhero.soccersystem.client.mobile.activities.games.GamesPlace;
import giddyhero.soccersystem.client.mobile.activities.home.HomePlace;
import giddyhero.soccersystem.client.mobile.activities.league.LeaguePlace;
import giddyhero.soccersystem.client.mobile.activities.livescore.LiveScorePlace;
import giddyhero.soccersystem.client.mobile.activities.mypage.MyPagePlace;
import giddyhero.soccersystem.client.mobile.activities.teams.TeamPlace;
import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;

public class BasicViewImpl extends HorizontalPanel implements BasicView {

	public static PanelMenu pnMenu = new PanelMenu();
	public static PanelMain pnMain = new PanelMain();
	public static PanelSetting pnSetting = new PanelSetting();
	public static HandlerRegistration hrMenuClick, hrBackClick;
	static {

		pnMain.pnHeader.imgSetting.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				boolean isVisible = pnSetting.isVisible();
				pnSetting.setVisible(!isVisible);
				if (!isVisible) {
					pnMain.getElement().getStyle().setMarginLeft(-60, Unit.PCT);
				} else
					pnMain.getElement().getStyle().setMarginLeft(0, Unit.PCT);
			}
		});

		pnMenu.pnSelectors[2].img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				MobileEntryPoint.clientFactory.getPlaceController().goTo(new LiveScorePlace());
				pnMenu.setHighlight("livescore");
			
			}
		});

		pnMenu.pnSelectors[1].img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				MobileEntryPoint.clientFactory.getPlaceController().goTo(new HomePlace());
				pnMenu.setHighlight("news");
			}
		});
		
		pnMenu.pnSelectors[5].img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				MobileEntryPoint.clientFactory.getPlaceController().goTo(new GamesPlace());
				pnMenu.setHighlight("games");
			}
		});
		
		pnMenu.pnSelectors[4].img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				MobileEntryPoint.clientFactory.getPlaceController().goTo(new TeamPlace());
				pnMenu.setHighlight("teams");
			}
		});
		
		pnMenu.pnSelectors[0].img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				MobileEntryPoint.clientFactory.getPlaceController().goTo(new MyPagePlace());
				pnMenu.setHighlight("mypage");
			}
		});
		
		
		pnMenu.pnSelectors[3].img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				MobileEntryPoint.clientFactory.getPlaceController().goTo(new LeaguePlace());
				pnMenu.setHighlight("league");
			}
		});
	}

	public BasicViewImpl() {
		super();
		initPanelMenu();
		initPanelMain();
		initPanelSetting();
		setHasMenuButtonMode();
		setDefaultState();
	}

	public static void setHasMenuButtonMode() {
		if (hrMenuClick == null) {
			pnMain.pnHeader.imgMenu.setResource(ClientBundleMobile.INST.get().icMenu());
			hrMenuClick = pnMain.pnHeader.imgMenu.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					pnMenu.setVisible(!pnMenu.isVisible());
				}
			});
		}
		if (hrBackClick != null) {
			hrBackClick.removeHandler();
			hrBackClick = null;
		}
	}

	public static void setStandAloneViewMode() {
		if (hrMenuClick != null)
		{
			hrMenuClick.removeHandler();
			hrMenuClick = null;
		}
		if (hrBackClick == null) {
			pnMain.pnHeader.imgMenu.setResource(ClientBundleMobile.INST.get().icBack());
			hrBackClick = pnMain.pnHeader.imgMenu.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					History.back();
				}
			});

		}
	}

	private void initPanelSetting() {
		pnSetting.setVisible(false);
		add(pnSetting);

	}

	private void initPanelMain() {
		pnMain.pnMiddle.clear();
		add(pnMain);

	}

	private void initPanelMenu() {
		add(pnMenu);
	}

	@Override
	public VerticalPanel getPanelMiddle() {
		return pnMain.pnMiddle;
	}

	@Override
	public Image getImageMenu() {
		return pnMain.pnHeader.imgMenu;
	}

	public static void setDefaultState() {
		pnMenu.setVisible(false);
		pnMain.pnScroll.setScrollingEnabledY(true);
	}

	@Override
	public PanelMenu getPanelMenu() {
		return pnMenu;
	}

	@Override
	public void setHeaderTitle(String str) {
		pnMain.pnHeader.lbTitle.setText(str);
	}

}
