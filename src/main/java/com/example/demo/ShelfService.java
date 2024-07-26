package com.example.demo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShelfService {
    @Autowired
    private ShelfRepository shelfRepository;

    public ShelfService(ShelfRepository shelfRepository) {
        this.shelfRepository = shelfRepository;
    }

    public List<Shelf> findAll() {
        return shelfRepository.findAll();
    }

    public Shelf findById(Long id) {
        return shelfRepository.findById(id).orElse(null);
    }
    // Other methods to manage shelves
}