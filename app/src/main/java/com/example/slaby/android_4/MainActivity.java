package com.example.slaby.android_4;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Integer numberOne = 0;
    Integer numberTwo = 0;
    String result = "";
    TextView helper;
    Boolean isFinished = false;
    MediaPlayer successSound;
    MediaPlayer failSound;
    SharedPreferences prefs;
    Integer zakres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = (TextView) findViewById(R.id.helper);
        successSound = MediaPlayer.create(this, R.raw.onsuccess);
        failSound = MediaPlayer.create(this, R.raw.onfail);

        prefs = getSharedPreferences("com.example.slaby.android_4", Context.MODE_PRIVATE);
        zakres = prefs.getInt("zakres",5);
        onStartAction();
    }

    public void onStartAction() {
        numberOne = randomInt();
        numberTwo = randomInt();
        setNumberOne();
        setNumberTwo();
        isFinished = false;
        TextView result = (TextView) findViewById(R.id.result);
        result.setText("");
        helper.setText("");
        Button check = (Button) findViewById(R.id.checkBtn);
        check.setText("Sprawdz");
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
        System.out.println("ZAKRES " + zakres);
        return (int) ((Math.random() * 100) % (zakres + 1));
    }

    public void onNumberClick(View view) {
        Button btn = (Button) view;
        String buttonText = (String) btn.getText();
        TextView tw = (TextView) findViewById(R.id.result);
        result = tw.getText().toString();
        result += buttonText;
        System.out.println(result);
        tw.setText(result);
    }

    public void onCheck(View view) {
        if (isFinished) {
            onStartAction();
        } else {
            TextView tw = (TextView) findViewById(R.id.result);
            if (tw.getText().toString().length() == 0) {
                return;
            }
            Integer result = Integer.valueOf(tw.getText().toString());
            if (result == (numberOne * numberTwo)) {
                onSuccess();
            } else {
                onError();
            }
        }

    }

    public void onSuccess() {
        helper.setText(numberOne + " x " + numberTwo + " = " + result + " Brawo!!!");
        isFinished = true;
        Button check = (Button) findViewById(R.id.checkBtn);
        successSound.start();
        check.setText("DALEJ");
    }

    public void onError() {
        helper.setText("Błąd!!! " + numberOne + " x " + numberTwo + " = " + numberOne * numberTwo);
        isFinished = true;
        failSound.start();
        Button check = (Button) findViewById(R.id.checkBtn);
        check.setText("DALEJ");
    }

    public void onOptions(View view) {
        Intent myIntent = new Intent(this, Options.class);
        startActivity(myIntent);
    }
}
