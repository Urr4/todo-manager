package de.urr4.todomanager.repositories.neo4j;

import java.util.List;

import de.urr4.todos.domain.Todo;
import de.urr4.todos.domain.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface TodoRepository extends Neo4jRepository<Todo, Long> {

    List<Todo> getAllByCreator(User creator);

}
