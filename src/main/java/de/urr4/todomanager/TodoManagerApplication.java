package de.urr4.todomanager;

import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.web.bind.annotation.RequestMapping;


@SpringBootApplication
@EnableNeo4jRepositories(basePackages = "de.urr4.todomanager.repositories.neo4j")
@RequestMapping(path = "/todo-manager")
public class TodoManagerApplication {

	@Bean
	public SessionFactory sessionFactory() {
		return new SessionFactory(configuration(), "de.urr4.wine.entities");
	}


	@Bean
	public Neo4jTransactionManager transactionManager() {
		return new Neo4jTransactionManager(sessionFactory());
	}


	@Bean
	public Configuration configuration() {
		return new Configuration.Builder()
				.uri("bolt://localhost")
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(TodoManagerApplication.class, args);
	}

}
