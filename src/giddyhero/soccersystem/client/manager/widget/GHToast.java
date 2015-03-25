package giddyhero.soccersystem.client.manager.widget;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.PopupPanel;

public class GHToast {
	private static PopupPanel dialogs = new PopupPanel(true, false);
	private static HorizontalPanel panel = new HorizontalPanel();
	private static HTML html = null;
	
	private static Integer toastCount = 0;
	public static final int top = 1;
	public static final int center = 2;
	public static final int bot = 3;
	
	protected static Timer timer = new Timer() {
		@Override
		public void run() {
			hideDialogs();
		}
	};
	
	public static void hideDialogs() {
		html.setHTML("");
		dialogs.hide();
	}
	
//	public static void showToast(String message, boolean isLong, int pos) {
//		if (Promotion.getPhoneGap().isPhoneGapDevice())
//			toast(message, isLong,pos);
//		else
//			showToastX(message, isLong);
//	}

	private static native void toast(String message, boolean isLong, int position)/*-{
		if(isLong) {
			if(position == 1)
				$wnd.plugins.toast.showLongTop(message);
			else if(position == 2)
				$wnd.plugins.toast.showLongCenter(message);
			else if(position == 3)
				$wnd.plugins.toast.showLongBottom(message);
		}
		else {
			if(position == 1)
			$wnd.plugins.toast.showShortTop(message);
		else if(position == 2)
			$wnd.plugins.toast.showShortCenter(message);
		else if(position == 3)
			$wnd.plugins.toast.showShortBottom(message);
		}
	}-*/;

	public static void showToastX(String message, boolean isLong) {
		if (html == null) {
			html = new HTML();
			panel.add(html);
			panel.setSpacing(5);
			dialogs.add(panel);
			dialogs.getElement().setAttribute("style", "background-color: white; z-index : 10000;");
		}
		html.getElement().setAttribute("style", "color:#212121; text-align: center;  text-overflow: ellipsis; overflow: hidden;font-size:"+Window.getClientWidth()/22+"px;");
		html.setHTML(message);
		dialogs.show();
		
		Element elem = dialogs.getElement();
		elem.getStyle().setPropertyPx("left", 0);
		elem.getStyle().setPropertyPx("top", 0);

		int left = (Window.getClientWidth() - dialogs.getOffsetWidth()) >> 1;
		dialogs.setPopupPosition(Math.max(Window.getScrollLeft() + left, 0), 10);
		timer.schedule(isLong ? 5000 : 3000);
	}
	
	public static void showToastX(String message, String color, int time) {
		if (html == null) {
			html = new HTML();
			panel.add(html);
			panel.setSpacing(5);
			dialogs.add(panel);
			dialogs.getElement().setAttribute("style", "background-color: white; z-index : 10000;");
		}
		html.getElement().setAttribute("style", "color:#212121; text-align: center;  text-overflow: ellipsis; overflow: hidden;font-size:"+Window.getClientWidth()/22+"px;");
		html.setHTML("<font color='" + color+ "'>" + message + "</font>");
		dialogs.show();

		Element elem = dialogs.getElement();
		elem.getStyle().setPropertyPx("left", 0);
		elem.getStyle().setPropertyPx("top", 0);

		int left = (Window.getClientWidth() - dialogs.getOffsetWidth()) >> 1;
		dialogs.setPopupPosition(Math.max(Window.getScrollLeft() + left, 0), 10);
		timer.schedule(time);
	}
	
//	public static void showToast(String msg, int pos) {
//		KSToast.showToast(msg, false, pos);
//	}
	
	public static Integer getToastCount() {
		return GHToast.toastCount;
	}
}
