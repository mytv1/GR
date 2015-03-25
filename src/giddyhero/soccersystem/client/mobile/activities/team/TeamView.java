package giddyhero.soccersystem.client.mobile.activities.team;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicView;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

public interface TeamView extends BasicView {
	public Label getLbName();
	
	public Label getLbEstablishYear();
	
	public Label getLbStadium();
	
	public Label getLbNation();
	
	public Label getLbManager();
	
	public Label getLbNumOfPlayer();
	
	public Image getImgLogo();
	
	public FlexTable getTblPlayers();

}
