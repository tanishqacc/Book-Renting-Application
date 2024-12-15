package BookRent.example.bookrent.service;

import BookRent.example.bookrent.entity.Book;
import BookRent.example.bookrent.entity.Review;
import BookRent.example.bookrent.entity.User;
import BookRent.example.bookrent.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public Review addReview(Long userId, Long bookId, int rating, String reviewText) {
        Review review = new Review();
        review.setUser(new User(userId));
        review.setBook(new Book(bookId));
        review.setRating(rating);
        review.setReviewText(reviewText);
        return reviewRepository.save(review);
    }
}
