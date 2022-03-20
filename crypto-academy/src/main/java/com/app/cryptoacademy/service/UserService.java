package com.app.cryptoacademy.service;

import com.app.cryptoacademy.domain.AppUser;
import com.app.cryptoacademy.domain.Role;

import java.util.List;

public interface UserService {
    AppUser saveUser (AppUser user);
    Role saveRole (Role role);
    void addRoleToUser(String username, String name);
    AppUser getUserByUsername(String username);
    //TODO Implement getUser to return only part of the users
    List<AppUser> getUsers();
}
