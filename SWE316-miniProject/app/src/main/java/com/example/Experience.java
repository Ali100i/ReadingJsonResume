package com.example;

public class Experience {
    private long ID;
    private String Organization;
    private String Industry;
    private Location work_location;
    private Occupation occupation;
    private String Start_date;
    private String End_date;
    private long Months_in_position;
    private boolean isCurrent;
    private String JobDescription;

    public Experience(long ID,String Organization, String Industry, Location work_location,String JobDescription, Occupation occupation, String Start_date, String End_date, long Months_in_position, boolean isCurrent) {
        this.ID = ID;
        this.Organization = Organization;
        this.Industry = Industry;
        this.work_location = work_location;
        this.occupation = occupation;
        this.Start_date = Start_date;
        this.End_date = End_date;
        this.Months_in_position = Months_in_position;
        this.isCurrent = isCurrent;
        this.JobDescription = JobDescription;
    }

    public long getID() {
        return ID;
    }

    public String getOrganization() {
        return Organization;
    }

    public String getIndustry() {
        return Industry;
    }

    public Location getWork_location() {
        return work_location;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public String getStart_date() {
        return Start_date;
    }

    public String getEnd_date() {
        return End_date;
    }

    public long getMonths_in_position() {
        return Months_in_position;
    }

    public boolean isIsCurrent() {
        return isCurrent;
    }

    public String getJobDescription() {
        return JobDescription;
    }
 

    @Override
    public String toString() {
        return "Experience:- \n" + "ID : " + getID() +"\nOrganization : " + getOrganization() + "\nIndustry : " + getIndustry() + "\nwork_location : " + getWork_location() + "\nJob description :"+ getJobDescription() +"\noccupation : " + getOccupation() + "\nStart_date : " + getStart_date() + "\nEnd_date : " + getEnd_date() + "\nMonths_in_position : " + getMonths_in_position() + "\nisCurrent : " + isIsCurrent() + "\n";
    }
}
