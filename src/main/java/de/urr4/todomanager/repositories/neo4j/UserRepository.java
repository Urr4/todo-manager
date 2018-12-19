package de.urr4.todomanager.repositories.neo4j;

import de.urr4.todos.domain.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface UserRepository extends Neo4jRepository<User, Long> {

    User getUserByName(String name);

    User getUserById(Long id);

}
