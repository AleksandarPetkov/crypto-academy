package com.app.cryptoacademy.web;

import com.app.cryptoacademy.domain.AppUser;
import com.app.cryptoacademy.domain.Role;
import com.app.cryptoacademy.dto.UserToRoleFormDTO;
import com.app.cryptoacademy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<AppUser> saveUser(@RequestBody AppUser user) {
        URI uri = getURI("/api/user/save");
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri = getURI("/api/role/save");
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser(@Valid @RequestBody UserToRoleFormDTO form) {
        userService.addRoleToUser(form.getUsername(), form.getRole());
        return ResponseEntity.ok().build();
    }



    private URI getURI(String path) {
        return URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path(path).toUriString());
    }
}
