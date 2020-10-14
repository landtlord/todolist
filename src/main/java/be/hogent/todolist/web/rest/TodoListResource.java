package be.hogent.todolist.web.rest;

import be.hogent.todolist.service.Todolist;
import be.hogent.todolist.service.TodolistService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class TodoListResource {
    @Autowired
    private TodolistService service;

    @GetMapping("/todolist")
    public ResponseEntity<List<Todolist>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("todolist")
    public ResponseEntity<Todolist> save(@RequestBody Todolist todolist){
        return ResponseEntity.ok(service.save(todolist));
    }

    @GetMapping("/todolist/persons/{personId}")
    public ResponseEntity<List<Todolist>> getAllForPerson(@PathVariable Long personId){
        return ResponseEntity.ok(service.getAllForPerson(personId));
    }
}
