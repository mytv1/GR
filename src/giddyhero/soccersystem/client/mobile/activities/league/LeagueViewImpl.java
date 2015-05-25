package giddyhero.soccersystem.client.mobile.activities.league;

import giddyhero.soccersystem.client.manager.widget.FocusParentPanel;
import giddyhero.soccersystem.client.mobile.activities.basic.BasicViewImpl;
import giddyhero.soccersystem.client.mobile.activities.league.LeagueViewImpl.PanelNationLeague.PanelLeague;
import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.share.CSSUtils;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class LeagueViewImpl extends BasicViewImpl implements LeagueView {

	List<PanelLeague>  pnLeagues = new ArrayList<>();
	
	public LeagueViewImpl() {
		super();
		setHasMenuButtonMode();
		init();
		pnMain.pnHeader.lbTitle.setText("Leagues");
	}


	@Override
	public List<PanelLeague> setData(List<MModelNation> nations) {

		for (MModelNation nation : nations) {
			PanelNationLeague pnNation = new PanelNationLeague();
			pnNation.setNation(nation);
			pnMain.pnMiddle.add(pnNation);
		}
		return pnLeagues;
	}

	private void init() {
	}


	class PanelNationLeague extends VerticalPanel {
		PanelHeader pnHeader = new PanelHeader();
		Image imgNation = new Image();

		public PanelNationLeague() {
			super();
			init();
			style();
		}

		public void setNation(MModelNation nation) {
			pnHeader.lbTitle.setText(nation.name);
			pnHeader.imgLogo.setResource(nation.resource);

			for (int i = 0; i < nation.leagues.size(); i++) {
				MModelLeague league = nation.leagues.get(i);
				PanelLeague pnLeague = new PanelLeague(league.name, league.resource);
				pnHeader.vpLeagues.add(pnLeague);
				pnLeagues.add(pnLeague);
			}

			// add(vpLeagues);
		}

		private void style() {
			Style style = getElement().getStyle();
//			style.setBackgroundColor("#eeeeee");
			style.setMarginTop(1, Unit.PCT);
			style.setMarginBottom(1, Unit.PCT);
		}

		private void init() {
			add(pnHeader);
			add(pnHeader.vpLeagues);
		}

		class PanelHeader extends FocusParentPanel {
			public VerticalPanel vpLeagues = new VerticalPanel();
			Image imgLogo = new Image();
			Label lbTitle = new Label("Title");

			public PanelHeader() {
				super();
				init();
				style();
			}

			public Panel initPanel() {
				return new HorizontalPanel();
			}

			private void style() {
				CSSUtils.Mobile.setSizePercent(hp, 0.95f, 0.05f);
				Style style = hp.getElement().getStyle();
				style.setBackgroundColor("green");
				style.setMarginLeft(2.5, Unit.PCT);
				style.setPaddingTop(2, Unit.PCT);
				style.setPaddingLeft(4, Unit.PCT);
			}

			private void init() {

				CSSUtils.Mobile.setSizePercent(imgLogo, 0.1f, 0.04f);
				Style style = imgLogo.getElement().getStyle();
				imgLogo.setResource(ClientBundleMobile.INST.get().icNation());
				hp.add(imgLogo);

				CSSUtils.Mobile.setSizePercent(lbTitle, 0.7f, 0.04f);
				style = lbTitle.getElement().getStyle();
				style.setFontSize(150, Unit.PCT);
				style.setColor("#FFFFFF");
				style.setMarginLeft(10, Unit.PCT);
				hp.add(lbTitle);

				addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						if (isHaveAnyLeague())
							setVisibleLeagues(!vpLeagues.isVisible());
						else
							Window.alert("These leagues not available now, we will update later!");
					}
				});

				setVisibleLeagues(false);
			}

			public void setVisibleLeagues(boolean b) {
				vpLeagues.setVisible(b);
			}
			
			public boolean isHaveAnyLeague() {
				return vpLeagues.getWidgetCount() != 0 ? true : false;
			}

		}

		class PanelLeague extends FocusParentPanel {
			Label lbLeague = new Label();
			Image imgLeague = new Image();

			public PanelLeague() {
				super();
				init();
				style();
			}

			public PanelLeague(String text, ImageResource resource) {
				this();
				lbLeague.setText(text);
				imgLeague.setResource(resource);
			}

			private void init() {
				CSSUtils.Mobile.setSizePercent(imgLeague, 0.1f, 0.05f);
				Style style = imgLeague.getElement().getStyle();
				// imgLeague.setResource(ClientBundleMobile.INST.get().icLeague());
				style.setPadding(4, Unit.PCT);
				hp.add(imgLeague);

				CSSUtils.Mobile.setSizePercent(lbLeague, 0.4f, 0.04f);
				style = lbLeague.getElement().getStyle();
				style.setFontSize(150, Unit.PCT);
				style.setColor("white");
				style.setPaddingTop(2, Unit.PCT);
				hp.add(lbLeague);
				
			}

			private void style() {
				CSSUtils.Mobile.setSizePercent(hp, 0.9f, 0.04f);
				Style style = getElement().getStyle();
				style.setMarginLeft(6.5, Unit.PCT);
				style.setMarginTop(1, Unit.PCT);
				style.setBackgroundColor("orange");

			}

			@Override
			public Panel initPanel() {
				return new HorizontalPanel();
			}

		}
	}

	public static class MModelNation {
		public String name = "";
		public ImageResource resource;
		public List<MModelLeague> leagues = new ArrayList<>();

		public MModelNation(String name, ImageResource resource) {
			setData(name, resource);
		}

		public void setData(String name, ImageResource resource) {
			this.name = name;
			this.resource = resource;
		}

	}

	public static class MModelLeague {
		public long id;
		public String name = "";
		public ImageResource resource;

		public MModelLeague(String name, ImageResource resource) {
			this.name = name;
			this.resource = resource;
		}
	}


}
