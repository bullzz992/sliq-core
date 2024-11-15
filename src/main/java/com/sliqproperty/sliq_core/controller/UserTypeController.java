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

import com.sliqproperty.sliq_core.model.UserType;
import com.sliqproperty.sliq_core.service.UserTypeService;

@RestController
@RequestMapping("/UserTypes")
public class UserTypeController {

    @Autowired
    private UserTypeService userTypeService;

    @PostMapping
    public UserType creaUserType(@RequestBody UserType userType) {
        return userTypeService.saveUserType(userType);
    }

    @GetMapping
    public List<UserType> getAllUserTypes() {
        return userTypeService.getAllUserTypes();

    }

    @GetMapping("/{id}")
    public Optional<UserType> getUserTypeById(@PathVariable Long id) {
        return userTypeService.getUserTypeById(id);
    }

    @PutMapping("/{id}")
    public UserType updateUserType(@PathVariable Long id, @RequestBody UserType userTypeDetails) {
        Optional<UserType> userType = userTypeService.getUserTypeById(id);
        if (userType.get() != null) {
            UserType userTypeOut = userType.get();
            userTypeOut.setName(userTypeDetails.getName());
            userTypeOut.setDescription(userTypeDetails.getDescription());
            userTypeService.saveUserType(userTypeOut);
            return userTypeOut;
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteUserType(@PathVariable Long id) {
        userTypeService.deleteById(id);
    }

}
