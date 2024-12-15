package BookRent.example.bookrent.controller;

import BookRent.example.bookrent.entity.User;
import BookRent.example.bookrent.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        try {
            // Convert the user object to a JSON string (optional)
            String userJson = objectMapper.writeValueAsString(user);
            System.out.println("User JSON: " + userJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @PostMapping("/registerAdmin")
    public ResponseEntity<User> registerAdmin(@RequestBody User user) {
        try {
            // Convert the user object to a JSON string (optional)
            String userJson = objectMapper.writeValueAsString(user);
            System.out.println("Admin JSON: " + userJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(userService.registerAdmin(user));
    }
}
