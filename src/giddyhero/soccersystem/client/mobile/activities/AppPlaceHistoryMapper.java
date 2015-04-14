package giddyhero.soccersystem.client.mobile.activities;

import giddyhero.soccersystem.client.mobile.activities.home.HomePlace.HomePlaceTokenizer;
import giddyhero.soccersystem.client.mobile.activities.livescore.LiveScorePlace.LiveScorePlaceTokenizer;
import giddyhero.soccersystem.client.mobile.activities.livescore.LiveScoreViewImpl;
import giddyhero.soccersystem.client.mobile.activities.news.NewsPlace.NewsPlaceTokenizer;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({ HomePlaceTokenizer.class, NewsPlaceTokenizer.class, LiveScorePlaceTokenizer.class })

public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}
