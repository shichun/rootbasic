package com.example.roombasic.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roombasic.entity.User;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insertUsers(User... users);

    @Update
    void updateUsers(User... users);

    @Delete
    void deleteUsers(User... users);

    @Query("DELETE FROM USER")
    void deleteAllUsers();

    @Query("SELECT * FROM USER ORDER BY ID DESC")
    List<User> getAllUsers();

}
