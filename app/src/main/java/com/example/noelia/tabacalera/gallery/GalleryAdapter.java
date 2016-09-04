package com.example.noelia.tabacalera.gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.noelia.tabacalera.R;
import com.squareup.picasso.Picasso;


/**
 * Created by Noelia on 13/08/2016.
 */

public class GalleryAdapter extends BaseAdapter {

    private Context context;
    private String[] items;

    public GalleryAdapter(Context context, String[] items) {
        super();
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Declaramos el ImageView
        ImageView img = null;

        if (convertView == null) {
            //Referenciamos el ImageView
            img = new ImageView(context);
            //Referenciamos el ImageView al convertView
            convertView = img;
            img.setPadding(2,2,2,2);
            img.setAdjustViewBounds(true);
        } else {
            img = (ImageView) convertView;
        }
        //Uso de la librería Picasso
        Picasso.with(context)
                //Cargamos la imagen sobre la que se esté iterando
                .load(items[position])
                //Imagen por defecto usada mientras se cargan las imágenes
                .placeholder(R.drawable.rounded_edit_text)
                .resize(200, 200)
                .centerCrop()
                //Se aplica sobre la imagen (ImageView - se hizo referencia a "convertView")
                .into(img);

        return convertView;

/*        ImageView img = null;
        String item = new GalleryDataProvider(items[position]).getImage();
        Picasso.with(context).load(url+item).resize(100,100).into(img);
        return img;*/
    }

    static class ViewHolder {
        ImageView imageView;
    }

}
