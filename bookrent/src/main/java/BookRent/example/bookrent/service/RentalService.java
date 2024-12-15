package BookRent.example.bookrent.service;

import BookRent.example.bookrent.entity.Book;
import BookRent.example.bookrent.entity.Rental;
import BookRent.example.bookrent.entity.User;
import BookRent.example.bookrent.entity.Wallet;
import BookRent.example.bookrent.repositories.BookRepository;
import BookRent.example.bookrent.repositories.RentalRepository;
import BookRent.example.bookrent.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class RentalService {
    @Autowired
    private RentalRepository rentalRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private WalletRepository walletRepository;


    public Rental rentBook(Long userId, Long bookId, int days) {


        Book book = bookRepository.findById(bookId).orElseThrow();
        if (!book.getAvailable()) {
            throw new RuntimeException("Book not available");
        }
        Wallet wallet = walletRepository.findByUserId(userId).orElseThrow();
        BigDecimal rentalCost = new BigDecimal(days * 10); // Example cost calculation
        if (wallet.getBalance().compareTo(rentalCost) < 0) {
            throw new RuntimeException("Insufficient balance");
        }
        wallet.setBalance(wallet.getBalance().subtract(rentalCost));
        walletRepository.save(wallet);

        book.setAvailable(false);
        bookRepository.save(book);

        Rental rental = new Rental();
        rental.setUser(new User(userId));
        rental.setBook(book);
        rental.setRentalStart(LocalDate.now());
        rental.setRentalEnd(LocalDate.now().plusDays(days));
        return rentalRepository.save(rental);
    }

//    public List<Rental> listAllRentals() {
//
//    }
}
