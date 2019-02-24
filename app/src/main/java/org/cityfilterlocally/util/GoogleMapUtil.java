package org.cityfilterlocally.util;

import android.content.Intent;
import android.net.Uri;
import org.cityfilterlocally.model.CityModel;
import java.util.Locale;

/**
 * Created by Erald Haka.
 */
public class GoogleMapUtil {

    public static Intent gMapIntent(CityModel cityModel) {
        double lat = cityModel.getCoord().getLat();
        double lng = cityModel.getCoord().getLon();
        String mapsUri = String.format(Locale.ENGLISH, "geo:%f,%f", lat, lng);
        Uri uri = Uri.parse(mapsUri);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, uri);
        mapIntent.setPackage("com.google.android.apps.maps");
        return mapIntent;
    }
}
