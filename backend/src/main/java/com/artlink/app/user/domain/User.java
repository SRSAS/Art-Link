package com.artlink.app.user.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String name;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER, orphalRemoval = true)
    private AuthUser authUser;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER, orphalRemoval = true)
    private UserData userData;

    protected User() {}

    protected User(String name, String username, String email, AuthUser.Type type) {
        setName(name);
        setUsername(username);
        setAuthUser(AuthUser.createAuthUser(this, username, email, type));
        setUserData(UserData.createUserData(this));
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AuthUser getAuthUser() {
        return this.authuser;
    }

    public void setAuthUser(AuthUser authUser) {
        this.authUser = authUser;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }


}

