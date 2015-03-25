package giddyhero.soccersystem.client.manager.widget;

import giddyhero.soccersystem.client.ClientUtils;

import com.google.gwt.dom.client.Style.Float;
import com.google.gwt.dom.client.Style.Unit;
import com.googlecode.mgwt.ui.client.widget.carousel.Carousel;

public class GHCarousel extends Carousel implements ICSSEditable {
	
	public GHCarousel() {
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
}
