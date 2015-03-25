package giddyhero.soccersystem.client.manager.ui.news;

import giddyhero.soccersystem.client.SoccerSystem;
import giddyhero.soccersystem.client.manager.widget.GHLabel;
import giddyhero.soccersystem.shared.model.News;

import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HasHorizontalAlignment.HorizontalAlignmentConstant;

public class PanelCreateNews extends FlowPanel {

	TableCreateNews tblCreateNews = new TableCreateNews();

	public PanelCreateNews() {
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
				News news = tblCreateNews.getNews();
				SoccerSystem.Service.news.addNews(news, new AsyncCallback<Void>() {

					@Override
					public void onSuccess(Void result) {
						Window.alert("Add news success ");
					}

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Add news fail " + caught.toString());
					}
				});
			}
		});

		add(btConfirm);
	}

	private void initLabelTitle() {
		GHLabel lbTitle = new GHLabel("Create new news");
		lbTitle.setWidth("100%");
		lbTitle.setFontSize("x-large");
		lbTitle.setTextAlign(TextAlign.CENTER);
		lbTitle.getElement().getStyle().setPaddingBottom(20, Unit.PX);
		add(lbTitle);
	}
}
