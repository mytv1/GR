
package giddyhero.soccersystem.client.manager.resources;

import com.google.gwt.core.client.GWT;

public class SSClientBundleBaseThemeManagerImpl {
	 private SSClientBundleBaseThemeManager bundle;

	    @SuppressWarnings("deprecation")
		public SSClientBundleBaseThemeManagerImpl() {
	    		bundle = GWT.create(SSClientBundleBaseThemeManager.class);
	    }
	    
	    public SSClientBundleBaseThemeManager getBundle() {
			return bundle;
		}
	    
}
