package giddyhero.soccersystem.client.mobile.activities.teams;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicView;

import com.google.gwt.event.dom.client.HasClickHandlers;

public interface TeamView  extends BasicView {
	
	void setName(String name);
	
	void setAvatar(String url);
	
	void setNation(String url);

	HasClickHandlers addPlayer(String name, String avatarUrl, String birth, int jerseyNumber);

	void setTempData();
	
}
