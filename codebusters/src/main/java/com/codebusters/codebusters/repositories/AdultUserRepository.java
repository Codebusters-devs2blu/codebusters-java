package com.codebusters.codebusters.repositories;

import com.codebusters.codebusters.models.entities.AdultUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdultUserRepository extends JpaRepository<AdultUser, Long> {

    Optional<AdultUser> findByEmail(String email);
    Optional<AdultUser> findById(Long id);

}
