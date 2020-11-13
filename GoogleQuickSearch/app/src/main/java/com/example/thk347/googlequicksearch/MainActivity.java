package com.example.thk347.googlequicksearch;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      startActivity(new Intent(Intent.ACTION_VOICE_COMMAND).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        //startActivity(new Intent(Intent.ACTION_ASSIST).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));

//        final Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
//        intent.setPackage("com.google.android.googlequicksearchbox");
//       // intent.putExtra(SearchManager.QUERY, "Your query");
//        startActivity(intent);
    }
}
