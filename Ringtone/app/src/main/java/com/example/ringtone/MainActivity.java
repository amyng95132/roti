package com.example.ringtone;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;


//https://android--code.blogspot.com/2017/07/android-play-default-ringtone.html

///sdcard/Music/AmyTest.mp3

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    private Activity mActivity;

    private Button mButtonRingtone;
    private Button mButtonMedia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the application context
        mContext = getApplicationContext();
        mActivity = MainActivity.this;

        // Get the widget reference from xml layout
        mButtonRingtone = findViewById(R.id.btn_play_ringtone);
        mButtonMedia = findViewById(R.id.btn_play_as_media);

        File k = new File("/enterprise/usr", "AmyTest.mp3");

        ContentValues values = new ContentValues();
        values.put(MediaStore.MediaColumns.DATA, k.getAbsolutePath());
        values.put(MediaStore.MediaColumns.MIME_TYPE, "audio/mp3");
        values.put(MediaStore.Audio.Media.IS_RINGTONE, true);
        values.put(MediaStore.Audio.Media.IS_NOTIFICATION, false);
        values.put(MediaStore.Audio.Media.IS_ALARM, false);
        values.put(MediaStore.Audio.Media.IS_MUSIC, false);

//Insert it into the database
        Uri uri = MediaStore.Audio.Media.getContentUriForPath(k.getAbsolutePath());
        Uri newUri = this.getContentResolver().insert(uri, values);

        RingtoneManager.setActualDefaultRingtoneUri(
                mActivity,
                RingtoneManager.TYPE_RINGTONE,
                newUri
        );


        // Play the default ringtone as ringtone
        mButtonRingtone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
                Ringtone ringtone = RingtoneManager.getRingtone(mContext,uri);
                ringtone.play();
            }
        });


    }


}