package giddyhero.soccersystem.client.manager.ui;

import giddyhero.soccersystem.client.HistoryToken;
import giddyhero.soccersystem.client.manager.resources.SSClientBundleBaseThemeManager;
import giddyhero.soccersystem.client.manager.ui.league.LeagueAllPanel;
import giddyhero.soccersystem.client.manager.ui.news.PanelNewsAll;
import giddyhero.soccersystem.client.manager.ui.news.PanelCreateNews;
import giddyhero.soccersystem.client.manager.ui.player.PanelCreatePlayer;
import giddyhero.soccersystem.client.manager.ui.player.PanelPlayerAll;
import giddyhero.soccersystem.client.manager.ui.player.PlayerCreatePanel;
import giddyhero.soccersystem.client.manager.ui.team.TeamAllPanel;
import giddyhero.soccersystem.client.manager.ui.team.TeamCreatePanel;
import giddyhero.soccersystem.client.manager.ui.widget.ButtonMenuLevel1;
import giddyhero.soccersystem.client.manager.ui.widget.ButtonMenuLevel2;
import giddyhero.soccersystem.client.manager.widget.GHFlowPanel;
import giddyhero.soccersystem.client.manager.widget.GHImage;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;

public class MainPage extends Composite implements ValueChangeHandler<String> {

	public interface MyUiBinder extends UiBinder<Widget, MainPage> {
	}
	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

	@UiField
	DockLayoutPanel pnMain;
	Image logo;
	ScrollPanel pnCenter = new ScrollPanel();
	GHFlowPanel pnWest = new GHFlowPanel();
	
	ButtonMenuLevel1 btLeague, btTeam, btPlayer, btMatch, btNews;

	public MainPage() {	
		initWidget(uiBinder.createAndBindUi(this));
		initHistoryMechanism();
		init();
	}
	
	private void initHistoryMechanism() {
		History.addValueChangeHandler(this);
	}

	private void init() {
		initNorth();
		initWest();
		initCenter();
	}

	private void initCenter() {
		Style style = pnCenter.getElement().getStyle();
		style.setMarginLeft(30, Unit.PX);
		style.setMarginTop(30, Unit.PX);
		style.setMarginRight(30, Unit.PX);
		
		pnMain.add(pnCenter);
	}

	private void initWest() {
		pnWest.setPostion("static");
		pnWest.setBackgroundColor("#FAFAFA");
		
		pnMain.addWest(pnWest,220);
		List<ButtonMenuLevel1> menu = new ArrayList<ButtonMenuLevel1>();
		
		initLeagueButtonFunction();
		initTeamButtonFunction();
		initPlayerButtonFunction();
		initMatchButtonFunction();
		initNewsButtonFunction();
	
		menu.add(btLeague);
		menu.add(btTeam);
		menu.add(btPlayer);
		menu.add(btMatch);
		menu.add(btNews);
		
		for (ButtonMenuLevel1 buttonExpandMenu : menu) {
			pnWest.add(buttonExpandMenu);	
		}		
		
		
	}

	private void initTeamButtonFunction() {
		btTeam = new ButtonMenuLevel1("Team");
		ButtonMenuLevel2 btTeamShowAll = new ButtonMenuLevel2("Show All");
		ButtonMenuLevel2 btTeamAdd = new ButtonMenuLevel2("Add New");
		
		btTeamShowAll.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				History.newItem(HistoryToken.TEAM);
			}
		});

		btTeamAdd.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				History.newItem(HistoryToken.TEAM_CREATE);
			}
		});
		
		btTeam.addChildButton(btTeamShowAll);
		btTeam.addChildButton(btTeamAdd);
		
		
	}

	private void initLeagueButtonFunction() {
		btLeague = new ButtonMenuLevel1("League");
		ButtonMenuLevel2 btmLeagueShowAll = new ButtonMenuLevel2("Show All");
		ButtonMenuLevel2 btmLeagueAdd = new ButtonMenuLevel2("Add New");
		
		btmLeagueShowAll.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				History.newItem(HistoryToken.LEAGUE);
			}
		});

		btmLeagueAdd.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
