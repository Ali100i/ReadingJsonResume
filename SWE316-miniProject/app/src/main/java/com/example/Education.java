package com.example;

public class Education {
    private long ID;
    private Location Edu_Location;
    private String Organization;
    private String Education;
    private String Education_level;
    private String Raw_grade;
    private String Grade_metric;
    private String Grade_value;
    private String Completion_date;
    private boolean isCurrent;
    private String Start_date;

    public Education(Long ID, Location Edu_Location, String Organization, String Education, String Education_level, String Raw_grade, String Grade_metric, String Grade_value, String Completion_date, boolean isCurrent, String Start_date) {
        this.ID = ID;
        this.Edu_Location = Edu_Location;
        this.Organization = Organization;
        this.Education = Education;
        this.Education_level = Education_level;
        this.Raw_grade = Raw_grade;
        this.Grade_metric = Grade_metric;
        this.Grade_value = Grade_value;
        this.Completion_date = Completion_date;
        this.isCurrent = isCurrent;
        this.Start_date = Start_date;
    }

    public long getID() {
        return ID;
    }

    public Location getEdu_Location() {
        return Edu_Location;
    }

    public String getOrganization() {
        return Organization;
    }

    public String getEducation() {
        return Education;
    }

    public String getEducation_level() {
        return Education_level;
    }

    public String getRaw_grade() {
        return Raw_grade;
    }

    public String getGrade_metric() {
        return Grade_metric;
    }

    public String getGrade_value() {
        return Grade_value;
    }

    public String getCompletion_date() {
        return Completion_date;
    }

    public boolean isCurrent() {
        return isCurrent;
    }

    public String getStart_date() {
        return Start_date;
    }

    @Override
    public String toString() {
        return "Education:- \n" + "ID : " + getID() + "\nEdu_Location : " + getEdu_Location() + "\nOrganization : " + getOrganization() + "\nEducation : " + getEducation() + "\nEducation_level : " + getEducation_level() + "\nRaw_grade : " + getRaw_grade() + "\nGrade_metric : " + getGrade_metric() + "\nGrade_value : " + getGrade_value() + "\nCompletion_date : " + getCompletion_date() + "\nisCurrent : " + isCurrent() + "\nStart_date : " + getStart_date() +"\n";
    }
}
