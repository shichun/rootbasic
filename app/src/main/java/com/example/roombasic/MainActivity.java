package com.example.roombasic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.roombasic.dao.UserDao;
import com.example.roombasic.db.UserDataBase;
import com.example.roombasic.entity.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    UserDataBase userDataBase;
    UserDao userDao;
    TextView textView;
    Button buttonInsert,buttonUpdate,buttonDelete,buttonClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userDataBase = Room.databaseBuilder(this,UserDataBase.class,"user_database").allowMainThreadQueries().build();
        userDao = userDataBase.getUserDao();
        textView = findViewById(R.id.textView);
        updateView();
        buttonInsert = findViewById(R.id.buttonInsert);
        buttonUpdate = findViewById(R.id.buttonUpdate);
        buttonClear = findViewById(R.id.buttonClear);
        buttonDelete = findViewById(R.id.buttonDelete);

        buttonInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                User user1 = new User("user1","123");
                User user2 = new User("user2", "123");
                userDao.insertUsers(user1,user2);
                updateView();
            }
        });
    }

    void updateView(){
        List<User> list = userDao.getAllUsers();
        String text = "";
        for(int i =0;i<list.size();i++){
            User user = list.get(i);
            text +=user.getId()+":"+user.getUserName()+"="+user.getPassword()+"\n";

        }
        textView.setText(text);

    }
}