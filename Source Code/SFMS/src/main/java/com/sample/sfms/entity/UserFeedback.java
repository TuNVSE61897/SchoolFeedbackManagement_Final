package com.sample.sfms.entity;

import javax.persistence.*;

/**
 * Created by MyPC on 01/03/2018.
 */
@Entity
@Table(name = "user_feedback", schema = "capstone", catalog = "")
@IdClass(UserFeedbackPK.class)
public class UserFeedback {
    private int userId;
    private int feedbackId;
    private boolean isConductor;
    private boolean isViewer;
    private boolean isConducted;
    private User userByUserId;
    private Feedback feedbackByFeedbackId;
    @Id
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "feedback_id", nullable = false)
    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int courseId) {
        this.feedbackId = courseId;
    }

    @Basic
    @Column(name = "is_conductor", nullable = true)
    public boolean isConductor() {
        return isConductor;
    }

    public void setConductor(boolean conductor) {
        isConductor = conductor;
    }

    @Basic
    @Column(name = "is_viewer", nullable = true)
    public boolean isViewer() {
        return isViewer;
    }

    public void setViewer(boolean viewer) {
        isViewer = viewer;
    }

    @Basic
    @Column(name = "is_conducted", nullable = true)
    public boolean isConducted() {
        return isConducted;
    }

    public void setConducted(boolean conducted) {
        isConducted = conducted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserFeedback that = (UserFeedback) o;

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

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "feedback_id", referencedColumnName = "id", nullable = false)
    public Feedback getFeedbackByFeedbackId() {
        return feedbackByFeedbackId;
    }

    public void setFeedbackByFeedbackId(Feedback feedbackByFeedbackId) {
        this.feedbackByFeedbackId = feedbackByFeedbackId;
    }

    public UserFeedback(int userId, int feedbackId, boolean isConductor, boolean isViewer, boolean isConducted) {
        this.userId = userId;
        this.feedbackId = feedbackId;
        this.isConductor = isConductor;
        this.isViewer = isViewer;
        this.isConducted = isConducted;
    }
}
