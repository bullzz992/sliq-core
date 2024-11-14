package com.sliqproperty.sliq_core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sliqproperty.sliq_core.model.Gender;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Long> {

}
