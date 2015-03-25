package giddyhero.soccersystem.client.manager.widget;

import com.google.gwt.dom.client.Style.Float;

public interface ICSSEditable {
	public void setMarginTop(double pixel);
	
	public void setMarginBottom(double pixel);
	
	public void setMarginLeft(double pixel);

	public void setMarginRight(double pixel);
	
	public void setAlign(Float align);
	
	public void setBackgroundColor(String color);
	
	/**
	 * Set position
	 * @param position {static, relative, absolute, fixed}
	 */
	public void setPostion(String position);
	
	/**
	 * Set top unit Pixel (For absolute position)
	 * @param pixel
	 */
	public void setTop(double pixel);
	
	/**
	 * Set left unit Pixel (For absolute position)
	 * @param pixel
	 */
	public void setLeft(double pixel);
	
	/**
	 * Set bottom unit Pixel (For absolute position)
	 * @param pixel
	 */
	public void setBottom(double pixel);
	
	/**
	 * Set right unit Pixel (For absolute position)
	 * @param pixel
	 */
	public void setRight(double pixel);

	public void setPixelSize(int width, int height);
	
	public int getPixelWidth();
	
	public int getPixelHeight();
}
