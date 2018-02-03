package com.appz.abhi.daksheventbuffer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class TimelineActivity extends AppCompatActivity {

    ImageView nav_circle_timeline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        nav_circle_timeline = findViewById(R.id.nav_circle_timeline_id);

        nav_circle_timeline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TimelineActivity.this, HomeActivity.class));
                finish();
            }
        });
    }
}
