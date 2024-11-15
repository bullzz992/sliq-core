package com.sliqproperty.sliq_core.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sliqproperty.sliq_core.model.User;
import com.sliqproperty.sliq_core.model.User.Status_Enum;
import com.sliqproperty.sliq_core.service.UserService;

@RestController
@RequestMapping("/Users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(null);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/status/{status}")
    public List<User> getUsersByStatus(@PathVariable Status_Enum status) {
        return userService.getUsersByStatus(status);
    }

    @GetMapping("/idNumber/{idnumber}")
    public User getUserByIdNumber(@PathVariable String idnumber) {
        return userService.getUserByIDNumber(idnumber);
    }

    @GetMapping("/mobileNumber/{mobilenumber}")
    public User getUserByMobileNumber(@PathVariable String mobilenumber) {
        return userService.getUserByMobileNumber(mobilenumber);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable long id, @RequestBody User userDetails) {
        Optional<User> user = userService.getUserById(id);
        if (user.get() != null) {
            User userOut = user.get();
            userOut.setFirstName(userDetails.getFirstName());
            userOut.setLastName(userDetails.getLastName());
            userOut.setIdNUmber(userDetails.getIdNUmber());
            userOut.setPassport(userDetails.getPassport());
            userOut.setPasswordHash(userDetails.getPasswordHash());
            userOut.setEmail(userDetails.getEmail());
            userOut.setMobileNumber(userDetails.getMobileNumber());
            userOut.setCreatedAt(userDetails.getCreatedAt());
            userOut.setUpdatedAt(userDetails.getUpdatedAt());
            userOut.setStatus(userDetails.getStatus());
            userOut.setAddress(userDetails.getAddress());
            userOut.setUserType(userDetails.getUserType());
            userOut.setTitle(userDetails.getTitle());
            userOut.setGender(userDetails.getGender());
            userService.saveUser(userOut);
            return userOut;
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}
