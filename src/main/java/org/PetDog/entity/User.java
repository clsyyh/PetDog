package org.PetDog.entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.util.Date;

public class User {
    private Integer id;
    private String loginname;
    private byte[] photo;
    /*
    姓名
     */
    private String name;
    @NumberFormat(style= NumberFormat.Style.NUMBER)
    private Integer sex;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date birthday;
    private  String tel;
    private  String email;
    private String weChat;
    public User() {
        super();
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the value of loginname
     *
     * @return the value of loginname
     */
    public String getLoginname() {
        return loginname;
    }

    /**
     * Sets the loginname
     * <p>You can use getLoginname() to get the value of loginname</p>
     *
     * @param loginname loginname
     */
    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    /**
     * Gets the value of photo
     *
     * @return the value of photo
     */
    public byte[] getPhoto() {
        return photo;
    }

    /**
     * Sets the photo
     * <p>You can use getPhoto() to get the value of photo</p>
     *
     * @param photo photo
     */
    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    /*
            姓名
             */
    public String getName() {
        return this.name;
    }

    /*
        姓名
         */
    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return this.sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeChat() {
        return this.weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }
}
