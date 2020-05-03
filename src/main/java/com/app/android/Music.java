package com.app.android;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Music extends AppCompatActivity {
    Button bnUkulele;
    MediaPlayer mpUkulele;
    int playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        bnUkulele = (Button)findViewById(R.id.btnUkulele);
        bnUkulele.setOnClickListener(bUkulele);

        mpUkulele = new MediaPlayer();
        mpUkulele = MediaPlayer.create(this, R.raw.ukulele);

        playing = 0;
    }

    Button.OnClickListener bUkulele = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(playing) {
                case 0:
                    mpUkulele.start();
                    playing = 1;
                    bnUkulele.setText("Stop Playing Ukulele?");
                    break;
                case 1:
                    mpUkulele.pause();
                    playing = 0;
                    bnUkulele.setText("Start Playing Ukulele?");
                    break;
            }
        }
    };
}
