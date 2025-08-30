package com.zzs.pojo;

public class User {
    private int id;
    private String username;
    private String password;
    private String gender;
    private String addr;

    //省略了 setter 和 getter

    public User(int id, String username, String password, String gender, String addr) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.addr = addr;
    }
}
