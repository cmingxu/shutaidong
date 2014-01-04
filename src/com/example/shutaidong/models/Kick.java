package com.example.shutaidong.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: xcm
 * Date: 1/4/14
 * Time: 8:52 AM
 * To change this template use File | Settings | File Templates.
 */

@Table(name="kicks")
public class Kick extends Model {
    @Column(name="user_name")
    public String user_name;
    @Column(name="happen_at")
    public Date happen_at;
    @Column(name="synced_to_server")
    public boolean synced_to_server;
}
