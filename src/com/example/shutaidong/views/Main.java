package com.example.shutaidong.views;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.shutaidong.R;

import java.util.MissingFormatArgumentException;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: xcm
 * Date: 1/4/14
 * Time: 9:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }


    public void blueToothDataSync(View view){
        redirctTo(DataSync.class);
    }
    public void login(View view){}
    public void registration(View view){}
    public void uploadToServer(View view){}
    public void chartShow(View view){}


    private void redirctTo(Class clazz){
        Intent intent = new Intent();
        intent.setClass(Main.this, clazz);
        startActivity(intent);
    }
}