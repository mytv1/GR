package giddyhero.soccersystem.client.mobile.activities.news.list;

import giddyhero.soccersystem.client.ClientUtils;
import giddyhero.soccersystem.client.mobile.activities.basic.BasicViewImpl;

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
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.ui.client.widget.button.Button;

public class NewsViewImpl extends BasicViewImpl implements NewsView{

	private static NewsViewImplUiBinder uiBinder = GWT
			.create(NewsViewImplUiBinder.class);

	interface NewsViewImplUiBinder extends UiBinder<Widget, NewsViewImpl> {
	}
	NewsItem[] newItems;
	
	@UiField
	protected VerticalPanel mainPanel;
	
	public NewsViewImpl() {
		super();
		this.layout.getScrollPanel().setWidget(uiBinder.createAndBindUi(this));
		this.layout.getHeaderBackButton().setVisible(false);
		mainPanel.setHeight(ClientUtils.getHeight()
				-this.layout.getHeaderPanel().getOffsetHeight() +"px");
		addNews();
		
	}

	private void addNews() {
		newItems = new NewsItem[10];
		for(int i = 0;i < 10;i++){
			NewsItem item = new NewsItem("images/messi.jpg", "Messi : Why always me? Bring Ronaldo come here, ok men? " +
					"Messi said after Argentina won Europa League");
			mainPanel.add(item);
			newItems[i] = item;
		}
	}

	@Override
	public NewsItem[] getNewsItems() {
		return newItems;
	}

}
