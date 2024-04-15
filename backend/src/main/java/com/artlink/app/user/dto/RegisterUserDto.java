package com.artlink.app.user.dto;

import com.artlink.app.auth.domain.AuthNormalUser;

public class RegisterUserDto {
    private Integer id;
    private String name;
    private String username;
    private String email;
    private String password;
    private boolean active;
    private String confirmationtoken;

    public RegisterUserDto() {
    }

    public RegisterUserDto(AuthNormalUser authUser) {
        this.id = authUser.getId();
        this.name = authUser.getUser().getName();
        this.username = authUser.getUsername();
        this.email = authUser.getEmail();
        this.password = authUser.getPassword();
        this.active = authUser.isActive();
        this.confirmationtoken = authUser.getConfirmationToken();
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
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
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
     * @return the confirmationtoken
     */
    public String getConfirmationtoken() {
        return confirmationtoken;
    }

    /**
     * @param confirmationtoken the confirmationtoken to set
     */
    public void setConfirmationtoken(String confirmationtoken) {
        this.confirmationtoken = confirmationtoken;
    }
}
