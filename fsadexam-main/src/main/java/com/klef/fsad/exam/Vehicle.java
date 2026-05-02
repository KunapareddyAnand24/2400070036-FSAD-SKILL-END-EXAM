package com.klef.fsad.exam;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String type;
    private String description;

    @Temporal(TemporalType.DATE)
    private Date manufactureDate;

    private String status;

    public Vehicle() {}

    public Vehicle(String name, String type, String description, Date manufactureDate, String status) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.manufactureDate = manufactureDate;
        this.status = status;
    }

    
    public int getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Date getManufactureDate() { return manufactureDate; }
    public void setManufactureDate(Date manufactureDate) { this.manufactureDate = manufactureDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}