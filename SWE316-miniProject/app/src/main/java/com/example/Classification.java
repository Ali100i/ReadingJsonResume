package com.example;

public class Classification {
    private String Title;
    private String Minor_Group;
    private String Sub_Major_Group;
    private String Major_Group;

    public Classification(String Title, String Minor_Group, String Sub_Major_Group, String Major_Group) {
        this.Title = Title;
        this.Minor_Group = Minor_Group;
        this.Sub_Major_Group = Sub_Major_Group;
        this.Major_Group = Major_Group;
    }

    public String getTitle() {
        return Title;
    }

    public String getMinor_Group() {
        return Minor_Group;
    }

    public String getSub_Major_Group() {
        return Sub_Major_Group;
    }

    public String getMajor_Group() {
        return Major_Group;
    }

    @Override   
    public String toString() {
        return "Classification:- \n" + "Title : " + getTitle() + "\nMinor_Group : " + getMinor_Group() + "\nSub_Major_Group : " + getSub_Major_Group() + "\nMajor_Group : " + getMajor_Group();
    }
}
