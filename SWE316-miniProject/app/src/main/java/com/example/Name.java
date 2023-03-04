package com.example;

public class Name {
    // make every variable private
    private String Raw;
    private String First;
    private String Last;
    private String Middle;
    private String Title;

    public Name(String Raw, String First, String Last, String Middle, String Title) {
        this.Raw = Raw;
        this.First = First;
        this.Middle = Middle;
        this.Last = Last;
        this.Title = Title;
    }

    public String getRaw() {
        return Raw;
    }

    public String getFirst() {
        return First;
    }

    public String getMiddle() {
        return Middle;
    }

    public String getLast() {
        return Last;
    }

    public String getTitle() {
        return Title;
    }

    @Override
    public String toString() {
        return "Full name : " + getRaw() + "\nFirst : " + getFirst() + "\nMiddle : " + getMiddle() + "\nLast : " + getLast() + "\nTitle : " + getTitle();
    }
}
