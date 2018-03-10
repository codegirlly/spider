package com.spider.service.impl;

import com.spider.entity.JobEntity;
import com.spider.repository.JobRepository;
import com.spider.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImplement implements JobService{

    @Autowired
    private JobRepository jobRepository;

    @Override
    public void save(JobEntity jobEntity) {
        jobRepository.save(jobEntity);
    }
}
