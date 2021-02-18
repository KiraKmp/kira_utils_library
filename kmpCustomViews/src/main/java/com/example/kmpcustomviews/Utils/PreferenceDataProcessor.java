package com.example.kmpcustomviews.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

public class PreferenceDataProcessor {
    private static Context context;
    private static String APP_NAME;
    public PreferenceDataProcessor(Context context){
        PreferenceDataProcessor.context = context;
    }
    public static void initializePreference(Context context){
        PreferenceDataProcessor.context = context;
    }
    public boolean sharedPreferenceExist(String key)
    {
        SharedPreferences prefs = context.getSharedPreferences( getAppName(), 0);
        if(!prefs.contains(key)){
            return true;
        }
        else {
            return false;
        }
    }

    public static void setInt( String key, int value) {
        SharedPreferences prefs = context.getSharedPreferences( getAppName(),0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static int getInt(String key) {
        SharedPreferences prefs = context.getSharedPreferences( getAppName(), 0);
        return prefs.getInt(key, 0);
    }

    public static void setStr(String key, String value) {
        SharedPreferences prefs = context.getSharedPreferences( getAppName(),0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getStr(String key) {
        SharedPreferences prefs = context.getSharedPreferences( getAppName(), 0);
        return prefs.getString(key,"");
    }

    public static void setBool(String key, boolean value) {
        SharedPreferences prefs = context.getSharedPreferences( getAppName(),0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static boolean getBool(String key) {
        SharedPreferences prefs = context.getSharedPreferences( getAppName(), 0);
        return prefs.getBoolean(key,false);
    }

    public static String getAppName(){
        final PackageManager pm = context.getPackageManager();
        ApplicationInfo ai;
        try {
            ai = pm.getApplicationInfo( context.getPackageName(), 0);
        } catch (final PackageManager.NameNotFoundException e) {
            ai = null;
        }
        final String applicationName = (String) (ai != null ? pm.getApplicationLabel(ai) : "(unknown)");
        return applicationName;
    }
}
