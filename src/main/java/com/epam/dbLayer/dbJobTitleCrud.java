package com.epam.dbLayer;

import com.epam.Models.JobTitle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;

public interface dbJobTitleCrud extends CrudRepository<JobTitle,String> {
}
