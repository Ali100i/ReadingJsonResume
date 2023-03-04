package com.example;

public class Location {
    // make every variable private
    private String Formatted;
    private String Street_no;
    private String Street_name;
    private String City;
    private String Country;
    private String Country_code;
    private String Postal_code;
    private String State;

    public Location(String Formatted, String Postal_code, String State, String Country, String Country_code, String Street_no,String street_name, String City ) {
        this.Formatted = Formatted;
        this.Street_no = Street_no;
        this.Street_name = Street_name;
        this.City = City;
        this.Country = Country;
        this.Country_code = Country_code;
        this.Postal_code = Postal_code;
        this.State = State;
    }
    public String getFormatted() {
        return Formatted;
    }

    public String getStreet_no() {
        return Street_no;
    }

    public String getStreet_name() {
        return Street_name;
    }

    public String getCity() {
        return City;
    }

    public String getCountry() {
        return Country;
    }

    public String getCountry_code() {
        return Country_code;
    }

    public String getPostal_code() {
        return Postal_code;
    }

    public String getState() {
        return State;
    }

    @Override
    public String toString() {
        return "\nFormatted: "+ getFormatted() + "\nStreet_no : " + getStreet_no() + "\nStreet_name : " + getStreet_name() + "\nCity : " + getCity() + "\nCountry : " + getCountry() + "\nCountry_code : " + getCountry_code() + "\nPostal_code : " + getPostal_code() + "\nState : " + getState();
    }
}