//				History.newItem(HistoryToken.);
			}
		});

		
		btLeague.addChildButton(btmLeagueShowAll);
		btLeague.addChildButton(btmLeagueAdd);		
	}
	
	private void initPlayerButtonFunction() {
		btPlayer = new ButtonMenuLevel1("Player");
		ButtonMenuLevel2 btmPlayerShowAll = new ButtonMenuLevel2("Show All");
		ButtonMenuLevel2 btmPlayerAdd = new ButtonMenuLevel2("Add New");
		
		btmPlayerShowAll.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				History.newItem(HistoryToken.PLAYER);
			}
		});

		btmPlayerAdd.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				History.newItem(HistoryToken.PLAYER_CREATE);
			}
		});
		
		btPlayer.addChildButton(btmPlayerShowAll);
		btPlayer.addChildButton(btmPlayerAdd);		
	}
	
	private void initMatchButtonFunction() {
		btMatch = new ButtonMenuLevel1("Match");
		ButtonMenuLevel2 btmMatchShowAll = new ButtonMenuLevel2("Show All");
		ButtonMenuLevel2 btmMatchAdd = new ButtonMenuLevel2("Add New");
		btMatch.addChildButton(btmMatchShowAll);
		btMatch.addChildButton(btmMatchAdd);		
	}

	private void initNewsButtonFunction() {
		btNews = new ButtonMenuLevel1("News");
		ButtonMenuLevel2 btmNewsShowAll = new ButtonMenuLevel2("Show All");
		btmNewsShowAll.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				History.newItem(HistoryToken.NEWS);
			}
		});
		btNews.addChildButton(btmNewsShowAll);

		ButtonMenuLevel2 btmNewsAdd = new ButtonMenuLevel2("Add New");
		btmNewsAdd.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				History.newItem(HistoryToken.NEWS_CREATE);
			}
		});
		btNews.addChildButton(btmNewsAdd);
	}

	private void initNorth() {
		GHFlowPanel pnNorth = new GHFlowPanel();
		pnMain.addNorth(pnNorth,50);
		pnNorth.setBackgroundColor("#FFFFFF");
		pnNorth.setBorderStyle("solid");
		pnNorth.setBorderColor("#FFFFFF","#FFFFFF","#CCCCCC","#FFFFFF");
		pnNorth.setBorderWidth("0px","00px","5px","0px");
		pnNorth.add(createLogo());
		
	}

	private Widget createLogo() {
		GHImage logo = new GHImage(SSClientBundleBaseThemeManager.IMPL.getBundle().logo());
		logo.setPixelSize(300, 50);
		return logo;
	}

	public void addNewCenterContent(Widget widget) {
		pnCenter.clear();
		pnCenter.add(widget);
	}

	public void clearMainPanel() {
		pnCenter.clear();
	}


	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		String historyToken = event.getValue();
		try {
			if (historyToken.equalsIgnoreCase(HistoryToken.LEAGUE))
				addNewCenterContent(new LeagueAllPanel());
			else if (historyToken.equalsIgnoreCase(HistoryToken.TEAM))
				addNewCenterContent(new TeamAllPanel());
			else if (historyToken.equalsIgnoreCase(HistoryToken.PLAYER))
				addNewCenterContent(new PanelPlayerAll());
			else if (historyToken.equalsIgnoreCase(HistoryToken.PLAYER_CREATE))
					addNewCenterContent(new PanelCreatePlayer());
			else if (historyToken.equalsIgnoreCase(HistoryToken.TEAM_CREATE))
				addNewCenterContent(new TeamCreatePanel());
			else if (historyToken.equalsIgnoreCase(HistoryToken.NEWS))
				addNewCenterContent(new PanelNewsAll());
			else if (historyToken.equalsIgnoreCase(HistoryToken.NEWS_CREATE))
//				addNewCenterContent(new NewsCreatePanel());
				addNewCenterContent(new PanelCreateNews());
			
//			else if (historyToken.equalsIgnoreCase(HistoryToken.SEASON))
//				addNewCenterContent(new SeasonOverViewPanel(league, getSeasonOfId(id)));
			else
				clearMainPanel();
		} catch (Exception e) {
//			 TODO: handle exception
		}
	}

}