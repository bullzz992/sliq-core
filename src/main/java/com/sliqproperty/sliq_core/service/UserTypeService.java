package com.sliqproperty.sliq_core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sliqproperty.sliq_core.model.UserType;
import com.sliqproperty.sliq_core.repository.UserTypeRepository;

@Service
public class UserTypeService {

    @Autowired
    private UserTypeRepository userTypeRepository;

    public UserType saveUserType(UserType userType) {
        return userTypeRepository.save(userType);
    }

    public List<UserType> getAllUserTypes() {
        return userTypeRepository.findAll();
    }

    public Optional<UserType> getUserTypeById(Long id) {
        return userTypeRepository.findById(id);
    }

    public void deleteById(Long id) {
        userTypeRepository.deleteById(id);
    }

}
