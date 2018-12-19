package com.productreviews.data;

import com.productreviews.entities.Role;
import lombok.Data;

import java.util.Set;

@Data
public class UserData {
    private String email;

    private String name;
    private String lastName;
    private String password;
    private Set<Role> roles;
}
