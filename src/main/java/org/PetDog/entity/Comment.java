package org.PetDog.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Comment {
    private Integer id;
    private Integer questionId;
    private User user;
    private String comment;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date date;

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
     * Gets the value of questionId
     *
     * @return the value of questionId
     */
    public Integer getQuestionId() {
        return questionId;
    }

    /**
     * Sets the questionId
     * <p>You can use getQuestionId() to get the value of questionId</p>
     *
     * @param questionId questionId
     */
    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
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
     * Gets the value of comment
     *
     * @return the value of comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the comment
     * <p>You can use getComment() to get the value of comment</p>
     *
     * @param comment comment
     */
    public void setComment(String comment) {
        this.comment = comment;
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
}
