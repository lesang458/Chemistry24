package com.example.user.chemistry24.controllers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.user.chemistry24.database.DBOpenHelper;
import com.example.user.chemistry24.models.TestQuestion;
import com.example.user.chemistry24.models.TopicTheory;

import java.util.ArrayList;

public class TheoryController {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static TheoryController instance;

    private TheoryController(Context context){
        this.openHelper = new DBOpenHelper(context);
    }

    public static TheoryController getInstance(Context context) {
        if(instance == null)
            instance = new TheoryController(context);

        return instance;
    }

    public void open() {
        this.database = openHelper.getReadableDatabase();
    }

    public void close() {
        if(database != null) this.database.close();
    }

    public TopicTheory getTopicTheory(int idTopic) {
        Cursor cursor = database.rawQuery("SELECT * FROM TopicTheory WHERE _id = "+idTopic,null);
        cursor.moveToFirst();
        TopicTheory topicTheory = new TopicTheory(cursor.getInt(0),cursor.getString(1),cursor.getString(2));
        cursor.close();
        return topicTheory;
    }
}
