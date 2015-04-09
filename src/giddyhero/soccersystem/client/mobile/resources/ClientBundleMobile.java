package giddyhero.soccersystem.client.mobile.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ClientBundle.Source;

public interface ClientBundleMobile extends ClientBundle {
	public static final ClientBundleMobileImpl INSTANCE = new ClientBundleMobileImpl();

	@Source("image/menu.png")
	public ImageResource icMenu();

	@Source("image/logo.png")
	public ImageResource icLogo();
	
	@Source("image/news.png")
	public ImageResource btNews();

	@Source("image/logo-text.png")
	public ImageResource logoText();

	@Source("image/mypage.png")
	public ImageResource btMyPage();

	@Source("css/main-menu.css")
	Style style();

	public interface Style extends CssResource {
		String button();

	}

}