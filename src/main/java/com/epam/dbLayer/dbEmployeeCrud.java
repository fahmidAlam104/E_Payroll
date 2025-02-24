package com.epam.dbLayer;

import com.epam.Models.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;

public interface dbEmployeeCrud extends CrudRepository<Employee,Long> {
}
