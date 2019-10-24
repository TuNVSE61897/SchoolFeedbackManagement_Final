package com.sample.sfms.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.sample.sfms.view.FeedbackView;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by MyPC on 22/02/2018.
 */
@Entity
public class Question {
    @JsonView(FeedbackView.conductFeedbackView.class)
    private int id;
    private String type;
    private String suggestion;
    @JsonView(FeedbackView.conductFeedbackView.class)
    private boolean isRequied;
    @JsonView(FeedbackView.conductFeedbackView.class)
    private String questionContent;
    @JsonView(FeedbackView.conductFeedbackView.class)
    private Collection<Optionn> optionsById;
    private Criteria criteriaByCriteriaId;
    private Feedback feedbackByFeedbackId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type", nullable = false, length = 255)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "suggestion", nullable = true)
    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    @Basic
    @Column(name = "is_requied", nullable = false)
    public boolean getIsRequied() {
        return isRequied;
    }

    public void setIsRequied(boolean isRequied) {
        this.isRequied = isRequied;
    }

    @Basic
    @Column(name = "question_content", nullable = true)
    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (id != question.id) return false;
        if (isRequied != question.isRequied) return false;
        if (type != null ? !type.equals(question.type) : question.type != null) return false;
        if (suggestion != null ? !suggestion.equals(question.suggestion) : question.suggestion != null) return false;
        if (questionContent != null ? !questionContent.equals(question.questionContent) : question.questionContent != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (suggestion != null ? suggestion.hashCode() : 0);
        //result = 31 * result + (int) isRequied;
        result = 31 * result + (questionContent != null ? questionContent.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "questionByQuestionId")
    public Collection<Optionn> getOptionsById() {
        return optionsById;
    }

    public void setOptionsById(Collection<Optionn> optionsById) {
        this.optionsById = optionsById;
    }

    @ManyToOne
    @JoinColumn(name = "criteria_id", referencedColumnName = "id")
    public Criteria getCriteriaByCriteriaId() {
        return criteriaByCriteriaId;
    }

    public void setCriteriaByCriteriaId(Criteria criteriaByCriteriaId) {
        this.criteriaByCriteriaId = criteriaByCriteriaId;
    }

    @ManyToOne
    @JoinColumn(name = "feedback_id", referencedColumnName = "id", nullable = false)
    public Feedback getFeedbackByFeedbackId() {
        return feedbackByFeedbackId;
    }

    public void setFeedbackByFeedbackId(Feedback feedbackByFeedbackId) {
        this.feedbackByFeedbackId = feedbackByFeedbackId;
    }
}
