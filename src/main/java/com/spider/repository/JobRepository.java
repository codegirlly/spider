package com.spider.repository;

import com.spider.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<JobEntity,Long> {

}
