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
	
	@Source("image/my-page.png")
	public ImageResource icMenuMyPage();
	
	@Source("image/news.png")
	public ImageResource icMenuNews();
	
	@Source("image/live-score.png")
	public ImageResource icMenuLiveScore();
	
	@Source("image/league.png")
	public ImageResource icMenuLeague();
	
	@Source("image/teams.png")
	public ImageResource icMenuTeams();
	
	@Source("image/games.png")
	public ImageResource icMenuGames();

	@Source("image/logo-text.png")
	public ImageResource logoText();

	@Source("image/mypage.png")
	public ImageResource btMyPage();
	

	@Source("image/playing.png")
	public ImageResource liveScorePlaying();

	@Source("image/playing-back.png")
	public ImageResource liveScorePlayingBack();

	@Source("image/previous.png")
	public ImageResource liveScorePrevious();

	@Source("image/previous-back.png")
	public ImageResource liveScorePreviousBack();

	@Source("image/upcomming.png")
	public ImageResource liveScoreUpcomming();

	@Source("image/upcomming-back.png")
	public ImageResource liveScoreUpcommingBack();

	@Source("css/main-menu.css")
	Style style();

	public interface Style extends CssResource {
		String button();

	}

}