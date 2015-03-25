package giddyhero.soccersystem.client.manager.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ClientBundle.Source;

public interface SSClientBundleBaseThemeManager extends ClientBundle, SSClientBundleManager {
	public static final SSClientBundleBaseThemeManagerImpl IMPL = new SSClientBundleBaseThemeManagerImpl();
	
	@Source("css/logo.png")
	public ImageResource logo();

	@Source("css/edit-ic.png")
	public ImageResource editIc();

	@Source("css/delete-ic.png")
	public ImageResource deleteIc();
}