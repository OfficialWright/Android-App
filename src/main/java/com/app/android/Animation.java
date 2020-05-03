package com.app.android;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Animation extends AppCompatActivity {
    Button bnCar;
    ImageView imgFrame;
    AnimationDrawable carAnimation;
    int animating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        bnCar = (Button)findViewById(R.id.btnCar);
        bnCar.setOnClickListener(bCar);

        imgFrame = (ImageView)findViewById(R.id.imgCar);
        imgFrame.setBackgroundResource(R.drawable.animation);

        carAnimation = (AnimationDrawable)imgFrame.getBackground();

        animating = 0;
    }

    Button.OnClickListener bCar = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(animating) {
                case 0:
                    carAnimation.start();
                    animating = 1;
                    bnCar.setText("Stop Animating Car?");
                    break;
                case 1:
                    carAnimation.stop();
                    animating = 0;
                    bnCar.setText("Start Animating Car?");
                    break;
            }
        }
    };
}
