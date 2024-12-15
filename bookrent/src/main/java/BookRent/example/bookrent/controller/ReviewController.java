package BookRent.example.bookrent.controller;

import BookRent.example.bookrent.entity.Review;
import BookRent.example.bookrent.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping("/add")
    public ResponseEntity<Review> addReview(@RequestParam Long userId, @RequestParam Long bookId, @RequestParam int rating, @RequestParam String reviewText) {
        return ResponseEntity.ok(reviewService.addReview(userId, bookId, rating, reviewText));
    }
}
