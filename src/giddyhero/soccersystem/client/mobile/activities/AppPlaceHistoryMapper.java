package giddyhero.soccersystem.client.mobile.activities;

import giddyhero.soccersystem.client.mobile.activities.greeting.GreetingPlace;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({ GreetingPlace.HomePlaceTokenizer.class, giddyhero.soccersystem.client.mobile.activities.greeting.GreetingPlace.HomePlaceTokenizer.class })
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}
