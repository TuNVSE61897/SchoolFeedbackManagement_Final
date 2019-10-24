package com.sample.sfms.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by MyPC on 02/03/2018.
 */
public class UserFeedbackPK implements Serializable{
    private int userId;
    private int feedbackId;

    @Column(name = "user_id", nullable = false, insertable = false, updatable = false)
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "feedback_id", nullable = false, insertable = false, updatable = false)
    @Id
    public int getFeedbackId() {
        return feedbackId;
    }
    
    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserFeedbackPK that = (UserFeedbackPK) o;

        if (userId != that.userId) return false;
        if (feedbackId != that.feedbackId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + feedbackId;
        return result;
    }

    public UserFeedbackPK(int userId, int feedbackId) {
        this.userId = userId;
        this.feedbackId = feedbackId;
    }
}
