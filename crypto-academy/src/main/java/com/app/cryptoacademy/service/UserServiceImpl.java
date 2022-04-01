package com.app.cryptoacademy.service;

import com.app.cryptoacademy.domain.AppUser;
import com.app.cryptoacademy.domain.Role;
import com.app.cryptoacademy.excetion.EmptyInputException;
import com.app.cryptoacademy.excetion.NonExistingEntityException;
import com.app.cryptoacademy.repo.RoleRepository;
import com.app.cryptoacademy.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = this.userRepository.findUserByUsername(username);
        if (user == null) {
            throw new NonExistingEntityException();
        }

        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(r -> authorities.add(new SimpleGrantedAuthority(r.getName())));

        return new org.springframework.security.core.userdetails
                .User(user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public AppUser saveUser(AppUser user) {
        if (user == null) {
            throw new EmptyInputException();
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.userRepository.save(user);
        return user;
    }

    @Override
    public Role saveRole(Role role) {
        if (role == null) {
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
