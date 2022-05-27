package com.zemoso.greencommute.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String title;
    String company;
    String locality;
    String city;
    int pincode;
    short bike,bus,car,train;
    LocalDateTime createdTime;
    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name="job_skills",
            joinColumns=@JoinColumn(name="id"),
            inverseJoinColumns = @JoinColumn(name="name"))
    List<Skill> skillsList;


}
