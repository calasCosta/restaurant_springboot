package com.restaurant.presentation;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.restaurant.service.MenuItemService;
import com.restaurant.persistence.entities.MenuItem;
import java.util.List;

@RestController
@RequestMapping("/items")
public class MenuItemController {
    private final MenuItemService service;

    public MenuItemController(MenuItemService service) {
        this.service = service;
    }

    //GET /items retrieve all
    @GetMapping
    List<MenuItem> getAll(){
        return service.getAllItems();
    }

    //GET /items/{id} - retrieve one
    @GetMapping("/{id}")
    MenuItem getOne(@PathVariable Long id){
        return service.getItem(id);
    }

    //POST /items - create new
    @PostMapping
    MenuItem create(@Valid @RequestBody MenuItem newItem){
        return service.createItem(newItem.getName(), newItem.getPrice());
    }

    //PUT /{id} - update existing
    @PutMapping("/{id}")
    MenuItem update(@PathVariable Long id, @Valid @RequestBody MenuItem updatedItem){
        return service.updateItem(id, updatedItem.getName(), updatedItem.getPrice());
    }

    //DELETE /{id} - delete
    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id){
        service.deleteItem(id);
    }
}
