package giddyhero.soccersystem.client.mobile.activities.greeting;

import giddyhero.soccersystem.client.mobile.activities.basic.BasicViewImpl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

public class GreetingViewImpl extends BasicViewImpl implements GreetingView {

	private static GreetingViewImplUiBinder uiBinder = GWT
			.create(GreetingViewImplUiBinder.class);

	interface GreetingViewImplUiBinder extends
			UiBinder<Widget, GreetingViewImpl> {
	}
	
	@UiField
	Image imgMain;

	public GreetingViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public Image getMainImage() {
		return imgMain;
	}


}
