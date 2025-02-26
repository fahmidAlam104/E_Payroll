package com.epam.RepositoryLayer;

import com.epam.Models.Department;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department,String> {

    @Modifying
    @Transactional
    @Query("UPDATE Department d SET d.employeeCount = d.employeeCount + 1 WHERE d.departmentName = :key")
    public void incrementEmployeeCount(@Param("key") String key);
}
