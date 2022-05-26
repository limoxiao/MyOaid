package com.example.oaidtest2;

public class DeviceInfo {
    public String oaid;
    public String vaid;
    public String aaid;
    public boolean support = false;
    public boolean isLimited = false;

    @Override
    public String toString() {
        return "DeviceInfo{" +
                "   \noaid='" + oaid + '\'' +
                ",  \n vaid='" + vaid + '\'' +
                ",  \n aaid='" + aaid + '\'' +
                ",  \n support=" + support +
                ",  \n isLimited=" + isLimited +
                "\n}";
    }
}
