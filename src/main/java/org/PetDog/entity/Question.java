package org.PetDog.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import java.util.List;

public class Question {
    private Integer id;
    private String title;
    private String content;
    private User user;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date date;
    private Integer count;
    //一对多
    private List<Comment> comments;

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
     * Gets the value of title
     *
     * @return the value of title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title
     * <p>You can use getTitle() to get the value of title</p>
     *
     * @param title title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the value of content
     *
     * @return the value of content
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content
     * <p>You can use getContent() to get the value of content</p>
     *
     * @param content content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Gets the value of user
     *
     * @return the value of user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user
     * <p>You can use getUser() to get the value of user</p>
     *
     * @param user user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets the value of date
     *
     * @return the value of date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date
     * <p>You can use getDate() to get the value of date</p>
     *
     * @param date date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets the value of count
     *
     * @return the value of count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * Sets the count
     * <p>You can use getCount() to get the value of count</p>
     *
     * @param count count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * Gets the value of comments
     *
     * @return the value of comments
     */
    public List<Comment> getComments() {
        return comments;
    }

    /**
     * Sets the comments
     * <p>You can use getComments() to get the value of comments</p>
     *
     * @param comments comments
     */
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
