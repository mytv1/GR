package giddyhero.soccersystem.client.mobile.activities.player;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicView;
import giddyhero.soccersystem.shared.model.News;

import java.util.List;

public interface PlayerView  extends BasicView {

	void setPlayerInfo(String name, String birth, String avatarUrl, String nationality, String position,
			int jerseyNumber);
	
}
