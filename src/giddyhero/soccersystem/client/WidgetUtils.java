package giddyhero.soccersystem.client;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

public class WidgetUtils {

	public static Image createImageIgnoseNull(String url){
		Image img = new Image();
		if (url != null)
			img.setUrl(url);
		return img;
	}
	
	public static Image createImageIgnoseNull(String url, int width, int height){
		Image img = createImageIgnoseNull(url);
		img.setPixelSize(width, height);
		return img;
	}
	
	public static String dmyToString(int day,int month, int year){
		return ""+day+"/"+month+"/"+year;
	}
	
	public static Label createIdLabel(long id, int width, int height){
		Label label = new Label(""+id);
		label.setPixelSize(width, height);
		label.getElement().setAttribute("whiteSpace", "normal");
		return label;
	}
}
