package com.zhangqie.jetpackmodel.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * Created by zhangqie on 2020/6/17
 * Describe:
 */

@Database(entities = {DbUser.class},version = 1)
public abstract class UserDataBase extends RoomDatabase {

    public static final String DB_NAME="user.db";

    private static UserDataBase instance;

    public static synchronized UserDataBase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context,UserDataBase.class,DB_NAME)
                    .allowMainThreadQueries()//默认room不允许在主线程操作数据库，这里设置允许
                    .build();
        }

        return instance;
    }

    public abstract UserDao getUserDao();

}
