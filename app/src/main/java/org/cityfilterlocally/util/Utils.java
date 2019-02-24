package org.cityfilterlocally.util;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.cityfilterlocally.model.CityModel;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

/**
 * Created by Erald Haka.
 */
public  class Utils {

    public static List<CityModel> loadData(Context context, Gson gson)throws IOException {
        InputStream citiesStream = context.getAssets().open("cities.json");
        Reader reader = new InputStreamReader(citiesStream, "UTF-8");
        Type listType = new TypeToken<List<CityModel>>() {
        }.getType();
        List<CityModel> cityModels = gson.fromJson(reader, listType);
        Collections.sort(cityModels);
        return cityModels;
    }
}
