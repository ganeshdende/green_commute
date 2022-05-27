package com.zemoso.greencommute.service;

import com.zemoso.greencommute.entity.Job;

import java.util.List;

public interface JobsService {
    List<Job> getAllJobs();
    Job getJobById();


}
