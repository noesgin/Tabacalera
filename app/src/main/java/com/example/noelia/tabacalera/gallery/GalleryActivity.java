package com.example.noelia.tabacalera.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.example.noelia.tabacalera.R;

public class GalleryActivity extends AppCompatActivity {
    //  ArrayList images = new ArrayList();
/*    public String[] items;*/
    //   private ArrayList<GalleryDataProvider> items = new ArrayList<>();

    public static int mSelected = 0;
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
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_gallery);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Galeria");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setDrawSelectorOnTop(true);
        gridView.setAdapter(new GalleryAdapter(GalleryActivity.this, items));

        gridView.setSelection(mSelected);

        gridView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
/*                String image = String.valueOf(parent.getItemAtPosition(position));
                Intent i = new Intent(GalleryActivity.this, GalleryDetailActivity.class);
                i.putExtra(GalleryDetailActivity.EXTRA_IMAGE, image);
                startActivity(i);*/

                String index = String.valueOf(position);
                Bundle extras = new Bundle();
                extras.putString("position", index);
                startActivity(new Intent(GalleryActivity.this, GallerySwipeActivity.class).putExtras(extras).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));

/*                HashMap<String, Object> selected = (HashMap<String, Object>)
                     gridView.getItemAtPosition(position);*/
            }
        });
    }

}