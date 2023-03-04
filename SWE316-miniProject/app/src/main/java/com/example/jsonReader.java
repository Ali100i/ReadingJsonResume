package com.example;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class jsonReader {
    private String path;
    private Object obj;
    private JSONObject jsonObject;
    private JSONParser parser;

    public jsonReader(String path){
        this.path = path;
        this.parser = new JSONParser();
        try{
            this.obj = parser.parse(new FileReader(path));
            this.jsonObject = (JSONObject) obj;
            this.jsonObject = (JSONObject) jsonObject.get("Value");
            this.jsonObject = (JSONObject) jsonObject.get("Data");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    private void resetpointer(){
        this.jsonObject = (JSONObject) obj;
        this.jsonObject = (JSONObject) jsonObject.get("Value");
        this.jsonObject = (JSONObject) jsonObject.get("Data");
    }


    private Name name_Generator(){
        String raw = null;
        String first = null;
        String last = null;
        String middle = null;
        String title = null;

        this.jsonObject = (JSONObject) jsonObject.get("Name");
        if (this.jsonObject == null){
            resetpointer();
            return null;
        }
        else{
            raw = (String) this.jsonObject.get("Raw");
            first = (String) this.jsonObject.get("First");
            last = (String) this.jsonObject.get("Last");
            middle = (String) this.jsonObject.get("Middle");
            title = (String) this.jsonObject.get("Title");
        }
        resetpointer();
        return new Name(raw, first, last, middle, title);
    }

    private Location location_Generator(){
        
        this.jsonObject = (JSONObject) jsonObject.get("Location");
        if(this.jsonObject == null){
            resetpointer();
            return null;
        }

        String formatted = (String) this.jsonObject.get("Formatted");
        String postalCode = (String) this.jsonObject.get("PostalCode");
        String state = (String) this.jsonObject.get("State");
        String country = (String) this.jsonObject.get("Country");
        String CountryCode = (String) this.jsonObject.get("CountryCode");
        String street_no = (String) this.jsonObject.get("StreetNumber");
        String street_name = (String) this.jsonObject.get("Street");
        String city = (String) this.jsonObject.get("City");

        resetpointer();
        return new Location(formatted, postalCode, state, country, CountryCode, street_no, street_name, city);
    }
    
    private Personal_info info_Generator(){
        Name name = name_Generator();
        String date_of_birth = (String) jsonObject.get("DateOfBirth");
        
        resetpointer();
        List<String> phone_numbers = new ArrayList<String>();
        JSONArray phone_no = (JSONArray) jsonObject.get("PhoneNumbers");
        if(phone_no == null){
            resetpointer();
        }
        else{
        for (Object number : phone_no) {
            phone_numbers.add((String) number);
        }
        resetpointer();
        }
        Location location = location_Generator();
        return new Personal_info(name, phone_numbers, date_of_birth, location);
    }
    
    private Education edu_Generator(){
        resetpointer();

        long id = 0;
        String org = null;
        String Certificate = null;
        String edu_lvl = null;
        String raw_grade = null;
        String Metric = null;
        String Value = null;
        Location edu_Location = null;
        String Completion_date = null;
        boolean isCurrent = false;
        String Start_date = null;

        JSONArray education = (JSONArray) jsonObject.get("Education");

            this.jsonObject = (JSONObject) education.get(0);
            if(this.jsonObject.get("Id") == null){
                id = 0;
            }
            else{
                id = (long) this.jsonObject.get("Id");
            }
            org = (String) this.jsonObject.get("Organization");
            this.jsonObject = (JSONObject) this.jsonObject.get("Accreditation");
            Certificate = (String) this.jsonObject.get("Education");
            edu_lvl = (String) this.jsonObject.get("EducationLevel");
            
            resetpointer();
            this.jsonObject = (JSONObject) education.get(0);
            this.jsonObject = (JSONObject) this.jsonObject.get("Grade");
            if(this.jsonObject == null){
                resetpointer();
            }
            else{
                raw_grade = (String) this.jsonObject.get("Raw");
                Metric = (String) this.jsonObject.get("Metric");
                Value = (String) this.jsonObject.get("Value");
            }
            resetpointer();
            this.jsonObject = (JSONObject) education.get(0);
            edu_Location = location_Generator();

            resetpointer();
            this.jsonObject = (JSONObject) education.get(0);
            this.jsonObject = (JSONObject) this.jsonObject.get("Dates");
            if(this.jsonObject == null){
                resetpointer();
            }
            else{
                Completion_date = (String) this.jsonObject.get("CompletionDate");
                isCurrent = (boolean) this.jsonObject.get("IsCurrent");
                Start_date = (String) this.jsonObject.get("StartDate");
            }

        return new Education(id, edu_Location, org, Certificate, edu_lvl, raw_grade, Metric, Value, Completion_date, isCurrent, Start_date);
    }

    private Classification classification_Generator(){
        String title = null;
        String minor = null;
        String sub_major = null;
        String major = null;

        this.jsonObject = (JSONObject) jsonObject.get("Classification");
        if(this.jsonObject == null){
            return null;
        }
        else{
            title = (String) this.jsonObject.get("Title");
            minor = (String) this.jsonObject.get("MinorGroup");
            sub_major = (String) this.jsonObject.get("SubMajorGroup");
            major = (String) this.jsonObject.get("MajorGroup");
            return new Classification(title, minor, sub_major, major);
        }
    }

    private Occupation occupation_Generator(){
        long Managment_level = 0;
        this.jsonObject = (JSONObject) jsonObject.get("Occupation");
        if(this.jsonObject == null){
            return null;
        }
        else{
            String job_title = (String) this.jsonObject.get("JobTitle");
            String job_title_normalized = (String) this.jsonObject.get("JobTitleNormalized");
            if(this.jsonObject.get("ManagementLevel") == null){
                Managment_level = 0;
            }
            else{
                Managment_level = (long) this.jsonObject.get("ManagementLevel");
            }
            Classification classification = classification_Generator();
            return new Occupation(job_title, job_title_normalized, Managment_level, classification);
        }
    }

    private List<Experience> experience_Generator(){
        resetpointer();

        List<Experience> experience = new ArrayList<Experience>();
        long Id = 0;
        String org = null;
        String Industry = null;
        Location work_Location = null;
        String job_description = null;
        String start_date = null;
        String end_date = null;
        long Months_in_position = 0;
        boolean isCurrent = false;
        Occupation occupation = null;

        JSONArray work_exp = (JSONArray) jsonObject.get("WorkExperience");
        if(work_exp == null){
            return null;
        }
        else{
            for(int i=0; i<work_exp.size(); i++){
                this.jsonObject = (JSONObject) work_exp.get(i);
                if(this.jsonObject == null){
                    return experience;
                }
                else { 
                    if(this.jsonObject.get("Id") == null){
                        Id = 0;
                    }
                    else{
                        Id = (long) this.jsonObject.get("Id");
                    }
                    org = (String) this.jsonObject.get("Organization");
                    Industry = (String) this.jsonObject.get("Industry");
                    work_Location = location_Generator();
                    this.jsonObject = (JSONObject) work_exp.get(i);
                    job_description = (String) this.jsonObject.get("JobDescription");
                    this.jsonObject = (JSONObject) this.jsonObject.get("Dates");
                    if(this.jsonObject == null){
                        resetpointer();
                        this.jsonObject = (JSONObject) work_exp.get(i);
                    }
                    else{
                        start_date = (String) this.jsonObject.get("StartDate");
                        end_date = (String) this.jsonObject.get("EndDate");
                        if(this.jsonObject.get("MonthsInPosition") == null){
                            Months_in_position = 0;
                        }
                        else{
                            Months_in_position = (long) this.jsonObject.get("MonthsInPosition");
                        }
                        isCurrent = (boolean) this.jsonObject.get("IsCurrent");
                    }

                    resetpointer();
                    this.jsonObject = (JSONObject) work_exp.get(0);
                    occupation = occupation_Generator();

                    resetpointer();
                    experience.add(new Experience(Id, org, Industry, work_Location, job_description, occupation, start_date, end_date, Months_in_position, isCurrent));
                }
            }
            return experience;
        }
    }

    private List<Skills> skills_Generator(){
        resetpointer();
        List<Skills> skill_list = new ArrayList<Skills>();
        JSONArray skills = (JSONArray) jsonObject.get("Skills");

        long id = 0;
        String name = null;
        String last_used = null;
        long Num_of_months = 0;
        String type = null;
        String weighting = null;
        String section = null;
        long position = 0;
        long work_exp_id = 0;

        if(skills == null){
            return skill_list;
        }
        else{
            for(int i=0; i<skills.size(); i++){
                this.jsonObject = (JSONObject) skills.get(i);
                if(this.jsonObject == null){
                    return skill_list;
                }
                else{
                    if(this.jsonObject.get("Id") == null){
                        id = 0;
                    }
                    else{
                        id = (long) this.jsonObject.get("Id");
                        
                    }
                    name = (String) this.jsonObject.get("Name");
                    last_used = (String) this.jsonObject.get("LastUsed");

                    if(this.jsonObject.get("NumberOfMonths") == null){
                        Num_of_months = 0;
                    }
                    else{
                        Num_of_months = (long) this.jsonObject.get("NumberOfMonths");
                    }
                    type = (String) this.jsonObject.get("Type");
                    weighting = (String) this.jsonObject.get("Weighting");

                    JSONArray sources = (JSONArray) this.jsonObject.get("Sources");
                    if(sources == null){
                        this.jsonObject = (JSONObject) skills.get(i);
                    }
                    else{
                        this.jsonObject = (JSONObject) sources.get(0);
                        if(this.jsonObject == null){
                            this.jsonObject = (JSONObject) skills.get(i);
                        }
                        else{
                            section = (String) this.jsonObject.get("Section");
                            if(this.jsonObject.get("Position") == null){
                                position = 0;
                            }
                            else{
                                position = (long) this.jsonObject.get("Position");
                            }
                            if(this.jsonObject.get("WorkExperienceId") == null){
                                work_exp_id = 0;
                            }
                            else{
                                work_exp_id = (long) this.jsonObject.get("WorkExperienceId");
                            }
                            
                            }

                        }
                    resetpointer();
                    skill_list.add(new Skills(id, name, last_used, Num_of_months, type, weighting, section, position, work_exp_id));
                }
            }
            return skill_list;
        }
    }

    public Resume resume_Generator(){
        resetpointer();
        Personal_info personal_info = info_Generator();
        Education education = edu_Generator();
        List<Experience> experience = experience_Generator();
        List<Skills> skills = skills_Generator();
        List<String> website_list = new ArrayList<String>();
        List<String> emails = new ArrayList<String>();
        List<String> languages = new ArrayList<String>();
        List<String> certifications = new ArrayList<String>();
        String profession = null;

        JSONArray websites = (JSONArray) jsonObject.get("Websites");
        if(websites == null){
            website_list = null;
        }
        else{
            for(Object webs : websites){
                website_list.add((String) webs);
            }
            resetpointer();
        }

        JSONArray email = (JSONArray) jsonObject.get("Emails");
        if(email == null){
            emails = null;
        }
        else{
            for(Object em : email){
                emails.add((String) em);
            }
            resetpointer();
        }

        JSONArray language = (JSONArray) jsonObject.get("Languages");
        if(language == null){
            languages = null;
        }
        else{
            for(Object lang : language){
                languages.add((String) lang);
            }
            resetpointer();
        }

        JSONArray cert = (JSONArray) jsonObject.get("Certifications");
        if(cert == null){
            certifications = null;
        }
        else{
            for(Object cer : cert){
                certifications.add((String) cer);
            }
            resetpointer();
        }

        profession = (String) jsonObject.get("Profession");

        return new Resume(personal_info, profession, languages, emails, website_list, certifications, skills, education, experience);
    }

}   