package com.example.thk347.dwadf;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //MAIN BUNDLE PROPERTIES
        Bundle bMain = new Bundle();
        bMain.putString("PROFILE_NAME", "ProfileTest");
        bMain.putString("PROFILE_ENABLED", "true");
        bMain.putString("CONFIG_MODE", "CREATE_IF_NOT_EXIST");

//PLUGIN_CONFIG BUNDLE PROPERTIES
        Bundle bConfig = new Bundle();
        bConfig.putString("PLUGIN_NAME", "ADF");
        bConfig.putString("RESET_CONFIG", "true");
        bConfig.putString("OUTPUT_PLUGIN_NAME", "KEYSTROKE");
        bConfig.putString("adf_enabled", "true");

//PARAM_LIST BUNDLE PROPERTIES
//RULE BUNDLE PROPERTIES
        Bundle bParamsRule1 = new Bundle();
        bParamsRule1.putString("name", "Rule1");
        bParamsRule1.putString("enabled", "true");
        bParamsRule1.putString("alldevices", "true");
        bParamsRule1.putString("string", "abc");
        bParamsRule1.putString("string_pos", "2");
        bParamsRule1.putString("string_len", "4");

//ACTION BUNDLE PROPERTIES
        Bundle bParamsAction1 = new Bundle();
        bParamsAction1.putString("type", "SEND_NEXT");
        bParamsAction1.putString("action_param_1", "5");


//ACTION BUNDLE PROPERTIES
        Bundle bParamsAction2 = new Bundle();
        bParamsAction2.putString("type", "SKIP_BACK");

//DEVICE BUNDLE PROPERTIES
        Bundle bParamsDevice1 = new Bundle();
        bParamsDevice1.putString("device_id", "BARCODE");
        bParamsDevice1.putString("enabled", "true");
        bParamsDevice1.putString("alldecoders", "false");
        bParamsDevice1.putString("all_label_ids", "false");

//DEVICE BUNDLE PROPERTIES
        Bundle bParamsDevice2 = new Bundle();
        bParamsDevice2.putString("device_id", "MSR");
        bParamsDevice2.putString("enabled", "true");

//DEVICE BUNDLE PROPERTIES
        Bundle bParamsDevice3 = new Bundle();
        bParamsDevice3.putString("device_id", "SIMULSCAN");
        bParamsDevice3.putString("enabled", "true");

//DECODER BUNDLE PROPERTIES
        Bundle bParamsDecoders1 = new Bundle();
        bParamsDecoders1.putString("device_id", "BARCODE");
        bParamsDecoders1.putString("decoder", "Australian Postal");
        bParamsDecoders1.putString("enabled", "true");

//DECODER BUNDLE PROPERTIES
        Bundle bParamsDecoders2 = new Bundle();
        bParamsDecoders2.putString("device_id", "BARCODE");
        bParamsDecoders2.putString("decoder", "Bookland");
        bParamsDecoders2.putString("enabled", "false");

//DECODER BUNDLE PROPERTIES
        Bundle bParamsDecoders3 = new Bundle();
        bParamsDecoders3.putString("device_id", "BARCODE");
        bParamsDecoders3.putString("decoder", "Codebar");
        bParamsDecoders3.putString("enabled", "true");

//LABEL ID BUNDLE PROPERTIES
        Bundle bParamsLabelID1 = new Bundle();
        bParamsLabelID1.putString("device_id", "BARCODE");
        bParamsLabelID1.putString("label_id", "UDI_GS1");
        bParamsLabelID1.putString("enabled", "true");

//LABEL ID BUNDLE PROPERTIES
        Bundle bParamsLabelID2 = new Bundle();
        bParamsLabelID2.putString("device_id", "BARCODE");
        bParamsLabelID2.putString("label_id", "UDI_HIBCC");
        bParamsLabelID2.putString("enabled", "true");

        ArrayList<Bundle> bParamsActionList = new ArrayList<Bundle>();
        bParamsActionList.add(bParamsAction1);
        bParamsActionList.add(bParamsAction2);

        ArrayList<Bundle> bParamsDeviceList = new ArrayList<Bundle>();
        bParamsDeviceList.add(bParamsDevice1);
        bParamsDeviceList.add(bParamsDevice2);
        bParamsDeviceList.add(bParamsDevice3);

        ArrayList<Bundle> bParamsDecoderList = new ArrayList<Bundle>();
        bParamsDecoderList.add(bParamsDecoders1);
        bParamsDecoderList.add(bParamsDecoders2);
        bParamsDecoderList.add(bParamsDecoders3);

        ArrayList<Bundle> bParamsLabelIDList = new ArrayList<Bundle>();
        bParamsLabelIDList.add(bParamsLabelID1);
        bParamsLabelIDList.add(bParamsLabelID2);

        bParamsRule1.putParcelableArrayList("ACTIONS", bParamsActionList);
        bParamsRule1.putParcelableArrayList("DEVICES", bParamsDeviceList);
        bParamsRule1.putParcelableArrayList("DECODERS", bParamsDecoderList);
        bParamsRule1.putParcelableArrayList("LABEL_IDS", bParamsLabelIDList);

        Bundle bParamsRule2 = new Bundle();
        bParamsRule2.putString("name", "Rule30");
        bParamsRule2.putString("enabled", "true");
        bParamsRule2.putString("alldevices", "true");
        bParamsRule2.putString("string", "cde");
        bParamsRule2.putString("string_pos", "3");
        bParamsRule2.putString("string_len", "5");

        ArrayList<Bundle> bParamsList = new ArrayList<Bundle>();
        bParamsList.add(bParamsRule1);
        bParamsList.add(bParamsRule2);

        bConfig.putParcelableArrayList("PARAM_LIST", bParamsList);

        bMain.putBundle("PLUGIN_CONFIG", bConfig);

        Intent i = new Intent();
        i.setAction("com.symbol.datawedge.api.ACTION");
        i.putExtra("com.symbol.datawedge.api.SET_CONFIG", bMain);
        i.putExtra("SEND_RESULT", "true");
        i.putExtra("COMMAND_IDENTIFIER", "ADF_API");
        this.sendBroadcast(i);

// GET RESULT CODE
        public void onReceive (Context context, Intent intent){

            String command = intent.getStringExtra("COMMAND");
            String commandidentifier = intent.getStringExtra("COMMAND_IDENTIFIER");
            String result = intent.getStringExtra("RESULT");

            Bundle bundle = new Bundle();
            String resultInfo = "";
            if (intent.hasExtra("RESULT_INFO")) {
                bundle = intent.getBundleExtra("RESULT_INFO");
                Set<String> keys = bundle.keySet();
                for (String key : keys) {
                    resultInfo += key + ": " + bundle.getString(key) + "\n";
                }
            }

            String text = "Command: " + command + "\n" +
                    "Result: " + result + "\n" +
                    "Result Info: " + resultInfo + "\n" +
                    "CID:" + commandidentifier;
            Toast.makeText(context, text, Toast.LENGTH_LONG).show();
        }
        ;
    }
}