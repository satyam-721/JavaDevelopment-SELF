package com.satyam.Jobapp;

import com.satyam.Jobapp.model.JobPost;
import com.satyam.Jobapp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//use @RestController to make all by default @response Body
@RestController
@CrossOrigin(origins = "https://localhost:3000")  //works like cors in node
public class JobController {

    @Autowired
    JobService service;

    //Here view Resolver excepts a String (view name)
    @GetMapping("jobPosts")
    //we can use this to say hey this is data
//    @ResponseBody    //for send data in json/xml format
    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
    }

    @GetMapping("jobPost/{jobId}")
    public JobPost getJob(@PathVariable("jobId") int jobId){    //add pathVariable to get the data from url
        return service.getJob(jobId);
    }

    @PostMapping("jobPost")                                       //same url,different request
    public void addJob(@RequestBody JobPost job){  //here the json format data will be converted to JobPost
        service.addJob(job);

    }


    @PutMapping("jobPost")
    public void updateJob(@RequestBody JobPost job){
        service.updateJob(job);
    }

    @DeleteMapping("jobPost/{jobId}")
    public String deleteJob(@PathVariable int jobId){
        service.deleteJob(jobId);
        return "Success";
    }

    @GetMapping("jobPost/keyword/{keyword}")
    public List<JobPost> searchJob(@PathVariable("keyword") String keyword){
        return service.search(keyword);
    }

    @PostMapping("load")
    public String loadJob(){
        service.load();
        return "sucess";
    }



}
