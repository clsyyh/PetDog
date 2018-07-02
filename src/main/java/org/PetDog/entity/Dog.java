package org.PetDog.entity;

import org.springframework.format.annotation.NumberFormat;

public class Dog {
    private Integer id;
    private byte[] picture;
    private String name;
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private Integer age;
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private Integer sex;
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private Integer weight;
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private Integer height;
    private String vaccine;
    private String bloodline;
    private String kind;
    private Integer price;
    private String area;
    private User seller;
    private String introduction;

    public Dog() {
        super();
    }

    /**
     * Gets the value of id
     *
     * @return the value of id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the id
     * <p>You can use getId() to get the value of id</p>
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the value of picture
     *
     * @return the value of picture
     */
    public byte[] getPicture() {
        return picture;
    }

    /**
     * Sets the picture
     * <p>You can use getPicture() to get the value of picture</p>
     *
     * @param picture picture
     */
    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    /**
     * Gets the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name
     * <p>You can use getName() to get the value of name</p>
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the value of age
     *
     * @return the value of age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Sets the age
     * <p>You can use getAge() to get the value of age</p>
     *
     * @param age age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * Gets the value of sex
     *
     * @return the value of sex
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * Sets the sex
     * <p>You can use getSex() to get the value of sex</p>
     *
     * @param sex sex
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * Gets the value of weight
     *
     * @return the value of weight
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * Sets the weight
     * <p>You can use getWeight() to get the value of weight</p>
     *
     * @param weight weight
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * Gets the value of height
     *
     * @return the value of height
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * Sets the height
     * <p>You can use getHeight() to get the value of height</p>
     *
     * @param height height
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * Gets the value of vaccine
     *
     * @return the value of vaccine
     */
    public String getVaccine() {
        return vaccine;
    }

    /**
     * Sets the vaccine
     * <p>You can use getVaccine() to get the value of vaccine</p>
     *
     * @param vaccine vaccine
     */
    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    /**
     * Gets the value of bloodline
     *
     * @return the value of bloodline
     */
    public String getBloodline() {
        return bloodline;
    }

    /**
     * Sets the bloodline
     * <p>You can use getBloodline() to get the value of bloodline</p>
     *
     * @param bloodline bloodline
     */
    public void setBloodline(String bloodline) {
        this.bloodline = bloodline;
    }

    /**
     * Gets the value of kind
     *
     * @return the value of kind
     */
    public String getKind() {
        return kind;
    }

    /**
     * Sets the kind
     * <p>You can use getKind() to get the value of kind</p>
     *
     * @param kind kind
     */
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * Gets the value of price
     *
     * @return the value of price
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * Sets the price
     * <p>You can use getPrice() to get the value of price</p>
     *
     * @param price price
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * Gets the value of area
     *
     * @return the value of area
     */
    public String getArea() {
        return area;
    }

    /**
     * Sets the area
     * <p>You can use getArea() to get the value of area</p>
     *
     * @param area area
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * Gets the value of seller
     *
     * @return the value of seller
     */
    public User getSeller() {
        return seller;
    }

    /**
     * Sets the seller
     * <p>You can use getSeller() to get the value of seller</p>
     *
     * @param seller seller
     */
    public void setSeller(User seller) {
        this.seller = seller;
    }

    /**
     * Gets the value of introduction
     *
     * @return the value of introduction
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * Sets the introduction
     * <p>You can use getIntroduction() to get the value of introduction</p>
     *
     * @param introduction introduction
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
