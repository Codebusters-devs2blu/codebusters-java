package com.codebusters.codebusters.repositories;

import com.codebusters.codebusters.models.entities.ChildUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChildUserRepository extends JpaRepository<ChildUser, Long> {

    Optional<ChildUser> findById(Long Id);

}
