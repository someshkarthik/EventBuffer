package com.appz.abhi.daksheventbuffer;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class ProfileActivity extends AppCompatActivity {

    ImageView nav_circle_profile;
    ImageView imageView;
    RoundImage roundedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        nav_circle_profile = findViewById(R.id.nav_circle_profile_id);

        nav_circle_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, HomeActivity.class));
                finish();
            }
        });

        imageView = findViewById(R.id.imageView_id);
        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.profile_pic);
        roundedImage = new RoundImage(bm);
        imageView.setImageDrawable(roundedImage);
    }
}
