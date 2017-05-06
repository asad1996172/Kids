package com.app.kids;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.app.kids.navigationdrawervideotutorial.R;

public class Main2Activity extends AppCompatActivity {
    PopupWindow pw;
    Context mContext ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e("Music Status on S2", String.valueOf(((MyApplication) getApplication()).getMusic()));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mContext = this;

        final Button bgm = (Button)findViewById(R.id.background_music);
        if (((MyApplication) getApplication()).getMusic() == true) {
            MusicManager.start(this, MusicManager.MUSIC_MENU);
            bgm.setBackground(getResources().getDrawable(R.drawable.volume));
        }
        else
        {
            MusicManager.pause();
            bgm.setBackground(getResources().getDrawable(R.drawable.mute));
        }

       // MusicManager.start(this, MusicManager.MUSIC_MENU);
        final Button close = (Button)findViewById(R.id.close);
        close.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        close.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.button_animation));
                        break;

                    case MotionEvent.ACTION_UP:
                        close.clearAnimation();
                        break;
                }
                return false;
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(mContext);
                dialog.setContentView(R.layout.popup_layout_1);

                dialog.show();
                final ImageView accept = (ImageView) dialog.findViewById(R.id.accept);
                accept.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        switch (event.getAction()) {
                            case MotionEvent.ACTION_DOWN:

                                accept.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.button_animation));
                                break;

                            case MotionEvent.ACTION_UP:
                                accept.clearAnimation();
                                break;
                        }
                        return false;
                    }
                });

                final ImageView reject = (ImageView) dialog.findViewById(R.id.reject);
                reject.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        switch (event.getAction()) {
                            case MotionEvent.ACTION_DOWN:

                                reject.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.button_animation));
                                break;

                            case MotionEvent.ACTION_UP:
                                reject.clearAnimation();
                                break;
                        }
                        return false;
                    }
                });

                accept.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                        System.exit(0);
                    }
                });
                reject.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        });


        bgm.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        bgm.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.button_animation));
                        break;

                    case MotionEvent.ACTION_UP:
                        bgm.clearAnimation();
                        break;
                }
                return false;
            }
        });
        bgm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((MyApplication) getApplication()).getMusic() == false) {
                    MusicManager.start(mContext, MusicManager.MUSIC_MENU);
                    bgm.setBackground(getResources().getDrawable(R.drawable.volume));
                    ((MyApplication) getApplication()).setMusic(true);

                }
                else
                {
                    MusicManager.pause();
                    bgm.setBackground(getResources().getDrawable(R.drawable.mute));
                    ((MyApplication) getApplication()).setMusic(false);
                }
            }
        });









        final ImageView iv3 = (ImageView)findViewById(R.id.report);

        iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), reportCard.class);
                finishAffinity();
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

        iv3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        iv3.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.button_animation));
                        break;

                    case MotionEvent.ACTION_UP:
                        iv3.clearAnimation();
                        break;
                }
                return false;
            }
        });















        final ImageView iv1 = (ImageView)findViewById(R.id.learn);

        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Main3Activity.class);

                finishAffinity();
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

        iv1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        iv1.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.button_animation));
                        break;

                    case MotionEvent.ACTION_UP:
                        iv1.clearAnimation();
                        break;
                }
                return false;
            }
        });
        final ImageView iv2 = (ImageView)findViewById(R.id.test);


        iv2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        iv2.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.button_animation));
                        break;

                    case MotionEvent.ACTION_UP:
                        iv2.clearAnimation();
                        break;
                }
                return false;
            }
        });


        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        if (((MyApplication) getApplication()).getMusic()) {
            MusicManager.pause();
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Music Status on R2", String.valueOf(((MyApplication) getApplication()).getMusic()));
        if (((MyApplication) getApplication()).getMusic() == true) {
            MusicManager.start(this, MusicManager.MUSIC_MENU);
        }
    }



}
