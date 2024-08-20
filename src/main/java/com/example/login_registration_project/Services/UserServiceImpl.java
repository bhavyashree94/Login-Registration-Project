package com.example.login_registration_project.Services;

import com.example.login_registration_project.DTOs.LoginDTO;
import com.example.login_registration_project.DTOs.RegisterDTO;
import com.example.login_registration_project.Modules.User;
import com.example.login_registration_project.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public String userLogin(LoginDTO loginDTO) {
        User existingUser = userRepository.findByUserEmail(loginDTO.getUserEmail());
        if(existingUser != null && passwordEncoder.matches(loginDTO.getPassword(), existingUser.getPassword()))
        {
            return "login Successfull";
        } else if ( existingUser == null ) {
            return "You enter wrong email , please enter again";
        }
        else {
            return "you enter wrong password";
        }
    }

    @Override
    public String userRegister(RegisterDTO registerDTO) {
        if (userRepository.findByUserName(registerDTO.getUserName()) != null) {
            return "User with this username is already present";
        } else if (userRepository.findByUserEmail(registerDTO.getUserEmail()) != null) {
            return "User with this email is already present";
        }
        else {
            User user = convertToUser(registerDTO);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return "User is registered successfully";
        }
    }

    private User convertToUser(RegisterDTO registerDTO) {
        User user = new User();
        user.setUserName(registerDTO.getUserName());
        user.setUserEmail(registerDTO.getUserEmail());
        user.setPassword(registerDTO.getPassword());
        return user;
    }
}
