package com.example.noelia.tabacalera.events;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.noelia.tabacalera.R;

public class EventsDetailActivity extends AppCompatActivity {
    public static final String IMAGE = "img_id";

    private ImageView ivImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_events_detail);

        ivImage = (ImageView) findViewById(R.id.TallerImageDetalle);
        Glide.with(this).load(getIntent().getStringExtra(IMAGE)).into(ivImage);

        ///TOOLBAR///

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("evento");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                finish();
                EventsDetailActivity.this.overridePendingTransition(R.anim.right_in, R.anim.right_out);
            }
        });
    }
}
