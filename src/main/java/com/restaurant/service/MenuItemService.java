package com.restaurant.service;

import com.restaurant.persistence.entities.MenuItem;
import com.restaurant.persistence.repositories.MenuItemRepository;
import com.restaurant.exeption.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class MenuItemService {
    private final MenuItemRepository repository;


    public MenuItemService(MenuItemRepository repository) {
        this.repository = repository;
    }

    public List<MenuItem> getAllItems(){
        return repository.findAll();
    }

    @GetMapping("/items/{id}")
    public MenuItem getItem(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with id:" +id));
    }

    public MenuItem createItem(String name, double price){
        MenuItem item= new MenuItem(name, price);
        return repository.save(item);
    }
}
