package com.example.thk347.poweroff;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Intent i = new Intent("android.intent.action.ACTION_REQUEST_SHUTDOWN");
//        i.putExtra("android.intent.extra.KEY_CONFIRM", false);
//        i.setFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
//        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(i);
        Context ctx = getApplication();

        //https://stackoverflow.com/questions/8655060/how-to-know-whether-roaming-data-is-enabled-disabled-programmatically
        NetworkInfo info = (NetworkInfo) ((ConnectivityManager) ctx
                .getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        if(info.isConnected())
        {
            Toast.makeText(this, "Data Roaming!", Toast.LENGTH_LONG).show();
        }




    }

    public void powerOffDevice() {

        try{
            Process su = Runtime.getRuntime().exec("su");
            DataOutputStream outputStream = new DataOutputStream(su.getOutputStream());

            outputStream.writeBytes("adb reboot" + "\n");
            outputStream.flush();

            outputStream.writeBytes("exit\n");
            outputStream.flush();

////            DataOutputStream os = new DataOutputStream(p.getOutputStream());
////            os.writeBytes("adb shell" + "\n");
////            os.flush();
////            os.writeBytes("input keyevent --longpress 26" + "\n");
////            os.flush();

            su.waitFor();
        }catch(IOException e){

        }catch(InterruptedException e){

        }
    }
//
////      Toast.makeText(this, "I was written in Java 8!", Toast.LENGTH_LONG).show();
//
//        try {
//            String line = null;
//            String cmd = "adb reboot";
//
//            Runtime run = Runtime.getRuntime();
//            Process pr = run.exec(cmd);
//
//            pr.waitFor();
//
//            BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
//            while ((line = buf.readLine()) != null) {
//                System.out.println(line);
//            }
//        }catch (IOException ioe){
//
//        }catch (InterruptedException ite){
//
//        }
//
//
////        try {
////         //   Process process = Runtime.getRuntime().exec("adb shell input keyevent --longpress 26");
////            ProcessBuilder pb = new ProcessBuilder("adb shell reboot");
////            Process pc = pb.start();
////            pc.waitFor();
////            System.out.println("Done");
////
////        }catch (IOException ioe){
////
////        }catch (InterruptedException ite){
////
////        }
//
////        String commandToRun = "input keyevent --longpress 26";
////
////        try {
////            Process p = Runtime.getRuntime().exec("su");
////            DataOutputStream os = new DataOutputStream(p.getOutputStream());
////            os.writeBytes("adb shell" + "\n");
////            os.flush();
////            os.writeBytes("input keyevent --longpress 26" + "\n");
////            os.flush();
////        } catch (Exception e) {
////
////        }
//
//
//
//    }


}



//https://android.jlelse.eu/adb-survival-guide-for-android-2cd22bad0a0f
    //power button
    //adb shell input keyevent 26
    //
    //adb shell input keyevent --longpress 26



