package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.chaquo.python.PyException;
import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //python code 実行のために Python.start()
        if(!Python.isStarted()){
            Python.start(new AndroidPlatform(this));
        }
        Python py = Python.getInstance();
        PyObject module = py.getModule("chaquopy_test");
        try{
//            float randomNumber = module.callAttr("create_random_number").toFloat();
//            TextView textView = findViewById(R.id.text_view);
//            textView.setText(Float.toString(randomNumber));
            String x = module.callAttr("sample_torch").toString();
            TextView textView = findViewById(R.id.text_view);
            textView.setText(x);
        } catch (PyException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}