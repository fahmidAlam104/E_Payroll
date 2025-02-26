package com.epam.dbLayer;

import com.epam.Models.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Optional;

@Repository
public interface dbEmployeeCrud extends CrudRepository<Employee,Long> {
}
