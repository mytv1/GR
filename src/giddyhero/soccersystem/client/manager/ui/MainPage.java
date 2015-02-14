package giddyhero.soccersystem.client.manager.ui;

import giddyhero.soccersystem.client.SoccerSystem;
import giddyhero.soccersystem.client.manager.ui.league.LeagueAllPanel;
import giddyhero.soccersystem.client.manager.ui.news.NewsCreatePanel;
import giddyhero.soccersystem.client.manager.ui.news.NewsAllPanel;
import giddyhero.soccersystem.client.manager.ui.player.PlayerCreatePanel;
import giddyhero.soccersystem.client.manager.ui.player.PlayerAllPanel;
import giddyhero.soccersystem.client.manager.ui.team.TeamAllPanel;
import giddyhero.soccersystem.client.manager.ui.team.TeamCreatePanel;
import giddyhero.soccersystem.shared.model.Team;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;

public class MainPage extends Composite {

	public interface MyUiBinder extends UiBinder<Widget, MainPage> {
	}

	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

	@UiField
	Image logo;
	@UiField
	ScrollPanel centerPanel;
	@UiField
	Hyperlink hlNewPlayer,hlPlayerAllOverview, hlNews, hlTeams, hlCreateTeam, hlLeagueAll;

	public MainPage() {
		initWidget(uiBinder.createAndBindUi(this));
		initBanner();
	}

	private void initCenterMainPage() {
		HorizontalPanel h;
		Hyperlink link;
		Label l;
		
	}
	
	public void addNewPanel(Composite panel){
		centerPanel.clear();
		centerPanel.add(panel);
	}
	
	@UiHandler("hlLeagueAll")
	void onClickHyperLinkLeagueAllOverview(ClickEvent e) {
		addNewPanel(new LeagueAllPanel());
		
	}
	
	@UiHandler("hlPlayerAllOverview")
	void onClickHyperLinkPlayerAllOverview(ClickEvent e) {
		addNewPanel(new PlayerAllPanel());
		
	}
	
	@UiHandler("hlNewPlayer")
	void onClickHyperLinkNewPlayer(ClickEvent e) {
		addNewPanel(new PlayerCreatePanel());
	}

	@UiHandler("hlNewNews")
	void onClickHyperLinkNewNews(ClickEvent e) {
		addNewPanel(new NewsCreatePanel());
	}
	
	@UiHandler("hlNews")
	void onClickHyperLinkNews(ClickEvent e) {
		addNewPanel(new NewsAllPanel());
	}
	
	@UiHandler("hlTeams")
	void onClickHyperLinkTeams(ClickEvent e) {
		addNewPanel(new TeamAllPanel());
	}
	
	@UiHandler("hlCreateTeam")
	void onClickHyperLinkCreateTeam(ClickEvent e) {
		addNewPanel(new TeamCreatePanel());
	}

	private void initBanner() {
		logo.setUrl("logo.png");
	}

}