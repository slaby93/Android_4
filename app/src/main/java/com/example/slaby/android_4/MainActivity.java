package com.example.slaby.android_4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Integer numberOne = randomInt();
    Integer numberTwo = randomInt();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setNumberOne();
        setNumberTwo();
    }

    public void setNumberOne() {
        TextView tw = (TextView) findViewById(R.id.firstValue);
        tw.setText(numberOne.toString());
    }

    public void setNumberTwo() {
        TextView tw = (TextView) findViewById(R.id.secondValue);
        tw.setText(numberTwo.toString());
    }

    public Integer randomInt() {
        return (int) ((Math.random() * 100) % 11);
    }
}
