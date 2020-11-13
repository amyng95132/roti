package com.example.thk347.screenlockpin;

import android.app.admin.DeviceAdminReceiver;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //https://stackoverflow.com/questions/38191817/no-active-admin-owned-by-uid-10204-for-policy-2
    DevicePolicyManager dpm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dpm = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);

     // dpm.resetPassword("4279", 0);
        try {

            dpm.resetPassword("", 0);

            dpm.lockNow();
            finish();
        } catch (SecurityException e) {
            Intent it = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
            it.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, new ComponentName(this, DeviceAdminReceiver.class));
            startActivityForResult(it, 0);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            dpm.lockNow();
        } else {
            Toast.makeText(this, "Device administrator must be activated to lock the screen", Toast.LENGTH_LONG).show();
        }
        finish();
    }
}