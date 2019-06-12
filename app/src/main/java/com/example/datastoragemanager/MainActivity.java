package com.example.datastoragemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView infoTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         infoTv = findViewById(R.id.activity_main__tv__info);
        final Button colorBtn = findViewById(R.id.activity_main__btn__color);
        colorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoTv.setTextColor(Color.BLUE);
            }
        });

        SharedPreferences preferences = getSharedPreferences("Any name you want", Context.MODE_PRIVATE);
        int textColor = preferences.getInt("infoTextColor", -1);
        if (textColor != -1) {
            infoTv.setTextColor(textColor);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences.Editor editor = getSharedPreferences("Any name you want", Context.MODE_PRIVATE).edit();
        editor.putInt("infoTextColor", infoTv.getCurrentTextColor());
        editor.apply();
    }
}
