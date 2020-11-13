package com.example.thk347.java8test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = new Intent("android.intent.action.ACTION_REQUEST_SHUTDOWN");
        i.putExtra("android.intent.extra.KEY_CONFIRM", true);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);



//        Button button = (Button) findViewById(R.id.button);
//        if (button != null) {
//            button.setOnClickListener((View view) -> Toast.makeText(this,
//                    "I was written in Java 8!", Toast.LENGTH_LONG).show());
//
//        }

      //  https://code.tutsplus.com/tutorials/java-8-for-android-cleaner-code-with-lambda-expressions--cms-29661

        //Shutdown device:
        //https://stackoverflow.com/questions/24693682/turn-off-device-programmatically
    }
}
