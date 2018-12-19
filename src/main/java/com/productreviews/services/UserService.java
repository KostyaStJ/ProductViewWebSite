package com.productreviews.services;

import com.productreviews.converters.UserConverter;
import com.productreviews.data.UserData;
import com.productreviews.entities.Role;
import com.productreviews.entities.User;
import com.productreviews.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserConverter userConverter;

    public void addUser(UserData userData) {
        User user = new User();

        Set<Role> userRoles = new HashSet<>();
        userRoles.add(Role.USER);
        userData.setRoles(userRoles);

        String encodedPassword = passwordEncoder.encode(userData.getPassword());
        userConverter.dataToModel(userData, user);
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    public UserData getUserById(String email) {
        Optional<User> userOptional = userRepository.findById(email);
        if (userOptional.isPresent()) {
            User requiredUser = userOptional.get();
            UserData userData = new UserData();
            userConverter.modelToData(userData, requiredUser);
            return userData;
        } else {
            return null;
        }

    }

    public List<User> getUsers() {
        Iterable<User> userIterable = userRepository.findAll();
        List<User> userList = new ArrayList<>();
        userIterable.forEach(userList::add);
        return userList;
    }
}
