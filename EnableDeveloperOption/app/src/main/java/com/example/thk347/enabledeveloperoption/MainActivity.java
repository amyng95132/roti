package com.example.thk347.enabledeveloperoption;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {



        }

        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 10, locationListener);
    }

    public void statusCheck() {
        final LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            buildAlertMessageNoGps();

        }
    }

    private void buildAlertMessageNoGps() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Your GPS seems to be disabled, do you want to enable it?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }
}
//    private void showPermissionsDialog() {
//        if (Build.VERSION.SDK_INT == 23) {
//
//            int hasWriteSettingsPermission = checkSelfPermission(Manifest.permission.WRITE_SETTINGS);
//            if (hasWriteSettingsPermission != PackageManager.PERMISSION_GRANTED) {
//                //You can skip the next if block. I use it to explain to user why I wan his permission.
//                if (!ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)) {
//                    showMessageOKCancel("You need to allow write settings",
//                            new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialog, int which) {
//                                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_SETTINGS}, WRITE_PERMISSION_REQUEST);
//                                }
//                            });
//                    return;
//                }
////The next line causes a dialog to popup, asking the user to allow or deny us write permission
//                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_SETTINGS}, WRITE_PERMISSION_REQUEST);
//                return;
//            } else {
//                //Permissions have already been granted. Do whatever you want :)
//                Settings.Secure.getLong(getContentResolver(), Settings.System.SCREEN_OFF_TIMEOUT, 86400000);
//            }
//        }
//    }

    //Now you only need this if you want to show the rationale behind
//requesting the permission.
//    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
//        new AlertDialog.Builder(MainActivity.this).setMessage(message).setPositiveButton("OK", okListener)
//                .setNegativeButton("Cancel", null).show();
//    }
//
//    //This method is called immediately after the user makes his decision to either allow
//    // or disallow us permision.
//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//        switch (requestCode) {
//            case WRITE_PERMISSION_REQUEST:
//                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    //User pressed the allowed button
//                    //Do what you want :)
//                } else {
//                    //User denied the permission
//                    //Come up with how to hand the requested permission
//                }
//            default:
//                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        }
//
//
////        // Get the button and add onClickListener.
////        final Button writeSettingsPermissionButton = (Button)findViewById(R.id.write_settings_permission_button);
////        writeSettingsPermissionButton.setOnClickListener(new View.OnClickListener() {
////
////            @Override
////            public void onClick(View view) {
////
////                Context context = getApplicationContext();
////
////                // Check whether has the write settings permission or not.
////                boolean settingsCanWrite = Settings.System.canWrite(context);
////
////                if(!settingsCanWrite) {
////                    // If do not have write settings permission then open the Can modify system settings panel.
////                    Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
////                    startActivity(intent);
////                }else {
////                    // If has permission then show an alert dialog with message.
////                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
////                    alertDialog.setMessage("You have system write settings permission now.");
////                    alertDialog.show();
////                }
////            }
////        });
//    }
//
//        //Settings.System.putString(getContentResolver(), Settings.System.SCREEN_OFF_TIMEOUT, "-1");
//
////        try {
////            Process p = Runtime.getRuntime().exec(new String[]{"settings", "put", "secure lock_screen_lock_after_timeout", "86400000"});
//////            DataOutputStream os = new DataOutputStream(p.getOutputStream());
//////            os.writeBytes("adb shell" + "\n");
//////
//////            os.flush();
//////
////////        os.writeBytes("am force-stop com.symbol.zebravolumecontrol" + "\n");
////////        os.writeBytes("am force-stop com.rhomobile.appgallery" + "\n");
//////            os.writeBytes("settings put secure lock_screen_lock_after_timeout 86400000" + "\n");
//////            os.flush();
////        }catch(IOException e){
////            e.printStackTrace();
////            // return;
////        }
//
//
////        try {
////            Process process = Runtime.getRuntime().exec("adb shell settings put secure lock_screen_lock_after_timeout 86400000");
////            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
////        }catch (IOException ioe) {
////
////        }
//        //https://github.com/hushnymous/android_packages_apps_Settings/blob/master/src/com/android/settings/SecuritySettings.java
//
////        int DELAY = 300000;
//////        int defTimeOut = 0;
//////
//////        defTimeOut = Settings.System.getInt(getContentResolver(),
//////                Settings.System.SCREEN_OFF_TIMEOUT, DELAY);
////
////        Settings.System.putInt(getContentResolver(), Settings.System.SCREEN_OFF_TIMEOUT, DELAY);
//
//                //settings put secure lock_screen_lock_after_timeout 86400000
//
//        //int time = Settings.Secure.getInt(getContentResolver(), "lock_screen_lock_after_timeout", 300000);
//
//
//}
