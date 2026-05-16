package com.restaurant.presentation;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

record MenuItem(Long id, String name, double price){}

@RestController
@RequestMapping("/items")
public class MenuItemController {
    private final List<MenuItem> menuItems = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    //GET /items retrieve all
    @GetMapping
    List<MenuItem> getAll(){
        return menuItems;
    }

    //GET /items/{id} - retrieve one
    @GetMapping("/{id}")
    MenuItem getOne(@PathVariable Long id){
       return menuItems.stream()
                .filter(item -> item.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Item not found"));
    }

    //POST /items - create new
    @PostMapping
    MenuItem create(@RequestBody MenuItem newItem){
        MenuItem item = new MenuItem(
                idGenerator.getAndIncrement(),
                newItem.name(),
                newItem.price());
        menuItems.add(item);
        return item;
    }

    //PUT /{id} - update existing
    @PutMapping("/{id}")
    MenuItem update(@PathVariable Long id, @RequestBody MenuItem updatedItem){
        MenuItem existing = getOne(id); // reuse lookup
        menuItems.remove(existing);

        MenuItem newItem = new MenuItem(id, updatedItem.name(), updatedItem.price());
        menuItems.add(newItem);
        return newItem;
    }

    //DELETE /{id} - delete
    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id){
        MenuItem existing = getOne(id);
        menuItems.remove(existing);
    }
}
