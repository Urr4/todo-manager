package de.urr4.todomanager.endpoints;

import java.util.List;

import de.urr4.todomanager.services.TodoService;
import de.urr4.todomanager.services.UserService;
import de.urr4.todos.domain.Todo;
import de.urr4.todos.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/todos")
public class TodoEndpoint {

    @Autowired
    private TodoService todoService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Todo> getAllTodos(){
        return todoService.getAllTodos();
    }

    @RequestMapping(path = "/creator/{username}", method = RequestMethod.GET)
    public List<Todo> getAllTodosByCreatorName(@PathVariable("username") String username){
        User user = userService.getUserByName(username);
        return todoService.getTodosByCreator(user);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Todo createTodo(@RequestBody Todo todo){
        return todoService.createTodo(todo);
    }


}
