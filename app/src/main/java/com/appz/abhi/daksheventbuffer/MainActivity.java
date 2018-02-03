package com.appz.abhi.daksheventbuffer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button next, skip;
    SharedPreferences preferences;
    private ViewPager viewPager;
    private int[] layouts;
    private TextView[] dots;
    private ViewPagerAdapter viewPagerAdapter;
    private LinearLayout dotsLinearLayout;
    ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            addButtonDots(position);
            if (position == layouts.length - 1) {
                next.setText("PROCEED");
                skip.setVisibility(View.GONE);
            } else {
                next.setText("NEXT");
                skip.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences("pref_file", 0);
        if (!preferences.getBoolean("onboard", true)) {
            Intent i = new Intent(MainActivity.this, EventsActivity.class);
            startActivity(i);
            finish();
        } else {
            preferences.edit().putBoolean("onboard", false).apply();
        }
        viewPager = findViewById(R.id.onboard_viewpager);
        dotsLinearLayout = findViewById(R.id.dots_layout);
        skip = findViewById(R.id.skip);
        next = findViewById(R.id.next);
        layouts = new int[]{
                R.layout.screen1, R.layout.screen2, R.layout.screen3, R.layout.screen4
        };
        addButtonDots(0);
        changeStatusBarColor();
        viewPagerAdapter = new ViewPagerAdapter();
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(pageChangeListener);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, EventsActivity.class);
                startActivity(i);
                finish();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int current = getItem(+1);
                if (current < layouts.length) {
                    viewPager.setCurrentItem(current);
                } else {
                    Intent i = new Intent(MainActivity.this, EventsActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });

    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    private void addButtonDots(int position) {
        dots = new TextView[layouts.length];
        int[] colorActive = getResources().getIntArray(R.array.dot_active);
        int[] colorInActive = getResources().getIntArray(R.array.dot_inactive);
        dotsLinearLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226:"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorInActive[position]);
            dotsLinearLayout.addView(dots[i]);

        }
        if (dots.length > 0) {
            dots[position].setTextColor(colorActive[position]);
        }
    }

    private void changeStatusBarColor() {
        Window win = getWindow();
        win.getAttributes().systemUiVisibility |=
                (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        win.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        win.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        win.setStatusBarColor(Color.TRANSPARENT);

    }

    public class ViewPagerAdapter extends PagerAdapter {
        LayoutInflater layoutInflater;

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = layoutInflater.inflate(layouts[position], container, false);
            container.addView(v);
            return v;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
