package com.productreviews.data;

import com.productreviews.entities.Role;
import lombok.Data;

import javax.validation.constraints.Email;
import java.util.Set;

@Data
public class UserData {
    @Email(message = "Please provide a valid email address")
    private String email;

    private String name;
    private String lastName;
    private String password;
    private Set<Role> roles;
}
