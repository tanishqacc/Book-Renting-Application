package BookRent.example.bookrent.controller;

import BookRent.example.bookrent.entity.Rental;
import BookRent.example.bookrent.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {
    @Autowired
    private RentalService rentalService;

    @PostMapping("/rent")
    public ResponseEntity<Rental> rentBook(@RequestParam Long userId, @RequestParam Long bookId, @RequestParam int days) {
        return ResponseEntity.ok(rentalService.rentBook(userId, bookId, days));
    }
}

