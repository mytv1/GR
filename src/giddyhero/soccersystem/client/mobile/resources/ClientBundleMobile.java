package giddyhero.soccersystem.client.mobile.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ClientBundle.Source;

public interface ClientBundleMobile extends ClientBundle {
	public static final ClientBundleMobileImpl INST = new ClientBundleMobileImpl();

	@Source("image/menu.png")
	public ImageResource icMenu();

	@Source("image/logo.png")
	public ImageResource icLogo();
	
	@Source("image/icon-back.png")
	public ImageResource icBack();
	
	@Source("image/setting.png")
	public ImageResource icSetting();
	
	@Source("image/line.png")
	public ImageResource icMenuLine();
	
	@Source("image/ic-menu-mypage.png")
	public ImageResource icMenuMyPage();
	
	@Source("image/ic-menu-news.png")
	public ImageResource icMenuNews();
	
	@Source("image/ic-menu-livescore.png")
	public ImageResource icMenuLiveScore();
	
	@Source("image/ic-menu-league.png")
	public ImageResource icMenuLeague();
	
	@Source("image/ic-menu-games.png")
	public ImageResource icMenuGames();
	
	@Source("image/ic-menu-store.png")
	public ImageResource icMenuStore();

	@Source("image/logo-text.png")
	public ImageResource logoText();


	@Source("image/playing.png")
	public ImageResource liveScorePlaying();


	@Source("image/previous.png")
	public ImageResource liveScorePrevious();


	@Source("image/upcomming.png")
	public ImageResource liveScoreUpcomming();

	@Source("image/bt-add-new-team.png")
	public ImageResource btAddTeam();
	
	@Source("image/ic-player-temp1.jpg")
	public ImageResource icPlayerTemp1();
	
	@Source("image/ic-player-temp2.jpg")
	public ImageResource icPlayerTemp2();
	
	@Source("image/ic-barca.png")
	public ImageResource icTeamLogoTemp();
	
	@Source("image/ic-arsenal.png")
	public ImageResource icTeamLogoTemp2();
	
	@Source("image/ic-win.png")
	public ImageResource icWin();
	
	@Source("image/ic-lose.png")
	public ImageResource icLose();

	@Source("image/ic-draw.png")
	public ImageResource icDraw();
	
	@Source("image/avatar-na.jpg")
	public ImageResource avatarNotAvailable();
	
	/* My Page */
	@Source("image/ic-user.png")
	public ImageResource icUser();
	
	@Source("image/ic-team.png")
	public ImageResource icTeam();
	
	@Source("image/ic-games.png")
	public ImageResource icGames();

	@Source("image/ic-games-back.png")
	public ImageResource icGamesBack();
	
	@Source("image/ic-cup-1.png")
	public ImageResource icAchivement1();
	
	@Source("image/ic-cup-2.png")
	public ImageResource icAchivement2();

	@Source("image/ic-cup-3.png")
	public ImageResource icAchivement3();
	
	/* League */
	@Source("image/ic-league.png")
	public ImageResource icLeague();
	
	@Source("image/ic-nation.png")
	public ImageResource icNation();
	
	@Source("image/leagues/england.png")
	public ImageResource icNationEngland();
	
	@Source("image/leagues/germany.png")
	public ImageResource icNationGermany();
	
	@Source("image/leagues/france.png")
	public ImageResource icNationFrance();
	
	@Source("image/leagues/italia.jpg")	
	public ImageResource icNationItalia();
	
	@Source("image/leagues/spain.png")	
	public ImageResource icNationSpain();
	
	@Source("image/leagues/premier-league.jpg")
	public ImageResource icLeaguePremierLeague();
	
	@Source("image/leagues/seria-a.jpg")
	public ImageResource icLeagueSeriaA();
	
	@Source("image/leagues/bundesliga.png")
	public ImageResource icLeagueBundesliga();
	
	@Source("image/leagues/primera-division.jpg")	
	public ImageResource icLeaguePrimeraDivision();
	
	@Source("image/leagues/league-1.jpg")	
	public ImageResource icLeagueLeagueOne();
	
	/* Team */
	@Source("image/manager.jpg")
	public ImageResource icManagerTemp();
	
	/* Match */
	@Source("image/ball.png")
	public ImageResource icBall();
	
