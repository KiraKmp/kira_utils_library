package com.example.kmpcustomviews.Utils;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.example.kmpcustomviews.ApplicationInitializationListener;
import com.example.kmpcustomviews.DB.DatabaseHelper;
import com.example.kmpcustomviews.DB.QueryHelper;
import com.example.kmpcustomviews.models.APP_SETTINGS;

import java.util.List;

public class ApplicationHelper {
    public static int DB_VERSION=0;

    public static int getDB_VERSION() {
        return DB_VERSION;
    }

    public static void setDB_VERSION(int DB_VERSION) {
        ApplicationHelper.DB_VERSION = DB_VERSION;
    }

    public static void initialize(Activity activity, ApplicationInitializationListener applicationInitializationListener, List<Class> modelClassList){
        PreferenceDataProcessor.initializePreference(activity);
        if(!PreferenceDataProcessor.getStr(AppConstants.APP_INITIALIZED).equals(AppConstants.SUCCESS)) {
            try {
                PackageInfo pInfo = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0);
                String version = pInfo.versionName;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                applicationInitializationListener.onInitializationError(e.getMessage());
            }
            if (getDB_VERSION() == 0) {
                applicationInitializationListener.onInitializationError("Please set DB version");
            } else {
                DatabaseHelper.instantiateDB(getApplicationName(activity), getDB_VERSION());
                DatabaseHelper.getInstance(activity).initialize(modelClassList);
                PreferenceDataProcessor.setStr(AppConstants.APP_INITIALIZED, AppConstants.SUCCESS);
                applicationInitializationListener.onInitializationSuccess();
            }
        }else {
            applicationInitializationListener.appAlreadyInitiated();
        }

    }



    public static String getApplicationName(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int stringId = applicationInfo.labelRes;
        return stringId == 0 ? applicationInfo.nonLocalizedLabel.toString() : context.getString(stringId);
    }

}
