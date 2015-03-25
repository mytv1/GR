package giddyhero.soccersystem.client;

import com.google.gwt.user.client.Window;

public class ClientUtils {
	public static int getHeight() {
		return Window.getClientHeight() - 40;
	}
	
	public static int DESIGN_WIDTH = 0;
	public static int DESIGN_HEIGHT = 0;

	public static int getWidth() {
		return Window.getClientWidth();
	}

	public static native void log(String msg)/*-{
		$wnd.console.log("log: -- " + msg);
	}-*/;
	
	
	public static int getDeviceHeight() {
		return Window.getClientHeight();
	}
	
	public static int getDeviceWidth() {
		return Window.getClientWidth();
	}

	public static int convertWidth(int width) {
		return (int)(width*getDeviceWidth()/DESIGN_WIDTH);
	}
	
	public static int convertHeight(int height) {
		return (int)(height*getDeviceHeight()/DESIGN_HEIGHT);
	}
	
	public static double convertOffsetY(double offsetY) {
		return offsetY*getDeviceHeight()/DESIGN_HEIGHT;
	}
	
	public static double convertOffsetX(double offsetX) {
		return offsetX*getDeviceWidth()/DESIGN_WIDTH;
	}
	
}
