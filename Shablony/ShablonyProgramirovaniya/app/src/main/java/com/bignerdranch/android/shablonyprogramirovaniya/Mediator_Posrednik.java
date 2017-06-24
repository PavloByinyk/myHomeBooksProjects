package com.bignerdranch.android.shablonyprogramirovaniya;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 31.08.2016.
 */
public class Mediator_Posrednik extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factory_method);

        TextChat textChat=new TextChat();

        User admin=new Admin(textChat);
        User user1=new SimpleUser(textChat);
        User user2=new SimpleUser(textChat);

        textChat.setAdmin(admin);
        textChat.addUser(user1);
        textChat.addUser(user2);

        user1.sendMessage("Hi, I am USER 1");


    }

    interface User{
        void sendMessage(String msg);
        void getdMessage(String msg);

    }

    interface Chat{
        void sendMessage(String msg,User user);
    }

    class Admin implements User{

        Chat chat;

        public Admin(Chat chat) {
            this.chat = chat;
        }

        @Override
        public void sendMessage(String msg) {
            chat.sendMessage(msg,this);

        }

        @Override
        public void getdMessage(String msg) {
            System.out.println("Administrator get a message " + msg);

        }
    }

    class SimpleUser implements User{

        Chat chat;

        public SimpleUser(Chat chat) {
            this.chat = chat;
        }

        @Override
        public void sendMessage(String msg) {
            chat.sendMessage(msg,this);

        }

        @Override
        public void getdMessage(String msg) {
            System.out.println("SimpleUser get a message " + msg);

        }
    }

    class TextChat implements Chat{

        User admin;
        List<User> users=new ArrayList<>();

        public void setAdmin(User admin) {
            this.admin = admin;
        }

        public void addUser(User user){
            users.add(user);
        }

        @Override
        public void sendMessage(String msg, User user) {

            for(User user1 :users){
                user1.getdMessage(msg);
            }
            admin.getdMessage(msg);


        }
    }
}
