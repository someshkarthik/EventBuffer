package com.appz.abhi.daksheventbuffer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class FestivalsActivity extends AppCompatActivity {

    ImageView nav_circle_festivals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_festivals);

        nav_circle_festivals = findViewById(R.id.nav_circle_festivals_id);

        nav_circle_festivals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FestivalsActivity.this, HomeActivity.class));
                finish();
            }
        });
    }
}
