package com.example.suncica.todo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Suncica on 10/23/2016.
 */

public class TaskDataBase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "tasks.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "tasks";
    public static final String COLUMN_TASK_TITLE = "TaskTitle";
    public static final String COLUMN_TASK_DESCRIPTION = "TaskDescription";
    public static final String COLUMN_IS_DONE = "IsDone";
    public static final String COLUMN_COLOR = "ColorColumn";


    public TaskDataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_TASK_TITLE + " TEXT, " +
                COLUMN_TASK_DESCRIPTION + " TEXT, " +
                COLUMN_IS_DONE + " TEXT, " +
                COLUMN_COLOR + " TEXT );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(Element element) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_TASK_TITLE, element.getToDoTask());
        values.put(COLUMN_TASK_DESCRIPTION, element.getTaskDescription());
        values.put(COLUMN_IS_DONE, element.getTaskDone());
        values.put(COLUMN_COLOR, element.getColor());
        db.insert(TABLE_NAME, null, values);
        close();
    }

    public Element[] readAllTasks() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null, null);

        if (cursor.getCount() <= 0) {
            return null;
        }

        Element[] elements = new Element[cursor.getCount()];
        int i = 0;
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            elements[i++] = createNewElement(cursor);
        }

        close();
        return elements;
    }

    public Element readElement(String taskTitle) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, COLUMN_TASK_TITLE + "=?",
                new String[]{taskTitle}, null, null, null);
        cursor.moveToFirst();
        Element element = createNewElement(cursor);

        close();
        return element;
    }

    public void deleteElement(String taskTitle) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_TASK_TITLE + "=?", new String[]{taskTitle});
        close();
    }

    private Element createNewElement(Cursor cursor) {
        String taskTitle = cursor.getString(cursor.getColumnIndex(COLUMN_TASK_TITLE));
        String taskDecription = cursor.getString(cursor.getColumnIndex(COLUMN_TASK_DESCRIPTION));
        String isDone = cursor.getString(cursor.getColumnIndex(COLUMN_IS_DONE));
        String colorValue = cursor.getString(cursor.getColumnIndex(COLUMN_COLOR));
        return new Element(taskTitle, taskDecription, Boolean.valueOf(isDone),colorValue);
    }

    public void updatedetails(String taskTtitleOld, String taskTitle, String taskDescription, String isDone,String color) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(COLUMN_TASK_TITLE, taskTitle);
        args.put(COLUMN_TASK_DESCRIPTION, taskDescription);
        args.put(COLUMN_IS_DONE, isDone);
        args.put(COLUMN_COLOR, color);
        db.update(TABLE_NAME, args, COLUMN_TASK_TITLE + "=?",new String[]{taskTtitleOld});
    }
}
