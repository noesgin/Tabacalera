/*
package com.example.noelia.tabacalera.gallery;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.ImageView;

import com.example.noelia.tabacalera.R;
import com.squareup.picasso.Picasso;


public class GalleryDetailActivity extends AppCompatActivity {

    public static final String EXTRA_IMAGE = "extra_image";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.activity_gallery_detail);

            ImageView imageGaleriaDetalle = (ImageView) findViewById(R.id.imageGaleriaDetalle);
            if (getIntent() != null && getIntent().getExtras() != null) {
                if (getIntent().getExtras().containsKey(EXTRA_IMAGE)) {
                    Picasso.with(this).load(getIntent().getExtras().getString(EXTRA_IMAGE)).into(imageGaleriaDetalle);
                }
            }
        }
    }

*/
