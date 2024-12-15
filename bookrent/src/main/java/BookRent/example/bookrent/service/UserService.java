package BookRent.example.bookrent.service;

import BookRent.example.bookrent.entity.Role;
import BookRent.example.bookrent.entity.User;
import BookRent.example.bookrent.entity.Wallet;
import BookRent.example.bookrent.repositories.RoleRepository;
import BookRent.example.bookrent.repositories.UserRepository;
import BookRent.example.bookrent.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private WalletRepository walletRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    List<User>listofuser=new ArrayList<>();
    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByName("USER").orElseThrow();
        user.getRoles().add(userRole);
        User savedUser = userRepository.save(user);
        Wallet wallet = new Wallet();
        wallet.setUser(savedUser);
        walletRepository.save(wallet);

        return savedUser;
    }

    public User registerAdmin(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role adminRole = roleRepository.findByName("ADMIN").orElseThrow();
        user.getRoles().add(adminRole);
        return userRepository.save(user);
    }


}

