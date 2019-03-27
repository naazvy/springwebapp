package naazvy.example.springwebapp.repositories;

import naazvy.example.springwebapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepositories extends CrudRepository<Author, Long> {
}
