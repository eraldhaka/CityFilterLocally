package org.cityfilterlocally.loader;

import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.os.Bundle;
import com.google.gson.Gson;
import org.cityfilterlocally.model.CityModel;
import org.cityfilterlocally.util.Utils;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by Erald Haka.
 */
public class DataLoader extends AsyncTaskLoader<Collection<CityModel>> {

    private Gson gson;

    public DataLoader(Context context, Gson gson, Bundle bundle) {
        super(context);
        this.gson = gson;
    }

    public static void start(int loaderId,
                             LoaderManager.LoaderCallbacks<Collection<CityModel>> loaderCallbacks,
                             LoaderManager loaderManager) {
        Bundle args = new Bundle();
        loaderManager.initLoader(loaderId, args, loaderCallbacks);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public Collection<CityModel> loadInBackground() {
        Collection<CityModel> cityModels;
        try {
            cityModels = Utils.loadData(getContext(),gson);
        } catch (IOException e) {
            cityModels = null;
        }
        return cityModels;

    }
}
