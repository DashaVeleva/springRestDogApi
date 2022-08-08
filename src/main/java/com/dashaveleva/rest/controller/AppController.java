package com.dashaveleva.rest.controller;

import com.dashaveleva.rest.entity.Dog;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/api/dogs")
public class AppController {

    public static Map<Integer, Dog> allDogs = new ConcurrentHashMap<>();
    private static AtomicInteger idGenerator = new AtomicInteger();

    @PostMapping
    public Dog createDog(@RequestBody Dog dog) {
        int id = idGenerator.incrementAndGet();
        dog.setId(id);
        allDogs.put(id, dog);
        return dog;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDog(@PathVariable int id) {
        Dog dog = allDogs.get(id);
        if(dog == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(dog);
    }

    @GetMapping
    public ResponseEntity<?> getAllDogs() {

        if(allDogs.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(allDogs);
    }

    @PutMapping("/{id}")
    public Dog updateDog(@PathVariable int id, @RequestBody Dog dog) {
        allDogs.put(id, dog);
        return dog;
    }

    @DeleteMapping("/{id}")
    public Dog deleteDog(@PathVariable int id, @RequestBody Dog dog) {
        allDogs.remove(id);
        return dog;
    }


}
