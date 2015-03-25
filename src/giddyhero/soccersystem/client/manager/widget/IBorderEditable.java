package giddyhero.soccersystem.client.manager.widget;

public interface IBorderEditable {
	/**
	 * Set border color
	 * @param colors [top - left - bottom -right]
	 * Ignore use ""
	 */
	public void setBorderColor(String ... colors);
	
	/**
	 * Set border width
	 * @param width [top - left - bottom -right]
	 * Ignore use ""
	 */
	public void setBorderWidth(String ... width);
	
	/**
	 * Set border radius
	 * @param radius [top - left, top - right, bottom - left, bottom - right]
	 * Ignore use ""
	 */
	public void setBorderRadius(String ... radius);
	
}
