package com.example.slaby.android_4;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

public class Options extends AppCompatActivity {

    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        prefs = getSharedPreferences("com.example.slaby.android_4", Context.MODE_PRIVATE);
    }

    public void setZakres(View view) {
        RadioButton rbt = (RadioButton) view;
        prefs.edit().putInt("zakres", Integer.valueOf(rbt.getText().toString())).apply();

    }

    public void onImageClick(View view) {
        ImageView imageView = (ImageView) view;
        int id = imageView.getId();
        System.out.println("ID: " + id);
        goBackToMainActivity(id);
    }

    public void goBackToMainActivity() {
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }

    public void goBackToMainActivity(int value) {
        Intent myIntent = new Intent(this, MainActivity.class);
        myIntent.putExtra("photo", value);
        startActivity(myIntent);
    }
}
