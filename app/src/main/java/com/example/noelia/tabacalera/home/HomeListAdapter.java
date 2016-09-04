package com.example.noelia.tabacalera.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.noelia.tabacalera.R;

/**
 * Created by Noelia on 19/08/2016.
 */

public class HomeListAdapter extends BaseAdapter {

    Context context;
    String[] className;
    int[] listImage;
    LayoutInflater inflater;

    public HomeListAdapter (Context context, String[] className, int[] lisImage){
        this.context = context;
        this.className = className;
        this.listImage = lisImage;
    }

    @Override
    public int getCount() {
        return className.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView txtTitle;
        ImageView imgImg;

        //http://developer.android.com/intl/es/reference/android/view/LayoutInflater.html
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.activity_home_lista, parent, false);

        // Locate the TextViews in listview_item.xml
        txtTitle = (TextView) itemView.findViewById(R.id.rowList);
        imgImg = (ImageView) itemView.findViewById(R.id.icon);

        // Capture position and set to the TextViews
        txtTitle.setText(className[position]);
        imgImg.setImageResource(listImage[position]);

        return itemView;
    }
}
