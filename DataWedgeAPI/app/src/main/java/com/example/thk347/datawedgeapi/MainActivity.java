package com.example.thk347.datawedgeapi;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//    // Main bundle properties
//    Bundle bMain = new Bundle();

    Button enableDW;
    Button disableDW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enableDW = findViewById(R.id.enablebtn);
        disableDW = findViewById(R.id.disablebtn);

    }

    private void tToast(String s) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, s, duration);
        toast.show();
    }

    public void disableProfile(View v) {

        //MAIN BUNDLE PROPERTIES
        Bundle bMain = new Bundle();
        bMain.putString("PROFILE_NAME", "MyADF");
        bMain.putString("PROFILE_ENABLED", "true");


        Bundle bConfig = new Bundle();
        bConfig.putString("PLUGIN_NAME","BARCODE");

        Bundle bParams = new Bundle();
        bParams.putString("decoder_pdf417","false");
        bConfig.putString("RESET_CONFIG","true");

        //PUT bParams into bConfig
        bConfig.putBundle("PARAM_LIST", bParams);


//PUT bConfig into bMain
        bMain.putBundle("PLUGIN_CONFIG", bConfig);

        Intent i = new Intent();
        i.setAction("com.symbol.datawedge.api.ACTION");
        i.putExtra("com.symbol.datawedge.api.SET_CONFIG", bMain);
        i.putExtra("SEND_RESULT", "true");
        i.putExtra("COMMAND_IDENTIFIER", "ADF_API");

        this.sendBroadcast(i);
        tToast("Disable");
    }

        public void enableProfile(View v){

        //MAIN BUNDLE PROPERTIES
        Bundle bMain = new Bundle();
//        bMain.putString("PROFILE_NAME","Profile0 (default)");
//
//        bMain.putString("PROFILE_ENABLED","false");
        bMain.putString("PROFILE_NAME","MyADF");

        bMain.putString("PROFILE_ENABLED","true");
        bMain.putString("CONFIG_MODE","CREATE_IF_NOT_EXIST");


//PLUGIN_CONFIG BUNDLE PROPERTIES
        Bundle bConfig = new Bundle();
        bConfig.putString("PLUGIN_NAME","BARCODE");
        bConfig.putString("PLUGIN_NAME","ADF");
        bConfig.putString("RESET_CONFIG","true");
        bConfig.putString("OUTPUT_PLUGIN_NAME","KEYSTROKE");
        bConfig.putString("adf_enabled","true");


//PARAM_LIST BUNDLE PROPERTIES
        Bundle bParams = new Bundle();
        bParams.putString("name","RuleAN");
        bParams.putString("enabled","true");
        bParams.putString("alldevices","true");
        bParams.putString("string","abc");
        bParams.putString("string_pos","2");
        bParams.putString("string_len","4");
//        bParams.putString("current-device-id","0");
//        bParams.putString("scanner_input_enabled","true");
        bParams.putString("decoder_pdf417","false");
//        bParams.putString("decoder_upca","false");
//        bParams.putString("decoder_upce0","false");
//        bParams.putString("decoder_datamatrix","false");
//        bParams.putString("decoder_code128","true");

        //ACTION BUNDLE PROPERTIES
//        Bundle bParamsAction1 = new Bundle();
//        bParamsAction1.putString("type","SEND_NEXT");
//        bParamsAction1.putString("action_param_1","5");


        //ACTION BUNDLE PROPERTIES
//        Bundle bParamsAction2 = new Bundle();
//        bParamsAction2.putString("type", "SKIP_BACK");


//        ArrayList<Bundle> bParamsActionList = new ArrayList<Bundle>();
//        bParamsActionList.add(bParamsAction1);
//        bParamsActionList.add(bParamsAction2);

//        bParams.putParcelableArrayList("ACTION", bParamsActionList);

        //PUT bParams into bConfig
        bConfig.putBundle("PARAM_LIST", bParams);

//PUT bConfig into bMain
        bMain.putBundle("PLUGIN_CONFIG", bConfig);

// APP_LIST BUNDLES
//        Bundle bundleApp1 = new Bundle();
//        bundleApp1.putString("PACKAGE_NAME","com.quest.questdsd");
//        bundleApp1.putStringArray("ACTIVITY_LIST", new String[]{"*"});

//PUT THEM ALL TOGETHER INTO THE MAIN BUNDLE
       // bMain.putParcelableArray("APP_LIST", new Bundle[]{bundleApp1});

        Intent i = new Intent();
        i.setAction("com.symbol.datawedge.api.ACTION");
        i.putExtra("com.symbol.datawedge.api.SET_CONFIG", bMain);
        i.putExtra("SEND_RESULT", "true");
        i.putExtra("COMMAND_IDENTIFIER", "ADF_API");

        this.sendBroadcast(i);

//
//        bMain.putString("PROFILE_NAME","" +
//                "DWDemo2");
//        bMain.putString("PROFILE_ENABLED","true");
//        bMain.putString("CONFIG_MODE","CREATE_IF_NOT_EXIST");
//
//        setKeystrokeOutputPluginConfiguration();
//        setIntentOutputPluginConfiguration();
//        setBDFPluginConfiguration();

// plugin_config bundle properties
//        Bundle bConfig = new Bundle();
//        bConfig.putString("PLUGIN_NAME","BARCODE");
//        bConfig.putString("PLUGIN_NAME", "INTENT");
//        bConfig.putString("PLUGIN_NAME","KEYSTROKE");
//        bConfig.putString("RESET_CONFIG","true");
      //  bConfig.putString("OUTPUT_PLUGIN_NAME","KEYSTROKE");
//        Bundle bConfig2 = new Bundle();
//        bConfig.putString("PLUGIN_NAME","BDF");
//        bConfig.putString("RESET_CONFIG","true");
//        bConfig.putString("OUTPUT_PLUGIN_NAME","KEYSTROKE");




// param_list bundle properties
//        Bundle bParams = new Bundle();
//        bParams.putString("scanner_selection","auto");
//        bParams.putString("scanner_input_enabled","true");
//        bParams.putString("decoder_code128", "true");



//        bParams.putString("bdf_enabled","true");
//        bParams.putString("bdf_prefix","AAA");
//        bParams.putString("bdf_send_enter","true");

//        bParams.putString("intent_action", "android.intent.action.SEND");
//        bParams.putInt("intent_delivery",2); //Use "0" for Start Activity, "1" for Start Service, "2" for Broadcast



        //PUT bParams1 into bConfig1
//        bConfig.putBundle("PARAM_LIST", bParams);
//
////      //PUT bConfig1 into bMain
//        bMain.putBundle("PLUGIN_CONFIG", bConfig);
//
//
//       // bConfig.putString("RESET_CONFIG","false");
//       // bConfig.putBundle("PARAM_LIST", bParams);
//
////        bMain.putBundle("PLUGIN_CONFIG", bConfig);
////        bMain.putString("PROFILE_NAME","UserProfile");
////        bMain.putString("PROFILE_ENABLED","true");
////        bMain.putString("CONFIG_MODE","CREATE_IF_NOT_EXIST");
//
//        Intent i = new Intent();
//        i.setAction("com.symbol.datawedge.api.ACTION");
//        i.putExtra("com.symbol.datawedge.api.SET_CONFIG",bMain);
//        i.putExtra("SEND_RESULT", "true");
//        i.putExtra("COMMAND_IDENTIFIER", "KEYSTROKE_API");
//        i.putExtra("COMMAND_IDENTIFIER", "INTENT_API");
//        this.sendBroadcast(i);
        /*
        //PLUGIN_CONFIG BUNDLE PROPERTIES
        Bundle bConfig2 = new Bundle();
        bConfig2.putString("PLUGIN_NAME","INTENT");

        //PARAM_LIST BUNDLE PROPERTIES
        Bundle bParams2 = new Bundle();
        bParams2.putString("intent_output_enabled", "true");
        bParams2.putString("intent_action", "android.intent.action.SEND");
        bParams2.putString("intent_delivery", "2");

        //PUT bParams2 into bConfig2
        bConfig2.putBundle("PARAM_LIST", bParams2);

        //PUT bConfig and bConfig2 into bMain
        bMain.putParcelableArray("PLUGIN_CONFIG", new Bundle[]{bConfig, bConfig2});

         */
    }

