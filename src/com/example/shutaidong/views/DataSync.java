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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.example.shutaidong.R;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: xcm
 * Date: 2/3/14
 * Time: 11:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class DataSync extends Activity {
    public static final String TAG = "DataSyncActivity";
    public static final int REQUEST_ENABLE_BT = 0;
    private BluetoothAdapter mBluetoothAdapter = null;

    private ImageButton mImageButton;
    private ListView mDeviceListView;
    private DeviceListAdapter mDeviceListAdapter = null;
    private ArrayList<BluetoothDevice> mDevices;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_sync);

        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            Log.d(DataSync.TAG, "mBluetoothAdapter is null");
            this.finish();
        }

//        enable blue tooth in case it is disabled
        if (!mBluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        } else {
            pairDevices();
            startDiscoverDevices();
        }


//        mImageButton = (ImageButton)findViewById(R.id.actionButton);
        mDeviceListView = (ListView)findViewById(R.id.deviceListView);
        mDevices = new ArrayList<BluetoothDevice>();
        mDeviceListAdapter = new DeviceListAdapter(mDevices, DataSync.this);

        mDeviceListView.setAdapter(mDeviceListAdapter);
//        mDeviceListView.setEmptyView();
//        mImageButton.setOnClickListener(new OnButtonClickListener());


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_ENABLE_BT:
                if (resultCode == RESULT_OK) {
//                    make sure paired devices discovered
                    pairDevices();
                    startDiscoverDevices();
                }
                if (resultCode == RESULT_CANCELED) {
                    Log.d(DataSync.TAG, "use cancelled blue tooth function");
                    finish();
                }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    public void pairDevices() {
        Log.d(DataSync.TAG, "start pairDevices");
        Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
        if (pairedDevices.size() > 0) {
            // Loop through paired devices
            for (BluetoothDevice device : pairedDevices) {
                // Add the name and address to an array adapter to show in a ListView
                Log.d(DataSync.TAG, device.getAddress() + "\n " + device.getName());
                newDeviceFound(device);
            }
        }
    }


    public void startDiscoverDevices() {
        Log.d(DataSync.TAG, "start discover devices surroundings");
        // Create a BroadcastReceiver for ACTION_FOUND
        BroadcastReceiver mReceiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                // When discovery finds a device
                if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                    // Get the BluetoothDevice object from the Intent
                    BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                    // Add the name and address to an array adapter to show in a ListView
                    Log.d(DataSync.TAG, device.getAddress() + "\n " + device.getName());
                    newDeviceFound(device);

                }
            }
        };
        // Register the BroadcastReceiver
        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(mReceiver, filter);
        mBluetoothAdapter.startDiscovery();
    }


    private class OnButtonClickListener implements Button.OnClickListener{

        @Override
        public void onClick(View v) {
            Log.d(DataSync.TAG, "button clicked");
        }
    }


    private void newDeviceFound(BluetoothDevice device){
        mDevices.add(device);
        mDeviceListAdapter = new DeviceListAdapter(mDevices, DataSync.this);

        mDeviceListView.setAdapter(mDeviceListAdapter);
        mDeviceListView.invalidate();
    }


    private class DeviceListAdapter extends BaseAdapter{
        ArrayList<BluetoothDevice> devices = null;
        Context context;

        public DeviceListAdapter(ArrayList<BluetoothDevice> devices, Context context) {
            this.devices = devices;
            this.context = context;
            if (this.devices == null) {
                this.devices = new ArrayList<BluetoothDevice>();
            }
        }

        public void add(BluetoothDevice device){
            devices.add(device);
        }

        @Override
        public int getCount() {
            return devices.size();
        }

        @Override
        public Object getItem(int position) {
            return devices.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            BluetoothDevice device = devices.get(position);
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.device_list_item, null);
            TextView editText = (TextView)view.findViewById(R.id.device_name);
            editText.setText(device.getName());
            return view;
        }
    }

}