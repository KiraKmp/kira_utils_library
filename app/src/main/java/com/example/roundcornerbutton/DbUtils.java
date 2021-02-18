package com.example.roundcornerbutton;

import android.content.ContentValues;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class DbUtils {
//    public static String generateCreateTableQueryForModelClass(Class c){
//        Field[] fields = c.getDeclaredFields();
//        String create_table = "CREATE TABLE "+c.getSimpleName()+" (";
//         for(int i = 0; i < fields.length; i++) {
//             if(i==(fields.length-1)){
//                if(fields[i].getName().equals(DbFieldTypes.PRIMARY_KEY_FLAG)){
//                    create_table = create_table + fields[i].getName() + " "+DbFieldTypes.PRIMARY_KEY;
//                }else {
//                    if(fields[i].getGenericType().getTypeName().equals(String.class.getTypeName())){
//                        create_table = create_table + fields[i].getName() + " "+DbFieldTypes.TEXT;
//                    }else  if(fields[i].getGenericType().getTypeName().equals(int.class.getTypeName())){
//                        create_table = create_table + fields[i].getName() + " "+DbFieldTypes.INTEGER;
//                    }
//                }
//            }else {
//                if(fields[i].getName().equals(DbFieldTypes.PRIMARY_KEY_FLAG)){
//                    create_table = create_table + fields[i].getName() + " "+DbFieldTypes.PRIMARY_KEY+",";
//                }else {
//                    if(fields[i].getGenericType().getTypeName().equals(String.class.getTypeName())){
//                        create_table = create_table + fields[i].getName() + " "+DbFieldTypes.TEXT+",";
//                    }else  if(fields[i].getGenericType().getTypeName().equals(Integer.class.getTypeName())){
//                        create_table = create_table + fields[i].getName() + " "+DbFieldTypes.INTEGER+",";
//                    }
//                }
//
//            }
//
//        }
//        create_table = create_table+")";
//        return create_table;
//    }
//
//    public static String generateDropTableQueryForModelClass(Class c){
//        return "DROP TABLE IF EXISTS "+c.getSimpleName();
//    }
//
//    public static ContentValues getContentValues(Class c, Object obj) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        ContentValues contentValues = new ContentValues();
//
//        Field[] fields = c.getDeclaredFields();
//        for(int i = 0; i < fields.length; i++) {
//            if(fields[i].getGenericType().getTypeName().equals(String.class.getTypeName())){
//                Log.e("STR",String.valueOf(obj.getClass().getDeclaredMethod("get"+fields[i].getName()).invoke(null)));
//                contentValues.put(fields[i].getName(), String.valueOf(obj.getClass().getDeclaredMethod("get"+fields[i].getName()).invoke(null)));
//            }else  if(fields[i].getGenericType().getTypeName().equals(int.class.getTypeName())){
//                Log.e("STR", String.valueOf((Integer)(obj.getClass().getDeclaredMethod("get"+fields[i].getName()).invoke(null))));
//                contentValues.put(fields[i].getName(), (Integer) obj.getClass().getDeclaredMethod("get"+fields[i].getName()).invoke(null));
//            }
//
//        }
//
//        return contentValues;
//    }
}
