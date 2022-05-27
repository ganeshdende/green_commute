package com.zemoso.greencommute.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Skill {
    @Id
    String name;
    @ManyToMany(mappedBy = "skillsList")
    List<Job> jobList;
}
