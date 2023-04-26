package com.repaso.repaso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.repaso.repaso.entity.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, Long>{
    public UserEntity findByEmail(String email);

    public UserEntity findByUsername(String username);
}
