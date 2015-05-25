package giddyhero.soccersystem.client.manager.ui.league.season;

import giddyhero.soccersystem.client.share.CSSUtils;
import giddyhero.soccersystem.shared.model.Season;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

class DialogBoxSeasonSync extends DialogBox {
	VerticalPanel container = new VerticalPanel();
	Label lbTitle = new Label("Please input season id of this site : ");
	HorizontalPanel hpButton = new HorizontalPanel();
	TextBox tbId = new TextBox();
	CheckBox cbInfo = new CheckBox("Sync season information");
	CheckBox cbTeams = new CheckBox("Sync all teams of season");
	CheckBox cbPlayers = new CheckBox("Sync all players of season");
	CheckBox cbFixtures = new CheckBox("Sync fixtures of season");
	private Season season;

	public DialogBoxSeasonSync() {
		super();
		init();
	}
	

	private void init() {
		setText("Sync with api.football-data.org");
		container.add(lbTitle);
		container.add(tbId);
		container.add(cbInfo);
		container.add(cbTeams);
		container.add(cbPlayers);
		container.add(cbFixtures);
		container.add(hpButton);

		CSSUtils.setMarginCenter(hpButton);
		cbInfo.setVisible(false);
		cbPlayers.setVisible(false);
		cbTeams.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				cbPlayers.setVisible(cbTeams.getValue());
				cbPlayers.setValue(false);
			}
		});

		Button btSync = new Button("Start", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				Window.alert("Syncing..... ");
				try {
					int externalSeasonId = Integer.parseInt(tbId.getText());
					ServiceSyncSeason.sync(season, externalSeasonId, cbInfo.getValue(), cbTeams.getValue(), cbPlayers.getValue(),
							cbFixtures.getValue());
					hide();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		hpButton.add(btSync);

		Button btHide = new Button("Hide", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				hide();
			}
		});
		hpButton.add(btHide);

		setWidget(container);
	}

	public void setSeason(Season result) {
		this.season = result;
	}

}