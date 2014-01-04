package com.example.shutaidong.models;

/**
 * Created with IntelliJ IDEA.
 * User: xcm
 * Date: 1/4/14
 * Time: 8:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class User {
    public String user_name;
    public String password;

    public String loginErrorMessage;

    public static boolean authentication(User user){
        return true;
    }
}
