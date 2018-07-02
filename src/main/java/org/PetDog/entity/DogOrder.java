package org.PetDog.entity;

import java.util.Date;

public class DogOrder {
    private Integer id;
    private String number;
    private String deliverWay;
    private Integer deliverPrice;
    private Integer sumprice;
    private String payWay;
    private Date createDate;
    private String status;

    private String shr;
    private String tel;
    private String shad;

    private Integer buyerId;
    private Integer sellerId;
    private Dog dog;

    public DogOrder() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDeliverWay() {
        return deliverWay;
    }

    public void setDeliverWay(String deliverWay) {
        this.deliverWay = deliverWay;
    }

    public Integer getDeliverPrice() {
        return deliverPrice;
    }

    public void setDeliverPrice(Integer deliverPrice) {
        this.deliverPrice = deliverPrice;
    }

    public Integer getSumprice() {
        return sumprice;
    }

    public void setSumprice(Integer sumprice) {
        this.sumprice = sumprice;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the value of shr
     *
     * @return the value of shr
     */
    public String getShr() {
        return shr;
    }

    /**
     * Sets the shr
     * <p>You can use getShr() to get the value of shr</p>
     *
     * @param shr shr
     */
    public void setShr(String shr) {
        this.shr = shr;
    }

    /**
     * Gets the value of tel
     *
     * @return the value of tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * Sets the tel
     * <p>You can use getTel() to get the value of tel</p>
     *
     * @param tel tel
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * Gets the value of shad
     *
     * @return the value of shad
     */
    public String getShad() {
        return shad;
    }

    /**
     * Sets the shad
     * <p>You can use getShad() to get the value of shad</p>
     *
     * @param shad shad
     */
    public void setShad(String shad) {
        this.shad = shad;
    }

    /**
     * Gets the value of buyerId
     *
     * @return the value of buyerId
     */
    public Integer getBuyerId() {
        return buyerId;
    }

    /**
     * Sets the buyerId
     * <p>You can use getBuyerId() to get the value of buyerId</p>
     *
     * @param buyerId buyerId
     */
    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    /**
     * Gets the value of sellerId
     *
     * @return the value of sellerId
     */
    public Integer getSellerId() {
        return sellerId;
    }

    /**
     * Sets the sellerId
     * <p>You can use getSellerId() to get the value of sellerId</p>
     *
     * @param sellerId sellerId
     */
    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    /**
     * Gets the value of dog
     *
     * @return the value of dog
     */
    public Dog getDog() {
        return dog;
    }

    /**
     * Sets the dog
     * <p>You can use getDog() to get the value of dog</p>
     *
     * @param dog dog
     */
    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
