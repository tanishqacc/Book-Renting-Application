package BookRent.example.bookrent.controller;

import BookRent.example.bookrent.entity.Book;
import BookRent.example.bookrent.entity.Rental;
import BookRent.example.bookrent.entity.User;
import BookRent.example.bookrent.service.BookService;
import BookRent.example.bookrent.service.RentalService;
import BookRent.example.bookrent.service.UserService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;
    @Autowired
    private RentalService rentalService;

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.addBook(book));
    }

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
        return ResponseEntity.noContent().build();
    }

//    @GetMapping("/users")
//    public ResponseEntity<List<User>> listUsers() {
//        return ResponseEntity.ok(userService.listAllUsers());
//    }

//    @GetMapping("/rentals")
//    public ResponseEntity<List<Rental>> listRentals() {
//        return ResponseEntity.ok(rentalService.listAllRentals());
//    }
}

