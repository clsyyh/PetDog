package org.PetDog.entity;

import java.util.Date;

public class Complaint {
    private Integer id;
    private Date complainDate;
    private String content;
    private  DogOrder dogOrder;

    public Complaint() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getComplainDate() {
        return complainDate;
    }

    public void setComplainDate(Date complainDate) {
        this.complainDate = complainDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public DogOrder getDogOrder() {
        return dogOrder;
    }

    public void setDogOrder(DogOrder dogOrder) {
        this.dogOrder = dogOrder;
    }
}
