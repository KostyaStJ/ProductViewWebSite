package com.productreviews.data;

import com.productreviews.entities.Role;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Set;

@Data
public class UserData {

    private Integer id;


    @Email(message = "Please provide a valid email address")
    @Size(min = 5, message = "Please provide a valid email address")
    private String email;


    @Size(min = 2, max = 50, message = "Wrong user's name size. It must be from 1 to 50 characters")
    private String name;

    private String lastName;

    @NotNull
    @NotBlank (message = "Please enter a valid password")
    private String password;

    private Set<Role> roles;
}
