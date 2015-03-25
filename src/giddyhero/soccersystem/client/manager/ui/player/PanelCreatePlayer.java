package giddyhero.soccersystem.client.manager.ui.player;

import giddyhero.soccersystem.client.SoccerSystem;
import giddyhero.soccersystem.client.manager.ui.news.TableCreateNews;
import giddyhero.soccersystem.client.manager.widget.GHLabel;
import giddyhero.soccersystem.shared.model.News;
import giddyhero.soccersystem.shared.model.Player;

import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;

public class PanelCreatePlayer extends FlowPanel {

	TableCreatePlayer tblCreatePlayer = new TableCreatePlayer();

	public PanelCreatePlayer() {
		super();
		init();
	}

	private void init() {
		initLabelTitle();
		add(tblCreatePlayer);
		initConfirmButton();
	}

	private void initConfirmButton() {
		Button btConfirm = new Button("Create");
		btConfirm.setSize("150px", "40px");
		btConfirm.setStyleName("center");
		btConfirm.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				Player player = tblCreatePlayer.getPlayer();
				SoccerSystem.Service.player.addNewPlayer(player, new AsyncCallback<Player>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Failure : "+caught.toString());
					}

					@Override
					public void onSuccess(Player player) {
						Window.alert("Success : "+player.toString());
						
					}
				});
			}
		});

		add(btConfirm);
	}

	private void initLabelTitle() {
		GHLabel lbTitle = new GHLabel("Create New Player");
		lbTitle.setWidth("100%");
		lbTitle.setFontSize("x-large");
		lbTitle.setTextAlign(TextAlign.CENTER);
		lbTitle.getElement().getStyle().setPaddingBottom(20, Unit.PX);
		add(lbTitle);
	}
}
