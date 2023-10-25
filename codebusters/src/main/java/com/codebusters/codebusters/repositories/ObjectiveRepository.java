package com.codebusters.codebusters.repositories;

import com.codebusters.codebusters.models.entities.ChildTask;
import com.codebusters.codebusters.models.entities.Objective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ObjectiveRepository extends JpaRepository<Objective, Long> {



}
