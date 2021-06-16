package com.PayRoxxy.api.models;

import javax.persistence.*;

@Entity
@Table(name = "tbl_users")
public class UserModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;
    private String user;
    private String password;
    private String name;
    private Integer entityId; 
    
    // Get elements
    public Integer getId(){
        return id;
    }

    public String getUser(){
        return user;
    }

    public String getPassword(){
        return password;
    }

    public String getName(){
        return name;
    }

    public Integer getEntityId(){
        return entityId;
    }

    // Set elements
    public void setId(Integer id) {
        this.id = id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

}