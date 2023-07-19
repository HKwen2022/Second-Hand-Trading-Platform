package com.mymarket.pojo;

public class User {
    private Integer id;
    private String name;
    private String password;
    private String phone;
    private String email;
    private String imageUrl; //头像地址
    public User(){}
    public User(Integer id, String name, String password, String phone, String email, String imageUrl){
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.imageUrl = imageUrl;
    }
    public Integer getId() {return id;}
    public String getName() {return name;}
    public String getPhone() {return phone;}
    public String getEmail() {return email;}
    public String getPassword() {return password;}

    public String getImageUrl() {
        return imageUrl;
    }
}
