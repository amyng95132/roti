package com.example.thk347.locktimeout;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.hardware.display.DisplayManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//        Settings.Secure.getLong(getContentResolver(), "lock_screen_lock_after_timeout", 300000);
        //86,400,000


        //https://stackoverflow.com/questions/16635221/android-get-lock-timeout-programmatically
//        mResolver = this.getContentResolver();
//        long timeout = Settings.Secure.getInt(mResolver,
//                "lock_screen_lock_after_timeout",
//                0);
    }
}
