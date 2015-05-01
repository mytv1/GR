package giddyhero.soccersystem.client.share;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Float;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class CSSUtils {
	
	public static class Mobile{
		public static int WIDTH_DESIGN = 800, HEIGHT_DESIGN = 1280;
		public static int WIDTH_DEVICE = 0, HEIGHT_DEVICE = 0;
		
		static{
			WIDTH_DEVICE = Window.getClientWidth();
			HEIGHT_DEVICE = Window.getClientHeight();
		}
		
		public static void setPixelSize(Widget widget, int w, int h){
			widget.setPixelSize(w*WIDTH_DEVICE/WIDTH_DESIGN, h*HEIGHT_DEVICE/HEIGHT_DESIGN);
		}
		
		/**
		 * 
		 * @param widget
		 * @param w (0.0 - 1.0)
		 * @param h (0.0 - 1.0)
		 */
		public static void setSizePercent(Widget widget, float w, float h){
			int wP = (int)(w*WIDTH_DEVICE);
			int wH = (int)(h*HEIGHT_DEVICE);
			widget.setPixelSize(wP, wH);
		}
		
		
		public static void setWidthPercent(Widget widget, float w){
			int wP = (int)(w*WIDTH_DEVICE);
			widget.setWidth(wP+"px");
		}

		public static void setHeightPercent(Widget widget, float h) {
			int hP = (int)(h*HEIGHT_DEVICE);
			widget.setHeight(hP+"px");
//			Window.alert("hp : "+hP+" - h "+h+" Height device : "+HEIGHT_DEVICE);
		}
		
	}
	
	public static String COLOR_DIV = "#DADADA";
	
	public static void setBorderRadius(Widget widget, String radius){
		Style style = widget.getElement().getStyle();
		style.setProperty("borderTopLeftRadius", radius);
		style.setProperty("borderTopRightRadius", radius);
		style.setProperty("borderBottomLeftRadius", radius);
		style.setProperty("borderBottomRightRadius", radius);
	}
	
	public static void setMarginCenter(Widget widget){
		Style style = widget.getElement().getStyle();
		style.setProperty("marginLeft", "auto");
		style.setProperty("marginRight", "auto");
	}
	
	public static void setMargin(Widget widget, double pixel) {
		widget.getElement().getStyle().setMargin(pixel, Unit.PX);
	}
	
	public static void setMarginTop(Widget widget, double pixel) {
		widget.getElement().getStyle().setMarginTop(pixel, Unit.PX);
	}
	
	public static void setMarginBottom(Widget widget, double pixel) {
		widget.getElement().getStyle().setMarginBottom(pixel, Unit.PX);
	}
	
	public static void setMarginLeft(Widget widget, double pixel) {
		widget.getElement().getStyle().setMarginLeft(pixel, Unit.PX);
	}

	public static void setMarginRight(Widget widget, double pixel) {
		widget.getElement().getStyle().setMarginRight(pixel, Unit.PX);
	}
	
	public static void setPadding(Widget widget, double pixel) {
		widget.getElement().getStyle().setPadding(pixel, Unit.PX);
	}
	
	public static void setPaddingTop(Widget widget, double pixel) {
		widget.getElement().getStyle().setPaddingTop(pixel, Unit.PX);
	}
	
	public static void setPaddingBottom(Widget widget, double pixel) {
		widget.getElement().getStyle().setPaddingBottom(pixel, Unit.PX);
	}
	
	public static void setPaddingLeft(Widget widget, double pixel) {
		widget.getElement().getStyle().setPaddingLeft(pixel, Unit.PX);
	}

	public static void setPaddingRight(Widget widget, double pixel) {
		widget.getElement().getStyle().setPaddingRight(pixel, Unit.PX);
	}
	
	
	/**
	 * Set font size
	 * @param size {xx-small, x-small, small, medium, large, x-large, smaller, larger}
	 */
	public static void setFontSize(Label label,String value){
		label.getElement().getStyle().setProperty("fontSize", value);
	}
	
	/**
	 * Set font weight
	 * @param weight {normal, bold, bolder, lighter}
	 */
	public static void setFontWeight(Label label, String value){
		label.getElement().getStyle().setProperty("fontWeight", value);
	}
	
	/**
	 * Set font style
	 * @param style {normal, italic, oblique, inherit, !important}
	 */
	public static void setFontStyle(Label label,String style) {
		label.getElement().getStyle().setProperty("fontStyle", style);
	}
	
	/**
	 * Set text decoration
	 * @param decoration {none, underline, overline, line-through, blink}
	 */
	public static  void setTextDecoration(Label label,String decoration) {
		label.getElement().getStyle().setProperty("textDecoration", decoration);
	}
	
	/**
	 * Set text transform
	 * @param transform {capitalize, uppercase, lowercase, none}
	 */
	public static void setTextTransform(Label label, String transform) {
		label.getElement().getStyle().setProperty("textTransform", transform);
	}
	
	/**
	 * Set position
	 * @param position {static, relative, absolute, fixed}
	 */
	public static void setPosition(Label label, String value){
		label.getElement().getStyle().setProperty("position", value);
	}
	
	public static void setTop(Widget widget,double pixel){
		widget.getElement().getStyle().setTop(pixel, Unit.PX);
	}
	
	
	public static void setLeft(Widget widget,double pixel){
		widget.getElement().getStyle().setLeft(pixel, Unit.PX);
	}
	
	public static void setRight(Widget widget,double pixel){
		widget.getElement().getStyle().setRight(pixel, Unit.PX);
	}
	
	
	public static void setBottom(Widget widget,double pixel){
		widget.getElement().getStyle().setBottom(pixel, Unit.PX);
	}
	
	public static void setAlign(Widget widget,Float align) {
		widget.getElement().getStyle().setFloat(align);
	}
	
	public static void setTextAlign(Label label,TextAlign value) {
		label.getElement().getStyle().setTextAlign(value);
	}

	public static void setBackgroundColor(Widget widget,String color) {
		widget.getElement().getStyle().setProperty("backgroundColor", color);
	}
	
	public static void setColor(Widget widget,String color) {
		widget.getElement().getStyle().setProperty("color", color);
	}
}
