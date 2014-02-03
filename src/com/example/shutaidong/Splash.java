package com.example.shutaidong;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.example.shutaidong.views.Main;

public class Splash extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Intent intent = new Intent();
        intent.setClass(Splash.this, Main.class);
        startActivity(intent);
    }


}
