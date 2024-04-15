package com.artlink.app.user;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.artlink.app.auth.domain.AuthNormalUser;
import com.artlink.app.auth.domain.AuthUser;
import com.artlink.app.auth.repository.AuthUserRepository;
import com.artlink.app.user.domain.User;
import com.artlink.app.user.domain.UserData;
import com.artlink.app.user.dto.RegisterUserDto;
import com.artlink.app.user.dto.UserDto;
import com.artlink.app.user.repository.UserDataRepository;
import com.artlink.app.user.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDataRepository userDataRepository;

    @Autowired
    private AuthUserRepository authUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static final String MAIL_FORMAT = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public static final String PASSWORD_CONFIRMATION_MAIL_SUBJECT = "Password Confirmation";

    public static final String PASSWORD_CONFIRMATION_MAIL_BODY = "Link to password confirmation page";

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public List<UserDto> getUsers() {
        return userRepository.findAll().stream().map(user->new UserDto(user))
            .sorted(Comparator.comparing(UserDto::getUsername))
            .collect(Collectors.toList());
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public AuthUser createUserWithAuth(String name, String username, String email, AuthUser.Type type) throws Exception {
        if (authUserRepository.findAuthUserByUsername(username).isPresent()) {
            //TODO change exception
            throw new Exception("Duplicate user");
        }

        User user = new User(name, username, email, type);
        userRepository.save(user);
        return user.getAuthUser();
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public UserDto registerUser(RegisterUserDto registerUserDto) throws Exception {
        AuthNormalUser authUser = createAuthNormalUser(registerUserDto);
        return new UserDto(authUser);
    }

    private AuthNormalUser createAuthNormalUser(RegisterUserDto registerUserDto) throws Exception {
        if (registerUserDto.getUsername() == null || registerUserDto.getUsername().trim().length() == 0) {
            //TODO change exception
            throw new Exception("Invalid username");
        }

        if (authUserRepository.findAuthUserByUsername(registerUserDto.getUsername()).isPresent()) {
            //TODO change exception
            throw new Exception("Username already exists");
        }

        User user = new User(registerUserDto.getName(),registerUserDto.getUsername(), registerUserDto.getEmail(), AuthUser.Type.NORMAL);

        userRepository.save(user);
        
        return (AuthNormalUser) user.getAuthUser();
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public RegisterUserDto confirmRegistration(RegisterUserDto registerUserDto) throws Exception {
        AuthNormalUser authUser = (AuthNormalUser) authUserRepository.findAuthUserByUsername(registerUserDto.getUsername()).orElse(null);

        if (authUser == null) {
            //TODO change exception
            throw new Exception("User not found");
        }

        if (registerUserDto.getPassword() == null || registerUserDto.getPassword().isEmpty()) {
            //TODO change exception
            throw new Exception("Invalid password");
        }

        //TODO finish implementing
        return new RegisterUserDto(authUser);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public UserData getData(Integer id) throws Exception {
        return (userRepository.findById(id).orElseThrow(() -> new Exception("User not found"))).getUserData();
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public List<UserDto> getUsersByNameExpression(String expression) throws Exception {
    return userRepository.findUsersByUsernameExpression(expression).orElseThrow(() -> new Exception("Users not found"))
        .stream().map(user -> new UserDto(user))
        .sorted(Comparator.comparing(UserDto::getUsername))
        .collect(Collectors.toList());
    }
}
