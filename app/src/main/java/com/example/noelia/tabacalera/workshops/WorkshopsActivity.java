
package com.example.noelia.tabacalera.workshops;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.noelia.tabacalera.R;
import com.example.noelia.tabacalera.events.EventsActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class WorkshopsActivity extends AppCompatActivity {

    public static final String NAMES = "names";
    public static final String SCHEDULES = "schedules";
    public static final String IMAGES = "images";
    public static final String TYPE = "type";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<WorkshopsDataProvider> list = new ArrayList<>();
    ProgressDialog progressDialog;
    RequestQueue requestQueue;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_workshops);

        ////TOOLBAR////
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setTitle("Home");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // to disable title in a toolbar
      //  getSupportActionBar().setDisplayShowTitleEnabled(false);

        requestQueue = Volley.newRequestQueue(getApplicationContext());

        showInfo();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                finish();
                WorkshopsActivity.this.overridePendingTransition(R.anim.right_in, R.anim.right_out);
            }
        });
    }


    private void showInfo() {

        String type = getIntent().getStringExtra(TYPE);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        adapter = new WorkshopsRecyclerAdapter(list, this, type);
        recyclerView.setAdapter(adapter);
        recyclerView.setClickable(true);

        String url = null;
        if (type.equals(WorkshopsActivity.class.getSimpleName())) {
                url = "http://tabacalera.net23.net/workShopsQuery.php";
            getSupportActionBar().setTitle("Talleres");
        } else if (type.equals(EventsActivity.class.getSimpleName())) {
            url = "http://tabacalera.net23.net/eventsShopsQuery.php";
            getSupportActionBar().setTitle("Eventos");
        }

        JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject object = response.getJSONObject(i);
                        String iconUrl = object.getString("icon"); //BBDD Table atribute name
                        String name = object.getString("name");
                        String schedule = object.getString("schedule");
                        String description = object.getString("description");
                        String imageUrl = object.getString("pic");

                        list.add(new WorkshopsDataProvider(
                                iconUrl, name, schedule, description, imageUrl
                        ));

                    } catch (JSONException e) {
                        Toast.makeText(WorkshopsActivity.this, "" + e, Toast.LENGTH_LONG).show();
                    }
                }


                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(request);

    }

}
