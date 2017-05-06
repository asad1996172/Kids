package com.app.kids;

import android.app.Application;

/**
 * Created by Asad Mahmood on 4/28/2017.
 */

public class MyApplication extends Application {

    private boolean continueMusic = true;
    private boolean abccomp = false;
    public boolean getMusic() {
        return continueMusic;
    }

    public void setMusic(boolean someVariable) {
        this.continueMusic = someVariable;
    }

    public boolean getAbcComp() {
        return abccomp;
    }

    public void setAbccomp(boolean someVariable) {
        this.abccomp = someVariable;
    }
}