package org.PetDog.entity;

public class DogKnowleage {
    private Integer id;
    private byte[] picture;
    private String introduction;
    private String feed;
    private String treatment;
    private String trainning;

    public DogKnowleage() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getFeed() {
        return feed;
    }

    public void setFeed(String feed) {
        this.feed = feed;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getTrainning() {
        return trainning;
    }

    public void setTrainning(String trainning) {
        this.trainning = trainning;
    }
}
