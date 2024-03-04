package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.color.utilities.Variant;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2;
    EditText txt;
    TextView txtView;
    String Data;
    private String file = "My-Data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("lifecycleevents", "Created");
        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        txt = (EditText) findViewById(R.id.editTextText);
        txtView = (TextView) findViewById(R.id.textView2);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Data = txt.getText().toString();
                try {
                    FileOutputStream fos = openFileOutput(file, Context.MODE_PRIVATE);
                    fos.write(Data.getBytes());
                    fos.close();
                    txt.setText("");

                    Toast.makeText(MainActivity.this, "File Saved", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                 e.printStackTrace();
                }
//                Toast.makeText(MainActivity.this, "You Clicked", Toast.LENGTH_LONG).show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream fis = openFileInput(file);
                    InputStreamReader isr = new InputStreamReader(fis);
                    BufferedReader br = new BufferedReader(isr);
                    StringBuilder sb = new StringBuilder();
                    String text;

                    while ((text = br.readLine()) != null) {
                        sb.append(text).append("\n");
                    }
                    txtView.setText(sb.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

//    @Override
//    protected void onStart() {
//        super.onStart();
//        Log.d("lifecycleevents","Started");
//    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        Log.d("lifecycleevents","Resumed");
//    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//        Log.d("lifecycleevents","Paused");
//    }

//    @Override
//    protected void onStop() {
//        super.onStop();
//        Log.d("lifecycleevents","Stopped");
//    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Log.d("lifecycleevents","Destroyed");
//    }

//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        Log.d("lifecycleevents","ReStarted");
//    }
    }
}