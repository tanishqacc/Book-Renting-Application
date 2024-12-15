package BookRent.example.bookrent.repositories;

import BookRent.example.bookrent.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContainingOrAuthorContaining(String title, String author);
}
