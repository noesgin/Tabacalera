package com.example.noelia.tabacalera.location;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

import com.example.noelia.tabacalera.R;

import java.util.Locale;

public class LocationActivity extends AppCompatActivity {
    ViewPager viewPager;
    //NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_location);

        ////TOOLBAR////
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Ubicación");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                finish();
                LocationActivity.this.overridePendingTransition(R.anim.right_in, R.anim.right_out);
            }
        });

        final ImageButton bMaps = (ImageButton) findViewById(R.id.googleMaps);
        bMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = String.format(Locale.ENGLISH, "geo:%f,%f", 40.4062145, -3.7052288);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                LocationActivity.this.startActivity(intent);
            }

        });
    }
}
