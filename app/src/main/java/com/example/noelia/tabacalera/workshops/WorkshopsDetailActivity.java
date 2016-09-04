package com.example.noelia.tabacalera.workshops;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.noelia.tabacalera.R;

public class WorkshopsDetailActivity extends AppCompatActivity {

    public static final String IMAGE = "img_id";
    public static final String NAME = "name";
    public static final String SCHEDULE = "horario";
    public static final String DESCRIPTION = "descripcion";
    public static final String TYPE ="type";

    private ImageView ivImage;
    private TextView tvName, tvSchedule, tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_workshops_detail);

        ivImage = (ImageView) findViewById(R.id.TallerImageDetalle);
        tvName = (TextView) findViewById(R.id.TallerTextName);
        tvSchedule = (TextView) findViewById(R.id.TallerTextDetalle);
        tvDescription = (TextView) findViewById(R.id.tvDescription);

        Glide.with(this).load(getIntent().getStringExtra(IMAGE)).into(ivImage);
        tvName.setText(getIntent().getStringExtra(NAME));
        tvSchedule.setText(getIntent().getStringExtra(SCHEDULE));
        tvDescription.setText(getIntent().getStringExtra(DESCRIPTION));

        ///TOOLBAR///

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("taller");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                finish();
                WorkshopsDetailActivity.this.overridePendingTransition(R.anim.right_in, R.anim.right_out);
            }
        });
    }
}
