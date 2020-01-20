package com.science.app.sciencelab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        SharedPreferences prefs = getSharedPreferences("science", MODE_PRIVATE);
        boolean isFirst= prefs.getBoolean("isFirstTime", true);
        if(isFirst){
             MyDbHelper myDbHelper = new MyDbHelper(SplashScreen.this);
        myDbHelper.addItem("aaa","asdasfsdfl kds;lfkds;lfk sd;lkf d;lskf sd;lfksd;l kf;lsd",R.drawable.ic_biology,1);
        myDbHelper.addItem("bbb","sdklf;lsdk ;flsdk ;lfk sd;lkfsd ;lkfsd;l kfd;lskf;sdlf kd",R.drawable.ic_electr,1);
        myDbHelper.addItem("ccc","d;fld; fd;lf ;dl ;dl;f ld;l ;dlf ;dl f;dl f;dl ;l d;l d;fl ",R.drawable.ic_mec,1);
        myDbHelper.addItem("aaa","asdasfsdfl kds;lfkds;lfk sd;lkf d;lskf sd;lfksd;l kf;lsd",R.drawable.ic_chem,1);
        myDbHelper.addItem("aaa","asdasfsdfl kds;lfkds;lfk sd;lkf d;lskf sd;lfksd;l kf;lsd",R.drawable.ic_helper,2);
        myDbHelper.addItem("aaa","asdasfsdfl kds;lfkds;lfk sd;lkf d;lskf sd;lfksd;l kf;lsd",R.drawable.ic_glass,2);
        myDbHelper.addItem("aaa","asdasfsdfl kds;lfkds;lfk sd;lkf d;lskf sd;lfksd;l kf;lsd",R.drawable.ic_chem,2);
        myDbHelper.addItem("aaa","asdasfsdfl kds;lfkds;lfk sd;lkf d;lskf sd;lfksd;l kf;lsd",R.drawable.ic_magnetic,2);
        myDbHelper.addItem("aaa","asdasfsdfl kds;lfkds;lfk sd;lkf d;lskf sd;lfksd;l kf;lsd",R.drawable.ic_light,2);
        prefs.edit().putBoolean("isFirstTime",false).apply();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                    Intent intent = new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(intent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }


}
