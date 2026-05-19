package com.satyam.Jobapp.service;

import com.satyam.Jobapp.Repo.JobRepo;
import com.satyam.Jobapp.model.JobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {

    List<JobPost> list=new ArrayList<>(Arrays.asList(
            new JobPost(12,"cse"),
            new JobPost(13,"ece"),
            new JobPost(14,"aiml")
    ));


    @Autowired
    JobRepo repo;

    public void addJob(JobPost jp){
        repo.save(jp);
    }


    public List<JobPost> getAllJobs(){

        //bypasses proxy
        display();
        return repo.findAll();
    }

    public JobPost getJob(int postId) {

        int a=10/postId;
        return repo.findById(postId).orElse(new JobPost());
    }

    public void updateJob(JobPost job) {
        repo.save(job);
    }

    public void deleteJob(int jobId) {
        repo.deleteById(jobId);

    }

    public void load() {
        repo.saveAll(list);
    }

    public List<JobPost> search(String keyword) {
        return repo.findBySkillreqContainingOrJobidContaining(keyword,keyword);

    }


    public void display(){
        System.out.println("Displaying all Jobs");
    }
}
