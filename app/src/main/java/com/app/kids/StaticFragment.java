package com.app.kids;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.app.kids.navigationdrawervideotutorial.R;


/**
 * Example about replacing fragments inside a ViewPager. I'm using
 * android-support-v7 to maximize the compatibility.
 *
 * @author Dani Lao (@dani_lao)
 */
public class StaticFragment extends Fragment {

    private static final String TAG = "StaticFragment";
    String val;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater
                .inflate(R.layout.static_fragment, container, false);

        Button backslider = (Button)view.findViewById(R.id.backslider);
        Button forwardslider = (Button)view.findViewById(R.id.forwardslider);
        String value = getArguments().getString("key");
        int pos = getArguments().getInt("position");

        if (pos == 0)
            backslider.setAlpha((float)0.3);
        else if (pos == 2)
            forwardslider.setAlpha((float)0.3);

        val = value;
        ImageView iv = (ImageView)view.findViewById(R.id.alphabet);
        if (val == "a")
            iv.setImageDrawable(getResources().getDrawable(R.drawable.a));
        else if (val=="b")
            iv.setImageDrawable(getResources().getDrawable(R.drawable.b));
        else if (val=="3")
            iv.setImageDrawable(getResources().getDrawable(R.drawable.three));
        else if (val=="ball")
            iv.setImageDrawable(getResources().getDrawable(R.drawable.ball));
        else if (val=="z")
            iv.setImageDrawable(getResources().getDrawable(R.drawable.z));
        else if (val=="1")
            iv.setImageDrawable(getResources().getDrawable(R.drawable.one));
        else if (val=="2")
            iv.setImageDrawable(getResources().getDrawable(R.drawable.two));

        else if (val=="chair")
            iv.setImageDrawable(getResources().getDrawable(R.drawable.chair));
        else if (val=="cup")
            iv.setImageDrawable(getResources().getDrawable(R.drawable.cup));

        Button bt = (Button)view.findViewById(R.id.soundd);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MediaPlayer mMediaPlayer = new MediaPlayer();
                if (val == "a")
                    mMediaPlayer = MediaPlayer.create(getContext(),R.raw.aa);
                else if (val == "b")
                    mMediaPlayer = MediaPlayer.create(getContext(),R.raw.bb);

                else if (val == "z")
                {
                    mMediaPlayer = MediaPlayer.create(getContext(),R.raw.zz);

                }

                else if (val == "1")
                    mMediaPlayer = MediaPlayer.create(getContext(),R.raw.one);
                else if (val == "3")
                    mMediaPlayer = MediaPlayer.create(getContext(),R.raw.three);
                else if (val == "ball")
                    mMediaPlayer = MediaPlayer.create(getContext(),R.raw.ball);
                else if (val == "2")
                    mMediaPlayer = MediaPlayer.create(getContext(),R.raw.two);

                else if (val == "chair")
                    mMediaPlayer = MediaPlayer.create(getContext(),R.raw.chair);
                else if (val == "cup")
                    mMediaPlayer = MediaPlayer.create(getContext(),R.raw.cup);

                mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mMediaPlayer.start();

            }
        });
        return view;
    }

}
