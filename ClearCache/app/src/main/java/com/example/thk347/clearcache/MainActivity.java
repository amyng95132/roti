package com.example.thk347.clearcache;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.media.AudioManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.SystemClock;
import android.os.Vibrator;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

//https://medium.com/@droidbyme/clear-cache-in-android-programmatically-26a1405a470b
public class MainActivity extends AppCompatActivity {

    Vibrator vibrator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       /*
       adb shell
        input touchscreen tap 70 356

        adb shell input tap 70 356
        */
      startActivityForResult(new Intent(android.provider.Settings.ACTION_SOUND_SETTINGS), 2);


     //   stopService();
//// Obtain MotionEvent object
//        long downTime = SystemClock.uptimeMillis();
//        long eventTime = SystemClock.uptimeMillis() + 100;
//        float x = 70.0f;
//        float y = 356.0f;
//// List of meta states found here:     developer.android.com/reference/android/view/KeyEvent.html#getMetaState()
//        int metaState = 0;
//        MotionEvent motionEvent = MotionEvent.obtain(
//                downTime,
//                eventTime,
//                MotionEvent.ACTION_DOWN,
//                x,
//                y,
//                metaState
//        );

       // Runtime.getRuntime().exec("reboot");
//        try {
//
//
//
//           // Process process = Runtime.getRuntime().exec("input touchscreen swipe 100 1000 300 1000 1000");
//             Process process = Runtime.getRuntime().exec("input touchscreen tap 70 356");
////            String cmd = "adb shell input touchscreen tap 70 356";
////            Runtime run = Runtime.getRuntime();
////            Process pr = run.exec(cmd);
//            BufferedReader buf = new BufferedReader(new InputStreamReader(process.getInputStream()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


       //Runtime.getRuntime().exec("adb shell input touchscreen tap 70 356");




//       try {
//           String myStringArray = "adb shell\n" +
//                   "        input touchscreen tap 70 356";
//           Process process = Runtime.getRuntime().exec(myStringArray);
//       }catch (IOException ioe){
//
//        }

//        MotionEvent event = getWindowManager().getDefaultDisplay();
//        Display mdisp = getWindowManager().getDefaultDisplay();
//        Point mdispSize = new Point();
//        mdisp.getSize(mdispSize);
//        int maxX = mdispSize.x;
//        int maxY = mdispSize.y;
//        String xString = String.valueOf(maxX);
//        String yString = String.valueOf(maxY);
//        Toast.makeText(getApplicationContext(), xString, Toast.LENGTH_LONG).show();



//        boolean isTouchSoundsEnabled = Settings.System.getInt(getContentResolver(),
//                Settings.System.VIBRATE_WHEN_RINGING, 1) != 0;

        //https://stackoverflow.com/questions/4461874/android-how-to-open-notification-sound-settings-menu-in
      //  startActivityForResult(new Intent(android.provider.Settings.ACTION_SOUND_SETTINGS), 2);

//        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
//
//        v.cancel();



        //toggleButton.setChecked(true);

        //http://www.fatalerrors.org/a/you-cannot-keep-your-settings-in-the-secure-settings.html
//        Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
//        intent.setData(Uri.parse("package:" + getApplicationContext().getPackageName()));
//        startActivity(intent);

//        boolean enable = true;
//        ContentResolver mContentResolver = getContentResolver();
//        Settings.System.putInt(mContentResolver, Settings.System.VIBRATE_WHEN_RINGING, enable ? 1 : 0);
//        //boolean vibrate = true;
        //Settings.Global.putInt(getContentResolver(), "vibrate_when_ringing", 1);)

//        AudioManager am = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
//        am.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
      //  boolean vibrate = am.shouldVibrate(AudioManager.VIBRATE_TYPE_RINGER);


