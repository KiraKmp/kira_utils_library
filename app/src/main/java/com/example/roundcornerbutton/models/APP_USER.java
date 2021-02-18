package com.example.roundcornerbutton.models;

public class APP_USER{

    private int ID;
    public static String TABLE_NAME = "APP_USER";
    public static String USER_SERVER_ID,
            USER_NAME,
            USER_MOBILE,
            USER_EMAIL,
            USER_DEVICE_TOKEN;

    public enum FIELDS{
        USER_SERVER_ID,
        USER_NAME,
        USER_MOBILE,
        USER_EMAIL,
        USER_DEVICE_TOKEN
    }



    public APP_USER() { }



    public APP_USER(int ID, String USER_SERVER_ID, String USER_NAME, String USER_MOBILE, String USER_EMAIL, String USER_DEVICE_TOKEN) {
        this.ID = ID;
        APP_USER.USER_SERVER_ID = USER_SERVER_ID;
        APP_USER.USER_NAME = USER_NAME;
        APP_USER.USER_MOBILE = USER_MOBILE;
        APP_USER.USER_EMAIL = USER_EMAIL;
        APP_USER.USER_DEVICE_TOKEN = USER_DEVICE_TOKEN;
    }

    public int getID() { return ID; }

    public void setID(int ID) { this.ID = ID; }

    public String getUSER_SERVER_ID() { return USER_SERVER_ID; }

    public void setUSER_SERVER_ID(String USER_SERVER_ID) { APP_USER.USER_SERVER_ID = USER_SERVER_ID; }

    public String getUSER_NAME() { return USER_NAME; }

    public void setUSER_NAME(String USER_NAME) { APP_USER.USER_NAME = USER_NAME; }

    public String getUSER_MOBILE() { return USER_MOBILE; }

    public void setUSER_MOBILE(String USER_MOBILE) { APP_USER.USER_MOBILE = USER_MOBILE; }

    public String getUSER_EMAIL() {
        return USER_EMAIL;
    }

    public void setUSER_EMAIL(String USER_EMAIL) { APP_USER.USER_EMAIL = USER_EMAIL; }

    public String getUSER_DEVICE_TOKEN() {
        return USER_DEVICE_TOKEN;
    }

    public void setUSER_DEVICE_TOKEN(String USER_DEVICE_TOKEN) { APP_USER.USER_DEVICE_TOKEN = USER_DEVICE_TOKEN; }




}
