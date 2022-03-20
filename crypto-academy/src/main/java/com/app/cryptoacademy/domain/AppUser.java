package com.app.cryptoacademy.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "users")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column()
    @Size(min = 2, max = 15, message = "First Name must be between 3 AND 15 characters")
    @NotNull(message = "First name is compulsory")
    private String firstName;

    @Column()
    @Size(min = 2, max = 15, message = "Last Name must be between 3 AND 15 characters")
    @NotNull(message = "Last name is compulsory")
    private String lastName;

    @Column(unique = true)
    @NotNull(message = "Email is compulsory")
    @Pattern(regexp = "^[^@]+@[^@]+\\.[^@]+$", message = "Not a valid Email")
    private String email;

    @Column(unique = true)
    @Size(min = 2, max = 15, message = "Username must be between 3 AND 15 characters")
    @NotNull(message = "Username name is compulsory")
    private String username;

    @Column()
    @NotNull(message = "Password is compulsory")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER) //First load all roles
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public AppUser() {
        this.roles = new HashSet<>();
    }

        public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}