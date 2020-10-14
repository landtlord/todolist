package be.hogent.todolist.service;

import be.hogent.todolist.business.TodoListRepo;
import be.hogent.todolist.business.TodolistEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TodolistService {
    @Autowired
    private TodolistMapper mapper;

    @Autowired
    private TodoListRepo repo;

    public Todolist save(Todolist todolist){
        TodolistEntity entityToSave = mapper.toEntity(todolist);
        TodolistEntity savedEntity = repo.save(entityToSave);
        return mapper.toDTO(savedEntity);
    }

    public List<Todolist> getAll(){
        return mapper.toDTO(repo.findAll());
    }

    public List<Todolist> getAllForPerson(Long personId) {
        return mapper.toDTO(repo.findAllByPersonId(personId));
    }
}
