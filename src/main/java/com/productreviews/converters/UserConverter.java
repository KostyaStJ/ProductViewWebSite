package com.productreviews.converters;

import com.productreviews.data.UserData;
import com.productreviews.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public void dataToModel(UserData userData, User user) {
        user.setName(userData.getName());
        user.setLastName(userData.getLastName());
        user.setEmail(userData.getEmail());
        user.setRoles(userData.getRoles());
        user.setPassword(userData.getPassword());
    }

    public void modelToData(UserData userData, User user) {
        userData.setId(user.getId());
        userData.setName(user.getName());
        userData.setLastName(user.getLastName());
        userData.setEmail(user.getEmail());
        userData.setPassword(user.getPassword());
        userData.setRoles(user.getRoles());
    }
}
