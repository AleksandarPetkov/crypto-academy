package com.app.cryptoacademy.service;

import com.app.cryptoacademy.domain.AppUser;
import com.app.cryptoacademy.domain.Role;
import com.app.cryptoacademy.excetion.EmptyInputException;
import com.app.cryptoacademy.excetion.NonExistingEntityException;
import com.app.cryptoacademy.repo.RoleRepository;
import com.app.cryptoacademy.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    @Override
    public AppUser saveUser(AppUser user) {
        if (user == null){
            throw new EmptyInputException();
        }
        this.userRepository.save(user);
        return user;
    }

    @Override
    public Role saveRole(Role role) {
        if (role == null){
            throw new EmptyInputException();
        }
        this.roleRepository.save(role);
        return role;
    }

    @Override
    public void addRoleToUser(String username, String name) {
        AppUser user = this.userRepository.findUserByUsername(username);
        Role role = this.roleRepository.findRoleByName(name);

        user.getRoles().add(role);
        this.userRepository.save(user);
    }

    @Override
    public AppUser getUserByUsername(String username) {
        return this.userRepository.findUserByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {
        return this.userRepository.findAll();
    }
}
