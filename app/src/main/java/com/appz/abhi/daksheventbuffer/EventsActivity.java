package com.appz.abhi.daksheventbuffer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;

public class EventsActivity extends AppCompatActivity {

    ImageView nav_circle_events;
    CardView c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        nav_circle_events = findViewById(R.id.nav_circle_events_id);

        nav_circle_events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EventsActivity.this, HomeActivity.class));
                finish();
            }
        });

        c1 = findViewById(R.id.cardview_id1);
        c2 = findViewById(R.id.cardview_id2);
        c3 = findViewById(R.id.cardview_id3);
        c4 = findViewById(R.id.cardview_id4);
        c5 = findViewById(R.id.cardview_id5);
        c6 = findViewById(R.id.cardview_id6);
        c7 = findViewById(R.id.cardview_id7);
        c8 = findViewById(R.id.cardview_id8);
        c9 = findViewById(R.id.cardview_id9);
        c10 = findViewById(R.id.cardview_id10);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EventsActivity.this, QuizActivity.class));
            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EventsActivity.this, DevappsActivity.class));
            }
        });

        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EventsActivity.this, PitchProductActivity.class));
            }
        });

        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EventsActivity.this, MockInterviewActivity.class));
            }
        });

        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EventsActivity.this, BlindTypoActivity.class));
            }
        });

        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EventsActivity.this, PhotoRangerActivity.class));
            }
        });

        c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EventsActivity.this, CodexActivity.class));
            }
        });

        c8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EventsActivity.this, FindItActivity.class));
            }
        });

        c9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EventsActivity.this, HopperActivity.class));
            }
        });

        c10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EventsActivity.this, CombinationsActivity.class));
            }
        });

    }
}
