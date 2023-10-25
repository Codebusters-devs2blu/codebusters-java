package com.codebusters.codebusters.repositories;

import com.codebusters.codebusters.models.entities.ChildTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChildTaskRepository extends JpaRepository<ChildTask, Long> {

    Optional<ChildTask> findByID(Long id);
}
