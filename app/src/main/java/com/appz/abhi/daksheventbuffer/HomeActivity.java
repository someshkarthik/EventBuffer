package com.appz.abhi.daksheventbuffer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity {

    LinearLayout events_ll, festivals_ll, timeline_ll, profile_ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        events_ll = findViewById(R.id.events_ll_id);
        festivals_ll = findViewById(R.id.festivals_ll_id);
        timeline_ll = findViewById(R.id.timeline_ll_id);
        profile_ll = findViewById(R.id.profile_ll_id);

        events_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, EventsActivity.class));
                finish();
            }
        });

        festivals_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, FestivalsActivity.class));
                finish();
            }
        });

        timeline_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, TimelineActivity.class));
                finish();
            }
        });

        profile_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ProfileActivity.class));
                finish();
            }
        });
    }
}
