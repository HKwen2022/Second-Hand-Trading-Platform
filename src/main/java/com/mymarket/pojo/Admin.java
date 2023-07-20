package com.mymarket.pojo;

public class Admin {
    private Integer id;
    private String name;
    private String password;
    private String phone;
    private String email;
    public Admin(){}
    public Admin(Integer id, String name, String password, String phone, String email){
        this.id = id;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }
    public Integer getId(){return id;}
    public String getName(){return name;}
    public String getPassword() {
        return password;
    }
    public String getPhone(){return phone;}
    public String getEmail(){return email;}
}
