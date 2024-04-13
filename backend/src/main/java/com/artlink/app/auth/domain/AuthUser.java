package com.artlink.app.auth.domain;

import jakarta.persistence.*;

import java.lang.annotation.Inherited;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.artlink.app.user.domain.User;

@Entity
@Table(name = "auth_users",
    indexes = {
        @Index(name = "auth_users_indx_0", columnList= "username")
    })
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "auth_type",
    discriminatorType = DiscriminatorType.STRING)
public abstract class AuthUser implements UserDetails {
    public abstract boolean isDemo();

    public abstract Type getType();

    public enum Type {NORMAL, DEMO}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private boolean active = true;

    @OneToOne
    private User user;

    private String email;

    private String password;

    @Column(unique = true)
    private String username;

    @Column(name = "last_access")
    private LocalDateTime lastAccess;


    /**
     * 
     */
    protected AuthUser() {

    }



    /**
     * @param user
     * @param username
     * @param email
     */
    protected AuthUser(User user, String username, String email) {
        this.user = user;
        this.username = username;
        this.email = email;
    }

    public static AuthUser createAuthUser(User user, String username, String email, Type type) {
        switch (type) {
            case NORMAL:
                return new AuthNormalUser(user, username, email);
            case DEMO:
                return new AuthDemoUser(user, username, email);
            default:
                throw new Exception();
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<>();

        list.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));

        return list;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void remove() {
        user.setAuthUser(null);
        setUser(null);
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
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
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
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the lastAccess
     */
    public LocalDateTime getLastAccess() {
        return lastAccess;
    }

    /**
     * @param lastAccess the lastAccess to set
     */
    public void setLastAccess(LocalDateTime lastAccess) {
        this.lastAccess = lastAccess;
    }
}
