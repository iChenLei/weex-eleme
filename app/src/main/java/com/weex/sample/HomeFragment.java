package com.weex.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by ichenlei on 2017/12/15.
 */

public class HomeFragment extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(HomeFragment.this,NavigationActivity.class);
                startActivity(intent);
                HomeFragment.this.finish();
            }
        },700);
    }
}
