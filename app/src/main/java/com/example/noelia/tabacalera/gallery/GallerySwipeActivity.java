package com.example.noelia.tabacalera.gallery;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.noelia.tabacalera.R;
import com.squareup.picasso.Picasso;



public class GallerySwipeActivity extends AppCompatActivity {

    private Context ctx;
    private LayoutInflater layoutInflater;
    public Context context;
    public static String[] items = {
            "http://madrider.es/wp-content/uploads/2013/08/Lucha-Libre-en-La-Tabacalera.jpg",
            "https://pbs.twimg.com/profile_images/1329905318/201271_206652302691908_203880556302416_744352_1974764_o.jpg",
            "http://elpais.com/diario/imagenes/2011/11/12/madrid/1321100662_850215_0000000000_sumario_normal.jpg",
            "http://mundoturistico.es/wp-content/uploads/2011/05/taba.jpg",
            "http://1.bp.blogspot.com/-4VDZlTfoZlE/U4X0tc0O5mI/AAAAAAAAG1g/9WIClloaues/s1600/6.jpg",
            "http://madriddiferente.com/wp-content/uploads/2011/07/La-Tabacalera-01.jpg",
            "https://culturaconectada.files.wordpress.com/2014/01/keller.jpg?w=350&h=200&crop=1",
            "http://escuela-fotografia-digital.com/wp-content/uploads/2013/11/12370026943_bf2ff56774_o-710x575.jpg",
            "http://cdn.traveler.es/uploads/images/thumbs/es/trav/2/s/2016/06/chylo_y_findac_en_tabacalera_embajadores_51_8945_1400x933.jpg",
            "http://3.bp.blogspot.com/-uqWOoJs9Nis/U3jdk69yNoI/AAAAAAAD3KY/_dGnSZdkhaM/s1600/IMG_7338.jpg",
            "http://revistaplacet.es/wp-content/uploads/2016/07/AntonyoMarest.jpg",
            "http://moovemag.com/wp-content/uploads/2013/03/taller-cocina.jpg",
            "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQLmyER0uSx7RYSgN-wIJnze_tP-nKbNSg7OmQ0CYu6WC1t-sMmFA",
            "http://payload214.cargocollective.com/1/13/443850/6588235/4875211356_12cfbf2f10_z.jpg",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_swipe);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("foto");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        String i = getIntent().getStringExtra("position");
        int index = Integer.parseInt(i);
        SwipeImagePagerAdapter swipeNewsAdapter = new SwipeImagePagerAdapter();
        ViewPager newsPager = (ViewPager) findViewById(R.id.swipe_pager);
        newsPager.setAdapter(swipeNewsAdapter);
        newsPager.setCurrentItem(index);

        newsPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {
                GalleryActivity.mSelected = i;
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private class SwipeImagePagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return GalleryActivity.items.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return (view == object);
        }

        @Override
        public Object instantiateItem(ViewGroup collection, int position) {
            LayoutInflater inflater = (LayoutInflater) collection.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View item_view = inflater.inflate(R.layout.item_swipe, collection, false);
            ImageView imageEvento = (ImageView) item_view.findViewById(R.id.noticiaImag);

          //  ImageView imageGaleriaDetalle = (ImageView) findViewById(R.id.imageGaleriaDetalle);
            //imageView.setImageResource(Integer.parseInt(items[position]));
            //Uso de la librería Picasso
            Picasso.with(context)
                    //Cargamos la imagen sobre la que se esté iterando
                    .load(items[position])
                    //Imagen por defecto usada mientras se cargan las imágenes
                    .placeholder(R.drawable.rounded_edit_text)
                    //.resize(200, 300)
                   // .centerCrop()
                    //Se aplica sobre la imagen (ImageView - se hizo referencia a "convertView")
                    .into(imageEvento);

            collection.addView(item_view, 0);

            return item_view;
        }

        @Override
        public void destroyItem(ViewGroup collection, int position, Object view) {
            collection.removeView((View) view);
        }

        @Override
        public void finishUpdate(ViewGroup arg0) {
        }

        @Override
        public void restoreState(Parcelable arg0, ClassLoader arg1) {
        }
        @Override
        public Parcelable saveState() {
            return null;
        }
        @Override
        public void startUpdate(ViewGroup arg0) {
        }
    }
}
