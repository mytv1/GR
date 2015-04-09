package giddyhero.soccersystem.client.mobile.activities.basic;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.widget.button.image.PreviousitemImageButton;
import com.googlecode.mgwt.ui.client.widget.header.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.header.HeaderTitle;
import com.googlecode.mgwt.ui.client.widget.panel.flex.RootFlexPanel;
import com.googlecode.mgwt.ui.client.widget.panel.scroll.ScrollEndEvent;
import com.googlecode.mgwt.ui.client.widget.panel.scroll.ScrollEndEvent.Handler;
import com.googlecode.mgwt.ui.client.widget.panel.scroll.ScrollPanel;

public class BasicViewImpl extends Composite implements BasicView {


	private static BasicViewImplUiBinder uiBinder = GWT
			.create(BasicViewImplUiBinder.class);

	interface BasicViewImplUiBinder extends UiBinder<Widget, Layout> {
	}
	
	protected final Layout layout;
	
	public static class Layout{
		private final BasicViewImpl basicView;
		@UiField
		protected RootFlexPanel main;
		@UiField
		protected ScrollPanel scrollPanel;
		@UiField
		protected HeaderPanel headerPanel;
		@UiField
		protected HeaderTitle title;
		@UiField
		protected PreviousitemImageButton headerBackButton;
		
		public Layout(BasicViewImpl basicView) {
			this.basicView = basicView;
		}
		
		public RootFlexPanel getMain() {
			return main;
		}
		
		public void setMain(RootFlexPanel main) {
			this.main = main;
		}
		
		public void setHeaderBackButton(PreviousitemImageButton headerBackButton) {
			this.headerBackButton = headerBackButton;
		}
		
		public void setHeaderPanel(HeaderPanel headerPanel) {
			this.headerPanel = headerPanel;
		}
		
		public void setScrollPanel(ScrollPanel scrollPanel) {
			this.scrollPanel = scrollPanel;
		}
		
		public void setTitle(HeaderTitle title) {
			this.title = title;
		}
		
		public BasicViewImpl getBasicView() {
			return basicView;
		}
		
		public PreviousitemImageButton getHeaderBackButton() {
			return headerBackButton;
		}
		
		public HeaderPanel getHeaderPanel() {
			return headerPanel;
		}
		
		public ScrollPanel getScrollPanel() {
			return scrollPanel;
		}
		
		public HeaderTitle getTitle() {
			return title;
		}
	}

	public BasicViewImpl() {
		this.layout = new Layout(this);
		uiBinder.createAndBindUi(this.layout);
		this.layout.getScrollPanel().addScrollEndHandler(new Handler() {
			
			@Override
			public void onScrollEnd(ScrollEndEvent event) {
				layout.getScrollPanel().refresh();
			}
		});
		
		getButtonBack().addTapHandler(new TapHandler() {
			
			@Override
			public void onTap(TapEvent event) {
				History.back();
			}
		});
	}
	
	

	@Override
	public Widget asWidget() {
		return layout.main;
	}



	@Override
	public HasTapHandlers getButtonBack() {
		return layout.headerBackButton;
	}

	@Override
	public HasText getHeader() {
		return layout.title;
	}
}
