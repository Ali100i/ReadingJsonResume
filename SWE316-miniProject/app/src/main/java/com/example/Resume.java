package com.example;

import java.util.List;

public class Resume {
    private Personal_info personal;
    private String Profession;
    private List<String> Languages;
    private List<String> emails;
    private List<String> websites;
    private List<String> Certifications;
    private List<Skills> Skills;
    private Education Education;
    private List<Experience> Work_experience;

    public Resume(Personal_info personal, String Profession, List<String> Languages, List<String> emails, List<String> websites, List<String> Certifications, List<Skills> Skills, Education Education, List<Experience> Work_experience) {
        this.personal = personal;
        this.Profession = Profession;
        this.Languages = Languages;
        this.emails = emails;
        this.websites = websites;
        this.Certifications = Certifications;
        this.Skills = Skills;
        this.Education = Education;
        this.Work_experience = Work_experience;
    }

    public Personal_info getPersonal() {
        return personal;
    }

    public String getProfession() {
        return Profession;
    }

    public List<String> getLanguages() {
        return Languages;
    }

    public List<String> getEmails() {
        return emails;
    }

    public List<String> getWebsites() {
        return websites;
    }

    public List<String> getCertifications() {
        return Certifications;
    }

    public List<Skills> getSkills() {
        return Skills;
    }

    public Education getEducation() {
        return Education;
    }

    public List<Experience> getWork_experience() {
        return Work_experience;
    }

    @Override
    public String toString() {
        return "Resume: \n" + "personal : " + getPersonal() + "\nProfession : " + getProfession() + "\nLanguages : " + getLanguages() + "\nemails : " + getEmails() + "\nwebsites : " + getWebsites() + "\nCertifications : " + getCertifications() + "\nSkills : " + getSkills() + "\nEducation : " + getEducation() + "\nWork_experience : " + getWork_experience();
    }
}
