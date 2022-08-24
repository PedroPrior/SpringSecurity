package com.pedroprior.springsecurity.repository;

import com.pedroprior.springsecurity.entities.AdminModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AdminRepository extends JpaRepository<AdminModel, UUID> {

    Optional<AdminModel> findByUsername(String username);
}
