package com.example.kmpcustomviews.DB;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.kmpcustomviews.models.APP_SETTINGS;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static DatabaseHelper databaseHelper = null;
    private List<String> createTableQuery;
    private List<String> dropTableQuery;
    // Logcat tag
    public static  String LOG = "DatabaseHelper";
    // Database Version
    public static  int DATABASE_VERSION = 1;
    // Database Name
    public static  String DB_NAME = "";

    public SQLiteDatabase getDB(){
        SQLiteDatabase db = this.getReadableDatabase();
        return db;
    }


    public static void instantiateDB(String DB_NAME,int DB_VERSION){
        setDbName(DB_NAME);
        setDatabaseVersion(DB_VERSION);
    }


    public static DatabaseHelper getInstance(Activity activity){
        if(getDbName().isEmpty()){
            Toast.makeText(activity, "DB name is not set", Toast.LENGTH_SHORT).show();
        }
        if (databaseHelper == null) {
            databaseHelper = new DatabaseHelper(activity,getDbName(),null,getDatabaseVersion());
        }
        return databaseHelper;
    }

    public void initialize(List<Class> tableList){
        createTableQuery=new ArrayList<>();
        dropTableQuery=new ArrayList<>();
        for (Class c : tableList){
            createTableQuery.add(DbUtils.generateCreateTableQueryForModelClass(c));
            dropTableQuery.add(DbUtils.generateDropTableQueryForModelClass(c));
        }
        this.getWritableDatabase();
    }

    public static String getLOG() {
        return LOG;
    }

    public static int getDatabaseVersion() {
        return DATABASE_VERSION;
    }

    public static void setLOG(String LOG) {
        DatabaseHelper.LOG = LOG;
    }

    public static void setDatabaseVersion(int databaseVersion) {
        DATABASE_VERSION = databaseVersion;
    }

    public static String getDbName() {
        return DB_NAME;
    }

    public static void setDbName(String dbName) {
        DB_NAME = dbName;
    }

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        for (String createTable : createTableQuery){
            db.execSQL(createTable);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        for (String dropTable : dropTableQuery){
            db.execSQL(dropTable);
        }
        onCreate(db);
    }
}
