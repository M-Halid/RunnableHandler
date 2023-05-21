package com.ewig.runnablehandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    TextView textView2;
    double number;
    Runnable runnable;
    Handler handler;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        textView2=findViewById(R.id.textView2);
        button1=findViewById(R.id.button1);
        number=0;
    }
    public void start(View view){
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
            textView.setText("Time: "+number);
            number+=0.1;
            textView.setText("Time: " + String.format("%.1f", number));
            handler.postDelayed(runnable,100);
            }};
        handler.post(runnable);
        button1.setEnabled(false);
            }
    public void stop(View view){
        button1.setEnabled(true);
        handler.removeCallbacks(runnable);
        textView2.setText("Your Time is: " + String.format("%.1f", number));
        number=0;
        textView.setText("Time: "+number);

    }
}