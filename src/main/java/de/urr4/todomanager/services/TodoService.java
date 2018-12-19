package de.urr4.todomanager.services;

import java.util.ArrayList;
import java.util.List;

import de.urr4.todomanager.repositories.neo4j.TodoRepository;
import de.urr4.todos.domain.Todo;
import de.urr4.todos.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos(){
        List<Todo> todos= new ArrayList<>();
        todoRepository.findAll().forEach(todo -> todos.add(todo));
        return todos;
    }

    public List<Todo> getTodosByCreator(User creator){
        return todoRepository.getAllByCreator(creator);
    }

    public Todo createTodo(Todo todo){
        return todoRepository.save(todo);
    }

}
