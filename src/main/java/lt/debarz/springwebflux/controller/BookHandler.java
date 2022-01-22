package lt.debarz.springwebflux.controller;

import lombok.AllArgsConstructor;
import lt.debarz.springwebflux.model.Book;
import lt.debarz.springwebflux.service.BookService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * Functional Spring WebFlux application will be based on two main components, a router and a handler.
 * The router is responsible for routing HTTP requests to handler functions. Handler functions are responsible
 * for executing business functionality and building responses.
 * */
/**
 * This is not a controller, but rather a standard Spring bean that will be wired into the BookRouter.
 * */
@AllArgsConstructor
@Component
public class BookHandler {
    private final BookService bookService;

    public Mono<ServerResponse> findById(ServerRequest request) {
        String id = request.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(bookService.findById(id), Book.class);
    }

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(bookService.findAll(), Book.class);
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        final Mono<Book> book = request.bodyToMono(Book.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(book.flatMap(bookService::save), Book.class));
    }
    public Mono<ServerResponse> delete(ServerRequest request) {
        String id = request.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(bookService.deleteById(id), Void.class);
    }
}
