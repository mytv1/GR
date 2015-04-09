package giddyhero.soccersystem.client.mobile.activities.home2;

import giddyhero.soccersystem.client.mobile.activities.home.HomeView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;

public class HomeViewImpl extends Composite implements HomeView {

	private static HomeViewImplUiBinder uiBinder = GWT.create(HomeViewImplUiBinder.class);

	interface HomeViewImplUiBinder extends UiBinder<Widget, HomeViewImpl> {
	}
	
	@UiField
	FlowPanel panel;

	public HomeViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
//		panel.add(new PanelHeader());
		
	}

	@Override
	public HasTapHandlers getButtonBack() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HasText getHeader() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HasTapHandlers getButtonNews() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HasTapHandlers getButtonLeague() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HasTapHandlers getButtonTeam() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HasTapHandlers getButtonPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HasTapHandlers getButtonAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HasTapHandlers getButtonGames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HasTapHandlers getButtonStore() {
		// TODO Auto-generated method stub
		return null;
	}


}
