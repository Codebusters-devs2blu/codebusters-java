package com.codebusters.codebusters.repositories;

import com.codebusters.codebusters.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByNickname(String nickname);
    @Query(value = "UPDATE users  SET is_active = false WHERE id = :id", nativeQuery = true)
    void updateInactive(@Param("id") Long id);


}
