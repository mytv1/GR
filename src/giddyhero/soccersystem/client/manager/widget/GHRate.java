package giddyhero.soccersystem.client.manager.widget;

import giddyhero.soccersystem.client.mobile.widget.GHTouchFlowPanel;
import giddyhero.soccersystem.client.mobile.widget.GHTouchImage;

import com.google.gwt.dom.client.Style.Float;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Image;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;

public class GHRate extends GHTouchFlowPanel implements HasValue<Integer> {
	
	private String selected_path = "";
	private String unselected_path = "";
	private ImageResource selected = null;
	private ImageResource unselected = null;
	
    private int rating = 0;
    private int rating_max = 10;
    private boolean read_only = false;
    private boolean is_path = true;
    
    public GHRate(int rating, int rating_max, boolean read_only, String selected_path, String unselected_path) {
        this.rating = rating;
        this.rating_max = rating_max;
        this.read_only = read_only;
        this.selected_path = selected_path;
        this.unselected_path = unselected_path;
        
        Image.prefetch(selected_path);
        Image.prefetch(unselected_path);
        
        buildWidget();
    }
    
    public GHRate(int rating, int rating_max, boolean read_only, ImageResource selected, ImageResource unselected) {
        this.rating = rating;
        this.rating_max = rating_max;
        this.read_only = read_only;
        this.selected = selected;
        this.unselected = unselected;
        this.is_path = false;
        
        buildWidget();
    }
    
    private void buildWidget() {
        //Stars
        for (int i = 0; i < this.getRatingMax(); i++) {
            GHTouchImage image = new GHTouchImage();
            image.setWidth((100/getRatingMax())+"%");
            image.setHeight("100%");
            image.setAlign(Float.LEFT);
            
            //Settings
            image.setTitle("" + (i + 1));
            image.addTapHandler(new TapHandler() {
				
            	@Override
				public void onTap(TapEvent event) {
                    if (!GHRate.this.isReadOnly()) {
                        Image image = (Image)event.getSource();
                        GHRate.this.setValue(Integer.parseInt(image.getTitle()), true);
                    }
				}
			});
            
            add(image);
        }
        
        //Set the star images
        this.setStarImages();
    }
    
    /**
     * Resets the button images
     */
    private void setStarImages() {
    	if (is_path) {
            for (int i = 0; i < this.getRatingMax(); i++) {
                Image image = (Image)getWidget(i);
                image.setUrl(this.getImagePath(i));        
            }
    	} else {
            for (int i = 0; i < this.getRatingMax(); i++) {
                Image image = (Image)getWidget(i);
                image.setResource(this.getImageResource(i));        
            }    		
    	}
    }
    
    /**
     * Gets the star image based on the index
     * @param index
     * @return
     */
    private String getImagePath(int index) {
        String path = "";
        
        if (index >= this.getRating()) {
            path = this.unselected_path;
        }
        else {
            path = this.selected_path;
        }
        
        return path;
    }
    
    /**
     * Gets the star image based on the index
     * @param index
     * @return
     */
    private ImageResource getImageResource(int index) {
        ImageResource resource = null;
        
        if (index >= this.getRating()) {
            resource = this.unselected;
        }
        else {
            resource = this.selected;
        }
        
        return resource;
    }

    /**
     * @return the rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * @return the rating_max
     */
    public int getRatingMax() {
        return rating_max;
    }

    /**
     * @return the read_only
     */
    public boolean isReadOnly() {
        return read_only;
    
    }

    /**
     * Adds a ValueChangehandler
     */
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<Integer> handler) {
        return addHandler(handler, ValueChangeEvent.getType());
    }

    /**
     * Get the rating value
     */
    public Integer getValue() {
        return this.getRating();
    }

    /**
     * Set the rating value
     * @param value the rating to set
     */
    public void setValue(Integer value) {
        this.rating = value;
        this.setStarImages();
    }

    /**
     * Set the rating value
     * @param value the rating to set
     * @param fireEvents fire events
     */
    public void setValue(Integer value, boolean fireEvents) {
        this.setValue(value);
        if (fireEvents)
            ValueChangeEvent.fire(this, value);
    }
}