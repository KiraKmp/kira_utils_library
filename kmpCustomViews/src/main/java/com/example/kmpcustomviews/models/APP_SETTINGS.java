package com.example.kmpcustomviews.models;

import android.os.Parcel;
import android.os.Parcelable;

public class APP_SETTINGS implements Parcelable {

    public static int ID;
    public static String TABLE_NAME = "APP_USER";

    public static String APP_NAME,
            APP_VERSION,
            APP_ID;

    public APP_SETTINGS(int ID, String APP_NAME, String APP_VERSION, String APP_ID, String DEV_BASE_URL, String PROD_BASE_URL, String QUALITY_BASE_URL, String LOCAL_BASE_URL) {
        APP_SETTINGS.ID = ID;
        APP_SETTINGS.APP_NAME = APP_NAME;
        APP_SETTINGS.APP_VERSION = APP_VERSION;
        APP_SETTINGS.APP_ID = APP_ID;

    }

    protected APP_SETTINGS(Parcel in) {
        ID = in.readInt();
        APP_NAME = in.readString();
        APP_VERSION = in.readString();
        APP_ID = in.readString();

    }

    public static final Creator<APP_SETTINGS> CREATOR = new Creator<APP_SETTINGS>() {
        @Override
        public APP_SETTINGS createFromParcel(Parcel in) {
            return new APP_SETTINGS(in);
        }

        @Override
        public APP_SETTINGS[] newArray(int size) {
            return new APP_SETTINGS[size];
        }
    };

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        APP_SETTINGS.ID = ID;
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    public static void setTableName(String tableName) {
        TABLE_NAME = tableName;
    }

    public String getAPP_NAME() {
        return APP_NAME;
    }

    public void setAPP_NAME(String APP_NAME) {
        APP_SETTINGS.APP_NAME = APP_NAME;
    }

    public String getAPP_VERSION() {
        return APP_VERSION;
    }

    public void setAPP_VERSION(String APP_VERSION) {
        APP_SETTINGS.APP_VERSION = APP_VERSION;
    }

    public String getAPP_ID() {
        return APP_ID;
    }

    public void setAPP_ID(String APP_ID) {
        APP_SETTINGS.APP_ID = APP_ID;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ID);
        dest.writeString(APP_NAME);
        dest.writeString(APP_VERSION);
        dest.writeString(APP_ID);

    }
}
