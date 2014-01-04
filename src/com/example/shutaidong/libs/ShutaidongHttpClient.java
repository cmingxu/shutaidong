package com.example.shutaidong.libs;

import com.example.shutaidong.models.Kick;
import com.example.shutaidong.models.User;
import com.loopj.android.http.AsyncHttpClient;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: xcm
 * Date: 1/4/14
 * Time: 10:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class ShutaidongHttpClient {
     AsyncHttpClient asyncHttpClient;

    public ShutaidongHttpClient() {
        this.asyncHttpClient = new AsyncHttpClient();
    }

    public static User register(){
        return null;
    }
    public static User login(){
        return null;
    }
    
    public static ArrayList<Kick> getKickes(User user){
        return null;
    }

    public static JSONObject syncConfig(){
        return null;
    }

    public static void postKicks(ArrayList<Kick> kicks){}
}
