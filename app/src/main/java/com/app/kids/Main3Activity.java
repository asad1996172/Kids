package com.app.kids;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.app.kids.navigationdrawervideotutorial.R;

public class Main3Activity extends AppCompatActivity {

    Context mContext ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e("Music Status on S3", String.valueOf(((MyApplication) getApplication()).getMusic()));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        final Button bgm = (Button)findViewById(R.id.background_music);
        final Button back = (Button)findViewById(R.id.back) ;
        back.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        back.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.button_animation));
                        break;

                    case MotionEvent.ACTION_UP:
                        back.clearAnimation();
                        break;
                }
                return false;
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Main2Activity.class);

                finishAffinity();
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

            }
        });

        final Button home = (Button)findViewById(R.id.home) ;
        home.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        home.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.button_animation));
                        break;

                    case MotionEvent.ACTION_UP:
                        home.clearAnimation();
                        break;
                }
                return false;
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Main2Activity.class);

                finishAffinity();
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

            }
        });

















        mContext = this;
        if (((MyApplication) getApplication()).getMusic() == true) {
            MusicManager.start(this, MusicManager.MUSIC_MENU);
            bgm.setBackground(getResources().getDrawable(R.drawable.volume));
        }
        else
        {
            MusicManager.pause();
            bgm.setBackground(getResources().getDrawable(R.drawable.mute));
        }
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












        final CardView card = (CardView)findViewById(R.id.card_view);
        card.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        card.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.button_animation));
                        break;

                    case MotionEvent.ACTION_UP:
                        card.clearAnimation();
                        break;
                }
                return false;
            }
        });
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), learn_abc.class);

                finishAffinity();
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });


        final CardView card1 = (CardView)findViewById(R.id.card_view1);
        card1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        card1.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.button_animation));
                        break;

                    case MotionEvent.ACTION_UP:
                        card1.clearAnimation();
                        break;
                }
                return false;
            }
        });
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), learn_123.class);

                finishAffinity();
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

        final CardView card2 = (CardView)findViewById(R.id.card_view2);
        card2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        card2.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.button_animation));
                        break;

                    case MotionEvent.ACTION_UP:
                        card2.clearAnimation();
                        break;
                }
                return false;
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), learn_things.class);

                finishAffinity();
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
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
        Log.e("Music Status on R3", String.valueOf(((MyApplication) getApplication()).getMusic()));
        if (((MyApplication) getApplication()).getMusic() == true) {
            MusicManager.start(this, MusicManager.MUSIC_MENU);
        }
    }

}
