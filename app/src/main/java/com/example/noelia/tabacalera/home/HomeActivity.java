package com.example.noelia.tabacalera.home;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.noelia.tabacalera.InfoActivity;
import com.example.noelia.tabacalera.R;
import com.example.noelia.tabacalera.events.EventsActivity;
import com.example.noelia.tabacalera.gallery.GalleryActivity;
import com.example.noelia.tabacalera.location.LocationActivity;
import com.example.noelia.tabacalera.workshops.WorkshopsActivity;


public class HomeActivity extends AppCompatActivity {

    static TextView mDotsText[];
    private int mDotsCount;
    private LinearLayout mDotsLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);

        vistas();

        //here we create the gallery and set our adapter created before
        Gallery gallery = (Gallery) findViewById(R.id.gallery);
        gallery.setAdapter(new HomeImageAdapter(this));


        ////DOTS/////
        mDotsLayout = (LinearLayout) findViewById(R.id.image_count);
        //here we count the number of images we have to know how many dots we need
        mDotsCount = gallery.getAdapter().getCount();
        mDotsText = new TextView[mDotsCount];
        for (int i = 0; i < mDotsCount; i++) {
            mDotsText[i] = new TextView(this);
            mDotsText[i].setText(".");
            mDotsText[i].setTextSize(40);
            mDotsText[i].setTypeface(null, Typeface.BOLD);
            mDotsText[i].setTextColor(android.graphics.Color.GRAY);
            mDotsLayout.addView(mDotsText[i]);
        }

        gallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView adapterView, View view, int pos, long l) {
                for (int i = 0; i < mDotsCount; i++) {
                    HomeActivity.mDotsText[i]
                            .setTextColor(Color.GRAY);
                }
                HomeActivity.mDotsText[pos]
                        .setTextColor(Color.BLACK);
            }
            @Override
            public void onNothingSelected(AdapterView adapterView) {
            }
        });


        ////INFO TOOLBAR////
        final ImageButton info = (ImageButton)findViewById(R.id.info);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, InfoActivity.class);
                HomeActivity.this.startActivity(intent);
            }
        });

    }

    ///LISTVIEW////
    private void vistas() {
        String classNames[] = {"Talleres", "Eventos", "Galería", "Ubicación"};

        int[] listImages = {R.drawable.pencil, R.drawable.calendar, R.drawable.image,R.drawable.ubicacion};
        //ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, classNames);
        ListAdapter adapter = new HomeListAdapter(this, classNames, listImages);

        ListView listview = (ListView) findViewById(R.id.listView);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String textPosition = String.valueOf(parent.getItemAtPosition(position));

                if (position == 0) {
                    Intent intent = new Intent(HomeActivity.this, WorkshopsActivity.class);
                    intent.putExtra(WorkshopsActivity.TYPE, WorkshopsActivity.class.getSimpleName());
                    startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(HomeActivity.this, WorkshopsActivity.class);
                    intent.putExtra(WorkshopsActivity.TYPE, EventsActivity.class.getSimpleName());
                    startActivity(intent);
                } else if (position == 2) {
                    Intent intent = new Intent(HomeActivity.this, GalleryActivity.class);
                    startActivity(intent);
                } else if (position == 3) {
                    Intent intent = new Intent(HomeActivity.this, LocationActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public Boolean exit = false;
    public void onBackPressed() {
        if (exit) {
            //this.finish(); // finish activity
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Pulsa de nuevo atrás para salir.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);
        }
    }
}
