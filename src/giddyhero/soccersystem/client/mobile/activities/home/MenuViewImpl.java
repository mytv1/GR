package giddyhero.soccersystem.client.mobile.activities.home;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicView;
import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.widget.button.ImageButton;
import com.googlecode.mgwt.ui.client.widget.button.image.PreviousitemImageButton;
import com.googlecode.mgwt.ui.client.widget.header.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.header.HeaderTitle;
import com.googlecode.mgwt.ui.client.widget.panel.flex.RootFlexPanel;
import com.googlecode.mgwt.ui.client.widget.panel.scroll.ScrollEndEvent;
import com.googlecode.mgwt.ui.client.widget.panel.scroll.ScrollEndEvent.Handler;
import com.googlecode.mgwt.ui.client.widget.panel.scroll.ScrollPanel;

public class MenuViewImpl extends Composite implements BasicView {

	private static BasicViewImplUiBinder uiBinder = GWT
			.create(BasicViewImplUiBinder.class);

	interface BasicViewImplUiBinder extends UiBinder<Widget, Layout> {
	}
	
	protected final Layout layout;
	
	public static class Layout{
		@UiField (provided=true)
		ClientBundleMobile res;
		private final MenuViewImpl basicView;
		@UiField
		protected RootFlexPanel root;
		@UiField
		public FlowPanel main;
		@UiField
		public VerticalPanel menu;
		@UiField
		protected ScrollPanel scrollPanel;
		@UiField
		protected HeaderPanel headerPanel;
		@UiField
		protected HeaderTitle headerTitle;
		@UiField
		protected PreviousitemImageButton headerBackButton;
		@UiField
		public Image imgLogo;
		@UiField
		public Label lbLogo;
		
		public Layout(MenuViewImpl basicView) {
			this.basicView = basicView;
		}
		
		private void initMyPageRow() {
//			ImageButtonDefaultAppearance a = new ImageButtonDefaultAppearance();
//			a.css().image();
//			layout.ibtMyPage = new ImageButton(a, SSClientBundleBaseThemeMobile.IMPL.getBundle().menuBtMyPage(), "");
//			ibtMyPage.get
//			ibtMyPage.setSize("80%", "80%");
		}


		private void initLogoRow() {
			Style style;
			imgLogo.setResource(ClientBundleMobile.INSTANCE.getBundle().icLogo());
//			imgLogo.setSize("100%", "100%");
			imgLogo.setStyleName("imgLogo");
//			style = imgLogo.getElement().getStyle();
//			style.setMarginLeft(10, Unit.PCT);
//			style.setMarginTop(20, Unit.PCT);
			
//			lbLogo.setSize("100%", "100%");
//			style = lbLogo.getElement().getStyle();
			lbLogo.setStyleName("lbLogo");
//			style.setPosition(Position.ABSOLUTE);
//			style.setLeft(, Unit.PCT);
//			style.setTop(10, Unit.PCT);
		}

		
		public RootFlexPanel getMain() {
			return root;
		}
		
		public void setMain(RootFlexPanel main) {
			this.root = main;
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
		
		public void setTitle(HeaderTitle headerTitle) {
			this.headerTitle = headerTitle;
		}
		
		public MenuViewImpl getBasicView() {
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
			return headerTitle;
		}
	}

	public MenuViewImpl() {
		this.layout = new Layout(this);
		this.layout.res = ClientBundleMobile.INSTANCE.getBundle();
		this.layout.res.style().ensureInjected();
		
		uiBinder.createAndBindUi(this.layout);
		layout.initLogoRow();
		layout.initMyPageRow();
		this.layout.getScrollPanel().addScrollEndHandler(new Handler() {
			
			@Override
			public void onScrollEnd(ScrollEndEvent event) {
				layout.getScrollPanel().refresh();
			}
		});
		this.layout.headerBackButton.addTapHandler(new TapHandler() {
			
			@Override
			public void onTap(TapEvent event) {
				boolean isMenuVisible = layout.menu.isVisible();
				layout.menu.setVisible(!isMenuVisible);
				if (!isMenuVisible){
					layout.main.setWidth("135%");
				}else{
					layout.main.setWidth("100%");
				}
			}
		});
		this.layout.headerBackButton.setIcon(ClientBundleMobile.INSTANCE.getBundle().icMenu());
//		Window.alert("Size : "+RootPanel.get().getOffsetWidth()+" --- "+RootPanel.get().getOffsetHeight());
	}
	
	

	@Override
	public Widget asWidget() {
		return layout.root;
	}



	@Override
	public HasTapHandlers getButtonBack() {
		return layout.headerBackButton;
	}

	@Override
	public HasText getHeader() {
		return layout.headerTitle;
	}

}