        try {
//            Process process = Runtime.getRuntime().exec("adb shell pm clear com.android.browser");
//            BufferedReader bufferedReader = new BufferedReader(
//                    new InputStreamReader(process.getInputStream()));
//            Process p = Runtime.getRuntime().exec(new String[]{"adb", "shell", "input", "tap", "70", "356"});

            ProcessBuilder pb = new ProcessBuilder("cmd","/c","adb shell input tap 70 356");
            pb.directory(new File("C:\\Users\\thk347\\platform-tools\\"));
            pb.start();
        }catch (IOException ioe){

        }

//        PackageManager pm = getPackageManager();
//// Get all methods on the PackageManager
//        Method[] methods = pm.getClass().getDeclaredMethods();
//        for (Method m : methods) {
//            if (m.getName().equals("freeStorage")) {
//                // Found the method I want to use
//                try {
//                    long desiredFreeStorage = 5 * 1024 * 1024 * 1024; // Request for 8GB of free space
//                    m.invoke(pm, desiredFreeStorage , null);
//                } catch (Exception e) {
//                    // Method invocation failed. Could be a permission problem
//                }
//                break;
//            }
//        }
    }

    public void stopService(){

        try {

            Process process = Runtime.getRuntime().exec("adb shell");
            DataOutputStream os = new DataOutputStream(process.getOutputStream());
            os.writeBytes("input touchscreen tap 70 356" + "\n");

            os.flush();

//        os.writeBytes("am force-stop com.symbol.zebravolumecontrol" + "\n");
//        os.writeBytes("am force-stop com.rhomobile.appgallery" + "\n");
//            os.writeBytes("reboot" + "\n");
//            os.flush();
        }catch(IOException e){
            e.printStackTrace();
            // return;
        }
    }


//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        // MotionEvent object holds X-Y values
//        if(event.getAction() == MotionEvent.ACTION_DOWN) {
//            String text = "You click at x = " + event.getX() + " and y = " + event.getY();
//            Toast.makeText(this, text, Toast.LENGTH_LONG).show();
//        }
//
//        return super.onTouchEvent(event);
//    }
//
//    public void clickIt(){
//        try {
//            String myStringArray = "adb shell\n" +
//                    "        input touchscreen tap 70 356";
//            Process process = Runtime.getRuntime().exec(myStringArray);
//        }catch (IOException ioe){
//
//        }
//    }
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        int x = (int)event.getRawX();
//        //int y = (int) event.getY();
//        String xString = String.valueOf(x); //289? 209??
//        //String yString = String.valueOf(y);
//        //String combine = xString + yString;
//        Toast.makeText(getApplicationContext(), xString, Toast.LENGTH_LONG).show();
//
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//            case MotionEvent.ACTION_MOVE:
//            case MotionEvent.ACTION_UP:
//        }
//        return false;
//    }
//
//    public void startVibrate(View v) {
//        long pattern[] = { 0, 100, 200, 300, 400 };
//        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
//        vibrator.vibrate(pattern, 0);
//    }
//
//    public void stopVibrate(View v) {
//        vibrator.cancel();
//    }


//    @Override
//    protected void onDestroy() {
//
//        super.onDestroy();
//        try {
//            trimCache(this);
//            // Toast.makeText(this,"onDestroy " ,Toast.LENGTH_LONG).show();
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//
//    public static void trimCache(Context context) {
//        try {
//            File dir = context.getCacheDir();
//            if (dir != null && dir.isDirectory()) {
//                deleteDir(dir);
//            }
//        } catch (Exception e) {
//            // TODO: handle exception
//        }
//    }
//
//    public static boolean deleteDir(File dir) {
//        if (dir != null && dir.isDirectory()) {
//            String[] children = dir.list();
//            for (int i = 0; i < children.length; i++) {
//                boolean success = deleteDir(new File(dir, children[i]));
//                if (!success) {
//                    return false;
//                }
//            }
//        }
//        // The directory is now empty so delete it
//        return dir.delete();
//    }

//    public static void deleteCache(Context context) {
//        try {
//            File dir = context.getCacheDir();
//            deleteDir(dir);
//        } catch (Exception e) {}
//    }
//    public static boolean deleteDir(File dir) {
//        if (dir != null && dir.isDirectory()) {
//            String[] children = dir.list();
//            for (int i = 0; i < children.length; i++) {
//                boolean success = deleteDir(new File(dir, children[i]));
//                if (!success) {
//                    return false;
//                }
//            }
//            return dir.delete();
//        } else if(dir!= null && dir.isFile()) {
//            return dir.delete();
//        } else {
//            return false;
//        }
//    }

    //https://stackoverflow.com/questions/28492956/clearing-cache-in-android-app-programmatically
//    @Override
//    protected void onStop(){
//        super.onStop();
//    }
//
//    //Fires after the OnStop() state
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        try {
//            trimCache(this);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void trimCache(Context context) {
//        try {
//            File dir = context.getCacheDir();
//            deleteDir(dir);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static boolean deleteDir(File dir) {
//        if (dir != null && dir.isDirectory()) {
//            String[] children = dir.list();
//            for (int i = 0; i < children.length; i++) {
//                boolean success = deleteDir(new File(dir, children[i]));
//                if (!success) {
//                    return false;
//                }
//            }
//            return dir.delete();
//        }
//        else {
//            return false;
//        }
//    }
}
