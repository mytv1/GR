package giddyhero.soccersystem.client.mobile.activities.player;

import giddyhero.soccersystem.client.ClientUtils;
import giddyhero.soccersystem.client.mobile.activities.basic.BasicViewImpl;
import giddyhero.soccersystem.shared.model.Player;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.ui.client.widget.button.Button;

public class PlayerViewImpl extends BasicViewImpl implements PlayerView {

	private static PlayerViewImplUiBinder uiBinder = GWT
			.create(PlayerViewImplUiBinder.class);

	interface PlayerViewImplUiBinder extends
			UiBinder<Widget, PlayerViewImpl> {
	}

	@UiField
	VerticalPanel mainPanel;
	@UiField
	Image imgAvatar;
	@UiField
	Label lbName, lbBirth, lbCurrentTeam, lbNationality, lbPosition, lbHeight;

	public PlayerViewImpl() {
		super();
		baseImpl();
		int avatarWidth = (int) (ClientUtils.getWidth()*0.4f);
		int avatarHeight = (int) (ClientUtils.getWidth()*0.4f);
		imgAvatar.setPixelSize(avatarWidth, avatarHeight);
	}
	

	private void baseImpl() {
		this.layout.getScrollPanel().setWidget(uiBinder.createAndBindUi(this));
		this.layout.getHeaderBackButton().setVisible(false);
		mainPanel.setHeight(ClientUtils.getHeight()
				- this.layout.getHeaderPanel().getOffsetHeight() + "px");		
	}
	
	public Image getImgAvatar() {
		return imgAvatar;
	}
	
	public Label getLbBirth() {
		return lbBirth;
	}
	
	public Label getLbCurrentTeam() {
		return lbCurrentTeam;
	}
	
	public Label getLbNationality() {
		return lbNationality;
	}
	
	public Label getLbHeight() {
		return lbHeight;
	}
	
	public Label getLbName() {
		return lbName;
	}
	
	public Label getLbPosition() {
		return lbPosition;
	}


}
