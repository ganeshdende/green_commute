package com.zemoso.greencommute.service;

import com.zemoso.greencommute.dao.JobsDAO;
import com.zemoso.greencommute.entity.Job;
import com.zemoso.greencommute.exception.CityNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;



@RunWith(MockitoJUnitRunner.class)
public class JobsServiceImplTest {
    @Mock
    JobsDAO jobsDAO;
    @InjectMocks
    JobsServiceImpl jobsServiceImpl;

    @Test
    public void getAllJobs(){
        when(jobsDAO.findAll()).thenReturn(Arrays.asList(new Job(),new Job()));
        assertThat(jobsDAO.findAll().size(),is(2));
    }
    @Test
    public void getByCity(){
        when(jobsDAO.findByCity("hyderabad")).thenReturn(Arrays.asList(new Job()));
        assertThat(jobsDAO.findByCity("hyderabad").size(),is(1));
    }
    @Test
    public void deleteJob(){
        jobsServiceImpl.deleteJob(0);
        verify(jobsDAO,times(1)).deleteById(0);
    }
    @Test
    public  void saveJob(){
        Job job1=new Job();
        jobsServiceImpl.saveJob(job1);
        verify(jobsDAO,times(1)).save(job1);
    }

    @Test
    public void getJobById_withNoException(){
        Job newJob=new Job(1,"dotnetdeveloper","zemoso","raidurg","hyderabad",500090,(short) 1,(short) 0,(short) 1,(short) 0,LocalDateTime.now());
        when(jobsDAO.findById(1)).thenReturn(Optional.of(newJob));
        assertEquals(newJob,jobsDAO.findById(1).get());
    }
    @Test(expected = RuntimeException.class)
    public void getJobById_withException(){

        when(jobsDAO.findById(1)).thenReturn(null);
        if(jobsDAO.findById(1)==null){
            throw new RuntimeException("Job with id not found");
        }
    }

    @Test(expected= CityNotFoundException.class)
    public void getAllJobsByCityAndSkills_jobsListEmpty() {
        when(jobsDAO.findByCity("mumbai")).thenReturn(Arrays.asList());
        if (jobsDAO.findByCity("mumbai").isEmpty()) {
            throw new CityNotFoundException("No jobs are found in current city");
        }
    }
}

