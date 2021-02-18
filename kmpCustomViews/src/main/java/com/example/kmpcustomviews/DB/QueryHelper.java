package com.example.kmpcustomviews.DB;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class QueryHelper {
    private static QueryHelper queryHelper=null;
    private Activity mContext;
    private static SQLiteDatabase db ;

    public QueryHelper(Activity context) {
        this.mContext=context;
        db = DatabaseHelper.getInstance(context).getDB();
    }

    public static QueryHelper getInstance(Activity context) {

        if (queryHelper == null) {
            queryHelper = new QueryHelper(context);
        }
        return queryHelper;
    }

    public Cursor get(String TABLE_NAME){
        String query = "SELECT * FROM "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        return cursor;

    }

    public long put(String TABLE_NAME, ContentValues values){
        long id=  db.insert(TABLE_NAME,null,values);
        return id;
    }


}
