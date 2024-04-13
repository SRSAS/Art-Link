package com.artlink.app.auth.domain;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("EXTERNAL")
public class AuthNormalUser extends AuthUser {

    @Column(columnDefinition = "boolean default false")
    private boolean active;

    private String confirmationToken = "";

    private LocalDateTime tokenGenerationDate;

    @Override
    public boolean isDemo() {
        return false;
    }

    @Override
    public Type getType() {
        return Type.NORMAL;
    }

    protected AuthNormalUser() {
    }
}
