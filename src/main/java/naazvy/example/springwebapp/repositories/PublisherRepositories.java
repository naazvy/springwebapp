package naazvy.example.springwebapp.repositories;

import naazvy.example.springwebapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepositories extends CrudRepository<Publisher, Long> {
}
