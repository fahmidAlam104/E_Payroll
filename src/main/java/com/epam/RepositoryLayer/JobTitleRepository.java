package com.epam.RepositoryLayer;

import com.epam.Models.JobTitle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobTitleRepository extends CrudRepository<JobTitle,String> {
}
