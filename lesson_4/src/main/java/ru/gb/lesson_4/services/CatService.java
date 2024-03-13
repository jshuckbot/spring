package ru.gb.lesson_4.services;


import org.springframework.stereotype.Service;
import ru.gb.lesson_4.models.Cat;
import ru.gb.lesson_4.repository.CatRepository;

import java.util.List;

@Service
public class CatService {
    private final CatRepository catRepository;

    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }
    
    public List<Cat> getAll() {
        return catRepository.getCats();
    }
    
    public void addCatToList(Cat cat) {
        catRepository.getCats().add(cat);
    }
    
}