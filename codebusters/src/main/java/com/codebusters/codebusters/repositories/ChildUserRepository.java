package com.codebusters.codebusters.repositories;

import com.codebusters.codebusters.models.entities.ChildUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChildUserRepository extends JpaRepository<ChildUser, Long> {

    Optional<ChildUser> findById(Long id);
    @Query(value = "DELETE FROM codebusters.child_user\r\n"
    		+ "WHERE  guardian_id = :guardianId", nativeQuery = true)
    	void deleteGuardian(@Param("guardianId") Long guardianId);
    
    
    @Query(value = "SELECT family, birthday, guardian_id, id, user_id, wallet_id FROM codebusters.child_user WHERE guardian_id = :id", nativeQuery = true)
    List<ChildUser> findByGardian(@Param("id") Long guardianId);


}
