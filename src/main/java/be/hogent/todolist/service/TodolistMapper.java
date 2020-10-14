package be.hogent.todolist.service;

import be.hogent.todolist.business.TodolistEntity;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Mapper(componentModel = "spring")
public interface TodolistMapper {
    Todolist toDTO(TodolistEntity todolistEntity);

    TodolistEntity toEntity(Todolist todolist);

    default List<Todolist> toDTO(Iterable<TodolistEntity> todolists){
        return StreamSupport.stream(todolists.spliterator(), false)
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
