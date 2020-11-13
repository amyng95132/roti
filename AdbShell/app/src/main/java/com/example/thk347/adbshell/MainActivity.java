package com.example.thk347.adbshell;

import android.app.Instrumentation;
import android.content.Intent;
import android.media.AudioManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    Instrumentation instrumentation = new Instrumentation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // startActivity(new Intent(android.provider.Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS));

       startActivity(new Intent(Settings.ACTION_SOUND_SETTINGS));




//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                instrumentation.sendPointerSync(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), MotionEvent.ACTION_DOWN, 70, 334, 0));
//            }
//        }).start();



//        AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
//        //audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
//
//        audioManager.setVibrateSetting(AudioManager.VIBRATE_TYPE_RINGER,
//                AudioManager.VIBRATE_SETTING_ON);
//        audioManager.setVibrateSetting(AudioManager.VIBRATE_TYPE_NOTIFICATION,
//                AudioManager.VIBRATE_SETTING_ON);
    }



//    public void click(float x,float y){
//        MotionEvent downEvent=MotionEvent.obtain(SystemClock.uptimeMillis(),SystemClock.uptimeMillis(),MotionEvent.ACTION_DOWN,x,y,0);
//        MotionEvent upEvent=MotionEvent.obtain(SystemClock.uptimeMillis(),SystemClock.uptimeMillis(),MotionEvent.ACTION_UP,x,y,0);
//        Instrumentation instrumentation;
//        try {
//            instrumentation.sendPointerSync(downEvent);
//            instrumentation.sendPointerSync(upEvent);
//        }
//        catch (  SecurityException e) {
//            //Assert.fail("Click on (" + x + ","+ y+ ") failed.");
//        }
//    }





//    public static void exec(String deviceId,String command) throws IOException {
//        Process process = null;
//        String commandString;
//        if(deviceId != null) {
//            commandString = String.format("%s", "adb -s " + deviceId + " shell " + command);
//        }else
//            commandString = String.format("%s", "adb shell " + command);
//        System.out.print("Command is "+commandString+"\n");
//        try {
//            process = ProcessHelper.runTimeExec(commandString);
//        } catch (IOException e) {
//        }
//        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//        String line;
//        while ((line = reader.readLine()) != null) {
//            System.out.print(line+"\n");
//        }
//    }

//    public void stopService(){
//
//        try {
//            Process p = Runtime.getRuntime().exec("su");
//            DataOutputStream os = new DataOutputStream(p.getOutputStream());
//            os.writeBytes("adb shell" + "\n");
//
//            os.flush();
//
////        os.writeBytes("am force-stop com.symbol.zebravolumecontrol" + "\n");
////        os.writeBytes("am force-stop com.rhomobile.appgallery" + "\n");
//           // os.writeBytes("reboot" + "\n");
//           os.writeBytes("ime set com.wparam.nullkeyboard/.NullKeyboard" + "\n");
//            os.flush();
//        }catch(IOException e){
//            e.printStackTrace();
//            // return;
//        }
//    }
}



