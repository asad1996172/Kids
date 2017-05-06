package com.app.kids;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.app.kids.navigationdrawervideotutorial.R;

/**
 * Created by Asad Mahmood on 4/16/2017.
 */

public class Splash extends AppCompatActivity {
    public static final String PREFS_NAME = "MyPrefsFile";
    private final int DURATION = 2500;
    private Thread mSplashThread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        MediaPlayer mMediaPlayer = new MediaPlayer();
        mMediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.toink);
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        mMediaPlayer.start();
        mSplashThread = new Thread()
        {
            @Override
            public void run()
            {
                synchronized (this){
                    try{

                        wait(DURATION);
                    }
                    catch(InterruptedException e){}
                    finally {
                        finish();

//                        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
//                        int Islogin = prefs.getInt("user", 0);



                        Intent intent = new Intent(getBaseContext(), Main2Activity.class);
                        startActivity(intent);

                    }
                }

            }
        };
        mSplashThread.start();
    }

}