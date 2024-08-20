package com.example.login_registration_project.Controllers;

import com.example.login_registration_project.DTOs.LoginDTO;
import com.example.login_registration_project.DTOs.RegisterDTO;
import com.example.login_registration_project.Repositories.UserRepository;
import com.example.login_registration_project.Services.UserService;
import com.example.login_registration_project.Services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
public class UserController {
   private  final UserService userService;
   @Autowired
   public UserController(UserService userService, UserRepository userRepository , UserServiceImpl userServiceimpl)
   {
       this.userService=userService;
   }

   @PostMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody LoginDTO loginDTO)
   {
       String response = userService.userLogin(loginDTO);
       return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
   }

   @PostMapping("/register")
   public ResponseEntity<?> userRegister(@RequestBody RegisterDTO registerDTO) {
          String response = userService.userRegister(registerDTO);
          return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
   }

}
