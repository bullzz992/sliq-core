package com.sliqproperty.sliq_core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sliqproperty.sliq_core.model.User;
import com.sliqproperty.sliq_core.model.User.Status_Enum;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findByStatus(Status_Enum status);

    User findByIdNUmber(String idNUmber);

    User findByMobileNumber(String mobileNumber);
}
