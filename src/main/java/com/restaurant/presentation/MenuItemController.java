package com.restaurant.presentation;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

record MenuItem(Long id, String name, double price){}

@RestController
public class MenuItemController {
    private final List<MenuItem> menuItems = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @GetMapping("/items")
    List<MenuItem> getAll(){
        return menuItems;
    }

    @PostMapping("/items")
    MenuItem create(@RequestBody MenuItem newItem){
        MenuItem item = new MenuItem(
                idGenerator.getAndIncrement(),
                newItem.name(),
                newItem.price());
        menuItems.add(item);
        return item;
    }
}
