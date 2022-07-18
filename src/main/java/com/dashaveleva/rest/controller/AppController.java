package com.dashaveleva.rest.controller;

import com.dashaveleva.rest.entity.Dog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AppController {

    public static Map<Integer, Dog> allDogs = new HashMap();

    @PostMapping("/dogs/{id}")
    public void createDog(@PathVariable int id, @RequestBody Dog dog) {
        allDogs.put(id, dog);
    }

    @GetMapping("/dogs/{id}")
    public Dog showADog(@PathVariable int id) {
        Dog dog = allDogs.get(id);
        return dog;
    }

    @PutMapping("/dogs/{id}")
    public void updateDog(@PathVariable int id, @RequestBody Dog dog) {
        allDogs.put(id, dog);
    }

    @DeleteMapping("/dogs/{id}")
    public void deleteDog(@PathVariable int id) {
        allDogs.remove(id);
    }


}
