package com.epam.dbLayer;

import com.epam.Models.JobTitle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public interface dbJobTitleCrud extends CrudRepository<JobTitle,String> {
}
