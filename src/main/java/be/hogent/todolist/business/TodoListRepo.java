package be.hogent.todolist.business;

import org.springframework.data.repository.CrudRepository;

public interface TodoListRepo extends CrudRepository<TodolistEntity, Long> {
    Iterable<TodolistEntity> findAllByPersonId(Long personId);
}
