package com.zemoso.greencommute.dao;

import com.zemoso.greencommute.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobsDAO extends JpaRepository<Job,Integer> {
}
