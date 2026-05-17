package com.satyam.Jobapp.Repo;

import com.satyam.Jobapp.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer> {

    List<JobPost> findBySkillreqContainingOrJobidContaining(String SkillReq,String JobId);

}

//List<JobPost> list=new ArrayList<>(Arrays.asList(
//        new JobPost(12,"cse"),
//        new JobPost(13,"ece"),
//        new JobPost(14,"aiml")
//));
//
//public void add(JobPost jp) {
//    list.add(jp);
//}
//
//public List<JobPost> getAllJobs() {
//    return list;
//}
//
//
//public JobPost getJob(int i) {
//    for (JobPost job : list){
//        if(job.getJobid()==i){
//            return job;
//        }
//    }
//    return null;
//
//}
//
//public void updateJob(JobPost job) {
//    for (JobPost job1 : list){
//        if(job1.getJobid()==job.getJobid()){
//            job1.setSkillreq(job.getSkillreq());
//        }
//    }
//}
//
//public void deleteJob(int jobId) {
//    for(JobPost job1: list){
//        if(job1.getJobid()==jobId){
//            list.remove(job1);
//        }
//    }
//}