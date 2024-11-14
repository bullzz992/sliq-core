package com.sliqproperty.sliq_core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sliqproperty.sliq_core.model.Gender;
import com.sliqproperty.sliq_core.repository.GenderRepository;

@Service
public class GenderService {

    @Autowired
    private GenderRepository genderRepository;

    public void saveGender(Gender gender) {
        genderRepository.save(gender);
    }

    public List<Gender> getAllGenders() {
        return genderRepository.findAll();
    }

    public Optional<Gender> getGenderById(Long id) {
        return genderRepository.findById(id);
    }

    public void deleteById(Long id) {
        genderRepository.deleteById(id);
    }

}
