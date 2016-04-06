package com.intrixtech.unlok.view.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.intrixtech.unlok.R;
import com.intrixtech.unlok.UnlockActivity;
import com.intrixtech.unlok.adapter.ScreenSlidePagerAdapter;
import com.intrixtech.unlok.utils.Constants;
import com.intrixtech.unlok.widget.CrossfadePageTransformer;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Arti Verma on 06/04/16.
 */
public class UnlockTourActivity extends UnlockActivity {

    ViewPager pager;
    LinearLayout circles;
    Button skip;
    ImageButton next;
    Button done;
    RelativeLayout top_layout, button_layout;

    PagerAdapter pagerAdapter;
    boolean isOpaque = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.unlock_tour_activity);

        skip = Button.class.cast(findViewById(R.id.skip));
        next = ImageButton.class.cast(findViewById(R.id.next));
        done = Button.class.cast(findViewById(R.id.done));
        pager = (ViewPager) findViewById(R.id.pager);
        circles = LinearLayout.class.cast(findViewById(R.id.circles));
        top_layout = RelativeLayout.class.cast(findViewById(R.id.top_layout));
        button_layout = RelativeLayout.class.cast(findViewById(R.id.button_layout));

        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);
        pager.setPageTransformer(true, new CrossfadePageTransformer());
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position == Constants.NUM_PAGES - 2 && positionOffset > 0) {
                    if (isOpaque) {
                        pager.setBackgroundColor(Color.TRANSPARENT);
                        isOpaque = false;
                    }
                } else {
                    if (!isOpaque) {
                        pager.setBackgroundColor(getResources().getColor(R.color.primary_material_light));
                        isOpaque = true;
                    }
                }

                if(position == 0){
                    top_layout.setBackgroundColor(ContextCompat.getColor(UnlockTourActivity.this,
                            R.color.screen1_color));
                    button_layout.setBackgroundColor(ContextCompat.getColor(UnlockTourActivity.this,
                            R.color.screen1_color));
                }else if(position == 1){
                    top_layout.setBackgroundColor(ContextCompat.getColor(UnlockTourActivity.this,
                            R.color.screen2_color));
                    button_layout.setBackgroundColor(ContextCompat.getColor(UnlockTourActivity.this,
                            R.color.screen2_color));
                }else if(position == 2){
                    top_layout.setBackgroundColor(ContextCompat.getColor(UnlockTourActivity.this,
                            R.color.screen3_color));
                    button_layout.setBackgroundColor(ContextCompat.getColor(UnlockTourActivity.this,
                            R.color.screen3_color));
                }
            }

            @Override
            public void onPageSelected(int position) {
                setIndicator(position);
                if (position == Constants.NUM_PAGES - 2) {
                    skip.setVisibility(View.GONE);
                    next.setVisibility(View.GONE);
                    done.setVisibility(View.VISIBLE);
                } else if (position < Constants.NUM_PAGES - 2) {
                    skip.setVisibility(View.VISIBLE);
                    next.setVisibility(View.VISIBLE);
                    done.setVisibility(View.GONE);
                } else if (position == Constants.NUM_PAGES - 1) {
                    endTutorial();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        buildCircles();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void buildCircles() {

        float scale = getResources().getDisplayMetrics().density;
        int padding = (int) (5 * scale + 0.5f);

        for (int i = 0; i < Constants.NUM_PAGES - 1; i++) {
            ImageView circle = new ImageView(this);
            circle.setImageResource(R.drawable.ic_swipe_indicator_white_18dp);
            circle.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            circle.setAdjustViewBounds(true);
            circle.setPadding(padding, 0, padding, 0);
            circles.addView(circle);
        }

        setIndicator(0);
    }

    private void setIndicator(int index) {
        if (index < Constants.NUM_PAGES) {
            for (int i = 0; i < Constants.NUM_PAGES - 1; i++) {
                ImageView circle = (ImageView) circles.getChildAt(i);
                if (i == index) {
                    circle.setColorFilter(ContextCompat.getColor(this, R.color.text_selected));
                } else {
                    circle.setColorFilter(ContextCompat.getColor(this, android.R.color.transparent));
                }
            }
        }
    }

    private void endTutorial() {
        finish();
    }

}
