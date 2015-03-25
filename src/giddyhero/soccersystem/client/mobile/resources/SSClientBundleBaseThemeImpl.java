package giddyhero.soccersystem.client.mobile.resources;

import com.google.gwt.core.client.GWT;
import com.googlecode.mgwt.ui.client.MGWT;

public class SSClientBundleBaseThemeImpl implements SSTheme {
	
    private SSClientBundle bundle;

    @SuppressWarnings("deprecation")
	public SSClientBundleBaseThemeImpl() {

    	 	bundle = GWT.create(SSClientBundleBaseThemeRetina.class);
    		if (MGWT.getOsDetection().isAndroid()) {
                if (MGWT.getOsDetection().isAndroidPhone()) {
                    bundle = GWT.create(SSClientBundleBaseThemeAndroid.class);
                }

	            if (MGWT.getOsDetection().isTablet() || MGWT.getOsDetection().isAndroidTablet()) {
	                    bundle = GWT.create(SSClientBundleBaseThemeAndroidTablet.class);
	            }    			
    		}
    		else if (MGWT.getOsDetection().isIOs()) {
    			if (MGWT.getOsDetection().isIPadRetina() || MGWT.getOsDetection().isRetina()) {
    				 bundle = GWT.create(SSClientBundleBaseThemeRetina.class);
    			}
    			else if (MGWT.getOsDetection().isIPad()) {
                    bundle = GWT.create(SSClientBundleBaseThemeIPad.class);    				
	            } else {
	                bundle = GWT.create(SSClientBundleBaseThemeIPhone.class);
	            }
    		}
    		else if (MGWT.getOsDetection().isBlackBerry()) {
                    bundle = GWT.create(SSClientBundleBaseThemeBlackberry.class);
            }
    }	
    
    @Override
    public SSClientBundle getKSMGWTClientBundle() {
            return bundle;
    }
    
    @Override
    public String getTextColorLoading() {
		if (MGWT.getOsDetection().isAndroidPhone())
			return "#EEEEEE";
		else if (MGWT.getOsDetection().isIOs())
			return "#AEDDF4";    	
		return "#EEEEEE";
    }
    
    @Override
    public String getTextColorBack() {
		if (MGWT.getOsDetection().isAndroidPhone())
			return "#40403e";
		else if (MGWT.getOsDetection().isIOs())
			return "#40403e";
		return "#40403e";
    }    
	
    @Override
	public String getTextColorTitle() {
		if (MGWT.getOsDetection().isAndroidPhone())
			return "#666666";
		else if (MGWT.getOsDetection().isIOs())
			return "#127197";
		return "#127197";
	}
    
    @Override
	public String getTextColorHyperLink() {	
    	// current version #0000ff
		if (MGWT.getOsDetection().isAndroid())
			return "#00b184";//
		else if (MGWT.getOsDetection().isIOs())
			return "#00b184";
		return "#00b184";
	} 
	
    @Override
	public String getTextColorNormal() {
		if (MGWT.getOsDetection().isAndroidPhone())
			return "#000000";
		else if (MGWT.getOsDetection().isIOs())
			return "#000000";
		return "#ffffff";
	}
    
    @Override
	public String getTextColorTimer() {
		if (MGWT.getOsDetection().isAndroidPhone())
			return "#fff2ca";
		else if (MGWT.getOsDetection().isIOs())
			return "#1d7ea7";
		return "#fff2ca";
	}
    
    @Override
	public String getTextColorBox(int box) {
    	switch (box) {
	    	case 1:
	    		if (MGWT.getOsDetection().isAndroidPhone())
	    			return "red";
	    		else if (MGWT.getOsDetection().isIOs())
	    			return "red";
	    		else
	    			return "red";
	    	case 2:
	    		if (MGWT.getOsDetection().isAndroidPhone())
	    			return "orange";
	    		else if (MGWT.getOsDetection().isIOs())
	    			return "orange";
	    		else
	    			return "orange";
	    	case 3:
	    		if (MGWT.getOsDetection().isAndroidPhone())
	    			return "#edc951";
	    		else if (MGWT.getOsDetection().isIOs())
	    			return "#edc951";
	    		else
	    			return "#edc951";
	    	case 4:
	    		if (MGWT.getOsDetection().isAndroidPhone())
	    			return "green";
	    		else if (MGWT.getOsDetection().isIOs())
	    			return "green";
	    		else
	    			return "green";
	    	case 5:
	    		if (MGWT.getOsDetection().isAndroidPhone())
	    			return "blue";
	    		else if (MGWT.getOsDetection().isIOs())
	    			return "blue";
	    		else
	    			return "blue";
    	}
    	return "#00000";
	}
}