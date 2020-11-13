package com.example.devicemodel;

import android.app.Instrumentation;
import android.content.Intent;
import android.hardware.input.InputManager;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
//import android.os.SystemProperties;

public class MainActivity extends AppCompatActivity {

    EditText myModel;
    Method injectInputEventMethod;
    InputManager im;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(Settings.ACTION_SECURITY_SETTINGS));
//        Settings.System.putInt(
//                this.getContentResolver(),
//                Settings.System.TEXT_SHOW_PASSWORD, 0);


        //adb shell input swipe 540 900 540 100 1500
        //adb shell input tap 530 722

//        myModel = findViewById(R.id.model);
//        String deviceName = getDeviceProperty(); //getDeviceName();
//        myModel.setText(deviceName);


//        final String PROP_DEVICE_MODEL ="ro.config.device.model";
//        final String PROP_DEVICE_MODELSUPP ="ro.config.device.modelsupp";
//        final int product_lightning_wlan = 5200;
//
//        int config_type = Integer.parseInt(SystemProperties.get(PROP_DEVICE_MODEL, "0"));
//        int supp_type = Integer.parseInt(SystemProperties.get(PROP_DEVICE_MODELSUPP, "0"));
//        String device = "";
//        if ((config_type == product_lightning_wlan) && (supp_type == 2)){ // for Lighting WLAN Health care device
//            device = "Lighting WLAN Health care device : "+device+"_"+supp_type;
//        }


//        try {
//            ProcessBuilder pb = new ProcessBuilder("adb", "shell", "input", "tap", "530", "");
//            Process pc = pb.start();
//            pc.waitFor();
//        }catch (IOException ioe){
//            ioe.printStackTrace();
//        }catch (InterruptedException inter){
//            inter.printStackTrace();
//        }

//        String command = "input tap 530 522"; // Mention your list of commands here

//
//        try {
//            Process process = Runtime.getRuntime().exec("input tap 530 52");
//            BufferedReader bufferedReader = new BufferedReader(
//                    new InputStreamReader(process.getInputStream()));
//
//
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    }



//    public static String getDeviceProperty() {
//            Process p;
//            String propvalue = "";
//            try {
//                p = new ProcessBuilder("/system/bin/getprop", "ro.config.device.regulatory").redirectErrorStream(true).start();
//                BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
//                String line;
//                while ((line = br.readLine()) != null) {
//                    propvalue = line;
//                }
//                p.destroy();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return propvalue;
//    }
//
//    //https://stackoverflow.com/questions/1995439/get-android-phone-model-programmatically
//    /** Returns the consumer friendly device name */
//    public static String getDeviceName() {
//        String manufacturer = Build.MANUFACTURER;
//        String model = Build.MODEL;
//        if (model.startsWith(manufacturer)) {
//            return capitalize(model);
//        }
//        return capitalize(manufacturer) + " " + model;
//    }
//
//    //https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html
//    private static String capitalize(String str) {
//        if (TextUtils.isEmpty(str)) {
//            return str;
//        }
//        char[] arr = str.toCharArray();
//        boolean capitalizeNext = true;
//
//        StringBuilder phrase = new StringBuilder();
//        for (char c : arr) {
//            if (capitalizeNext && Character.isLetter(c)) {
//                phrase.append(Character.toUpperCase(c));
//                capitalizeNext = false;
//                continue;
//            } else if (Character.isWhitespace(c)) {
//                capitalizeNext = true;
//            }
//            phrase.append(c);
//        }
//
//        return phrase.toString();
//    }
}
