package giddyhero.soccersystem.client.manager.widget;

import giddyhero.soccersystem.client.ClientUtils;

import com.google.gwt.dom.client.Style.Float;
import com.google.gwt.dom.client.Style.Unit;
import com.googlecode.mgwt.ui.client.widget.input.MTextBox;

public class GHTextBox extends MTextBox implements ICSSEditable{
	public GHTextBox() {
		super();
	}
	
	public void setMarginTop(double pixel) {
		getElement().getStyle().setMarginTop(pixel, Unit.PX);
	}
	
	public void setMarginBottom(double pixel) {
		getElement().getStyle().setMarginBottom(pixel, Unit.PX);
	}
	
	public void setMarginLeft(double pixel) {
		getElement().getStyle().setMarginLeft(pixel, Unit.PX);
	}

	public void setMarginRight(double pixel) {
		getElement().getStyle().setMarginRight(pixel, Unit.PX);
	}
	
	public void setAlign(Float align) {
		getElement().getStyle().setFloat(align);
	}
	
	/**
	 * Set position
	 * @param position {static, relative, absolute, fixed}
	 */
	public void setPostion(String position) {
		getElement().getStyle().setProperty("position", position);
	}
	
	/**
	 * Set top unit Pixel (For absolute position)
	 * @param pixel
	 */
	public void setTop(double pixel) {
		getElement().getStyle().setTop(pixel, Unit.PX);
	}
	
	/**
	 * Set left unit Pixel (For absolute position)
	 * @param pixel
	 */
	public void setLeft(double pixel) {
		getElement().getStyle().setLeft(pixel, Unit.PX);
	}
	
	/**
	 * Set bottom unit Pixel (For absolute position)
	 * @param pixel
	 */
	public void setBottom(double pixel) {
		getElement().getStyle().setBottom(pixel, Unit.PX);
	}
	
	/**
	 * Set right unit Pixel (For absolute position)
	 * @param pixel
	 */
	public void setRight(double pixel) {
		getElement().getStyle().setRight(pixel, Unit.PX);
	}
	
	/**
	 * Set font size
	 * @param size {xx-small, x-small, small, medium, large, x-large, smaller, larger}
	 */
	public void setFontSize(String size) {
		getElement().getStyle().setProperty("fontSize", size);
	}
	
	/**
	 * Set font weight
	 * @param weight {normal, bold, bolder, lighter}
	 */
	public void setFontWeight(String weight) {
		getElement().getStyle().setProperty("fontWeight", weight);
	}
	
	/**
	 * Set font style
	 * @param style {normal, italic, oblique}
	 */
	public void setFontStyle(String style) {
		getElement().getStyle().setProperty("fontStyle", style);
	}
	
	/**
	 * Set text decoration
	 * @param decoration {none, underline, overline, line-through, blink}
	 */
	public void setTextDecoration(String decoration) {
		getElement().getStyle().setProperty("textDecoration", decoration);
	}
	
	/**
	 * Set text transform
	 * @param transform {capitalize, uppercase, lowercase, none}
	 */
	public void setTextTransform(String transform) {
		getElement().getStyle().setProperty("textTransform", transform);
	}
	
	@Override
	public void setPixelSize(int width, int height) {
		super.setPixelSize(ClientUtils.convertWidth(width), ClientUtils.convertHeight(height));
	}
	
	public int getPixelWidth() {
		return getElement().getClientWidth();
	}
	
	public int getPixelHeight() {
		return getElement().getClientHeight();
	}
	
	public void setWidth(int width) {
	    if (width >= 0) {
	        setWidth(width + "px");
	      }
	}
	
	public void setHeight(int height) {
		if (height >= 0) {
			setHeight(height + "px");
		}
	}
	

	@Override
	public void setBackgroundColor(String color) {
		getElement().getStyle().setProperty("backgroundColor", color);		
	}
}
