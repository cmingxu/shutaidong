package com.example.shutaidong.libs;

import android.content.Context;
import android.widget.Toast;

/**
 * Created with IntelliJ IDEA.
 * User: xcm
 * Date: 1/4/14
 * Time: 9:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class UIHelper {


    public static void toastMessage(Context cont,String msg)
    {
        Toast.makeText(cont, msg, Toast.LENGTH_SHORT).show();
    }
    public static void toastMessage(Context cont,int msg)
    {
        Toast.makeText(cont, msg, Toast.LENGTH_SHORT).show();
    }
    public static void toastMessage(Context cont,String msg,int time)
    {
        Toast.makeText(cont, msg, time).show();
    }

}
