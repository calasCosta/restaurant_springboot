package com.restaurant.service;

import com.restaurant.persistence.entities.MenuItem;
import com.restaurant.persistence.repositories.MenuItemRepository;
import org.springframework.stereotype.Service;
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

    public MenuItem createItem(String name, double price){
        MenuItem item= new MenuItem(name, price);
        return repository.save(item);
    }
}
