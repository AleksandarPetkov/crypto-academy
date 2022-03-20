package com.app.cryptoacademy.repo;

import com.app.cryptoacademy.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long>  {
    AppUser findUserByUsername(String username);
}
