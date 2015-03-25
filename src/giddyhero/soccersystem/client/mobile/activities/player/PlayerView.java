package giddyhero.soccersystem.client.mobile.activities.player;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicView;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

public interface PlayerView extends BasicView {
	public Image getImgAvatar();
	
	public Label getLbBirth();
	
	public Label getLbCurrentTeam();
	
	public Label getLbNationality();
	
	public Label getLbHeight();
	
	public Label getLbName();
	
	public Label getLbPosition();

}
