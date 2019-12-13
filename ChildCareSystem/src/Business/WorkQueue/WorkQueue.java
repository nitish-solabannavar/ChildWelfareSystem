/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author vinod
 */
public class WorkQueue {
    
    private ArrayList<WorkRequest> workRequestList;

    public WorkQueue() {
        workRequestList = new ArrayList();
    }

    public ArrayList<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }
    
    private ArrayList<AgencyWorkRequest> AgencyworkRequestList;
    private ArrayList<IssueWorkRequest> issueWorkRequestList;
    private ArrayList<JobWorkRequest> jobWorkRequestList;
    private ArrayList<PostTaskWorkRequest> postTaskWorkRequestList;
    private ArrayList<FosterCareChildrenWorkRequest> fosterCareChildrenWorkRequesList;
    private ArrayList<EducationChildrenWorkRequest> educationChildrenWorkRequestList;

    public ArrayList<AgencyWorkRequest> getAgencyworkRequestList() {
        return AgencyworkRequestList;
    }

    public void setAgencyworkRequestList(ArrayList<AgencyWorkRequest> AgencyworkRequestList) {
        this.AgencyworkRequestList = AgencyworkRequestList;
    }

    public ArrayList<IssueWorkRequest> getIssueWorkRequestList() {
        return issueWorkRequestList;
    }

    public void setIssueWorkRequestList(ArrayList<IssueWorkRequest> issueWorkRequestList) {
        this.issueWorkRequestList = issueWorkRequestList;
    }

    public ArrayList<JobWorkRequest> getJobWorkRequestList() {
        return jobWorkRequestList;
    }

    public void setJobWorkRequestList(ArrayList<JobWorkRequest> jobWorkRequestList) {
        this.jobWorkRequestList = jobWorkRequestList;
    }

    public ArrayList<PostTaskWorkRequest> getPostTaskWorkRequestList() {
        return postTaskWorkRequestList;
    }

    public void setPostTaskWorkRequestList(ArrayList<PostTaskWorkRequest> postTaskWorkRequestList) {
        this.postTaskWorkRequestList = postTaskWorkRequestList;
    }   

    public ArrayList<FosterCareChildrenWorkRequest> getFosterCareChildrenWorkRequesList() {
        return fosterCareChildrenWorkRequesList;
    }

    public void setFosterCareChildrenWorkRequesList(ArrayList<FosterCareChildrenWorkRequest> fosterCareChildrenWorkRequesList) {
        this.fosterCareChildrenWorkRequesList = fosterCareChildrenWorkRequesList;
    }

    public ArrayList<EducationChildrenWorkRequest> getEducationChildrenWorkRequestList() {
        return educationChildrenWorkRequestList;
    }

    public void setEducationChildrenWorkRequestList(ArrayList<EducationChildrenWorkRequest> educationChildrenWorkRequestList) {
        this.educationChildrenWorkRequestList = educationChildrenWorkRequestList;
    }
   
}
