package com.restaurant.presentation;

import com.restaurant.persistence.entities.MenuItem;
import com.restaurant.service.MenuItemService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@RestController
public class MenuItemController {
    private final MenuItemService service;

    public MenuItemController(MenuItemService service){
        this.service = service;
    }

    @GetMapping("/items")
    List<MenuItem> getAll(){
        return service.getAllItems();
    }

    @GetMapping("/items/{id}")
    MenuItem getOne(@PathVariable Long id) {
        return service.getItem(id);
    }

    @PostMapping("/items")
    MenuItem create(@Valid @RequestBody MenuItem newItem){
        return service.createItem(newItem.getName(), newItem.price());
    }
}
