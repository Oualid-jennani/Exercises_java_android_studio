package com.example.walid.appstandart;

public class User {
    private String firstname;
    private String lastname;
    private String fhone;

    public User(String firstname, String lastname, String fhone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.fhone = fhone;
    }


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFhone() {
        return fhone;
    }

    public void setFhone(String fhone) {
        this.fhone = fhone;
    }
}
