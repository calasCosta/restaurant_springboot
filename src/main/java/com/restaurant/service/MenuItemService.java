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

    public List<MenuItem> getAllItems() {
        return repository.findAll();
    }

    public MenuItem getItem(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found with id: " + id));
    }

    public MenuItem createItem(String name, double price) {
        MenuItem item = new MenuItem(name, price);
        return repository.save(item);
    }

    public MenuItem updateItem(Long id, String name, double price) {
        MenuItem existing = getItem(id);
        existing.setName(name);
        existing.setPrice(price);
        return repository.save(existing);
    }

    public void deleteItem(Long id) {
        MenuItem existing = getItem(id);
        repository.delete(existing);
    }
}