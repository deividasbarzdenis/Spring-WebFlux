package lt.debarz.springwebflux.service;

import lombok.AllArgsConstructor;
import lt.debarz.springwebflux.model.Book;
import lt.debarz.springwebflux.repo.BookRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Services represent business functionality and are identified in Spring using the @Service annotation.
 * In this example, business functionality simply delegates to the underlying repository
 * */
@AllArgsConstructor
@Service
public class BookService {
    private BookRepository bookRepository;

    public Mono<Book> findById(String id){
        return bookRepository.findById(id);
    }

    public Flux<Book> findAll() {
        return bookRepository.findAll();
    }

    public Mono<Book> save(Book book) {
        return bookRepository.save(book);
    }

    public Mono<Void> deleteById(String id) {
        return bookRepository.deleteById(id);
    }

}
