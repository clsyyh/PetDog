package org.PetDog.entity;

public class Address {
    private Integer id;
    private String area;
    private String detail;
    private  String tel;
    private Integer dogorderId;
    private Integer buyerId;

    public Address() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * Gets the value of dogorderId
     *
     * @return the value of dogorderId
     */
    public Integer getDogorderId() {
        return dogorderId;
    }

    /**
     * Sets the dogorderId
     * <p>You can use getDogorderId() to get the value of dogorderId</p>
     *
     * @param dogorderId dogorderId
     */
    public void setDogorderId(Integer dogorderId) {
        this.dogorderId = dogorderId;
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
}
