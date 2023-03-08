package com.crmapp.crmbackend.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "activities")
public class ActivitiesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private Date date = new Date();
    @Column
    private String type;

    @Column
    private String subject;
    @Column
    private String note;
    @Column
    private String document;




    @ManyToMany()
    @JoinTable(
            name = "activity_participant",
            joinColumns = @JoinColumn(name = "activity_id"),
            inverseJoinColumns = @JoinColumn(name = "contact_id")
    )
    private Set<Contact> participants = new HashSet<>();
    public ActivitiesEntity() {

    }

    public ActivitiesEntity(Long id, Date date, String type, String subject, String note, String document) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.subject = subject;
        this.note = note;
        this.document = document;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Set<Contact> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Contact> participants) {
        this.participants = participants;
    }
}
