package com.restaurant.presentation;

import com.restaurant.persistence.entities.MenuItem;
import com.restaurant.service.MenuItemService;
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

    @PostMapping("/items")
    MenuItem create(@RequestBody MenuItem newItem){
        return service.createItem(newItem.getName(), newItem.price());
    }
}
