package com.example.kmpcustomviews;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Size;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import java.util.List;

public class PermissionHelper {

    public final static int GENERAL_PERMISSION = 110;
    private static final String TAG = "PermissionHelper";


    public static boolean hasPhonePermission(Activity activity)
    {
        return ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED;
    }

    public static boolean hasStoragePermission(Activity activity)
    {
        return (ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
                && (ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
    }

    public static void requestPermissions(Object activity, List<String> list)
    {
        String[] permissions = new String[list.size()];

        for (int i = 0; i < list.size(); i++)
        {
            permissions[i] = list.get(i);
        }

        if (activity instanceof Activity)
            ActivityCompat.requestPermissions((Activity) activity, permissions, GENERAL_PERMISSION);
        else
            ((Fragment) activity).requestPermissions(permissions, GENERAL_PERMISSION);
    }


    public static boolean hasPermissions(@NonNull Context context,
                                         @Size(min = 1) @NonNull String... perms) {
        // Always return true for SDK < M, let the system deal with the permissions
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            Log.w(TAG, "hasPermissions: API version < M, returning true by default");

            // DANGER ZONE!!! Changing this will break the library.
            return true;
        }

        // Null context may be passed if we have detected Low API (less than M) so getting
        // to this point with a null context should not be possible.
        if (context == null) {
            throw new IllegalArgumentException("Can't check permissions for null context");
        }

        for (String perm : perms) {
            if (ContextCompat.checkSelfPermission(context, perm)
                    != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }

        return true;
    }
}
