package com.artlink.app.user.dto;

import java.time.LocalDateTime;

import com.artlink.app.auth.domain.AuthUser;
import com.artlink.app.user.domain.User;

public class UserDto {
    private Integer id; 

    private String username;

    private String name;

    private String email;

    private String role;

    private boolean active;

    private String type;

    private String creationDate;

    private String lastAccess;

    private boolean hasData;

    public UserDto() {
    }

    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUserName();
        this.name = user.getName();
        this.role = user.getRole();
        this.creationDate = LocalDateTime.now().toString();
        this.hasData = user.getUserData() != null;

        if (user.getAuthUser() != null) {
            this.active = user.getAuthUser().isActive();
            this.type = user.getAuthUser().getType().name();
            this.email = user.getAuthUser().getEmail();
            this.lastAccess = user.getAuthUser().getLastAccess().toString();
        }
    }

    public UserDto(AuthUser authUser) {
        this(authUser.getUser());
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the creationDate
     */
    public String getCreationDate() {
        return creationDate;
    }

    /**
     * @param creationDate the creationDate to set
     */
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @return the lastAccess
     */
    public String getLastAccess() {
        return lastAccess;
    }

    /**
     * @param lastAccess the lastAccess to set
     */
    public void setLastAccess(String lastAccess) {
        this.lastAccess = lastAccess;
    }

    /**
     * @return the hasData
     */
    public boolean isHasData() {
        return hasData;
    }

    /**
     * @param hasData the hasData to set
     */
    public void setHasData(boolean hasData) {
        this.hasData = hasData;
    }
}
