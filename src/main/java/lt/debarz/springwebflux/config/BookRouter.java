package lt.debarz.springwebflux.config;

import lt.debarz.springwebflux.controller.BookHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
/**
 * the route() method creates a bean of type RouterFunction<ServerResponse>. Router functions are responsible
 * for translating HTTP routes (HTTP verb and URI path) into handler functions. For example, the first route reads:
 * if there is a request of type GET for the URI path /fbooks and a media accept type of APPLICATION_JSON, then
 * invoke the BookHandler’s findAll() method.
 * */
@Configuration
public class BookRouter {
    @Bean
    public RouterFunction<ServerResponse> route(BookHandler handler) {
        return RouterFunctions
                .route(GET("/fbooks").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
                .andRoute(GET("/fbook/{id}").and(accept(MediaType.APPLICATION_STREAM_JSON)), handler::findById)
                .andRoute(POST("/fbook").and(accept(MediaType.APPLICATION_JSON)), handler::save)
                .andRoute(DELETE("/fbook/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::delete);
    }
}
