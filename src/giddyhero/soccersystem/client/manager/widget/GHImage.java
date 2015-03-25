package giddyhero.soccersystem.client.manager.widget;

import giddyhero.soccersystem.client.ClientUtils;

import com.google.gwt.dom.client.Style.Float;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;

public class GHImage extends Image implements ICSSEditable{
	
	public GHImage() {
		super();
	}
	
	public GHImage(ImageResource resource) {
		super(resource);
	}
	
	public GHImage(String url) {
		super(url);
	}
	
	/**
	 * Set MarginTop unit Pixel
	 * @param pixel
	 */
	public void setMarginTop(double pixel) {
		getElement().getStyle().setMarginTop(pixel, Unit.PX);
	}
	
	/**
	 * Set MarginBottom unit Pixel
	 * @param pixel
	 */
	public void setMarginBottom(double pixel) {
		getElement().getStyle().setMarginBottom(pixel, Unit.PX);
	}
	
	/**
	 * Set MarginLeft unit Pixel
	 * @param pixel
	 */
	public void setMarginLeft(double pixel) {
		getElement().getStyle().setMarginLeft(pixel, Unit.PX);
	}

	/**
	 * Set MarginRight unit Pixel
	 * @param pixel
	 */
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
	 * Align all children in center
	 */
	public void alignCenter() {		
		getElement().getStyle().setProperty("display", "table-cell");
		getElement().getStyle().setProperty("verticalAlign", "middle");
		getElement().getStyle().setProperty("textAlign", "center");
	}
	
	/**
	 * Set size by percent
	 * @param percent
	 */
	public void setPercentSize(int percent) {
		int oldWidth = getWidth();
		int oldHeight = getHeight();
		
		setPixelSize(oldWidth*percent/100, oldHeight*percent/100);
	}
	
	public void setZIndex(int index) {
		getElement().getStyle().setZIndex(index);
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

	@Override
	public void setBackgroundColor(String color) {
		getElement().getStyle().setProperty("backgroundColor", color);		
	}
}