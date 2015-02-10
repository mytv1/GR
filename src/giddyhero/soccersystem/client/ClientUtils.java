package giddyhero.soccersystem.client;

import com.google.gwt.user.client.Window;

public class ClientUtils {
	public static int getHeight(){
		return Window.getClientHeight() - 40;
	}
	
	public static int getWidth(){
		return Window.getClientWidth();
	}
	
	
}
