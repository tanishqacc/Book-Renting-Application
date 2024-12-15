package BookRent.example.bookrent.service;

import BookRent.example.bookrent.entity.Book;
import BookRent.example.bookrent.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> searchBooks(String query) {
        return bookRepository.findByTitleContainingOrAuthorContaining(query, query);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}

