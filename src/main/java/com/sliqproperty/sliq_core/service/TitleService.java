package com.sliqproperty.sliq_core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sliqproperty.sliq_core.model.Title;
import com.sliqproperty.sliq_core.repository.TitleRepository;

@Service
public class TitleService {

    @Autowired
    private TitleRepository titleRepository;

    public void saveTitle(Title title) {
        titleRepository.save(title);
    }

    public List<Title> getAllTitles() {
        return titleRepository.findAll();
    }

    public Optional<Title> getTitleById(Long id) {
        return titleRepository.findById(id);
    }

    public void deleteById(Long id) {
        titleRepository.deleteById(id);
    }
}
