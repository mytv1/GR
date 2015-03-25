package giddyhero.soccersystem.client.manager.widget;

import giddyhero.soccersystem.client.ClientUtils;

import com.google.gwt.dom.client.Style.Float;
import com.google.gwt.dom.client.Style.Unit;
import com.googlecode.mgwt.ui.client.widget.input.MTextArea;

public class GHTextArea extends MTextArea implements ICSSEditable,IBorderEditable{
	
	public GHTextArea() {
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
	
	public void setBackgroundColor(String color) {
		getElement().getStyle().setProperty("backgroundColor", color);
	}
	
	public void setColor(String color) {
		getElement().getStyle().setProperty("color", color);
	}
	
	/**
	 * Set border color
	 * @param colors [top - left - bottom -right]
	 * Ignore use ""
	 */
	public void setBorderColor(String ... colors) {
		switch (colors.length) {
		case 1:
			if (!colors[0].equals("")) getElement().getStyle().setProperty("borderTopColor", colors[0]);
			break;
			
		case 2:
			if (!colors[0].equals("")) getElement().getStyle().setProperty("borderTopColor", colors[0]);
			if (!colors[1].equals("")) getElement().getStyle().setProperty("borderLeftColor", colors[1]);
			break;
			
		case 3:
			if (!colors[0].equals("")) getElement().getStyle().setProperty("borderTopColor", colors[0]);
			if (!colors[1].equals("")) getElement().getStyle().setProperty("borderLeftColor", colors[1]);
			if (!colors[2].equals("")) getElement().getStyle().setProperty("borderBottomColor", colors[2]);
			break;
			
		case 4:
			if (!colors[0].equals("")) getElement().getStyle().setProperty("borderTopColor", colors[0]);
			if (!colors[1].equals("")) getElement().getStyle().setProperty("borderLeftColor", colors[1]);
			if (!colors[2].equals("")) getElement().getStyle().setProperty("borderBottomColor", colors[2]);
			if (!colors[3].equals("")) getElement().getStyle().setProperty("borderRightColor", colors[3]);
			break;
			
		default:
			break;
		}
	}
	
	/**
	 * Set border width
	 * @param width [top - left - bottom -right]
	 * Ignore use ""
	 */
	public void setBorderWidth(String ... width) {
		switch (width.length) {
		case 1:
			if (!width[0].equals("")) getElement().getStyle().setProperty("borderTopWidth", width[0]);
			break;
			
		case 2:
			if (!width[0].equals("")) getElement().getStyle().setProperty("borderTopWidth", width[0]);
			if (!width[1].equals("")) getElement().getStyle().setProperty("borderLeftWidth", width[1]);
			break;
			
		case 3:
			if (!width[0].equals("")) getElement().getStyle().setProperty("borderTopWidth", width[0]);
			if (!width[1].equals("")) getElement().getStyle().setProperty("borderLeftWidth", width[1]);
			if (!width[2].equals("")) getElement().getStyle().setProperty("borderBottomWidth", width[2]);
			break;
			
		case 4:
			if (!width[0].equals("")) getElement().getStyle().setProperty("borderTopWidth", width[0]);
			if (!width[1].equals("")) getElement().getStyle().setProperty("borderLeftWidth", width[1]);
			if (!width[2].equals("")) getElement().getStyle().setProperty("borderBottomWidth", width[2]);
			if (!width[3].equals("")) getElement().getStyle().setProperty("borderRightWidth", width[3]);
			break;
			
		default:
			break;
		}		
	}
	
	/**
	 * Set border radius
	 * @param radius [top - left, top - right, bottom - left, bottom - right]
	 * Ignore use ""
	 */
	public void setBorderRadius(String ... radius) {
		switch (radius.length) {
		case 1:
			if (!radius[0].equals("")) getElement().getStyle().setProperty("borderTopLeftRadius", radius[0]);
			break;
			
		case 2:
			if (!radius[0].equals("")) getElement().getStyle().setProperty("borderTopLeftRadius", radius[0]);
			if (!radius[1].equals("")) getElement().getStyle().setProperty("borderTopRightRadius", radius[1]);
			break;
			
		case 3:
			if (!radius[0].equals("")) getElement().getStyle().setProperty("borderTopLeftRadius", radius[0]);
			if (!radius[1].equals("")) getElement().getStyle().setProperty("borderTopRightRadius", radius[1]);
			if (!radius[2].equals("")) getElement().getStyle().setProperty("borderBottomLeftRadius", radius[2]);
			break;
			
		case 4:
			if (!radius[0].equals("")) getElement().getStyle().setProperty("borderTopLeftRadius", radius[0]);
			if (!radius[1].equals("")) getElement().getStyle().setProperty("borderTopRightRadius", radius[1]);
			if (!radius[2].equals("")) getElement().getStyle().setProperty("borderBottomLeftRadius", radius[2]);
			if (!radius[3].equals("")) getElement().getStyle().setProperty("borderBottomRightRadius", radius[3]);
			break;
			
		default:
			break;
		}
	}
	
	/**
	 * Set border style
	 * @param style {solid, dotted, dashed, double, inset, outset, none, hidden}
	 */
	public void setBorderStyle(String style) {
		getElement().getStyle().setProperty("borderStyle", style);
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
	
	public int getPixelWidth() {
		return getElement().getClientWidth();
	}
	
	public int getPixelHeight() {
		return getElement().getClientHeight();
	}
}
