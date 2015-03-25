package giddyhero.soccersystem.client.mobile.activities.team;

import giddyhero.soccersystem.client.ClientUtils;
import giddyhero.soccersystem.client.mobile.activities.basic.BasicViewImpl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class TeamViewImpl extends BasicViewImpl implements TeamView {

	private static TeamViewImplUiBinder uiBinder = GWT
			.create(TeamViewImplUiBinder.class);

	interface TeamViewImplUiBinder extends
			UiBinder<Widget, TeamViewImpl> {
	}

	@UiField
	VerticalPanel mainPanel;
	@UiField
	Image imgLogo;
	@UiField
	Label lbName, lbEstablishYear, lbStadium, lbNation, lbNumOfPlayer, lbManager;
	@UiField
	FlexTable tblPlayers;

	public TeamViewImpl() {
		super();
		baseImpl();
	}
	

	private void baseImpl() {
		this.layout.getScrollPanel().setWidget(uiBinder.createAndBindUi(this));
		this.layout.getHeaderBackButton().setVisible(false);
		mainPanel.setHeight(ClientUtils.getHeight()
				- this.layout.getHeaderPanel().getOffsetHeight() + "px");
		int logoWidth = (int) (ClientUtils.getWidth()*0.3f);
		int logoHeight = (int) (ClientUtils.getWidth()*0.3f);
		imgLogo.setPixelSize(logoWidth, logoHeight);
		
		tblPlayers.setText(0, 0, "Avatar");
		tblPlayers.setText(0, 1, "Name");
		tblPlayers.setText(0, 2, "Birth");
		tblPlayers.setText(0, 3, "Nationality");
		tblPlayers.setText(0, 4, "Position");
		tblPlayers.setText(0, 5, "Height");
		tblPlayers.setWidth(ClientUtils.getWidth()+"px");
	}
	
	public Label getLbName() {
		return lbName;
	}
	
	public Label getLbEstablishYear() {
		return lbEstablishYear;
	}
	
	public Label getLbStadium() {
		return lbStadium;
	}
	
	public Label getLbNation() {
		return lbNation;
	}
	
	public Label getLbManager() {
		return lbManager;
	}
	
	public Label getLbNumOfPlayer() {
		return lbNumOfPlayer;
	}
	
	public Image getImgLogo() {
		return imgLogo;
	}
	
	public FlexTable getTblPlayers() {
		return tblPlayers;
	}

}
