package com.productreviews.services;

import com.productreviews.converters.UserConverter;
import com.productreviews.data.UserData;
import com.productreviews.entities.Role;
import com.productreviews.entities.User;
import com.productreviews.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public UserData getUserById(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
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

    public void editUser(Integer id, UserData userData){

        User user = userRepository.findById(id).get();

        user.setName(userData.getName());

        if(!userData.getLastName().equals("")) {
            user.setLastName(userData.getLastName());
        }
        if(!userData.getEmail().equals("")) {
            user.setEmail(user.getEmail());
        }
        if (userData.getPassword()!=null && !userData.getPassword().isEmpty()){
            user.setPassword(passwordEncoder.encode(userData.getPassword()));
        }

        userRepository.save(user);

    }

    public void checkPasswordValidityForEditedUser(String password, BindingResult bindingResult){

        Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*[0-9]).{6,30}$");
        Matcher matcher = pattern.matcher(password);

        if (!matcher.matches()) {
            bindingResult.rejectValue("password", "userNew.password", "Password must contain at least one uppercase letter, " +
                    "at least one digit and be from 6 to 30 characters length");
        }

    }

}
