package com.example;

public class Occupation {
    private String Job_title;
    private String Job_title_normalized;
    private long Managment_level;
    private Classification job_class;

    public Occupation(String Job_title, String Job_title_normalized, long Managment_level, Classification job_class) {
        this.Job_title = Job_title;
        this.Job_title_normalized = Job_title_normalized;
        this.Managment_level = Managment_level;
        this.job_class = job_class;
    }

    public String getJob_title() {
        return Job_title;
    }

    public String getJob_title_normalized() {
        return Job_title_normalized;
    }

    public long getManagment_level() {
        return Managment_level;
    }

    public Classification getJob_class() {
        return job_class;
    }

    @Override
    public String toString() {
        return "Occupation:- \n" + "Job_title : " + getJob_title() + "\nJob_title_normalized : " + getJob_title_normalized() + "\nManagment_level : " + getManagment_level() + "\njob_class : " + getClass();
    }
}
