package com.example.oauthMacbook.repository;

import com.example.oauthMacbook.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface MeinUserRepository extends CrudRepository<User, UUID> {

    User findByUsername(String username);
}
