package com.epam.RepositoryLayer;

import com.epam.Models.Department;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    @Modifying(flushAutomatically = true,clearAutomatically = true)            // as by default JPA expect a Select query with @Query
    @Transactional      // since we are trying to update DB
    @Query("UPDATE Department d SET d.employeeCount = d.employeeCount + 1 WHERE d.id = :key")
    public void incrementEmployeeCount(@Param("key") Long key);
}
