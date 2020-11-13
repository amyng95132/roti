package com.example.thk347.clearcache2;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;


//https://stackoverflow.com/questions/8326852/how-to-delete-cache-folder-of-app
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // clearPreferences();

        File dir = new File("/data/data/com.android.gallery3d");
        delete(dir);
    }


    public static boolean delete(File path) {
        boolean result = true;
        if (path.exists()) {
            if (path.isDirectory()) {
                for (File child : path.listFiles()) {
                    result &= delete(child);
                }
                result &= path.delete(); // Delete empty directory.
            } else if (path.isFile()) {
                result &= path.delete();
            }
            return result;
        } else {
            return false;
        }
    }

//    private void clearPreferences() {
//        try {
//            // clearing app data
//            Runtime runtime = Runtime.getRuntime();
//            runtime.exec("pm clear com.android.gallery3d");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
