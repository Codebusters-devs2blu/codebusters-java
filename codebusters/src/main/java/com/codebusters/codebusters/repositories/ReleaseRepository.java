package com.codebusters.codebusters.repositories;

import com.codebusters.codebusters.models.entities.Release;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseRepository extends JpaRepository<Release, Long>  {

}
