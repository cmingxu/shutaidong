package com.example.shutaidong;

import android.app.Application;
import com.activeandroid.ActiveAndroid;
import com.example.shutaidong.models.User;

/**
 * Created with IntelliJ IDEA.
 * User: xcm
 * Date: 1/4/14
 * Time: 8:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class AppContext extends Application {

    public User current_user;
    public AppConfig appConfig;

    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }
    @Override
    public void onTerminate() {
        super.onTerminate();
        ActiveAndroid.dispose();
    }

    public AppContext() {
        super();
        appConfig = AppConfig.getAppConfig(getApplicationContext());
    }

    public void login(User current_user){
        this.current_user = current_user;
        appConfig.set_password(current_user.password);
        appConfig.set_user_name(current_user.user_name);
        appConfig.set_user_already_login(true);
    }

    public void logout(){
        appConfig.set_password("");
        appConfig.set_user_name("");
        appConfig.set_user_already_login(false);
    }


    public void clearCache(){

    }

}
