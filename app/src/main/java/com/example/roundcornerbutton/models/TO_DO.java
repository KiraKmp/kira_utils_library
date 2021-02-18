package com.example.roundcornerbutton.models;

import android.database.Cursor;

public class TO_DO {
    public int ID;
    public static String TABLE_NAME = "TO_DO";

    public static String TASK_NAME,
            DESCRIPTION,
            DATE,
            COMPLETED;

    public TO_DO(int ID, String TASK_NAME, String DESCRIPTION, String DATE, String COMPLETED) {
        this.ID = ID;
        TO_DO.TASK_NAME = TASK_NAME;
        TO_DO.DESCRIPTION = DESCRIPTION;
        TO_DO.DATE = DATE;
        TO_DO.COMPLETED = COMPLETED;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    public static void setTableName(String tableName) {
        TABLE_NAME = tableName;
    }

    public static String getTaskName() {
        return TASK_NAME;
    }

    public static void setTaskName(String taskName) {
        TASK_NAME = taskName;
    }

    public static String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public static void setDESCRIPTION(String DESCRIPTION) {
        TO_DO.DESCRIPTION = DESCRIPTION;
    }

    public static String getDATE() {
        return DATE;
    }

    public static void setDATE(String DATE) {
        TO_DO.DATE = DATE;
    }

    public static String getCOMPLETED() {
        return COMPLETED;
    }

    public static void setCOMPLETED(String COMPLETED) {
        TO_DO.COMPLETED = COMPLETED;
    }


}
