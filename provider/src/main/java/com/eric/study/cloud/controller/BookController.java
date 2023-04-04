package com.eric.study.cloud.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/book")
public class BookController {
    Set<String> books = new HashSet<>();
    @GetMapping("/{name}")
    public ResponseEntity queryBookByName(@PathVariable("name") String name) {
        if(books.contains(name))
            return ResponseEntity.ok("ok. the book " + name + " is here");
        else
            return ResponseEntity.ok("sorry, the " + name + " not exist in lib");
    }

    @PostMapping
    public ResponseEntity addBook(@RequestBody String name) {
        books.add(name);
        return ResponseEntity.ok("ok. the book " + name + " have add to lib");
    }

    @DeleteMapping
    public ResponseEntity deleteBook(String name) {
        books.remove(name);
        return ResponseEntity.ok("ok. the book " + name + " have remove from lib");
    }
    @GetMapping("/list")
    public ResponseEntity bookList() {
        return ResponseEntity.ok(books);
    }

}
