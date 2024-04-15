package com.artlink.app.auth.domain;

import com.artlink.app.user.domain.User;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("DEMO")
public class AuthDemoUser extends AuthUser {
    @Override
    public boolean isDemo() {
        return true;
    }

    @Override
    public Type getType() {
        return Type.DEMO;
    }

    public AuthDemoUser() {
    }

    public AuthDemoUser(User user, String username, String email) {
        super(user, username, email);
    }
}
