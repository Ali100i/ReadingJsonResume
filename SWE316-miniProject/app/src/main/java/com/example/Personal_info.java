package com.example;

import java.util.List;

public class Personal_info {
    private Name name;
    private List<String> phone_no;
    private String Date_Of_Birth;
    private Location location;

    public Personal_info(Name name, List<String> phone_no, String Date_Of_Birth, Location location) {
        this.name = name;
        this.phone_no = phone_no;
        this.Date_Of_Birth = Date_Of_Birth;
        this.location = location;
    }

    public Name getName() {
        return name;
    }

    public List<String> getPhone_no() {
        return phone_no;
    }

    public String getDate_Of_Birth() {
        return Date_Of_Birth;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Personal_info: \n" + getName() +"\nPhone numbers: " + getPhone_no() + "\nDate_Of_Birth : " + getDate_Of_Birth() + "\nlocation : " + getLocation();
    }
}
