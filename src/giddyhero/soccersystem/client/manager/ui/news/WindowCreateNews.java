package giddyhero.soccersystem.client.manager.ui.news;

import giddyhero.soccersystem.client.SystemManager;
import giddyhero.soccersystem.client.share.CSSUtils;
import giddyhero.soccersystem.shared.model.News;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;

public class WindowCreateNews extends FlowPanel {

	TableCreateNews tblCreateNews;

	public WindowCreateNews() {
		super();
		init();
		style();
	}

	private void style() {
		Style style = getElement().getStyle();
		style.setMargin(30, Unit.PX);
	}

	private void init() {
		initLabelTitle();
		tblCreateNews  = new TableCreateNews();
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
				SystemManager.Service.news.saveNews(news, new AsyncCallback<News>() {

					@Override
					public void onSuccess(News result) {
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
		Label lbTitle = new Label("Create new news");
		lbTitle.setWidth("100%");
		CSSUtils.setFontSize(lbTitle, "x-large");
		CSSUtils.setTextAlign(lbTitle, Style.TextAlign.CENTER);
		lbTitle.getElement().getStyle().setPaddingBottom(20, Unit.PX);
		add(lbTitle);
	}
}
