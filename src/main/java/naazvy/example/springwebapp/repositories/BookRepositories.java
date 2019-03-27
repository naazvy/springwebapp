package naazvy.example.springwebapp.repositories;

import naazvy.example.springwebapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepositories extends CrudRepository<Book, Long> {
}
