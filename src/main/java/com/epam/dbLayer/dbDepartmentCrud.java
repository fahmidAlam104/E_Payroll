package com.epam.dbLayer;

import com.epam.Models.Department;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;

public interface dbDepartmentCrud extends CrudRepository<Department,String> {
}
