package com.example.shutaidong;

import android.content.Context;
import com.example.shutaidong.libs.StringUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.*;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: xcm
 * Date: 1/4/14
 * Time: 8:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class AppConfig {
    private final static String APP_CONFIG = "config";

    public static final String version = "version";
    public static final String server_url = "server_url";


    public static final String new_apk_path = "new_apk_path";
    public static final String apk_name = "shutaidong.apk";
    public static final String user_already_login = "user_already_login";
    public static final String user_name = "user_name";
    public static final String password = "password";


    private Context mContext;
    private static AppConfig appConfig;

    public static AppConfig getAppConfig(Context context)
    {
        if(appConfig == null){
            appConfig = new AppConfig();
            appConfig.mContext = context;
        }
        return appConfig;
    }

    public void updateConfig(){}


    public String getVersion() {
        return getWithDefault(version, "1.0");
    }

    public void setVersion(String newVersion) {
        set(version, newVersion);
    }

    public String getServer_url() {
        return getWithDefault(server_url, "http://localhost:3000/");
    }

    public void setServer_url(String new_server_url){
        set(server_url, new_server_url);
    }

    public String getNew_apk_path() {
        return getWithDefault(server_url, getServer_url() + apk_name);
    }

    public void setNew_apk_path(String new_new_apk_path){
        set(new_apk_path, new_new_apk_path);
    }

    public boolean getUser_already_login() {
        return StringUtils.stringToBoolean(getWithDefault(user_already_login, "0"));
    }

    public void set_user_already_login(boolean status){
        set(user_already_login, Boolean.toString(status));
    }

    public String getUser_name() {
        return getWithDefault(user_name, "");
    }

    public void set_user_name(String new_user_name){
        set(user_name, new_user_name);
    }

    public String getPassword() {
        return getWithDefault(password, "");
    }

    public void set_password(String new_password){
        set(password, new_password);
    }

    public String getWithDefault(String key, String defaultValue){
        if(get(key) == null){
            return defaultValue;
        }

        return get(key);
    }

    public String get(String key)
    {
        Properties props = get();
        return (props!=null)?props.getProperty(key):null;
    }

    public Properties get() {
        FileInputStream fis = null;
        Properties props = new Properties();
        try{
            File dirConf = mContext.getDir(APP_CONFIG, Context.MODE_PRIVATE);
            fis = new FileInputStream(dirConf.getPath() + File.separator + APP_CONFIG);

            props.load(fis);
        }catch(Exception e){
        }finally{
            try {
                fis.close();
            } catch (Exception e) {}
        }
        return props;
    }

    private void setProps(Properties p) {
        FileOutputStream fos = null;
        try{
            File dirConf = mContext.getDir(APP_CONFIG, Context.MODE_PRIVATE);
            File conf = new File(dirConf, APP_CONFIG);
            fos = new FileOutputStream(conf);

            p.store(fos, null);
            fos.flush();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                fos.close();
            } catch (Exception e) {}
        }
    }

    public void set(Properties ps)
    {
        Properties props = get();
        props.putAll(ps);
        setProps(props);
    }

    public void set(String key,String value)
    {
        Properties props = get();
        props.setProperty(key, value);
        setProps(props);
    }

    public void remove(String...key)
    {
        Properties props = get();
        for(String k : key)
            props.remove(k);
        setProps(props);
    }


}
