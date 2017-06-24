package com.bignerdranch.android.rxjava;

/**
 * Created by 1 on 24.09.2016.
 */
public class Charge {
    @Override
    public String toString() {
        return "Charge{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}' + "\n";
    }

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
