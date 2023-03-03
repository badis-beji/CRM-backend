package com.crmapp.crmbackend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.util.Set;

@Entity
@Table
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String firstName;
@Column
    private String lastName;
@Column
@Email
    private String email;
@Column
    private String phone;
@Column
    private String jobTitle;
@Column
    private String contactOwner;
@Column
    private String company;

    @ManyToMany(mappedBy = "participants")
    private Set<ActivitiesEntity> activities;
    public Contact() {

    }

    public Contact(Long id, String firstName, String lastName, String email, String phone, String jobTitle, String contactOwner, String company) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.jobTitle = jobTitle;
        this.contactOwner = contactOwner;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getContactOwner() {
        return contactOwner;
    }

    public void setContactOwner(String contactOwner) {
        this.contactOwner = contactOwner;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
