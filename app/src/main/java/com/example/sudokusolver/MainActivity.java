package com.example.sudokusolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

// added
import org.tensorflow.lite.Interpreter;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

//import com.chaquo.python.Python;
//import com.chaquo.python.android.AndroidPlatform;

public class MainActivity extends AppCompatActivity {

    //private static int SPLASH_TIME_OUT = 1000;

    //added here
    //Interpreter tflite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // added for intial loading screen
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
//                startActivity(homeIntent);
//                finish();
//            }
//        }, SPLASH_TIME_OUT);

        Button letssolve = (Button) findViewById(R.id.letssolve);
        letssolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SudokuActivity.class);
                startActivity(i);
            }
        });
    }

}
