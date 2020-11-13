package com.example.thk347.camera2;

import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //https://stackoverflow.com/questions/8744994/android-camera-set-resolution
    Camera mCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCamera = Camera.open();
        Camera.Parameters params = mCamera.getParameters();

// Check what resolutions are supported by your camera
        List<Camera.Size> sizes = params.getSupportedPictureSizes();

// Iterate through all available resolutions and choose one.
// The chosen resolution will be stored in mSize.
        Camera.Size mSize;
        for (Camera.Size size : sizes) {
            String mWidth = Integer.toString(size.width);
            String mHeight = Integer.toString(size.height);
            Toast.makeText(this, mWidth + " " + mHeight, Toast.LENGTH_LONG).show();
            mSize = size;
        }
        params.setPictureSize(320, 240);
    }




}