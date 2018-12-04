package com.productreviews.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String email;

    private String name;
    private String lastName;
    private String password;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_email"), inverseJoinColumns = @JoinColumn
            (name = "id"))
    private Set<UserRoles> roles;
}
