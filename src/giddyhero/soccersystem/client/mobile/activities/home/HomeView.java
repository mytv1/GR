package giddyhero.soccersystem.client.mobile.activities.home;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicView;

import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;

public interface HomeView extends BasicView{
	
	public HasTapHandlers getButtonNews();

	public HasTapHandlers getButtonLeague();
	
	public HasTapHandlers getButtonTeam();
	
	public HasTapHandlers getButtonPlayer();

	public HasTapHandlers getButtonAccount();
	
	public HasTapHandlers getButtonGames();
	
	public HasTapHandlers getButtonStore();
}
