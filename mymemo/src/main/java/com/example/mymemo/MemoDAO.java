package com.example.mymemo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;

public class MemoDAO {

    DBHelper dbHelper;
    String tableName = "memo";

    public static ArrayList<MemoVO> selectAll(DBHelper dbHelper) {

        ArrayList<MemoVO> list = new ArrayList<MemoVO>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql ="select _id, title, content from memojang order by _id desc";
        Cursor cursor = db.rawQuery(sql, null);
        while(cursor.moveToNext()){
            MemoVO memoVO = new MemoVO();
            memoVO.set_id(Integer.parseInt(cursor.getString(0)));
            memoVO.setTitle(cursor.getString(1));
            memoVO.setContent(cursor.getString(2));
            list.add(memoVO);
        }
        db.close();
        return list;
    }

}
