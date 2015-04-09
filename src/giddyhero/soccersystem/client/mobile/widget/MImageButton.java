package giddyhero.soccersystem.client.mobile.widget;

import giddyhero.soccersystem.client.share.CSSUtils;

import com.google.gwt.dom.client.Node;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.Window;
import com.googlecode.mgwt.ui.client.widget.button.ImageButton;
import com.googlecode.mgwt.ui.client.widget.button.ImageButtonAppearance;

public class MImageButton extends ImageButton{
	
	
	public MImageButton() {
		super();
	}
	
	public MImageButton(ImageResource imgResource) {
		super(imgResource);
	}
	
	 public MImageButton(ImageButtonAppearance appearance, ImageResource iconImage, String text) {
		 super(appearance,iconImage,text);
		
	 }

}
