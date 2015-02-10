package giddyhero.soccersystem.client.mobile.activities;

import giddyhero.soccersystem.client.mobile.activities.greeting.GreetingPlace;
import giddyhero.soccersystem.client.mobile.activities.greeting.GreetingPlace.GreetingPlaceTokenizer;
import giddyhero.soccersystem.client.mobile.activities.home.HomePlace.HomePlaceTokenizer;
import giddyhero.soccersystem.client.mobile.activities.news.detail.NewsDetailPlace;
import giddyhero.soccersystem.client.mobile.activities.news.detail.NewsDetailPlace.NewsDetailPlaceTokenizer;
import giddyhero.soccersystem.client.mobile.activities.news.list.NewsPlace.NewsPlaceTokenizer;
import giddyhero.soccersystem.client.mobile.activities.player.PlayerPlace.PlayerPlaceTokenizer;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({ GreetingPlaceTokenizer.class, HomePlaceTokenizer.class, NewsPlaceTokenizer.class, NewsDetailPlaceTokenizer.class, PlayerPlaceTokenizer.class })
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}
