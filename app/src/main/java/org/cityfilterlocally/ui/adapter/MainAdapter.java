package org.cityfilterlocally.ui.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
import org.cityfilterlocally.model.CityModel;
import java.util.List;

/**
 * Created by Erald Haka.
 */
public class MainAdapter  extends ArrayAdapter<CityModel> {

    public MainAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<CityModel> cityModels) {
        super(context, resource, cityModels);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (null == convertView) {
            convertView = LayoutInflater
                    .from(parent.getContext())
                    .inflate(android.R.layout.simple_list_item_1, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        CityModel cityModel = getItem(position);

        if (cityModel != null) {
            viewHolder.bind(cityModel);
        }

        return convertView;
    }

    static final class ViewHolder {

        private final TextView txtFullName;

        ViewHolder(View itemView) {
            this.txtFullName = itemView.findViewById(android.R.id.text1);
        }

        void bind(CityModel city) {
            this.txtFullName.setText(city.getFullName());
        }
    }
}
