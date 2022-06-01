package com.zemoso.greencommute.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Entity
@Table(name = "jobs")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    @Column(name="created_time")
    LocalDateTime createdTime;
    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.EAGER)
    @JoinTable(name="job_skills",
            joinColumns=@JoinColumn(name="id"),
            inverseJoinColumns = @JoinColumn(name="skill_id"))
    List<Skill> skillsList;

    public Job(int id, String title, String company, String locality, String city, int pincode, short bike, short bus, short car, short train, LocalDateTime createdTime) {
        this.id = id;
        this.title = title;
        this.company = company;
        this.locality = locality;
        this.city = city;
        this.pincode = pincode;
        this.bike = bike;
        this.bus = bus;
        this.car = car;
        this.train = train;
        this.createdTime = createdTime;
    }


    public  void addSkill(Skill skill){
        if(skillsList==null){
            skillsList=new ArrayList<>();
        }
        skillsList.add(skill);

    }
    public void removeSkill(Skill skill){
        skillsList.remove(skill);
    }
    public List<String> skillsByName(){
        return skillsList.stream().map(s->s.getName()).collect(Collectors.toList());
    }


}
