package com.sliqproperty.sliq_core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sliqproperty.sliq_core.model.UserType;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Long> {

}
