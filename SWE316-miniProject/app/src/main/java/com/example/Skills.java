package com.example;

public class Skills {
    private long id;
    private String Name;
    private String LastUsed;
    private long Num_of_months;
    private String Type;
    private String Weighting;
    private String Section;
    private long position;
    private long Work_experience_Id;

    public Skills(long id, String Name, String LastUsed, long Num_of_months, String Type, String Weighting, String Section, long position, long Work_experience_Id) {
        this.id = id;
        this.Name = Name;
        this.LastUsed = LastUsed;
        this.Num_of_months = Num_of_months;
        this.Type = Type;
        this.Weighting = Weighting;
        this.Section = Section;
        this.position = position;
        this.Work_experience_Id = Work_experience_Id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getLastUsed() {
        return LastUsed;
    }

    public long getNum_of_months() {
        return Num_of_months;
    }

    public String getType() {
        return Type;
    }

    public String getWeighting() {
        return Weighting;
    }

    public String getSection() {
        return Section;
    }


    public long getPosition() {
        return position;
    }

    public long getWork_experience_Id() {
        return Work_experience_Id;
    }

    @Override
    public String toString() {
        return "Skills: \n" + "id : " + getId() + "\nName : " + getName() + "\nLastUsed : " + getLastUsed() + "\nNum_of_months : " + getNum_of_months() + "\nType : " + getType() + "\nWeighting : " + getWeighting() + "\nSection : " + getSection() + "\nposition : " + getPosition() + "\nWork_experience_Id : " + getWork_experience_Id();
    }
}