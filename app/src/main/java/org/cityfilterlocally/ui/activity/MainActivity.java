package org.cityfilterlocally.ui.activity;
import android.app.LoaderManager;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import com.google.gson.Gson;
import org.cityfilterlocally.R;
import org.cityfilterlocally.loader.DataLoader;
import org.cityfilterlocally.model.CityModel;
import org.cityfilterlocally.ui.adapter.MainAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Erald Haka.
 */

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Collection<CityModel>>{

    private SearchView searchView;
    private ProgressBar loadingProgress;
    private Gson gson;
    ListView listItem;
    private int loaderId = 0;

    private List<CityModel> cityModel;
    private ArrayAdapter<CityModel> mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gson = new Gson();
        searchView = findViewById(R.id.search_view);
        loadingProgress = findViewById(R.id.loading_progress);
        listItem = findViewById(R.id.list_item);
        loadData();
    }

    private void loadData(){
        DataLoader.start(loaderId,this, getLoaderManager());
    }


    @Override
    public Loader<Collection<CityModel>> onCreateLoader(int i, Bundle bundle) {
        if (loaderId == i) {
            return new DataLoader(this, gson,bundle);
        } else {
            return null;
        }
    }

    @Override
    public void onLoadFinished(Loader<Collection<CityModel>> loader, Collection<CityModel> cityModels) {
        if(cityModels!=null){
            cityModel = new ArrayList<>(cityModels);
            mainAdapter = new MainAdapter(this, android.R.layout.simple_list_item_1, cityModel);
            listItem.setAdapter(mainAdapter);
            loadingProgress.setVisibility(View.INVISIBLE);
            searchView.setVisibility(View.VISIBLE);
        }else {
            loadingProgress.setVisibility(View.VISIBLE);
            searchView.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public void onLoaderReset(Loader<Collection<CityModel>> loader) {

    }
}
