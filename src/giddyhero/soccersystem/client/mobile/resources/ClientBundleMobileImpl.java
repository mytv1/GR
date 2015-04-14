
package giddyhero.soccersystem.client.mobile.resources;

import com.google.gwt.core.client.GWT;
import com.googlecode.mgwt.ui.client.MGWT;

public class ClientBundleMobileImpl {
	 private ClientBundleMobile bundle;

	    @SuppressWarnings("deprecation")
		public ClientBundleMobileImpl() {
	    	bundle = GWT.create(ClientBundleMobile.class);
    		if (MGWT.getOsDetection().isAndroid()) {
                if (MGWT.getOsDetection().isAndroidPhone()) {
                    bundle = GWT.create(ClientBundleMobileAndroid.class);
                }

    		}
    		else if (MGWT.getOsDetection().isIOs()) {
	                bundle = GWT.create(ClientBundleMobileIPhone.class);
    		}
	    }
	    
	    public ClientBundleMobile get() {
			return bundle;
		}
	    
}
