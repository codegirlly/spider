package com.spider.repository;

import com.spider.JobHtmlForm;
import com.spider.entity.JobEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobMongoRepository  extends MongoRepository<JobHtmlForm,String> {
}
