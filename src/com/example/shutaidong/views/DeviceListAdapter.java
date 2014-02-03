package com.example.shutaidong.views;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import com.example.shutaidong.R;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: xcm
 * Date: 2/3/14
 * Time: 12:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class DeviceListAdapter extends BaseAdapter{
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
        EditText editText = (EditText)view.findViewById(R.id.device_name);
        editText.setText(device.getName());
        return view;
    }
}
