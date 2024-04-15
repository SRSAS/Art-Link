package com.artlink.app.auth.domain;

import java.time.LocalDateTime;

import org.springframework.security.crypto.keygen.KeyGenerators;

import com.artlink.app.user.domain.User;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

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

    public AuthNormalUser(User user, String username, String email) {
        super(user, username, email);
        setActive(false);
       generateConfirmationToken();
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
     * @return the confirmationToken
     */
    public String getConfirmationToken() {
        return confirmationToken;
    }

    /**
     * @param confirmationToken the confirmationToken to set
     */
    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    /**
     * @return the tokenGenerationDate
     */
    public LocalDateTime getTokenGenerationDate() {
        return tokenGenerationDate;
    }

    /**
     * @param tokenGenerationDate the tokenGenerationDate to set
     */
    public void setTokenGenerationDate(LocalDateTime tokenGenerationDate) {
        this.tokenGenerationDate = tokenGenerationDate;
    }

    public void checkConfirmationToken(String token) throws Exception {
        if (isActive()) {
            //TODO change exception
            throw new Exception("User is already active");
        }
        if (!token.equals(getConfirmationToken())) {
            //TODO change exception
            throw new Exception("Invalid confirmation token");
        }
        if (getTokenGenerationDate().isBefore(LocalDateTime.now().minusDays(1))) {
            //TODO change exception
            //TODO maybe add DateHandler
            throw new Exception("Expired confirmation token");
        }
    }

    public String generateConfirmationToken() {
        String token = KeyGenerators.string().generateKey();
        //TODO maybe add DateHandler
        setTokenGenerationDate(LocalDateTime.now());
        setConfirmationToken(token);
        return token;
    }

}
