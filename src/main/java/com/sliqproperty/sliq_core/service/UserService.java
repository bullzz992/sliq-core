package com.sliqproperty.sliq_core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sliqproperty.sliq_core.model.User;
import com.sliqproperty.sliq_core.model.User.Status_Enum;
import com.sliqproperty.sliq_core.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    public List<User> getUsersByStatus(Status_Enum status) {
        Optional<List<User>> users = Optional.ofNullable(userRepository.findByStatus(status));
        return users.orElse(null);
    }

    public List<User> getUserByIDNumber(String idNumber) {
        Optional<List<User>> user = Optional.ofNullable(userRepository.findByIdNUmber(idNumber));
        return user.orElse(null);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
