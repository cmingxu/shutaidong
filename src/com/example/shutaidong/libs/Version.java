package com.example.shutaidong.libs;

/**
 * Created with IntelliJ IDEA.
 * User: xcm
 * Date: 1/4/14
 * Time: 8:58 AM
 * To change this template use File | Settings | File Templates.
 */
public class Version {
    public int major;
    public int minor;

    public Version(String versionInString){
        this.parseFromString(versionInString);
    }

    public void parseFromString(String versionInString){
        this.major = Integer.parseInt(versionInString.split(".")[0]);
        this.minor = Integer.parseInt(versionInString.split(".")[1]);
    }

    public void inString(){
        String.format("%d.%d", major, minor);
    }

    public int compare(Version otherVersion){
        return (this.major * 10 + this.minor) - (otherVersion.major * 10 + otherVersion.minor);
    }
}
