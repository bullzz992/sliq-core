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

import com.sliqproperty.sliq_core.model.Title;
import com.sliqproperty.sliq_core.service.TitleService;

@RestController
@RequestMapping("/Titles")
public class TitleController {

    @Autowired
    private TitleService titleService;

    @PostMapping
    public Title createTitle(@RequestBody Title title) {
        return titleService.saveTitle(title);
    }

    @GetMapping
    public List<Title> getAllTitles() {
        return titleService.getAllTitles();
    }

    @GetMapping("/{id}")
    public Optional<Title> getGenderById(@PathVariable Long id) {
        return titleService.getTitleById(id);
    }

    @PutMapping("/{id}")
    public Title updateTitle(@PathVariable Long id, @RequestBody Title titleDetails) {
        Optional<Title> title = titleService.getTitleById(id);
        if (title.get() != null) {
            Title titleOut = title.get();
            titleOut.setName(titleDetails.getName());
            titleOut.setDescription(titleDetails.getDescription());
            titleService.saveTitle(titleOut);
            return titleOut;
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteTitle(@PathVariable Long id) {
        titleService.deleteById(id);
    }

}
