package com.example.radiocoubi;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.IOException;


public class MediaPlayerInApp extends AppCompatActivity implements View.OnClickListener {

    private ImageButton playButton,pauseButton;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player_in_app);

        final Bundle bundle = getIntent().getExtras();

        playButton = findViewById(R.id.playButton_id);
        pauseButton = findViewById(R.id.pauseButton_id);

        if(bundle!=null)
        {
            final String recordNo = bundle.getString("play");

            if(recordNo.equals("0"))
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.jim);
            else if(recordNo.equals("1"))
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.happy);
            else if(recordNo.equals("2"))
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.kryptonite);
        }

        playButton.setOnClickListener(this);
        pauseButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.playButton_id)
        {
            if(mediaPlayer!=null)
                mediaPlayer.start();
        }
        if(v.getId() == R.id.pauseButton_id)
        {
            if(mediaPlayer!=null)
                mediaPlayer.pause();
        }
    }

    @Override
    protected void onDestroy() {

        if(mediaPlayer!=null && mediaPlayer.isPlaying())
        {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer=null;
        }
        super.onDestroy();
    }
}
