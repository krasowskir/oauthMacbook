//package com.example.oauthMacbook.domain;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import java.util.UUID;
//
//@Entity
//@Table(name = "myuser")
//public class User {
//
//    @Id
//    private UUID id;
//    private String username;
//    private String password;
//
//    public User() {
//        this.id = UUID.randomUUID();
//    }
//
//    public User(String username, String password) {
//        this.id = UUID.randomUUID();
//        this.username = username;
//        this.password = password;
//    }
//
//    public UUID getId() {
//        return id;
//    }
//
//    public void setId(UUID id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", username='" + username + '\'' +
//                ", password='" + password + '\'' +
//                '}';
//    }
//}
