package com.zemoso.greencommute.service;

import com.zemoso.greencommute.dao.JobsDAO;
import com.zemoso.greencommute.entity.Job;
import com.zemoso.greencommute.entity.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class JobsServiceImpl implements JobsService{
    @Autowired
    JobsDAO jobsDAO;
    @Override
    @Transactional
    public List<Job> getAllJobsByCityAndSkills(String cityName, List<String> skills) {
        List<Job> jobs= jobsDAO.findByCity(cityName);
        if(jobs.isEmpty()){
            throw new RuntimeException("No city is found with name:"+cityName);
        }
        List<Job> matchedJobs=new ArrayList<>();
      for(Job job:jobs){
          if(skills.containsAll(job.skillsByName())){
              matchedJobs.add(job);
          }
      }
      return  matchedJobs;
    }

    @Override
    @Transactional
    public Job getJobById(int id) {
         Optional<Job> job =jobsDAO.findById(id);
         Job tempJob=null;
         if(job.isPresent()){
            tempJob=job.get();
         }
         else{
             throw new RuntimeException("Job with id not found:"+id);
         }
         return tempJob;
    }

    @Override
    @Transactional
    public void saveJob(Job job) {
        jobsDAO.save(job);
    }

    @Override
    @Transactional
    public void deleteJob(int id) {
        jobsDAO.deleteById(id);

    }

    @Override
    public List<Job> getByCity(String cityName) {
        return jobsDAO.findByCity(cityName);
    }

    @Override
    public List<Job> getAllJobs() {
        return jobsDAO.findAll();
    }
}
