package giddyhero.soccersystem.client.mobile.activities.home;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.ui.client.widget.button.Button;

public class HomeViewImpl extends MenuViewImpl implements HomeView{

	private static HomeViewImplUiBinder uiBinder = GWT
			.create(HomeViewImplUiBinder.class);

	interface HomeViewImplUiBinder extends UiBinder<Widget, HomeViewImpl> {
	}
	
	@UiField
	protected FlowPanel homePanel;
	@UiField
	protected Button btNews, btLeague, btTeam, btPlayer, btAccount, btGame, btStore;

	public HomeViewImpl() {
		super();
		this.layout.getScrollPanel().setWidget(uiBinder.createAndBindUi(this));
//		this.layout.getHeaderBackButton().setVisible(false);
//		homePanel.setHeight(ClientUtils.getHeight()
//				-this.layout.getHeaderPanel().getOffsetHeight() +"px");
		
	}



	@Override
	public HasTapHandlers getButtonNews() {
		return btNews;
	}

	@Override
	public HasTapHandlers getButtonLeague() {
		return btLeague;
	}

	@Override
	public HasTapHandlers getButtonTeam() {
		return btTeam;
	}

	@Override
	public HasTapHandlers getButtonPlayer() {
		return btPlayer;
	}

	@Override
	public HasTapHandlers getButtonAccount() {
		return btAccount;
	}

	@Override
	public HasTapHandlers getButtonGames() {
		return btGame;
	}

	@Override
	public HasTapHandlers getButtonStore() {
		return btStore;
	}

}
