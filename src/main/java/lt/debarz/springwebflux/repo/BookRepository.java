package lt.debarz.springwebflux.repo;

import lt.debarz.springwebflux.model.Book;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * The BookRepository is defined with two generic parameters: Book, which is the type of document that
 * the repository manages, and String, which is the type of the primary key (the Book's id field)
 * */
public interface BookRepository extends ReactiveMongoRepository<Book, String> {
}
