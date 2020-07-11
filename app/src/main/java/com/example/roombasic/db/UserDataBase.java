package com.example.roombasic.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.roombasic.dao.UserDao;
import com.example.roombasic.entity.User;

@Database(entities = {User.class},version=1 , exportSchema = false)
public abstract class UserDataBase extends RoomDatabase {
    public abstract UserDao getUserDao();

}
