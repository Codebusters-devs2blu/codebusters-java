package com.codebusters.codebusters.repositories;

import com.codebusters.codebusters.models.entities.ChildTask;
import com.codebusters.codebusters.models.entities.ChildUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChildTaskRepository extends JpaRepository<ChildTask, Long> {

//    Optional<ChildTask> findByID(Long id);
	
	 @Query(value = "DELETE FROM codebusters.child_task\r\n"
	 		+ "WHERE child_user_id = :adultUser ", nativeQuery = true)
    void deleteAdultUser(@Param("adultUser") Long guardianId);
}
