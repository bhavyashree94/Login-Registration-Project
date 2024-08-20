package com.example.login_registration_project.Services;

import com.example.login_registration_project.DTOs.LoginDTO;
import com.example.login_registration_project.DTOs.RegisterDTO;

public interface UserService  {

    String userRegister(RegisterDTO registerDTO);

    String userLogin(LoginDTO loginDTO);
}
