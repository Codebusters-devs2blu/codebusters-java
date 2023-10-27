package com.codebusters.codebusters.repositories;

import com.codebusters.codebusters.models.entities.ChildTask;
import com.codebusters.codebusters.models.entities.Objective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ObjectiveRepository extends JpaRepository<Objective, Long> {

	@Query(value = "DELETE FROM codebusters.objective\r\n"
			+ "WHERE child_user_id = :childUser", nativeQuery = true)
	void deleteChildUser(@Param("childUser") Long childUser);


}
