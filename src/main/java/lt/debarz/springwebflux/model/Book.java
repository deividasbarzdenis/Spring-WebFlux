package lt.debarz.springwebflux.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The Book class is a simple POJO that contains an ID, title, and author. It is annotated with the @Document
 * annotation, which identifies it as a MongoDB document. Spring Data will map documents to collections in MongoDB.
 * The next three annotations-- @Data, @NoArgsConstructor, and @AllArgsConstructor--are Lombok annotations.
 *
 * */
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private String id;
    private String title;
    private String author;

}
