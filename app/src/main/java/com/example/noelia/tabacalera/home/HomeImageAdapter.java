package com.example.noelia.tabacalera.home;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.example.noelia.tabacalera.R;

/**
 * Created by Noelia on 12/08/2016.
 */

public class HomeImageAdapter extends BaseAdapter {
    private Context mContext;
    //array of integers for images IDs
    private Integer[] imageIds = {R.drawable.home1, R.drawable.home2, R.drawable.home3};

    ImageRequest imageRequest = new ImageRequest("http://blogs.publico.es/fueradelugar/files/2011/11/tabaca2.jpg", new Response.Listener<Bitmap>() {
        @Override
        public void onResponse(Bitmap response) {
            //Hacer algo con el Bitmap
            ImageView imagOne = null;
            imagOne.setImageBitmap(response);
        }
    }, 0, 0, ImageView.ScaleType.CENTER_CROP, Bitmap.Config.ARGB_8888, new Response.ErrorListener(){
        @Override
        public void onErrorResponse(VolleyError error) {
        }
    }
    );

    public ImageRequest getImageRequest() {
        return imageRequest;
    }

    //constructor
    public HomeImageAdapter(Context c) {
        mContext = c;
    }

    @Override
    public int getCount() {
        return imageIds.length;
    }

    @Override
    public Object getItem(int i) {
      return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(mContext);

        imageView.setImageResource(imageIds[i]);
        imageView.setLayoutParams(new Gallery.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
        return imageView;

    }
}
