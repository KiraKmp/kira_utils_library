package com.example.roundcornerbutton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.kmpcustomviews.ApplicationInitializationListener;
import com.example.kmpcustomviews.CreateCustomDrawable;
import com.example.kmpcustomviews.DB.DatabaseHelper;
import com.example.kmpcustomviews.DB.QueryHelper;
import com.example.kmpcustomviews.Loader.Loader;
import com.example.kmpcustomviews.NetworkConnectionListner;
import com.example.kmpcustomviews.NetworkUtil;
import com.example.kmpcustomviews.PermissionHelper;
import com.example.kmpcustomviews.Utils.ApplicationHelper;
import com.example.roundcornerbutton.models.APP_USER;
import com.example.roundcornerbutton.models.TO_DO;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.security.Permissions;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NetworkConnectionListner, ApplicationInitializationListener {
    RelativeLayout mRootLayout;
    LinearLayout mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRootLayout=findViewById(R.id.xRootLayout);
        mButton=findViewById(R.id.xButton);
        List<Class> modelClassList = new ArrayList<>();
        ApplicationHelper.setDB_VERSION(1);
        modelClassList.add(APP_USER.class);
        modelClassList.add(TO_DO.class);
        ApplicationHelper.initialize(this,this,modelClassList);


//        APP_USER app_user = new APP_USER(0,"123","KIRA","7904189783","kira@gmail.com","yawegfriewaiufryeiwuyiyxa5875aewoifxoiaewfoi");
//        try {
//            DbUtils.getContentValues(app_user.getClass(),app_user);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
        // Cursor cursor = QueryHelper.getInstance(this).get(APP_USER.TABLE_NAME);
       // if(cursor!=null){ Log.e("CURSOR_LENGTH", String.valueOf(cursor.getCount()));}
//        mRootLayout.setBackground(CreateCustomDrawable.getInstance().getRectDrawableGradient(getResources().getColor(R.color.green),getResources().getColor(R.color.purple_500),getResources().getColor(R.color.green),5,R.color.purple_200,40,0,0,0));
//        mButton.setBackground(CreateCustomDrawable.getInstance().getRectDrawable(getResources().getColor(R.color.white),4,getResources().getColor(R.color.green),40,40,0,40));
//
//        if(PermissionHelper.hasPermissions(this, Manifest.permission.CALL_PHONE)){
//            Toast.makeText(this, "Already granted", Toast.LENGTH_SHORT).show();
//        }else {
//            List<String> permissionList = new ArrayList<>();
//            permissionList.add(Manifest.permission.CALL_PHONE);
//            PermissionHelper.requestPermissions(this,permissionList);
//            Toast.makeText(this, "Grant Permission", Toast.LENGTH_SHORT).show();
//        }
//            Loader.showLoader(this,"Fetching...");
//
//
//        new Handler().postDelayed(Loader::hideLoader,10000);
//
        NetworkUtil.registerForInternetConnection(this,MainActivity.this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for (int i : grantResults){
            if(i== PackageManager.PERMISSION_DENIED)
            {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onConnectionLost() {
        Toast.makeText(this, "Connection Lost", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onConnectionEstablished() {
        Toast.makeText(this, "Connected to internet", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        NetworkUtil.unRegisterForInternetConnection(this);
    }

    @Override
    public void onInitializationSuccess() {
        Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onInitializationError(String err) {
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void appAlreadyInitiated() {
        Toast.makeText(this, "Already Initiated", Toast.LENGTH_SHORT).show();
    }
}