//    public void setKeystrokeOutputPluginConfiguration() {
//        Bundle bConfig = new Bundle();
//        bConfig.putString("PLUGIN_NAME","KEYSTROKE");
//        bConfig.putString("RESET_CONFIG","true");
//
//        Bundle bParams = new Bundle();
//        bParams.putString("keystroke_output_enabled","true");
//        bParams.putString("keystroke_action_char","9");
//
//
//        //PUT bParams1 into bConfig1
//        bConfig.putBundle("PARAM_LIST", bParams);
//
////      //PUT bConfig1 into bMain
//        bMain.putBundle("PLUGIN_CONFIG", bConfig);
//
//        Intent i = new Intent();
//        i.setAction("com.symbol.datawedge.api.ACTION");
//        i.putExtra("com.symbol.datawedge.api.SET_CONFIG",bMain);
//        i.putExtra("SEND_RESULT", "true");
//        i.putExtra("COMMAND_IDENTIFIER", "KEYSTROKE_API");
//        this.sendBroadcast(i);
//
//    }
//
//    public void setBDFPluginConfiguration() {
//        Bundle bConfig = new Bundle();
//        bConfig.putString("PLUGIN_NAME","BDF");
//        bConfig.putString("OUTPUT_PLUGIN_NAME","KEYSTROKE");
//
//        Bundle bParams = new Bundle();
//        bParams.putString("bdf_enabled","true");
//        bParams.putString("bdf_prefix","AAA");
//        bParams.putString("bdf_send_enter","true");
//
//        //PUT bParams1 into bConfig1
//        bConfig.putBundle("PARAM_LIST", bParams);
//
////      //PUT bConfig1 into bMain
//        bMain.putBundle("PLUGIN_CONFIG", bConfig);
//
//        Intent i = new Intent();
//        i.setAction("com.symbol.datawedge.api.ACTION");
//        i.putExtra("com.symbol.datawedge.api.SET_CONFIG",bMain);
//        i.putExtra("SEND_RESULT", "true");
//        i.putExtra("COMMAND_IDENTIFIER", "KEYSTROKE_API");
//        this.sendBroadcast(i);
//
//
//    }
//    public void setIntentOutputPluginConfiguration() {
//        Bundle bConfig = new Bundle();
//        bConfig.putString("PLUGIN_NAME", "INTENT");
//        bConfig.putString("RESET_CONFIG","true");
//
//        Bundle bParams = new Bundle();
//        bParams.putString("intent_output_enabled","true");
//        bParams.putString("intent_action","android.intent.action.MAIN");
//        bParams.putString("intent_category","android.intent.category.LAUNCHER");
//
//        //PUT bParams1 into bConfig1
//        bConfig.putBundle("PARAM_LIST", bParams);
//
////      //PUT bConfig1 into bMain
//        bMain.putBundle("PLUGIN_CONFIG", bConfig);
//
//        Intent i = new Intent();
//        i.setAction("com.symbol.datawedge.api.ACTION");
//        i.putExtra("com.symbol.datawedge.api.SET_CONFIG",bMain);
//        i.putExtra("SEND_RESULT", "true");
//        i.putExtra("COMMAND_IDENTIFIER", "INTENT_API");
//        this.sendBroadcast(i);
//
//    }

}
