package com.turtledev.sql_study_2.pojo;

/**
 * Created by 1 on 27.05.2016.
 */
public class Login {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private int id;
    private String name;
    private String password;

    public Login(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
}
