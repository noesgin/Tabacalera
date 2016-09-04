/*
package com.example.noelia.tabacalera.news;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.noelia.tabacalera.R;

*/
/**
 * Created by Noelia on 16/08/2016.
 *//*


public class NewsAdapter extends PagerAdapter {

    private int[] img_resources = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};

    private Context ctx;
    private LayoutInflater layoutInflater;

    public NewsAdapter(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return img_resources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View item_view = layoutInflater.inflate(R.layout.item_swipe, container, false);

        ImageView imageEvento = (ImageView) item_view.findViewById(R.id.noticiaImag);
       // TextView textEvento = (TextView) item_view.findViewById(R.id.noticiaText);
        imageEvento.setImageResource(img_resources[position]);
       // textEvento.setText("Detalle..." + position);
        container.addView(item_view);

        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object view) {
        container.removeView((View) view);
    }

}
*/
