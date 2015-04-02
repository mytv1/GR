package giddyhero.soccersystem.client.manager.ui.league;

import giddyhero.soccersystem.client.SystemManager;
import giddyhero.soccersystem.client.share.CSSUtils;
import giddyhero.soccersystem.shared.model.League;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;

public class PanelCreateLeague extends FlowPanel {

	TableCreateLeague tblCreateNews = new TableCreateLeague();

	public PanelCreateLeague() {
		super();
		init();
	}

	private void init() {
		initLabelTitle();
		add(tblCreateNews);
		initConfirmButton();
	}

	private void initConfirmButton() {
		Button btConfirm = new Button("Create");
		btConfirm.setSize("150px", "40px");
		btConfirm.setStyleName("center");
		btConfirm.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				League league = tblCreateNews.getLeague();
				SystemManager.Service.league.saveLeague(league, new AsyncCallback<Void>() {
					
					@Override
					public void onSuccess(Void result) {
						Window.alert("new league success");
					}
					
					@Override
					public void onFailure(Throwable caught) {
						Window.alert("new league failure");				
					}
				});
			}
		});

		add(btConfirm);
	}

	private void initLabelTitle() {
		Label lbTitle = new Label("Create New League");
		lbTitle.setWidth("100%");
		CSSUtils.setFontSize(lbTitle, "x-large");
		CSSUtils.setTextAlign(lbTitle, Style.TextAlign.CENTER);
		lbTitle.getElement().getStyle().setPaddingBottom(20, Unit.PX);
		add(lbTitle);
	}
}
