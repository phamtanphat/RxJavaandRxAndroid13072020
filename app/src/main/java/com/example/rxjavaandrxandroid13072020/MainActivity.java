package com.example.rxjavaandrxandroid13072020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Button button = new Button(this);
//        button.setOnClickListener( v -> {
//            Log.d("BBB",v.toString());
//            Log.d("BBB",v.toString() + " dong 2");
//        });
//        fat arrow
//        button.performClick();
        int ketqua = tinhGiaTri(5, new OnCalculator() {
            @Override
            public int doubleValue(int number) {
                return number * 2;
            }
        });
        Log.d("BBB",ketqua + "");
    }

    private int tinhGiaTri(int a , OnCalculator onCalculator){
        return onCalculator.doubleValue(a);
    }

    interface OnCalculator{
        int doubleValue(int number);
    }
}