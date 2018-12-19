package de.urr4.todomanager.services;

import de.urr4.todomanager.exceptions.TodoManagerException;
import de.urr4.todomanager.exceptions.TodoManagerExceptionType;
import de.urr4.todomanager.repositories.neo4j.UserRepository;
import de.urr4.todos.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id){
        User user = userRepository.getUserById(id);
        if(user == null){
            throw new TodoManagerException(TodoManagerExceptionType.NOT_FOUND);
        }
        return user;
    }

    public User getUserByName(String name){
        User user = userRepository.getUserByName(name);
        if(user == null){
            throw new TodoManagerException(TodoManagerExceptionType.NOT_FOUND);
        }
        return user;
    }
}
