package com.example.login_registration_project.Repositories;

import com.example.login_registration_project.Modules.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserEmail(String userEmail);

    User findByUserName(String userName);

}
