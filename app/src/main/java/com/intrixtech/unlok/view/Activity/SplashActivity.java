package com.intrixtech.unlok.view.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.intrixtech.unlok.R;
import com.intrixtech.unlok.UnlockActivity;
import com.intrixtech.unlok.utils.Constants;

/**
 * Created by prateekarora on 06/04/16.
 */
public class SplashActivity extends UnlockActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        android.os.Handler handler = new android.os.Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getBaseContext(), TutorialActivity.class);
                startActivity(i);
                //Remove activity
                finish();
            }
        }, Constants.SPLASH_TIME);
    }

}
