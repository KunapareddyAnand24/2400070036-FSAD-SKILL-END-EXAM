package com.klef.fsad.exam;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Persistent Entity Class — Hospital
 * Maps to the "hospital" table in the "fsadendexam" database.
 */
@Entity
@Table(name = "hospital")
public class Hospital {

    // ------------------------------------------------------------------ //
    //  PRIMARY KEY — auto-generated                                        //
    // ------------------------------------------------------------------ //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hospital_id")
    private int id;

    // ------------------------------------------------------------------ //
    //  ATTRIBUTES                                                          //
    // ------------------------------------------------------------------ //

    @Column(name = "hospital_name", nullable = false, length = 150)
    private String name;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "established_date")
    private LocalDate date;

    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "location", length = 200)
    private String location;

    @Column(name = "contact_number", length = 15)
    private String contactNumber;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "number_of_beds")
    private int numberOfBeds;

    // ------------------------------------------------------------------ //
    //  CONSTRUCTORS                                                        //
    // ------------------------------------------------------------------ //

    /** No-arg constructor required by Hibernate. */
    public Hospital() {}

    /** Convenience constructor (id is auto-generated; leave it out). */
    public Hospital(String name, String description, LocalDate date,
                    String status, String location, String contactNumber,
                    String email, int numberOfBeds) {
        this.name          = name;
        this.description   = description;
        this.date          = date;
        this.status        = status;
        this.location      = location;
        this.contactNumber = contactNumber;
        this.email         = email;
        this.numberOfBeds  = numberOfBeds;
    }

    // ------------------------------------------------------------------ //
    //  GETTERS & SETTERS                                                   //
    // ------------------------------------------------------------------ //

    public int getId()                      { return id; }
    public void setId(int id)               { this.id = id; }

    public String getName()                 { return name; }
    public void setName(String name)        { this.name = name; }

    public String getDescription()          { return description; }
    public void setDescription(String d)    { this.description = d; }

    public LocalDate getDate()              { return date; }
    public void setDate(LocalDate date)     { this.date = date; }

    public String getStatus()               { return status; }
    public void setStatus(String status)    { this.status = status; }

    public String getLocation()             { return location; }
    public void setLocation(String loc)     { this.location = loc; }

    public String getContactNumber()        { return contactNumber; }
    public void setContactNumber(String c)  { this.contactNumber = c; }

    public String getEmail()                { return email; }
    public void setEmail(String email)      { this.email = email; }

    public int getNumberOfBeds()            { return numberOfBeds; }
    public void setNumberOfBeds(int n)      { this.numberOfBeds = n; }

    // ------------------------------------------------------------------ //
    //  toString                                                            //
    // ------------------------------------------------------------------ //

    @Override
    public String toString() {
        return "Hospital {" +
                "\n  ID            : " + id +
                "\n  Name          : " + name +
                "\n  Description   : " + description +
                "\n  Established   : " + date +
                "\n  Status        : " + status +
                "\n  Location      : " + location +
                "\n  Contact       : " + contactNumber +
                "\n  Email         : " + email +
                "\n  No. of Beds   : " + numberOfBeds +
                "\n}";
    }
}
