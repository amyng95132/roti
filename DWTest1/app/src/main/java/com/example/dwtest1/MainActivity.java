package com.example.dwtest1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //https://www.viralandroid.com/2015/10/how-to-increase-integer-value-when-button-is-clicked.html
            int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bMain = new Bundle();
//        bMain.putString("PROFILE_NAME","Profile0 (default)");
//
//        bMain.putString("PROFILE_ENABLED","false");
        bMain.putString("PROFILE_NAME","Amy"); //create a DataWedge profile
        bMain.putString("PROFILE_ENABLED","true"); //enable profile
        bMain.putString("CONFIG_MODE","CREATE_IF_NOT_EXIST");

        //PLUGIN_CONFIG BUNDLE PROPERTIES
        Bundle bConfig = new Bundle();
        bConfig.putString("PLUGIN_NAME","BARCODE");
        bConfig.putString("PLUGIN_NAME","ADF");
        bConfig.putString("RESET_CONFIG","true");
        bConfig.putString("OUTPUT_PLUGIN_NAME","KEYSTROKE");
        bConfig.putString("adf_enabled","true");

        Intent i = new Intent();
        i.setAction("com.symbol.datawedge.api.ACTION");
        i.putExtra("com.symbol.datawedge.api.SET_CONFIG", bMain);
        i.putExtra("SEND_RESULT", "true");
        i.putExtra("COMMAND_IDENTIFIER", "ADF_API");

        Bundle appConfig = new Bundle();
        appConfig.putString("PACKAGE_NAME", this.getPackageName());      //  Associate the profile with this app
        appConfig.putStringArray("ACTIVITY_LIST", new String[] { "*" });
        bMain.putParcelableArray("APP_LIST", new Bundle[] { appConfig });

        this.sendBroadcast(i);


    }

    public void increaseInteger(View view) {
        count = count + 1;
        display(count);
    }

    private void display(int number) {
        TextView displayInteger = (TextView) findViewById(
                R.id.tvCount);
        displayInteger.setText("Integer: " + number);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
