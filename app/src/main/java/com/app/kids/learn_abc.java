package com.app.kids;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.app.kids.navigationdrawervideotutorial.R;

public class learn_abc extends ActionBarActivity {

        // For this example, only two pages
        static final int NUM_ITEMS = 3;
        Context mContext;
        ViewPager mPager;
        SlidePagerAdapter mPagerAdapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_learn_abc);
            mContext = this;

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
                    Intent intent = new Intent(getBaseContext(), Main3Activity.class);

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
































		/* Instantiate a ViewPager and a PagerAdapter. */
            mPager = (ViewPager) findViewById(R.id.pager);
            mPagerAdapter = new SlidePagerAdapter(getSupportFragmentManager());
            mPager.setAdapter(mPagerAdapter);

        }

    public void jumpToPage(View view) {
        mPager.setCurrentItem(mPager.getCurrentItem() + 1, true);
    }

    public void jumpBackToPage(View view) {
        mPager.setCurrentItem(mPager.getCurrentItem() - 1, true);
    }

    /* PagerAdapter class */
        public class SlidePagerAdapter extends FragmentPagerAdapter {
            public SlidePagerAdapter(android.support.v4.app.FragmentManager fm)
            {
                super(fm);
            }

            @Override
            public android.support.v4.app.Fragment getItem(int position) {
			/*
			 * IMPORTANT: This is the point. We create a RootFragment acting as
			 * a container for other fragments
			 */
                if (position == 0) {
                    StaticFragment sf = new StaticFragment();
                    Bundle args = new Bundle();
                    args.putString("key", "a");
                    args.putInt("position", position);
                    sf.setArguments(args);
                    return sf;
                }
                else if (position == 1)
                {
                    StaticFragment sf = new StaticFragment();
                    Bundle args = new Bundle();
                    args.putString("key", "b");
                    args.putInt("position", position);
                    sf.setArguments(args);
                    return sf;
                }
                else
                {
                    StaticFragment sf = new StaticFragment();
                    Bundle args = new Bundle();
                    args.putString("key", "z");
                    args.putInt("position", position);
                    sf.setArguments(args);
                    return sf;
                }
            }

            @Override
            public int getCount() {
                return NUM_ITEMS;
            }
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
