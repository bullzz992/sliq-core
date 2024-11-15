package com.sliqproperty.sliq_core.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sliqproperty.sliq_core.model.Gender;
import com.sliqproperty.sliq_core.service.GenderService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/Genders")
public class GenderController {

    @Autowired
    private GenderService genderService;

    @PostMapping
    public Gender createGender(@RequestBody Gender gender) {
        return genderService.saveGender(gender);
    }

    @GetMapping
    public List<Gender> getAllGFGenders() {
        return genderService.getAllGenders();
    }

    @GetMapping("/{id}")
    public Optional<Gender> getGenderById(@PathVariable Long id) {
        return genderService.getGenderById(id);
    }

    @PutMapping("/{id}")
    public Gender updateGender(@PathVariable Long id, @RequestBody Gender genderDetails) {
        Optional<Gender> gender = genderService.getGenderById(id);

        if (gender.get() != null) {
            Gender genderOut = gender.get();
            genderOut.setName(genderDetails.getName());
            genderOut.setDescription(genderDetails.getDescription());
            genderService.saveGender(genderOut);
            return genderOut;
        }

        return null;

    }

    @DeleteMapping("/{id}")
    public void deleteGender(@PathVariable Long id) {
        genderService.deleteById(id);
    }

}