	@Source("image/red-card.png")
	public ImageResource icRedCard();
	
	@Source("image/yellow-card.png")
	public ImageResource icYellowCard();
	
	@Source("image/change-player.png")
	public ImageResource icChangePlayer();
	
	@Source("image/ic-chat.png")
	public ImageResource icChatRoom();
	
	@Source("image/ic-bet.png")
	public ImageResource icBetting();
	
	@Source("image/ic-smile.png")
	public ImageResource icSmile();
	
	/* Game */
	@Source("image/games/icon-1.png")
	public ImageResource game1();

	@Source("image/games/icon-2.png")
	public ImageResource game2();

	@Source("image/games/icon-3.png")
	public ImageResource game3();
	
	@Source("image/games/icon-4.png")
	public ImageResource game4();
	
	@Source("image/games/icon-5.png")
	public ImageResource game5();
	
	@Source("image/games/pack-rule.jpg")
	public ImageResource gamePackRule();
	
	@Source("image/games/pack-league.jpg")
	public ImageResource gamePackLeague();
	
	@Source("image/games/pack-news.jpg")
	public ImageResource gamePackNews();
	
	/* Store */
	@Source("image/ic-inventory.png")
	public ImageResource icInventory();
	
	@Source("image/ic-store.png")
	public ImageResource icStore();
	
	@Source("image/ball.jpg")
	public ImageResource icItemBall();
	
	@Source("image/football-whistle.jpg")
	public ImageResource icItemWhistle();
	
	@Source("image/jacket.jpg")
	public ImageResource icItemJacket();
	
	@Source("image/shoe.jpg")
	public ImageResource icItemShoe();
	
	@Source("image/stadium.jpg")
	public ImageResource icItemStadium();
	
	@Source("image/trophy.jpg")
	public ImageResource icItemTrophy();
	
	@Source("css/myStyle.css")
	MyStyle style();
	
	@Source("css/nextMatch.css")
	StyleNextMatch styleNextMatch();
	
	
	public interface MyStyle extends CssResource {
		@ClassName("button")
		String buttonClass();
		
		@ClassName("labelTitle")
		String lbTitle();
		
		@ClassName("tblLeagueScore")
		String tblLeagueScore();

		@ClassName("tblLeagueScoreRow")
		String tblLeagueScoreRow();
		
		@ClassName("panelLeagueScoreTable")
		String panelLeagueScoreTable();

		@ClassName("pnMatchInfo")
		String pnMatchInfo();
		
		@ClassName("imgEvent")
		String imgEvent();

		@ClassName("lbEventContent")
		String lbEventContent();
		
		@Source("pnPerformance")
		String pnPerformance();
		
		@Source("lbTitleLineUp")
		String lbTitleLineUp();
		
		@Source("pnInfoColTitle")
		String pnInfoColTitle();

		@Source("tblInfoRow")
		String tblInfoRow();
		
		@Source("wordWrap")
		String wordWrap();
		
		@Source("hyperlink")
		String hyperlink();
		
		@Source("lbGameStaringPn")
		String lbGameStaringPn();
		
		@Source("lbGameStaringPnValue")
		String lbGameStaringPnValue();
		
		@Source("imgGameKCQuestion")
		String imgGameKCQuestion();
		
		@Source("lbGameKCQuestion")
		String lbGameKCQuestion();
		
		@Source("tabPanelBottom")
		String tabPanelBottom();
		
		@Source("lbGroupMatchTitle")
		String lbGroupMatchTitle();
		
		@Source("pnMyPageInfo")
		String pnMyPageInfo();
		
		@Source("btSSLarge")
		String btSSLarge();
		
		@Source("btSS")
		String btSS();
	}
	
	public interface StyleNextMatch extends CssResource{
		
		@ClassName("lbTeamCode")
		String lbTeamCode();
		
		@ClassName("imgLogo")
		String imgLogo();
		
		@ClassName("lbScore")
		String lbScore();
		
		@ClassName("lbTime")
		String lbTime();
		
		@ClassName("lbStatus")
		String lbStatus();
		
		@ClassName("lbCenter")
		String lbCenter();
	}

	@Source("image/ronaldo-shirt.jpg")
	public ImageResource playerShirtTemp();

	@Source("image/ic-search.png")
	public ImageResource icSearch();


}