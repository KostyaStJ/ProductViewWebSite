package com.productreviews.services;

import com.productreviews.entities.User;
import com.productreviews.entities.UserRoles;
import com.productreviews.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void addUser(User user) {

        Set<UserRoles> userRoles = new HashSet<>();

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        User userEntity = new User(user.getEmail(), user.getName(), user.getLastName(), encodedPassword, userRoles);
        userRepository.save(userEntity);
    }

    public User getUserById(String email) {
        Optional<User> userOptional = userRepository.findById(email);
        if (userOptional.isPresent()) {
            User requiredUser = userOptional.get();
            return requiredUser;
        } else {
            return null;
        }

    }
}
