package com.java7.practical.project.sample.service;

import com.java7.practical.project.sample.model.User;
import com.java7.practical.project.sample.repository.UserRepository;
import org.h2.util.StringUtils;

import java.util.Date;

public class UserService {
    private final UserRepository userRepository = new UserRepository();


    // return String, because we want to show some feedback message
    public String addUser(String userName, String firstname,
                          String lastname, String email,
                          Date birth, String address) {

        //user validator
        if (StringUtils.isNullOrEmpty(userName)
                || StringUtils.isNullOrEmpty(firstname)
                || StringUtils.isNullOrEmpty(lastname)
                || StringUtils.isNullOrEmpty(address)
                || birth == null) {
            return "Input error. Complete all fields";
        }

        //UserFactory :: Factory pattern - that would be a better approach
        User user = new User();
        user.setAddress(address);
        user.setDateOfBirth(birth);
        user.setEmail(email);
        user.setFirstname(firstname);
        user.setUsername(userName);
        user.setLastname(lastname);

        long insertedUserId = userRepository.saveUser(user).getId();
        return "USER with ID: " + insertedUserId + " CREATED !";

    }

}
