package com.example.thk347.buildserialnumber;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Build;
import android.widget.TextView;

import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        String SerialNumber = Build.SERIAL;
//        String deviceName = Settings.Secure.getString(getContentResolver(), "bluetooth_name");
        //String deviceName = android.os.Build.MANUFACTURER + " " + android.os.Build.MODEL;
       // String str = Settings.System.getString(getContentResolver(), "device_name");

        String deviceName = getHostName();
        TextView tv1 = (TextView) findViewById(R.id.tv1);


        //https://stackoverflow.com/questions/7808526/getconnectioninfo-exception
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        int rssi = wifiManager.getConnectionInfo().getRssi();
        int level = WifiManager.calculateSignalLevel(rssi, 5);
        tv1.setText(level);
//        int numberOfLevels = 100;
//        WifiInfo wifiInfo = wifiManager.ConnectionInfo;
//        int level = WifiManager.CalculateSignalLevel(wifiInfo.Rssi, numberOfLevels);

// Level of a Scan Result
//        List<ScanResult> wifiList = wifiManager.getScanResults();
//        for (ScanResult scanResult : wifiList) {
//            int level = WifiManager.calculateSignalLevel(scanResult.level, 5);
//            tv1.setText(level);
//        }

//
//
//// Level of current connection
//        int rssi = wifiManager.getConnectionInfo().getRssi();
//        int level = WifiManager.calculateSignalLevel(rssi, 5);
////        System.out.println("Level is " + level + " out of 5");
//        tv1.setText(level);

//        try {
//            Process p = Runtime.getRuntime().exec("su");
//            DataOutputStream os = new DataOutputStream(p.getOutputStream());
//            os.writeBytes("adb shell" + "\n");
//
//            os.flush();
//
//       os.writeBytes("getprop net.hostname" + "\n");
////        os.writeBytes("am force-stop com.rhomobile.appgallery" + "\n");
//            os.writeBytes("reboot" + "\n");
//            os.flush();
//        }catch(IOException e){
//            e.printStackTrace();
//            // return;
//        }

//        tv1.setText(deviceName);

        //AmbientService to call finish()
    }

    public static String getHostName() {
        try {
            Method getString = Build.class.getDeclaredMethod("getString", String.class);
            getString.setAccessible(true);
            return getString.invoke(null, "net.hostname").toString();
        } catch (Exception ex) {
            return "error";
        }
    }

//    public static String getDeviceSerial(){
//
//        String SerialNumber;
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
//        {
//            SerialNumber = Build.getSerial();
//        }
//        else
//        {
//            SerialNumber = Build.SERIAL;
//        }
//        return SerialNumber;
//    }
}
