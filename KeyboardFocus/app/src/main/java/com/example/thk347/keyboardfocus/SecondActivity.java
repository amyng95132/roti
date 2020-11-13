package com.example.thk347.keyboardfocus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


//https://stackoverflow.com/questions/48020753/disable-keyboard-for-my-app-programmatically

public class SecondActivity extends AppCompatActivity {

    Button button2;

    EditText edittext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        edittext = (EditText) findViewById(R.id.EditTextInput);
        edittext.setInputType(InputType.TYPE_NULL);

        //https://stackoverflow.com/questions/5803193/android-disable-soft-keyboard-at-all-edittexts
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            edittext.setRawInputType(InputType.TYPE_CLASS_TEXT);
            edittext.setTextIsSelectable(true);
        }

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {

                    onBackPressed();

                }
            });
    }




//    public void goBackToPreviousActivity(View view) {
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
//    }

}
